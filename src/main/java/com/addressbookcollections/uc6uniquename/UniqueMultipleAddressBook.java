package com.addressbookcollections.uc6uniquename;

import com.addressbookcollections.uc2addnewcontact.AddNewContact;
import com.addressbookcollections.uc4deletecontact.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * Added Multiple address book with each address book has unique name
 *
 */
public class UniqueMultipleAddressBook {

    /**
     * Hashmap to add multiple address book
     */
    Map<String, AddNewContact> addressMap = new HashMap<>();

    public void addAddress() {
        System.out.println("Enter New Address book name :");
        Scanner sc = new Scanner(System.in);
        String bookname = sc.next();
        if(addressMap.containsKey(bookname)) {
            System.out.println("Address book with given name is exist. Please enter new Name ");
            addAddress();
        }
        else {
            AddNewContact addNewContact = new AddNewContact();
            addressMap.put(bookname, addNewContact);
            System.out.println("Address Book Successfully Added");
        }
        sc.close();
    }

    /**
     * Method to add contact in address book
     */
    public void addContact() {
        System.out.println("Enter the name of Address book to add the contact.");
        Scanner sc = new Scanner(System.in);
        String newContact = sc.nextLine();
        AddNewContact addContact = addressMap.get(newContact);
        if (addContact == null) {
            System.out.println("No book found");

        } else {
            addressMap.get(newContact);                         // if present then add it to hashMap
        }
        sc.close();
    }
    /**
     * Method to edit contact in address book
     */
    public void editContact() {
        System.out.println("Enter Name of Contact you want to edit : ");
        Scanner sc = new Scanner(System.in);
        String editName = sc.next();
        if (addressMap.containsKey(editName)) {
            addressMap.get(editName);                               // calling the edit contact method to edit contacts
        } else {
            System.out.println("Contact doesn't exist, Please enter correct name.");
            editContact();
        }
        sc.close();
    }

    /**
     * Method to delete Contact in address book
     */

    public void deleteContact() {
        System.out.println("Enter Name of Contact you want to delete : ");
        Scanner sc = new Scanner(System.in);
        String bookName = sc.next();
        if (addressMap.containsKey(bookName)) {
            addressMap.get(bookName);                                            // we call the deleteContact function to delete the contact
        } else {
            System.out.println("AddressBook doesn't exist, Please enter correct name.");
            deleteContact();
        }
        sc.close();
    }



    /**
     * Method to delete Address book
     */
    public void deleteAddressBook() {
        System.out.println("Enter Name of Address Book you want to delete: ");
        Scanner sc = new Scanner(System.in);
        String bookName = sc.next();
        if (addressMap.containsKey(bookName)) {                                       //we use containsKey to check if addressBook present
            addressMap.remove(bookName);                                                 // and use remove fun to remove the book
        } else {
            System.out.println("AddressBook doesn't exist, Please enter correct name.");
            deleteAddressBook();
        }
        sc.close();
    }

    /**
     * Method to print address book
     */
    public void printBook() {
        System.out.println("Address books are");
        for (String i : addressMap.keySet()) {                                     // we use keySet to get all the keys and display it
            System.out.println(i);
        }
    }

    /**
     * Method to print contact list in address book
     */
    public void printContacts() {
        for (String i : addressMap.keySet()) {
            System.out.println(i);
            System.out.println(addressMap.get(i));                     //we print the values of the key
        }
        System.out.println(" ");
    }

}