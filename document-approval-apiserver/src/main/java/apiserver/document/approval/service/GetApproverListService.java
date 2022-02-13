package apiserver.document.approval.service;

import java.util.List;

import apiserver.document.approval.dto.GetApproverListOutDto;

public interface GetApproverListService {
	
	public List<GetApproverListOutDto> getApproverList();

}
