package com.bridgelabz.addressbookapp.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public @Data class AddressBookDTO {

    @Pattern(regexp ="^[A-Z]{1}[a-zA-Z\\s]{2,}$",
            message = "Person First name Invalid" )
    public String firstName;

    @Pattern(regexp ="^[A-Z]{1}[a-zA-Z\\s]{2,}$",
    message = "Person last Name Invalid" )
    public String lastName;

    @Pattern(regexp = "male|female",
            message = "Gender needs to be male or female")
    public String gender;

    @NotBlank(message = "Address cannot be Empty")
    public String address;

    @Pattern(regexp = "^[A-Z][a-z]+$", message = "City Name is Invalid")
    public String city;

    @Pattern(regexp = "^[A-Z][a-z]+[\\s[A-Z][a-z]+]*$", message = "State Name is Invalid")
    public String state;

    @Pattern(regexp = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$", message = "Zip Code Is Invalid")
    public int zipCode;

    @Pattern(regexp = "^[789][0-9]{9}$", message = "Phone Number Is Invalid")
    public long phoneNumber;

    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",flags = Pattern.Flag.CASE_INSENSITIVE,message = "Email Id Is Invalid")
    public String emailId;


//    public AddressBookDTO(String firstName, String lastName, String gender, String address, String city, String state, int zipCode, long phoneNumber, String emailId) {
//        "firstName" : "firstName"
//        "lastName" : lastName,
//        "gender" : gender,
//        "address" : address;
//        "city" : city;
//        "state" : state;
//       "zipCode" : zipCode;
//        "phoneNumber" : phoneNumber;
//        "emailId" : emailId;
//    }
//
//    @Override
//    public String toString() {
//        return "AddressBookDTO{" +
//                "firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", gender='" + gender + '\'' +
//                ", address='" + address + '\'' +
//                ", city='" + city + '\'' +
//                ", state='" + state + '\'' +
//                ", zipCode=" + zipCode +
//                ", phoneNumber=" + phoneNumber +
//                ", emailId='" + emailId + '\'' +
//                '}';
//    }
}
