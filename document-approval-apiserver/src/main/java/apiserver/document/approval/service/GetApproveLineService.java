package apiserver.document.approval.service;

import java.util.List;

import apiserver.document.approval.dto.GetApproveLineInDto;
import apiserver.document.approval.dto.GetApproveLineOutDto;

public interface GetApproveLineService {

	public List<GetApproveLineOutDto> getApproveLine(GetApproveLineInDto input);
	
}
