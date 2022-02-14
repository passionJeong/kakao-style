package apiserver.document.approval.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PutDocumentApproveStatusInDto {
	
	//문서번호
	@NotNull(message = "문서번호를 입력해주세요.")
	private Integer documentNum;
	
	//승인/거절한 직원번호
	@NotNull(message = "직원번호를 입력해주세요.")
	private Integer approveUserNum;
	
	//승인 또는 거절
	@Size(min = 1, max = 1, message = "승인(A) 또는 거절(D) 값을 입력해주세요.")
	@NotNull(message = "승인(A) 또는 거절(D) 값을 입력해주세요.")
	private String approveStatus;
	
	//결재 메시지
	@Size(max = 100, message = "메시지는 최대 100자 입니다.")
	private String approveMessage;
}
