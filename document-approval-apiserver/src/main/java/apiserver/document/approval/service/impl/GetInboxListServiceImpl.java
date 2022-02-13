package apiserver.document.approval.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import apiserver.document.approval.dto.GetInboxListInDto;
import apiserver.document.approval.dto.GetInboxListOutDto;
import apiserver.document.approval.mapper.GetInboxListMapper;
import apiserver.document.approval.service.GetInboxListService;

@Component
public class GetInboxListServiceImpl implements GetInboxListService {

	private final GetInboxListMapper getInboxListMapper;
	
	public GetInboxListServiceImpl(GetInboxListMapper getInboxListMapper) {
		this.getInboxListMapper = getInboxListMapper;
	}
	
	@Override
	public List<GetInboxListOutDto> getInboxList(GetInboxListInDto input) {
		List<GetInboxListOutDto> inboxList = getInboxListMapper.getInboxList(input);
		
		return inboxList;
	}
	
}
