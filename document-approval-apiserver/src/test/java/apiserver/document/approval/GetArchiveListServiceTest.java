package apiserver.document.approval;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import apiserver.document.approval.dto.GetApproverListOutDto;
import apiserver.document.approval.dto.GetArchiveListInDto;
import apiserver.document.approval.dto.GetArchiveListOutDto;
import apiserver.document.approval.dto.PostNewDocumentInDto;
import apiserver.document.approval.dto.PostNewDocumentOutDto;
import apiserver.document.approval.dto.PutDocumentApproveStatusInDto;
import apiserver.document.approval.dto.PutDocumentApproveStatusOutDto;
import apiserver.document.approval.service.GetApproverListService;
import apiserver.document.approval.service.GetArchiveListService;
import apiserver.document.approval.service.PostNewDocumentService;
import apiserver.document.approval.service.PutDocumentApproveStatusService;

/**
 * archive 조회
 * 
 * @author jeongseoyeon 문서 생성(결재라인 조회) -> 다른 사람이 결재 -> Archive 조회
 */

@SpringBootTest
public class GetArchiveListServiceTest {

	@Autowired
	PostNewDocumentService postNewDocumentService;

	@Autowired
	PutDocumentApproveStatusService putDocumentApproveStatusService;

	@Autowired
	GetArchiveListService getArchiveListService;

	@Autowired
	GetApproverListService getApproverListService;

	@Test
	public void getApproverListTest() {
		List<GetApproverListOutDto> output = getApproverListService.getApproverList();

		for (GetApproverListOutDto approver : output) {
			assertNotEquals("", approver.getUserId());
		}

	}

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

		input.setDocumentTitle("testTitle2");
		input.setDocumentType("testType2");
		input.setDocumentContents("testContents2");
		input.setOwnerUserNum(1);
		input.setApproveLine("1,2");

		output = postNewDocumentService.postNewDocument(input);

		assertEquals("문서 생성 성공", output.getResult());

	}

	@Test
	public void putDocumentApproveStatus() {
		// 1번 문서
		// 1번 사용자 결재
		PutDocumentApproveStatusInDto input = new PutDocumentApproveStatusInDto();
		input.setDocumentNum(1);
		input.setApproveUserNum(1);
		input.setApproveStatus("A");
		input.setApproveMessage("approve Message");

		PutDocumentApproveStatusOutDto output = putDocumentApproveStatusService.putDocumentApproveStatus(input);

		assertEquals("결재 성공", output.getResult());

		// 2번 사용자 결재
		input.setApproveUserNum(2);
		input.setApproveStatus("A");
		output = putDocumentApproveStatusService.putDocumentApproveStatus(input);

		assertEquals("결재 성공", output.getResult());

		// 2번 문서
		// 1번 사용자 반려
		input.setDocumentNum(2);
		input.setApproveUserNum(1);
		input.setApproveStatus("D");
		input.setApproveMessage("approve Deny Message");

		output = putDocumentApproveStatusService.putDocumentApproveStatus(input);

		assertEquals("결재 성공", output.getResult());

		// 결재 완료된 문서 조회
		GetArchiveListInDto input3 = new GetArchiveListInDto();
		input3.setUserNum(1);
		List<GetArchiveListOutDto> archiveList = getArchiveListService.getArchiveList(input3);

		assertEquals(2, archiveList.size());

		for (int i = 0; i < archiveList.size(); i++) {
			assertEquals(i + 1, archiveList.get(i).getDocumentNum());
		}

	}

}
