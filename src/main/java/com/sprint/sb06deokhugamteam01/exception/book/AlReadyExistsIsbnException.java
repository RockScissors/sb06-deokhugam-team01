package com.sprint.sb06deokhugamteam01.exception.book;

import com.sprint.sb06deokhugamteam01.exception.ErrorCode;
import com.sprint.sb06deokhugamteam01.exception.RootException;

import java.util.Map;

public class AlReadyExistsIsbnException extends RootException {

    ErrorCode errorCode = ErrorCode.ALREADY_EXISTS_ISBN;

    public AlReadyExistsIsbnException(Map<String, Object> details) {
        super(ErrorCode.ALREADY_EXISTS_ISBN, details);
    }
}
