package apiserver.document.approval.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import apiserver.document.approval.dto.GetDocumentApproveHistoryInDto;
import apiserver.document.approval.dto.GetDocumentApproveHistoryOutDto;

@Mapper
public interface GetDocumentApproveHistoryMapper {
	
	List<GetDocumentApproveHistoryOutDto> getDocumentApproveHistory(GetDocumentApproveHistoryInDto input);
	
}
