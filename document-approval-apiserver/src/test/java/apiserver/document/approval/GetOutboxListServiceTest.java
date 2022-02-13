package apiserver.document.approval;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import apiserver.document.approval.dto.GetOutboxListInDto;
import apiserver.document.approval.dto.GetOutboxListOutDto;
import apiserver.document.approval.dto.PostNewDocumentInDto;
import apiserver.document.approval.dto.PostNewDocumentOutDto;
import apiserver.document.approval.service.GetOutboxListService;
import apiserver.document.approval.service.PostNewDocumentService;

/**
 * outbox 조회
 * @author jeongseoyeon
 * 문서 생성(결재라인 조회) -> inbox 조회
 */

@SpringBootTest
public class GetOutboxListServiceTest {
	
	@Autowired
	PostNewDocumentService postNewDocumentService;
	
	@Autowired
	GetOutboxListService getOutboxListService;
	
	@Test
	public void postNewDocumentTest() {
		PostNewDocumentInDto input = new PostNewDocumentInDto();
		input.setDocumentTitle("testTitle");
		input.setDocumentType("testType");
		input.setDocumentContents("testContents");
		input.setOwnerUserNum(1);
		input.setApproveLine("1,2");
		
		PostNewDocumentOutDto output = postNewDocumentService.postNewDocument(input);
		
		assertEquals("문서 생성 성공", output.getResult());
		
	}
	
	@Test
	public void getOutboxListTest() {
		//1번 사용자로 조회
		GetOutboxListInDto input = new GetOutboxListInDto();
		input.setUserNum(1);
		
		List<GetOutboxListOutDto> output = getOutboxListService.getOutboxList(input);
		
		assertEquals(1, output.size());
		
		for(GetOutboxListOutDto archiveList : output) {
			assertEquals(1, archiveList.getDocumentNum());
			assertEquals("testTitle", archiveList.getDocumentTitle());
			assertEquals("testType", archiveList.getDocumentType());
			assertEquals("testContents", archiveList.getDocumentContents());
		}
		
	}
}
