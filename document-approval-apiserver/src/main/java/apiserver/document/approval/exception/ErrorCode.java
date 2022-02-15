package apiserver.document.approval.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    /* 400 BAD_REQUEST : 잘못된 요청 */
	USER_JOIN_FAIL(HttpStatus.BAD_REQUEST, "회원가입을 실패하였습니다."),
	DUPLICATE_ID(HttpStatus.BAD_REQUEST, "이미 회원가입되어있는 ID입니다."),
    APRV_COMPLETE(HttpStatus.BAD_REQUEST, "결재가 이미 완료 또는 반려된 문서입니다."),
    POST_DOC_FAIL(HttpStatus.BAD_REQUEST, "문서 생성에 실패하였습니다."),
    POST_APRV_LINE_FAIL(HttpStatus.BAD_REQUEST, "결재라 생성에 실패하였습니다."),
    APRV_DOC_FAIL(HttpStatus.BAD_REQUEST, "문서 결재를 실패하였습니다."),
    APRV_INVALID_SEPARATOR(HttpStatus.BAD_REQUEST, "결재자 리스트의 구분자를 ','로 지정해주세요."),
    INVALID_INPUT(HttpStatus.BAD_REQUEST, "입력값을 확인해주세요."),

    /* 401 UNAUTHORIZED : 인증되지 않은 사용자 */
    UNAUTHORIZED_USER(HttpStatus.UNAUTHORIZED, "해당 문서에 결재권한이 없습니다."),

    /* 404 NOT_FOUND : Resource 를 찾을 수 없음 */
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 사용자 정보를 찾을 수 없습니다."),
    APRV_USER_NOT_FOUND(HttpStatus.NOT_FOUND, "결재자 정보를 찾을 수 없습니다."),
    DOC_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 문서입니다."),
    ;

    private final HttpStatus httpStatus;
    private final String detail;
}
