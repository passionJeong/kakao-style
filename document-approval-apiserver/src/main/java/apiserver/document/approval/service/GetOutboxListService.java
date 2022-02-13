package apiserver.document.approval.service;

import java.util.List;

import apiserver.document.approval.dto.GetOutboxListInDto;
import apiserver.document.approval.dto.GetOutboxListOutDto;

public interface GetOutboxListService {
	
	public List<GetOutboxListOutDto> getOutboxList(GetOutboxListInDto input);

}
