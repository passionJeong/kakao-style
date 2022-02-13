package apiserver.document.approval.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import apiserver.document.approval.dto.GetApproverListOutDto;

@Mapper
public interface GetApproverListMapper {
	
	List<GetApproverListOutDto> getApproverList();

}
