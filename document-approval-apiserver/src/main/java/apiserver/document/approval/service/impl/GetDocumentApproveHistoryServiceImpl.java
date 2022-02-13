package apiserver.document.approval.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import apiserver.document.approval.dto.GetDocumentApproveHistoryInDto;
import apiserver.document.approval.dto.GetDocumentApproveHistoryOutDto;
import apiserver.document.approval.mapper.GetDocumentApproveHistoryMapper;
import apiserver.document.approval.service.GetDocumentApproveHistoryService;

@Component
public class GetDocumentApproveHistoryServiceImpl implements GetDocumentApproveHistoryService {
	
	private final GetDocumentApproveHistoryMapper getDocumentApproveHistoryMapper;
	
	public GetDocumentApproveHistoryServiceImpl(GetDocumentApproveHistoryMapper getDocumentApproveHistoryMapper) {
		this.getDocumentApproveHistoryMapper = getDocumentApproveHistoryMapper;
	}
	
	public List<GetDocumentApproveHistoryOutDto> getDocumentApproveHistory(GetDocumentApproveHistoryInDto input) {
		List<GetDocumentApproveHistoryOutDto> documentApproveHistory = getDocumentApproveHistoryMapper.getDocumentApproveHistory(input);
		
		return documentApproveHistory;
	}

}
