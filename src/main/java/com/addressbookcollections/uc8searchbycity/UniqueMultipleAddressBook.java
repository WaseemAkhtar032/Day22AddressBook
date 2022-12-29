package com.addressbookcollections.uc8searchbycity;

import com.addressbookcollections.uc1createcontact.Contact;
import com.addressbookcollections.uc2addnewcontact.AddNewContact;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class UniqueMultipleAddressBook {


    Map<String, AddNewContact> addressMap = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    public void addAddress() {
        System.out.println("Enter New Address book name :");

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


    public void addContact() {
        System.out.println("Enter the name of Address book to add the contact.");
        Scanner sc = new Scanner(System.in);
        String newContact = sc.nextLine();
        AddNewContact addContact = addressMap.get(newContact);
        if (addContact == null) {
            System.out.println("No book found");

        } else {
            addressMap.get(newContact);
        }
        sc.close();
    }

    public void editContact() {
        System.out.println("Enter Name of Contact you want to edit : ");
        Scanner sc = new Scanner(System.in);
        String editName = sc.next();
        if (addressMap.containsKey(editName)) {
            addressMap.get(editName);
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
            addressMap.get(bookName);
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
        if (addressMap.containsKey(bookName)) {
            addressMap.remove(bookName);
        } else {
            System.out.println("AddressBook doesn't exist, Please enter correct name.");
            deleteAddressBook();
        }
        sc.close();
    }


    public void printBook() {
        System.out.println("Address books are");
        for (String i : addressMap.keySet()) {
            System.out.println(i);
        }
    }

    public void printContacts() {
        for (String i : addressMap.keySet()) {
            System.out.println(i);
            System.out.println(addressMap.get(i));
        }
        System.out.println(" ");
    }
    public void searchByCity() {
        System.out.println("Enter the name of the City to search the persons : ");
        String cityName = sc.next();
        for (String i : addressMap.keySet()) {
            List<Contact> arr = (List<Contact>) addressMap.get(i);
            arr.stream().filter(person -> person.getCity().equals(cityName)).forEach(person -> System.out.println(person.getFirstName()));
        }
    }
    public void searchByState() {

        System.out.println("Enter the name of the State to Search persons : ");
        String stateName = sc.next();
        for (String i : addressMap.keySet()) {
            List<Contact>	arr = (List<Contact>) addressMap.get(i);
            arr.stream().filter(person -> person.getState().equals(stateName)).forEach(person -> System.out.println(person.getFirstName()));
        }
    }

}
