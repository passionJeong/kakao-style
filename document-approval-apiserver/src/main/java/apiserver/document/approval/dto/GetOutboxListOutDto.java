package apiserver.document.approval.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class GetOutboxListOutDto {
	
	//문서번호
	private Integer documentNum;
	
	//제목
	private String documentTitle;
	
	//구분
	private String documentType;
	
	//내용
	private String documentContents;

}
