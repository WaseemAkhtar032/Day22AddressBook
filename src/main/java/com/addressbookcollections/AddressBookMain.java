package com.addressbookcollections;

import com.addressbookcollections.uc1createcontact.Contact;

import java.util.ArrayList;
import java.util.List;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program...!!!");

        List<Contact> contact = new ArrayList<Contact>();

        Contact newContact = new Contact("Wasee", "Ansari", "Dhule", "Pune", "Maharastra", "424001", "8237791113","wasee@gmail.com");

        contact.add(newContact);
        System.out.println(contact);
    }
}