package apiserver.document.approval.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import apiserver.document.approval.dto.GetApproveLineInDto;
import apiserver.document.approval.dto.GetApproveLineOutDto;
import apiserver.document.approval.dto.PutDocumentApproveStatusInDto;
import apiserver.document.approval.dto.PutDocumentApproveStatusOutDto;
import apiserver.document.approval.service.GetApproveLineService;
import apiserver.document.approval.service.PutDocumentApproveStatusService;

/**
 * 문서승인 controller
 * @author jeongseoyeon
 * 문서승인 관련 서비스 컨트롤러
 */

@RestController
public class DocumentApprovalController {
	
	private final PutDocumentApproveStatusService putDocumentApproveStatusService;
	
	private final GetApproveLineService getApproveLineService;
	
	public DocumentApprovalController(PutDocumentApproveStatusService putDocumentApproveStatusService, GetApproveLineService getApproveLineService) {
		this.putDocumentApproveStatusService = putDocumentApproveStatusService;
		this.getApproveLineService = getApproveLineService;
	}

	//문서 승인, 거절 서비스
	@ResponseBody
	@PutMapping("/v1/document-approve-status")
	public PutDocumentApproveStatusOutDto putDocumentApproveStatus(@RequestBody @Valid PutDocumentApproveStatusInDto documentApproveStatus) {
		PutDocumentApproveStatusOutDto output = putDocumentApproveStatusService.putDocumentApproveStatus(documentApproveStatus);
		
		return output;
	}

	//결재 라인 조회(결재 내역 조회)
	@ResponseBody
	@GetMapping("/v1/document-approve-line")
	public List<GetApproveLineOutDto> getDocumentApproveHistory(@RequestBody @Valid GetApproveLineInDto input) {
		List<GetApproveLineOutDto> output = getApproveLineService.getApproveLine(input);
		
		return output;
	}
}
