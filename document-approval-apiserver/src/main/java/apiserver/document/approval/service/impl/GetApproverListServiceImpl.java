package apiserver.document.approval.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import apiserver.document.approval.dto.GetApproverListOutDto;
import apiserver.document.approval.exception.CustomException;
import apiserver.document.approval.exception.ErrorCode;
import apiserver.document.approval.mapper.GetApproverListMapper;
import apiserver.document.approval.service.GetApproverListService;

/**
 * 결재권자 조회 서비스
 * @author jeongseoyeon
 * 결재권한이 있는 사용자 리스트를 조회한다.
 */

@Service
public class GetApproverListServiceImpl implements GetApproverListService{
	
	private final GetApproverListMapper getApproverListMapper;
	
	public GetApproverListServiceImpl(GetApproverListMapper getApproverListMapper) {
		this.getApproverListMapper = getApproverListMapper;
	}
	
	@Override
	public List<GetApproverListOutDto> getApproverList() {
		List<GetApproverListOutDto> approverList = getApproverListMapper.getApproverList();

		//결재권한이 있는 사용자가 없을경우
		if(approverList.size() == 0) {
			throw new CustomException(ErrorCode.APRV_USER_NOT_FOUND);
		}
		
		return approverList;
	}

}
