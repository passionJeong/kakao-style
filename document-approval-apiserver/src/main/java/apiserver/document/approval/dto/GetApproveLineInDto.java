package apiserver.document.approval.dto;

import javax.validation.constraints.NotNull;

import lombok.Setter;

@Setter
public class GetApproveLineInDto {
	
	@NotNull(message = "문서번호를 입력해주세요.")
	private Integer documentNum;

}
