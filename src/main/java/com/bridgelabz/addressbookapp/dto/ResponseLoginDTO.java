package com.bridgelabz.addressbookapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public @Data class  ResponseLoginDTO {
    public String  emailId;
    public String password;

    public ResponseLoginDTO() {
    }
}
