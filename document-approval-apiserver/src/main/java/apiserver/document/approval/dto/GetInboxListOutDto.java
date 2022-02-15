package apiserver.document.approval.dto;

import lombok.Getter;

@Getter
public class GetInboxListOutDto {

	//문서번호
	private Integer documentNum;
	
	//제목
	private String documentTitle;
	
	//구분
	private String documentType;
	
	//내용
	private String documentContents;
	
}
