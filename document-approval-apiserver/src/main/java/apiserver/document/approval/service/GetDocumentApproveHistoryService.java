package apiserver.document.approval.service;

import java.util.List;

import apiserver.document.approval.dto.GetDocumentApproveHistoryInDto;
import apiserver.document.approval.dto.GetDocumentApproveHistoryOutDto;

public interface GetDocumentApproveHistoryService {

	public List<GetDocumentApproveHistoryOutDto> getDocumentApproveHistory(GetDocumentApproveHistoryInDto input);
	
}
