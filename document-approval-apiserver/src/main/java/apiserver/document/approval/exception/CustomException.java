package apiserver.document.approval.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@SuppressWarnings("serial")
@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {
    private final ErrorCode errorCode;
}