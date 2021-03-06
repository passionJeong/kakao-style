package apiserver.document.approval.dto;

import javax.validation.constraints.NotNull;

import lombok.Setter;

@Setter
public class GetInboxListInDto {
	
	//직원 번호
	@NotNull(message = "직원번호를 입력해주세요.")
	private Integer userNum;

}
