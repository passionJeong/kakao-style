package apiserver.document.approval.service;

import java.util.List;

import apiserver.document.approval.dto.GetInboxListInDto;
import apiserver.document.approval.dto.GetInboxListOutDto;

public interface GetInboxListService {
	
	public List<GetInboxListOutDto> getInboxList(GetInboxListInDto input);
	
}
