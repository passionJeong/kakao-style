package apiserver.document.approval.service;

import java.util.List;

import apiserver.document.approval.dto.GetArchiveListInDto;
import apiserver.document.approval.dto.GetArchiveListOutDto;

public interface GetArchiveListService {

	public List<GetArchiveListOutDto> getArchiveList(GetArchiveListInDto input);
	
}
