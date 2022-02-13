package apiserver.document.approval.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import apiserver.document.approval.dto.GetOutboxListInDto;
import apiserver.document.approval.dto.GetOutboxListOutDto;
import apiserver.document.approval.mapper.GetOutboxListMapper;
import apiserver.document.approval.service.GetOutboxListService;

@Component
public class GetOutboxListServiceImpl implements GetOutboxListService {

	private final GetOutboxListMapper getOutboxListMapper;
	
	public GetOutboxListServiceImpl(GetOutboxListMapper getOutboxListMapper) {
		this.getOutboxListMapper = getOutboxListMapper;
	}
	
	@Override
	public List<GetOutboxListOutDto> getOutboxList(GetOutboxListInDto input) {
		List<GetOutboxListOutDto> outboxList = getOutboxListMapper.getOutboxList(input);
		
		return outboxList;
	}
	

}
