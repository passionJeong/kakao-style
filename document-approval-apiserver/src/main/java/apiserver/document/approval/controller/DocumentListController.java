package apiserver.document.approval.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import apiserver.document.approval.dto.GetArchiveListInDto;
import apiserver.document.approval.dto.GetArchiveListOutDto;
import apiserver.document.approval.dto.GetInboxListInDto;
import apiserver.document.approval.dto.GetInboxListOutDto;
import apiserver.document.approval.dto.GetOutboxListInDto;
import apiserver.document.approval.dto.GetOutboxListOutDto;
import apiserver.document.approval.service.GetArchiveListService;
import apiserver.document.approval.service.GetInboxListService;
import apiserver.document.approval.service.GetOutboxListService;

/**
 * 문서 목록 조회 controller
 * @author jeongseoyeon
 * 특정 조건을 가진 문서 목록을 조회하는 서비스
 */
@RestController
public class DocumentListController {

	private final GetOutboxListService getOutboxListService;
	
	private final GetInboxListService getInboxListService;
	
	private final GetArchiveListService getArchiveListService;
	
	public DocumentListController(GetOutboxListService getOutboxListService, GetInboxListService getInboxListService, GetArchiveListService getArchiveListService) {
		this.getOutboxListService = getOutboxListService;
		this.getInboxListService = getInboxListService;
		this.getArchiveListService = getArchiveListService;
	}
	
	//outbox
	@ResponseBody
	@GetMapping("/v1/outbox-list")
	public List<GetOutboxListOutDto> getOutboxList(@RequestBody @Valid GetOutboxListInDto input) {
		List<GetOutboxListOutDto> outboxList = getOutboxListService.getOutboxList(input);
		
		return outboxList;
	}
	
	//inbox
	@ResponseBody
	@GetMapping("/v1/inbox-list")
	public List<GetInboxListOutDto> getInboxList(@RequestBody @Valid GetInboxListInDto input) {
		List<GetInboxListOutDto> inboxList = getInboxListService.getInboxList(input);
		
		return inboxList;
	}
	
	//archive
	@ResponseBody
	@GetMapping("/v1/archive-list")
	public List<GetArchiveListOutDto> getArchiveList(@RequestBody @Valid GetArchiveListInDto input) {
		List<GetArchiveListOutDto> archiveList = getArchiveListService.getArchiveList(input);
		
		return archiveList;
	}
}
