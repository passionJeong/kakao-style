package apiserver.document.approval.service.impl;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import apiserver.document.approval.dto.PostUserAccountInDto;
import apiserver.document.approval.dto.PostUserAccountOutDto;
import apiserver.document.approval.exception.CustomException;
import apiserver.document.approval.exception.ErrorCode;
import apiserver.document.approval.mapper.PostUserAccountMapper;
import apiserver.document.approval.service.PostUserAccountService;

@Service
public class PostUserAccountServiceImpl implements PostUserAccountService {

    private final PostUserAccountMapper postUserAccountMapper;
    
    public PostUserAccountServiceImpl(PostUserAccountMapper postUserAccountMapper) {
    	this.postUserAccountMapper = postUserAccountMapper;
    }
	
	
	@Override
	public PostUserAccountOutDto postUserAccount(PostUserAccountInDto input) {

		//client에서 권한을 설정하지 않는다면, 결재권이 없음을 기본 권한으로 넣는다
		if(input.getApproveAuthority() == null) {
			input.setApproveAuthority(false);
		}

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
