package apiserver.document.approval.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetDocumentApproveHistoryOutDto {
	
	private String approveStatus;
	
	private String approveMessage;
	
	private Integer approveUserNum;
	
}
