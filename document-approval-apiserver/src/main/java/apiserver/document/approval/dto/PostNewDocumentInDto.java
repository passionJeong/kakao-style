package apiserver.document.approval.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostNewDocumentInDto {
	//제목
	@NotNull(message = "문서 제목을 입력해주세요.")
	@Size(min = 1, max = 30, message = "문서 제목 길이는 1~30자입니다.")
	private String documentTitle;
	
	//분류
	@Size(max = 30, message = "문서 타입은 최대 30자입니다.")
	private String documentType;
	
	//내용
	@Size(max = 70, message = "문서 내용은 최대 70자입니다.")
	private String documentContents;
	
	//소유자 직원번호
	@NotNull(message = "문서를 생성한 직원 번호를 입력해주세요.")
	private Integer ownerUserNum;
	
	//현재승인자 직원번호
	private Integer approveUserNum;
	
	//결재라인
	@NotNull(message = "결재 라인을 최소 1명 이상 지정해주세요.")
	@Size(min = 1, message = "결재 라인을 최소 1명 이상 지정해주세요.")
	private String approveLine;

}
