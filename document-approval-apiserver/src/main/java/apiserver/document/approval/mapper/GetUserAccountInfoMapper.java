package apiserver.document.approval.mapper;


import org.apache.ibatis.annotations.Mapper;

import apiserver.document.approval.dto.GetUserAccountInfoInDto;
import apiserver.document.approval.dto.GetUserAccountInfoOutDto;

@Mapper
public interface GetUserAccountInfoMapper {
	
	GetUserAccountInfoOutDto getUserAccountInfo(GetUserAccountInfoInDto userAccount);
	
}
