package apiserver.document.approval.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import apiserver.document.approval.dto.GetArchiveListInDto;
import apiserver.document.approval.dto.GetArchiveListOutDto;
import apiserver.document.approval.mapper.GetArchiveListMapper;
import apiserver.document.approval.service.GetArchiveListService;

@Component
public class GetArchiveListServiceImpl implements GetArchiveListService {

	private final GetArchiveListMapper getArchiveListMapper;
	
	public GetArchiveListServiceImpl(GetArchiveListMapper getArchiveListMapper) {
		this.getArchiveListMapper = getArchiveListMapper;
	}
	
	@Override
	public List<GetArchiveListOutDto> getArchiveList(GetArchiveListInDto input) {
		List<GetArchiveListOutDto> archiveList = getArchiveListMapper.getArchiveList(input);
		
		return archiveList;
	}

}
