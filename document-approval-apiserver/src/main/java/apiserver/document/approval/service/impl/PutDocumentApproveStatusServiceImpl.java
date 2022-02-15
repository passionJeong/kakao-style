package apiserver.document.approval.service.impl;

import org.springframework.stereotype.Service;

import apiserver.document.approval.dto.GetDocumentInfoInDto;
import apiserver.document.approval.dto.GetDocumentInfoOutDto;
import apiserver.document.approval.dto.GetNextApproveUserNumOutDto;
import apiserver.document.approval.dto.PutDocumentApproveStatusInDto;
import apiserver.document.approval.dto.PutDocumentApproveStatusOutDto;
import apiserver.document.approval.exception.CustomException;
import apiserver.document.approval.exception.ErrorCode;
import apiserver.document.approval.mapper.GetDocumentInfoMapper;
import apiserver.document.approval.mapper.PutDocumentApproveStatusMapper;
import apiserver.document.approval.service.PutDocumentApproveStatusService;

/**
 * 문서 결재 서비스
 * @author jeongseoyeon
 * 문서의 승인/반려를 처리한다.
 */

@Service
public class PutDocumentApproveStatusServiceImpl implements PutDocumentApproveStatusService {

	private final PutDocumentApproveStatusMapper putDocumentApproveStatusMapper;
	
	private final GetDocumentInfoMapper getDocumentInfoMapper;
	
	public PutDocumentApproveStatusServiceImpl(PutDocumentApproveStatusMapper putDocumentApproveStatusMapper, GetDocumentInfoMapper getDocumentInfoMapper) {
		this.putDocumentApproveStatusMapper = putDocumentApproveStatusMapper;
		this.getDocumentInfoMapper = getDocumentInfoMapper;
	}
	
	@Override
	public PutDocumentApproveStatusOutDto putDocumentApproveStatus(PutDocumentApproveStatusInDto documentApproveStatus) {
		
		//승인요청이 들어온 문서의 정보를 가져온다.
		Integer documentNum = documentApproveStatus.getDocumentNum();
		GetDocumentInfoInDto input = new GetDocumentInfoInDto();
		input.setDocumentNum(documentNum);
		GetDocumentInfoOutDto documentInfo = getDocumentInfoMapper.getDocumentInfo(input);
		
		//존재하지 않는 문서번호
		if(documentInfo == null) {
			throw new CustomException(ErrorCode.DOC_NOT_FOUND);
		}
		
		//결재권한이 있는 문서가 아닐 경우
		if(!documentApproveStatus.getApproveUserNum().equals(documentInfo.getApproveUserNum())) {
			throw new CustomException(ErrorCode.UNAUTHORIZED_USER);
		}
		
		//이미 완료된 문서
		if(documentInfo.getApproveStatus().equals("A") || documentInfo.getApproveStatus().equals("D")) {
			throw new CustomException(ErrorCode.APRV_COMPLETE);
		}
		
		//결재 처리(결재라인 테이블에 업데이트)
		int result = putDocumentApproveStatusMapper.putDocumentApproveLine(documentApproveStatus);
		
		if(result != 1) {
			throw new CustomException(ErrorCode.APRV_DOC_FAIL);
		}
		
		//승인 또는 거절 실제 요청온 내용
		String approveStatus = documentApproveStatus.getApproveStatus().toUpperCase();
		
		if(approveStatus.equals("A")) {
			//승인일 경우 다음 결재자로 넘김
			GetNextApproveUserNumOutDto approveLine = putDocumentApproveStatusMapper.getNextApproveUserNum(documentApproveStatus);
			
			if(approveLine != null) {
				//마지막 순번 아닐 경우 다음 순번으로 결재자 지정
				documentApproveStatus.setApproveStatus("I"); //결재 진행 중
				documentApproveStatus.setApproveUserNum(approveLine.getApproveUserNum());
			}
			
		}
		
		//문서 승인 상태 업데이트
		result = putDocumentApproveStatusMapper.putDocumentApproveStatus(documentApproveStatus);
		
		PutDocumentApproveStatusOutDto output = new PutDocumentApproveStatusOutDto();
		
		if(result == 1) {
			output.setResult("결재 성공");
		} else {
			throw new CustomException(ErrorCode.APRV_DOC_FAIL);
		}
		
		return output;
	}
	
}
