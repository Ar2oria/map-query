package edu.hrbust.common.dto.response;

import lombok.Getter;

@Getter
public enum StatusCodeEnum {
    OK(0),
    ParameterInvalid(2),
    VerifyFailure(3),
    QuotaFailure(4),
    AKFailure (5);

    StatusCodeEnum(Integer code){
        this.code = code;
    }
    private Integer code;
}