package apiserver.document.approval.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import apiserver.document.approval.dto.GetDocumentApproveHistoryInDto;
import apiserver.document.approval.dto.GetDocumentApproveHistoryOutDto;
import apiserver.document.approval.dto.PutDocumentApproveStatusInDto;
import apiserver.document.approval.dto.PutDocumentApproveStatusOutDto;
import apiserver.document.approval.service.GetDocumentApproveHistoryService;
import apiserver.document.approval.service.PutDocumentApproveStatusService;

/**
 * 문서승인 controller
 * @author jeongseoyeon
 * 문서승인 관련 서비스 컨트롤러
 */

@RestController
public class DocumentApprovalController {
	
	private final PutDocumentApproveStatusService putDocumentApproveStatusService;
	
	private final GetDocumentApproveHistoryService getDocumentApproveHistoryService;
	
	public DocumentApprovalController(PutDocumentApproveStatusService putDocumentApproveStatusService, GetDocumentApproveHistoryService getDocumentApproveHistoryService) {
		this.putDocumentApproveStatusService = putDocumentApproveStatusService;
		this.getDocumentApproveHistoryService = getDocumentApproveHistoryService;
	}

	//문서 승인, 거절 서비스
	@ResponseBody
	@PutMapping("/v1/document-approve-status")
	public PutDocumentApproveStatusOutDto putDocumentApproveStatus(@RequestBody @Valid PutDocumentApproveStatusInDto documentApproveStatus) {
		PutDocumentApproveStatusOutDto output = putDocumentApproveStatusService.putDocumentApproveStatus(documentApproveStatus);
		
		return output;
	}

	//문서 승인, 거절 히스토리 조회 서비스
	@ResponseBody
	@GetMapping("/v1/document-approve-history")
	public List<GetDocumentApproveHistoryOutDto> getDocumentApproveHistory(@RequestBody @Valid GetDocumentApproveHistoryInDto input) {
		List<GetDocumentApproveHistoryOutDto> output = getDocumentApproveHistoryService.getDocumentApproveHistory(input);
		
		return output;
	}
}
