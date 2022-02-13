package apiserver.document.approval.service.impl;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import apiserver.document.approval.dto.PostUserAccountInDto;
import apiserver.document.approval.dto.PostUserAccountOutDto;
import apiserver.document.approval.exception.CustomException;
import apiserver.document.approval.exception.ErrorCode;
import apiserver.document.approval.mapper.PostUserAccountMapper;
import apiserver.document.approval.service.PostUserAccountService;

@Component
public class PostUserAccountServiceImpl implements PostUserAccountService {

    private final PostUserAccountMapper postUserAccountMapper;
    
    public PostUserAccountServiceImpl(PostUserAccountMapper postUserAccountMapper) {
    	this.postUserAccountMapper = postUserAccountMapper;
    }
	
	
	@Override
	public PostUserAccountOutDto postUserAccount(PostUserAccountInDto input) {
		int result;
		
		try {
			result = postUserAccountMapper.postUserAccount(input);
		} catch(DuplicateKeyException e) {
			throw new CustomException(ErrorCode.DUPLICATE_ID);
		}
		
		PostUserAccountOutDto output = new PostUserAccountOutDto();
		
		if(result == 1) {
			output.setResult("회원가입 성공");
		} else {
			throw new CustomException(ErrorCode.USER_JOIN_FAIL);
		}
		
		return output;
	}

}
