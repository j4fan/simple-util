package com.j4fan.simpleutils.common;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * response dto
 */
@Data
@Accessors(chain = true)
public class Result {
    private int code;
    private String message;

    private Object data;

    public Result setCode(ResultCode code) {
        this.code = code.code;
        return this;
    }

}
