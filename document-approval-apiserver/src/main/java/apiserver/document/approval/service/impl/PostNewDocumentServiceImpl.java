package apiserver.document.approval.service.impl;

import org.springframework.stereotype.Service;

import apiserver.document.approval.dto.PostNewApproveLineInDto;
import apiserver.document.approval.dto.PostNewDocumentInDto;
import apiserver.document.approval.dto.PostNewDocumentOutDto;
import apiserver.document.approval.exception.CustomException;
import apiserver.document.approval.exception.ErrorCode;
import apiserver.document.approval.mapper.PostNewDocumentMapper;
import apiserver.document.approval.service.PostNewDocumentService;

/**
 * 문서 생성 서비스
 * @author jeongseoyeon
 * 문서를 생성한다.
 */

@Service
public class PostNewDocumentServiceImpl implements PostNewDocumentService {
	
	private final PostNewDocumentMapper documentMapper;
	
	public PostNewDocumentServiceImpl(PostNewDocumentMapper documentMapper) {
		this.documentMapper = documentMapper;
	}
	
	@Override
	public PostNewDocumentOutDto postNewDocument(PostNewDocumentInDto newDocument) {

		String[] approveLine = newDocument.getApproveLine().split(",");

		try {
			//결재라인 첫번 째 사원번호를 결재자로 지정
			newDocument.setApproveUserNum(Integer.parseInt(approveLine[0]));
		} catch(NumberFormatException e) {
			//결재자가 한 명도 지정되지 않았을 경우(','를 구분자로 하지 않았을 경우)
			throw new CustomException(ErrorCode.APRV_INVALID_SEPARATOR);
		}
		
		int result = documentMapper.postNewDocument(newDocument);
		PostNewDocumentOutDto output = new PostNewDocumentOutDto();
		
		if(result == 1) {
			output.setResult("문서 생성 성공");
		} else {
			throw new CustomException(ErrorCode.POST_DOC_FAIL);
		}
		
		//결재라인 생성을 위해 채번된 문서번호를 가져온다.
		int nextDocumentNum = documentMapper.getDocumentCount();
		PostNewApproveLineInDto newApproveLine = new PostNewApproveLineInDto();
		newApproveLine.setDocumentNum(nextDocumentNum);
		newApproveLine.setApproveStatus("I");
		//결재라인을 하나씩 insert한다.
		for(int i = 0; i < approveLine.length; i++) {
			newApproveLine.setApproveOrder(i);
			newApproveLine.setApproveUserNum(Integer.parseInt(approveLine[i]));
			result = documentMapper.postNewApproveLine(newApproveLine);
			
			if(result != 1) {
				throw new CustomException(ErrorCode.POST_APRV_LINE_FAIL);
			}
			
		}
		
		
		return output;
	}
	
}
