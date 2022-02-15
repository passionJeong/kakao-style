package apiserver.document.approval.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import apiserver.document.approval.dto.GetApproveLineInDto;
import apiserver.document.approval.dto.GetApproveLineOutDto;
import apiserver.document.approval.mapper.GetApproveLineMapper;
import apiserver.document.approval.service.GetApproveLineService;

/**
 * 문서 결재라인 조회 서비스
 * @author jeongseoyeon
 * 문서 결재라인을 조회한다. Archive 리스트를 조회할 때 결재에 참여했던 문서를 추출하기 위해 사용하는 서비스
 */

@Service
public class GetApproveLineServiceImpl implements GetApproveLineService {
	
	private final GetApproveLineMapper getApproveLineMapper;
	
	public GetApproveLineServiceImpl(GetApproveLineMapper getApproveLineMapper) {
		this.getApproveLineMapper = getApproveLineMapper;
	}
	
	@Override
	public List<GetApproveLineOutDto> getApproveLine(GetApproveLineInDto input) {
		List<GetApproveLineOutDto> approveLine = getApproveLineMapper.getApproveLine(input);
		
		return approveLine;
	}

}
