package apiserver.document.approval.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import apiserver.document.approval.dto.GetDocumentApproveHistoryInDto;
import apiserver.document.approval.dto.GetDocumentApproveHistoryOutDto;
import apiserver.document.approval.mapper.GetDocumentApproveHistoryMapper;
import apiserver.document.approval.service.GetDocumentApproveHistoryService;

/**
 * 문서 승인 히스토리 조회 서비스
 * @author jeongseoyeon
 * 문서 승인 내역을 조회한다(로그). Archive 리스트를 조회할 때 결재에 참여했던 문서를 추출하기 위해 사용하는 서비스
 */

@Component
public class GetDocumentApproveHistoryServiceImpl implements GetDocumentApproveHistoryService {
	
	private final GetDocumentApproveHistoryMapper getDocumentApproveHistoryMapper;
	
	public GetDocumentApproveHistoryServiceImpl(GetDocumentApproveHistoryMapper getDocumentApproveHistoryMapper) {
		this.getDocumentApproveHistoryMapper = getDocumentApproveHistoryMapper;
	}
	
	public List<GetDocumentApproveHistoryOutDto> getDocumentApproveHistory(GetDocumentApproveHistoryInDto input) {
		List<GetDocumentApproveHistoryOutDto> documentApproveHistory = getDocumentApproveHistoryMapper.getDocumentApproveHistory(input);
		
		return documentApproveHistory;
	}

}
