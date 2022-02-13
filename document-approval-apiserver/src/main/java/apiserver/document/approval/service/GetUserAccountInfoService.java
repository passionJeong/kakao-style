package apiserver.document.approval.service;

import apiserver.document.approval.dto.GetUserAccountInfoInDto;
import apiserver.document.approval.dto.GetUserAccountInfoOutDto;

public interface GetUserAccountInfoService {
	
	public GetUserAccountInfoOutDto doLogin(GetUserAccountInfoInDto userAccount);

}
