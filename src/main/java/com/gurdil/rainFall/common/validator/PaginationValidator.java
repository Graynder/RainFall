package com.gurdil.rainFall.common.validator;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public final class PaginationValidator {

    public static final PageRequest paginationValidator(Integer page, Integer limit) {

        PageRequest pageRequest;

        if (page != null) {
            if (limit != null) {
                pageRequest = PageRequest.of(page, limit);
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
        } else if (limit != null) {
            pageRequest = PageRequest.of(0, limit);
        } else {
            pageRequest = null;
        }
        return pageRequest;
    }
}

