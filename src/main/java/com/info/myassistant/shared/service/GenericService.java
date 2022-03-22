package com.info.myassistant.shared.service;

import com.info.myassistant.dto.responseDto.ResponseDto;

import java.util.List;

public interface GenericService <T,ID>{
    ResponseDto create (T t);

    ResponseDto findAllById(ID id);
}
