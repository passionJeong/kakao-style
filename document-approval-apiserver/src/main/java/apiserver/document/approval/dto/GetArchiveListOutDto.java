package apiserver.document.approval.dto;

import lombok.Getter;

@Getter
public class GetArchiveListOutDto {
	
	//문서번호
	private Integer documentNum;
	
	//제목
	private String documentTitle;
	
	//구분
	private String documentType;
	
	//내용
	private String documentContents;
	
	//결재 진행 상태
	private String approveStatus;

}
