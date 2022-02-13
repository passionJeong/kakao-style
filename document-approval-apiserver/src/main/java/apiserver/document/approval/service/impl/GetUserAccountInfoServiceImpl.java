package apiserver.document.approval.service.impl;

import org.springframework.stereotype.Component;

import apiserver.document.approval.dto.GetUserAccountInfoInDto;
import apiserver.document.approval.dto.GetUserAccountInfoOutDto;
import apiserver.document.approval.exception.CustomException;
import apiserver.document.approval.exception.ErrorCode;
import apiserver.document.approval.mapper.GetUserAccountInfoMapper;
import apiserver.document.approval.service.GetUserAccountInfoService;

@Component
public class GetUserAccountInfoServiceImpl implements GetUserAccountInfoService {
	
    private final GetUserAccountInfoMapper userInfoMapper;
    
    public GetUserAccountInfoServiceImpl(GetUserAccountInfoMapper userInfoMapper) {
    	this.userInfoMapper = userInfoMapper;
    }
	
	@Override
	public GetUserAccountInfoOutDto doLogin(GetUserAccountInfoInDto userAccount) {
		GetUserAccountInfoOutDto userAccountInfo = userInfoMapper.getUserAccountInfo(userAccount);
		
		if(userAccountInfo == null) {
			throw new CustomException(ErrorCode.USER_NOT_FOUND);
		}
		
		return userAccountInfo;
	}

}
