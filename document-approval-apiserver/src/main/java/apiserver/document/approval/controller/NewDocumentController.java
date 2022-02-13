package apiserver.document.approval.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import apiserver.document.approval.dto.GetApproverListInDto;
import apiserver.document.approval.dto.GetApproverListOutDto;
import apiserver.document.approval.dto.PostNewDocumentInDto;
import apiserver.document.approval.dto.PostNewDocumentOutDto;
import apiserver.document.approval.service.GetApproverListService;
import apiserver.document.approval.service.PostNewDocumentService;

/**
 * 문서 생성 controller
 * @author jeongseoyeon
 * 문서 생성관련 서비스
 */

@RestController
public class NewDocumentController {
	
	private final GetApproverListService getApproverListService;
	
	private final PostNewDocumentService postNewDocumentService;;
	
	public NewDocumentController(GetApproverListService getApproverListService, PostNewDocumentService postNewDocumentService) {
		this.getApproverListService = getApproverListService;
		this.postNewDocumentService = postNewDocumentService;
	}
	
	//결재자 리스트 정보를 읽어온다.
	@ResponseBody
	@GetMapping("/v1/approver-list")
	public List<GetApproverListOutDto> getApproverList(@RequestBody GetApproverListInDto input) {
		List<GetApproverListOutDto> approverList = getApproverListService.getApproverList();
		
		return approverList;
	}
	
	//문서 생성
	@ResponseBody
	@PostMapping("/v1/new-document")
	public PostNewDocumentOutDto postNewDocument(@RequestBody @Valid PostNewDocumentInDto newDocument) {
		PostNewDocumentOutDto result = postNewDocumentService.postNewDocument(newDocument);
		
		return result;
	}
	
}
