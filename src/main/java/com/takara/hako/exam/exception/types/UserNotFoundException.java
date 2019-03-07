package com.takara.hako.exam.exception.types;

import io.swagger.annotations.ApiModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author cyourin
 * @create 2019-03-05-14:09
 */
@ApiModel(description = "用户未找到异常类")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
