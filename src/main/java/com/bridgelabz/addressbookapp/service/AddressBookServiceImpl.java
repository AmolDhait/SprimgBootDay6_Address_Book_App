package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.entity.AddressBookData;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AddressBookServiceImpl implements AddressBookService{

    @Autowired
    private AddressBookRepository addressBookRepository;
    //private List<AddressBookData> addressBookDataList =
            //new ArrayList<>();

    @Override
    public List<AddressBookData> getAddressBookData() {

        return addressBookRepository.findAll();
    }

    @Override
    public AddressBookData getAddressBookDataById(int personId)
    {
        return addressBookRepository
                .findById(personId)
                .orElseThrow(()-> new AddressBookException
                        ("Person with personId" +personId + "does not exit"));
    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(addressBookDTO);
        log.debug("Address Bokk Data: " +addressBookData.toString());
                return addressBookRepository.save(addressBookData);
    }

    @Override
    public AddressBookData updateAddressBookData(int personId, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.getAddressBookDataById(personId);
       addressBookData.updateAddressBookData(addressBookDTO);
        return addressBookRepository.save(addressBookData);
    }

    @Override
    public void deleteAddressBookData(int personId) {
        AddressBookData addressBookData=
                this.getAddressBookDataById(personId);
        addressBookRepository.delete(addressBookData);
    }
}
