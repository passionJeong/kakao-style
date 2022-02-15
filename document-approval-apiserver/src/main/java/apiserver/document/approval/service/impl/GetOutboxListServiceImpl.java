package apiserver.document.approval.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import apiserver.document.approval.dto.GetOutboxListInDto;
import apiserver.document.approval.dto.GetOutboxListOutDto;
import apiserver.document.approval.mapper.GetOutboxListMapper;
import apiserver.document.approval.service.GetOutboxListService;

/**
 * Outbox 조회 서비스
 * @author jeongseoyeon
 * 내가 생성한 문서 중 결재가 진행중인(approveStatus = I) 문서를 조회
 */

@Service
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
