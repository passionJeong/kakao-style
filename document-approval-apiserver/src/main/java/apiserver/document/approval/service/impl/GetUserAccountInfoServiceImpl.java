package apiserver.document.approval.service.impl;

import org.springframework.stereotype.Service;

import apiserver.document.approval.dto.GetUserAccountInfoInDto;
import apiserver.document.approval.dto.GetUserAccountInfoOutDto;
import apiserver.document.approval.exception.CustomException;
import apiserver.document.approval.exception.ErrorCode;
import apiserver.document.approval.mapper.GetUserAccountInfoMapper;
import apiserver.document.approval.service.GetUserAccountInfoService;

/**
 * 사용자 정보 조회 서비스(로그인)
 * @author jeongseoyeon
 * ID 기준으로 조회하여 해당 사용자 정보를 return
 */

@Service
public class GetUserAccountInfoServiceImpl implements GetUserAccountInfoService {
	
    private final GetUserAccountInfoMapper userInfoMapper;
    
    public GetUserAccountInfoServiceImpl(GetUserAccountInfoMapper userInfoMapper) {
    	this.userInfoMapper = userInfoMapper;
    }
	
	@Override
	public GetUserAccountInfoOutDto doLogin(GetUserAccountInfoInDto userAccount) {
		GetUserAccountInfoOutDto userAccountInfo = userInfoMapper.getUserAccountInfo(userAccount);

		//ID 또는 비밀번호를 틀렸을 경우
		if(userAccountInfo == null) {
			throw new CustomException(ErrorCode.USER_NOT_FOUND);
		}
		
		return userAccountInfo;
	}

}
