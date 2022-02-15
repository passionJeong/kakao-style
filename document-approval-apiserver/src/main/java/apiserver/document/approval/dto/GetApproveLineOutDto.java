package apiserver.document.approval.dto;

import lombok.Getter;

@Getter
public class GetApproveLineOutDto {
	
	private Integer documentNum;
	
	private Integer approveOrder;
	
	private Integer approveUserNum;
	
	private String approveStatus;
	
	private String approveMessage;
	
}
