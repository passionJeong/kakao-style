package apiserver.document.approval.service;

import apiserver.document.approval.dto.PutDocumentApproveStatusInDto;
import apiserver.document.approval.dto.PutDocumentApproveStatusOutDto;

public interface PutDocumentApproveStatusService {
	
	public PutDocumentApproveStatusOutDto putDocumentApproveStatus(PutDocumentApproveStatusInDto documentApproveStatus);

}
