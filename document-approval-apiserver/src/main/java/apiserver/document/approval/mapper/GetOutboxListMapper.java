package apiserver.document.approval.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import apiserver.document.approval.dto.GetOutboxListInDto;
import apiserver.document.approval.dto.GetOutboxListOutDto;

@Mapper
public interface GetOutboxListMapper {
	
	List<GetOutboxListOutDto> getOutboxList(GetOutboxListInDto input);

}
