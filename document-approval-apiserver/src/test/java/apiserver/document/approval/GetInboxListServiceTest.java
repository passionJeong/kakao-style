package apiserver.document.approval;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import apiserver.document.approval.dto.GetInboxListInDto;
import apiserver.document.approval.dto.GetInboxListOutDto;
import apiserver.document.approval.dto.PostNewDocumentInDto;
import apiserver.document.approval.dto.PostNewDocumentOutDto;
import apiserver.document.approval.dto.PutDocumentApproveStatusInDto;
import apiserver.document.approval.dto.PutDocumentApproveStatusOutDto;
import apiserver.document.approval.service.GetInboxListService;
import apiserver.document.approval.service.PostNewDocumentService;
import apiserver.document.approval.service.PutDocumentApproveStatusService;

/**
 * inbox 리스트조회 서비스 테스트
 * @author jeongseoyeon
 * 문서 생성 -> 1번 사용자 결재 -> 2번사용자 inbox 조회
 */

@SpringBootTest
public class GetInboxListServiceTest {

	@Autowired
	PostNewDocumentService postNewDocumentService;
	
	@Autowired
	PutDocumentApproveStatusService putDocumentApproveStatusService;
	
	@Autowired
	GetInboxListService getInboxListService;
	
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
	public void putDocumentApproveStatus() {
		PutDocumentApproveStatusInDto input = new PutDocumentApproveStatusInDto();
		input.setDocumentNum(1);
		input.setApproveUserNum(1);
		input.setApproveStatus("A");
		input.setApproveMessage("approve Message");
		
		PutDocumentApproveStatusOutDto output = putDocumentApproveStatusService.putDocumentApproveStatus(input);
		
		assertEquals("결재 성공", output.getResult());
		
	}
	
	@Test
	public void getInboxListTest() {
		//2번 사용자로 조회
		GetInboxListInDto input = new GetInboxListInDto();
		input.setUserNum(2);
		
		List<GetInboxListOutDto> output = getInboxListService.getInboxList(input);
		
		assertEquals(1, output.size());
		
		for(GetInboxListOutDto archiveList : output) {
			assertEquals(1, archiveList.getDocumentNum());
		}
		
	}
}
