package apiserver.document.approval.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import apiserver.document.approval.dto.GetArchiveListInDto;
import apiserver.document.approval.dto.GetArchiveListOutDto;
import apiserver.document.approval.mapper.GetArchiveListMapper;
import apiserver.document.approval.service.GetArchiveListService;

/**
 * Archive 조회 서비스
 * @author jeongseoyeon
 * 결재가 완료된 문서를 조회한다. 문서 소유자이거나 결재에 참여했던 문서를 조회한다.
 */

@Service
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
