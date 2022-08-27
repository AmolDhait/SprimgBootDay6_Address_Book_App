package com.bridgelabz.addressbookapp.dto;

import com.bridgelabz.addressbookapp.entity.AddressBookData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ResponseDTO {

    private String message;
    private Object data;

}
