package apiserver.document.approval.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import apiserver.document.approval.dto.GetArchiveListInDto;
import apiserver.document.approval.dto.GetArchiveListOutDto;

@Mapper
public interface GetArchiveListMapper {
	
	List<GetArchiveListOutDto> getArchiveList(GetArchiveListInDto input);

}
