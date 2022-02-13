package apiserver.document.approval.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import apiserver.document.approval.dto.GetInboxListInDto;
import apiserver.document.approval.dto.GetInboxListOutDto;

@Mapper
public interface GetInboxListMapper {
	
	List<GetInboxListOutDto> getInboxList(GetInboxListInDto input);

}
