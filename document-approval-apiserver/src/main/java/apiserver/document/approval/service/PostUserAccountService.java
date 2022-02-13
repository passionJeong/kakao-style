package apiserver.document.approval.service;

import apiserver.document.approval.dto.PostUserAccountInDto;
import apiserver.document.approval.dto.PostUserAccountOutDto;

public interface PostUserAccountService {
	
	public PostUserAccountOutDto postUserAccount(PostUserAccountInDto input);

}
