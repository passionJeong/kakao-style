package apiserver.document.approval.dto;

import lombok.Setter;

@Setter
public class PostNewApproveLineInDto {
	
	//문서번호
	private Integer documentNum;
	
	//승인 순번
	private Integer approveOrder;
	
	//현재승인자 직원번호
	private Integer approveUserNum;
	
	//승인 상태
	private String approveStatus;

}
