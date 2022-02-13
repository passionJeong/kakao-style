package apiserver.document.approval.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import apiserver.document.approval.dto.GetApproverListOutDto;
import apiserver.document.approval.exception.CustomException;
import apiserver.document.approval.exception.ErrorCode;
import apiserver.document.approval.mapper.GetApproverListMapper;
import apiserver.document.approval.service.GetApproverListService;

@Component
public class GetApproverListServiceImpl implements GetApproverListService{
	
	private final GetApproverListMapper getApproverListMapper;
	
	public GetApproverListServiceImpl(GetApproverListMapper getApproverListMapper) {
		this.getApproverListMapper = getApproverListMapper;
	}
	
	@Override
	public List<GetApproverListOutDto> getApproverList() {
		List<GetApproverListOutDto> approverList = getApproverListMapper.getApproverList();
		
		if(approverList.size() == 0) {
			throw new CustomException(ErrorCode.APRV_USER_NOT_FOUND);
		}
		
		return approverList;
	}

}
