package com.sprint.sb06deokhugamteam01.exception.book;

import com.sprint.sb06deokhugamteam01.exception.ErrorCode;
import com.sprint.sb06deokhugamteam01.exception.RootException;

import java.util.Map;

public class NoSuchBookException extends RootException {

    public NoSuchBookException(Map<String, Object> details) {
        super(ErrorCode.BOOK_NOT_FOUND, details);
    }
}
