package apiserver.document.approval.mapper;

import org.apache.ibatis.annotations.Mapper;

import apiserver.document.approval.dto.PutDocumentApproveStatusInDto;

@Mapper
public interface PutDocumentApproveStatusMapper {
	
	int putDocumentApproveStatus(PutDocumentApproveStatusInDto input);

	int postDocumentApproveLog(PutDocumentApproveStatusInDto input);
	
}
