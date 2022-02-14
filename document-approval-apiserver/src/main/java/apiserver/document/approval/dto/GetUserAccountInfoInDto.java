package apiserver.document.approval.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserAccountInfoInDto {
	
	//사용자 ID
	@NotNull(message = "ID를 입력해주세요.")
	@Size(min = 5, max = 20, message = "ID의 길이는 5~20자입니다.")
	private String userId;

	@NotNull(message = "비밀번호를 입력해주세요.")
	@Size(min = 5, max = 20, message = "비밀번호의 길이는 5~20자입니다.")
	private String userPw;
	
}
