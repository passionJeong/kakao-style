package apiserver.document.approval.service.impl;

import org.springframework.stereotype.Component;

import apiserver.document.approval.dto.PostNewDocumentInDto;
import apiserver.document.approval.dto.PostNewDocumentOutDto;
import apiserver.document.approval.exception.CustomException;
import apiserver.document.approval.exception.ErrorCode;
import apiserver.document.approval.mapper.PostNewDocumentMapper;
import apiserver.document.approval.service.PostNewDocumentService;

@Component
public class PostNewDocumentServiceImpl implements PostNewDocumentService {
	
	private final PostNewDocumentMapper documentMapper;
	
	public PostNewDocumentServiceImpl(PostNewDocumentMapper documentMapper) {
		this.documentMapper = documentMapper;
	}
	
	@Override
	public PostNewDocumentOutDto postNewDocument(PostNewDocumentInDto newDocument) {
		
		//결재자가 한 명도 지정되지 않았을 경우
		if(newDocument.getApproveLine() == null || newDocument.getApproveLine().equals("")) {
			throw new CustomException(ErrorCode.APRV_LINE_NOT_FOUND);
		}
		
		//결재라인 첫번 째 사원번호를 결재자로 지정
		String[] approveLine = newDocument.getApproveLine().split(",");
		newDocument.setApproveUserNum(Integer.parseInt(approveLine[0]));
		
		int result = documentMapper.postNewDocument(newDocument);
		PostNewDocumentOutDto output = new PostNewDocumentOutDto();
		
		if(result == 1) {
			output.setResult("문서 생성 성공");
		} else {
			throw new CustomException(ErrorCode.POST_DOC_FAIL);
		}
		
		return output;
	}
	
}
