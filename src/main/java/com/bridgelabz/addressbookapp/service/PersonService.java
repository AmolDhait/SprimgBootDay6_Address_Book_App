package com.bridgelabz.addressbookapp.service;


import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseLoginDTO;
import com.bridgelabz.addressbookapp.entity.AddressBookData;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import com.bridgelabz.addressbookapp.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.awt.image.BandCombineOp;
import java.util.List;

@Service
public class PersonService implements AddressBookService{

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Override
    public String loginUser(ResponseLoginDTO responseLoginDTO) {

    //AddressBookData addressBookData = AddressBookRepository.findByEmailId(responseLoginDTO.emailId);

//    if (addressBookData==null)
//        return "user not found";
//
//    if (!(bCryptPasswordEncoder.matches(responseLoginDTO.password,addressBookData.getPassword())));
//        return "User name or password incorrect";

       // String token = tokenUtil.createToken(addressBookData.getPersonId());
        return null;
    }

    @Override
    public List<AddressBookData> getAddressBookData() {
        return null;
    }

    @Override
    public AddressBookData getAddressBookDataById(int personId) {
        return null;
    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        return null;
    }

    @Override
    public AddressBookData updateAddressBookData(int personId, AddressBookDTO addressBookDTO) {
        return null;
    }

    @Override
    public void deleteAddressBookData(int personId) {

    }
}
