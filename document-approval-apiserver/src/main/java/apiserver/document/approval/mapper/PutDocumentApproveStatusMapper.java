package apiserver.document.approval.mapper;

import org.apache.ibatis.annotations.Mapper;

import apiserver.document.approval.dto.GetNextApproveUserNumOutDto;
import apiserver.document.approval.dto.PutDocumentApproveStatusInDto;

@Mapper
public interface PutDocumentApproveStatusMapper {
	
	int putDocumentApproveLine(PutDocumentApproveStatusInDto input);
	
	int putDocumentApproveStatus(PutDocumentApproveStatusInDto input);

	GetNextApproveUserNumOutDto getNextApproveUserNum(PutDocumentApproveStatusInDto input);
	
}
