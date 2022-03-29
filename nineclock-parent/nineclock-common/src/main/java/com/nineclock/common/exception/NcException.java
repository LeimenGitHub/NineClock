package com.nineclock.common.exception;


import com.nineclock.common.enums.ResponseEnum;
import lombok.Data;

@Data
public class NcException extends RuntimeException{

    private Integer code;

    public NcException(ResponseEnum responseEnum){
        super(responseEnum.getMessage());
        this.code = responseEnum.getCode();
    }
}
