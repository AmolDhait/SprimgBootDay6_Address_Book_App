package com.bridgelabz.addressbookapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public @Data class ResponseDTO {

    private String message;
    private Object data;

}
