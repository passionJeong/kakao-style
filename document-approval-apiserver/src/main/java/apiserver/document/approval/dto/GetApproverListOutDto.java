package apiserver.document.approval.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetApproverListOutDto {

	//ID
	private String userId;
	
	//직원번호
	private Integer userNum;

}
