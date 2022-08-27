package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.entity.AddressBookData;

import java.util.List;

public interface AddressBookService {

    List<AddressBookData> getAddressBookData();
    AddressBookData getAddressBookDataById(int personId);
    AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);
    AddressBookData updateAddressBookData(int personId, AddressBookDTO addressBookDTO);
    void deleteAddressBookData(int personId);
}
