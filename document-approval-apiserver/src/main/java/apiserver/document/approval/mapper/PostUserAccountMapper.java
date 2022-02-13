package apiserver.document.approval.mapper;


import org.apache.ibatis.annotations.Mapper;

import apiserver.document.approval.dto.PostUserAccountInDto;

@Mapper
public interface PostUserAccountMapper {
	
	int postUserAccount(PostUserAccountInDto input);
	
}
