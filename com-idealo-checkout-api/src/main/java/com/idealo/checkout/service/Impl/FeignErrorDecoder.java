package com.idealo.checkout.service.Impl;

import com.idealo.checkout.exception.BadRequestException;
import com.idealo.checkout.exception.InternalServiceException;
import feign.Response;
import feign.codec.ErrorDecoder;

import static com.idealo.checkout.utils.AppConst.BAD_REQUEST;
import static com.idealo.checkout.utils.AppConst.INTERNAL_SERVER_ERROR;

public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        switch (response.status()) {
            case INTERNAL_SERVER_ERROR -> throw new InternalServiceException("Response status: " + response.status() + ", Response reason: " + response.reason() + ", methodKey: " + s);
            case BAD_REQUEST -> throw new BadRequestException("Response status: " + response.status() + ", Response reason: " + response.reason() + ", methodKey: " + s);
            default -> throw new IllegalStateException("Unexpected value: " + response.status());
        }
    }
}
