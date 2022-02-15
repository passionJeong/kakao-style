package apiserver.document.approval.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import apiserver.document.approval.dto.GetApproveLineInDto;
import apiserver.document.approval.dto.GetApproveLineOutDto;

@Mapper
public interface GetApproveLineMapper {
	
	List<GetApproveLineOutDto> getApproveLine(GetApproveLineInDto input);
	
}
