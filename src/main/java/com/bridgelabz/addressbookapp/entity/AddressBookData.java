package com.bridgelabz.addressbookapp.entity;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table (name= "addressbook")
public @Data class AddressBookData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="person_id")
    private int personId;

    @Column(name = "first_name")
     private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "person_gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zipcode")
    private int  zipCode;

    @Column(name = "phone_number")
    private long phoneNumber;

    @Column(name = "email_Id")
    private String emailId;


    public AddressBookData( int personId, AddressBookDTO addressBookDTO)
    {
        this.personId = personId;
        this.firstName = addressBookDTO.firstName;
        this.lastName = addressBookDTO.lastName;
        this.gender = addressBookDTO.gender;
        this.address = addressBookDTO.address;
        this.city = addressBookDTO.city;
        this.state = addressBookDTO.state;
        this.zipCode = addressBookDTO.zipCode;
        this.phoneNumber = addressBookDTO.phoneNumber;
        this.emailId = addressBookDTO.emailId;

    }

    public AddressBookData() {

    }

    public AddressBookData (AddressBookDTO addressBookDTO){
        this.updateAddressBookData(addressBookDTO);
    }

    public void updateAddressBookData(AddressBookDTO addressBookDTO){
        this.firstName=addressBookDTO.firstName;
        this.lastName=addressBookDTO.lastName;
        this.gender=addressBookDTO.gender;
        this.address=addressBookDTO.address;
        this.city=addressBookDTO.city;
        this.state=addressBookDTO.state;
        this.zipCode=addressBookDTO.zipCode;
        this.phoneNumber=addressBookDTO.phoneNumber;
        this.emailId=addressBookDTO.emailId;
    }
//
//    public int getPersonId() {
//        return personId;
//    }
//
//    public void setPersonId(int personId) {
//        this.personId = personId;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public int getZipCode() {
//        return zipCode;
//    }
//
//    public void setZipCode(int zipCode) {
//        this.zipCode = zipCode;
//    }
//
//    public long getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(long phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getEmailId() {
//        return emailId;
//    }
//
//    public void setEmailId(String emailId) {
//        this.emailId = emailId;
//    }
}
