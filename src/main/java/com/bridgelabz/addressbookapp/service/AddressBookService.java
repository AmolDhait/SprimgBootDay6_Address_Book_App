package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseLoginDTO;
import com.bridgelabz.addressbookapp.entity.AddressBookData;

import java.util.List;

public interface AddressBookService {

    String loginUser(ResponseLoginDTO responseLoginDTO);

    List<AddressBookData> getAddressBookData();
    AddressBookData getAddressBookDataById(int personId);
    AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);
    AddressBookData updateAddressBookData(int personId, AddressBookDTO addressBookDTO);
    void deleteAddressBookData(int personId);
}
