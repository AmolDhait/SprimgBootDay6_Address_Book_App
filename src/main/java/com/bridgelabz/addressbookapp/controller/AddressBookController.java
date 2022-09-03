package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.entity.AddressBookData;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import com.bridgelabz.addressbookapp.service.AddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.MimeMessage;
import java.util.List;

@RestController
//@RequestMapping("/addressbookservice")
@Slf4j
public class AddressBookController {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private AddressBookRepository addressBookRepository;
    @Autowired
    private AddressBookService addressBookService;

    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<ResponseDTO> getAddressBookData(){
        List<AddressBookData> addressBookDataList = null;
        addressBookDataList = addressBookService.getAddressBookData();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success", addressBookDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/get/{personId}")
    public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("personId")int personId){
        AddressBookData addressBookData = null;
        addressBookData = addressBookService.getAddressBookDataById(personId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call For Id Successful!!", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);    }

    @GetMapping("/mail/{personId}")
    public ResponseEntity<ResponseDTO> sendMail(@PathVariable("personId")int personId){
        AddressBookData addressBookData = addressBookRepository.findById(personId).get();
        sendmail(addressBookData);
        return new ResponseEntity<ResponseDTO>(HttpStatus.OK);
    }

    private void sendmail(AddressBookData addressBookData){

        final String emailToRecipient = addressBookData.getEmailId();
        final String emailSubject = "Successfully Email Send by Person Email Address";
        final String emailMessage = "Sir/Mam, This is Mail Form DataBase , Your Details successfully Store In Database ";

        javaMailSender.send(new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper( mimeMessage,true,"UTF-8");
                mimeMessageHelper.setTo(emailToRecipient);
                mimeMessageHelper.setText(emailMessage, true);
                mimeMessageHelper.setSubject(emailSubject);
                System.out.println("mailsend");
            }
        });
    }



    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addAddressBookData(@RequestBody AddressBookDTO addressBookDTO){
        AddressBookData addressBookData = null;
        addressBookData = addressBookService.createAddressBookData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Address Book Data Successfully: ", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);    }

    @PutMapping("/update/{personId}")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("personId") int personId, @RequestBody AddressBookDTO addressBookDTO){
        AddressBookData addressBookData = null;
        addressBookData = addressBookService.updateAddressBookData(personId, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Address Book Data Successfully:", addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);    }

    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("personId")int personId){
        addressBookService.deleteAddressBookData(personId);
        ResponseDTO responseDTO = new ResponseDTO("Address Book Data Deleted Successfully: ", "Delete Id:" +personId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
