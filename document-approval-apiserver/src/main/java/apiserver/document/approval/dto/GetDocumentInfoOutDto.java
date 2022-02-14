package apiserver.document.approval.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class GetDocumentInfoOutDto {
	
	private Integer documentNum;
	
	private String documentTitle;
	
	private String documentType;
	
	private String documentContents;
	
	private Integer ownerUserNum;
	
	private String approveStatus;
	
	private Integer approveUserNum;
	
	private String approveLine;

	public Integer getApproveUserNum;

}
