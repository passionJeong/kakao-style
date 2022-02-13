package apiserver.document.approval.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetOutboxListInDto {
	
	//직원 번호
	@NotNull(message = "직원번호를 입력해주세요.")
	private Integer userNum;

}
