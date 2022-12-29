package com.addressbookcollections.uc11sortalphabetically;

import com.addressbookcollections.uc1createcontact.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddNewContact {
    Scanner sc = new Scanner(System.in);
    List<Contact> contacts = new ArrayList<Contact>();



    public void addContact() {
        System.out.println("Please Enter the first Name : ");
        String firstName = sc.next();

        System.out.println("Please Enter the last Name : ");
        String lastName = sc.next();

        System.out.println("Please Enter the address : ");
        String address = sc.next();

        System.out.println("Please Enter the city : ");
        String city = sc.next();

        System.out.println("Please Enter the state : ");
        String state = sc.next();

        System.out.println("Please Enter the zip : ");
        String zip = sc.next();

        System.out.println("Please Enter the phone Number : ");
        String phoneNumber = sc.next();

        System.out.println("Please Enter the email : ");
        String email = sc.next();

        Contact newContact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
        contacts.add(newContact);
    }

    public Contact findContact() {
        System.out.println("\n Enter the firstName of contact to find : ");
        String name = sc.next();
        int duplicate = 0;
        Contact temp = null;
        for(Contact cont : contacts) {
            if(cont.getFirstName().equals(name)) {
                duplicate ++; //if contact found then increment
                temp = cont;
            }
        }

        if(duplicate == 1) {
            return temp;
        }

        else if(duplicate > 1) {
            System.out.println("Multiple contacts found with given name..please enter Email to find contact : ");
            String email = sc.next();
            for(Contact cont : contacts) {
                if(cont.getFirstName().equals(name) && cont.getEmail().equals(email)) {
                    return cont;
                }
            }
        }

        else{
            System.out.println("No contact with the given first name. Please enter the correct first name");
            findContact();
        }

        return temp;
    }

    public void editContact() {
        Contact contact = findContact();
        System.out.println("Enter your choice to edit: "
                + "\n 1.Edit first name"
                + "\n 2.Edit last name"
                + "\n 3.Edit address"
                + "\n 4.Edit city"
                + "\n 5.Edit state"
                + "\n 6.Edit zipcode"
                + "\n 7.Edit phone number"
                + "\n 8.Edit email");
        int choice = sc.nextInt();
        switch(choice) {
            case 1 :
                System.out.println("Enter new first Name ");
                String newFirstName = sc.next();
                contact.setFirstName(newFirstName);
                System.out.println("New First Name Updated");
                break;

            case 2 :
                System.out.println("Enter new last Name");
                String newLastName = sc.next();
                contact.setLastName(newLastName);
                System.out.println("New Last Name Updated");
                break;

            case 3 :
                System.out.println("Enter new Address");
                String newAdderss = sc.next();
                contact.setAddress(newAdderss);
                System.out.println("New Address Updated");
                break;

            case 4 :
                System.out.println("Enter new City");
                String newCity = sc.next();
                contact.setCity(newCity);
                System.out.println("New City Updated");
                break;

            case 5 :
                System.out.println("Enter fnew State");
                String newState = sc.next();
                contact.setState(newState);
                System.out.println("New State Updated");
                break;


            case 6 :
                System.out.println("Enter new zip Code");
                String newZip = sc.next();
                contact.setZip(newZip);
                System.out.println("New Zip code Updated");
                break;

            case 7 :
                System.out.println("Enter new Phone Number");
                String newPhoneNumber = sc.next();
                contact.setPhone(newPhoneNumber);
                System.out.println("New Phone Number Updated");
                break;

            case 8 :
                System.out.println("Enter new email");
                String newEmail = sc.next();
                contact.setEmail(newEmail);
                System.out.println("New Email Updated");
                break;

            default:
                System.out.println("Please enter a number between 1 to 8 only...");
                break;
        }
        System.out.println("The contact after editing is : " + contact);
    }


    public void displayContact() {
        System.out.println(contacts);
    }


    public void deleteContact() {
        Contact contact = findContact();
        if (contact == null) {
            System.out.println("No contact found with the given name");
            return;
        }

        contacts.remove(contact);
        System.out.println("The contact has been deleted from the Address Book");
    }

    public void addMultipleContact() {
        System.out.println("Enter no of contact yo want to enter : ");
        int num = sc.nextInt();
        for(int i=0; i<num; i++) {
            System.out.println("Enter the details of contact");
            addContact();
        }
    }
    public void sortByName() {
        List<Contact> list = contacts.stream().collect(Collectors.toList());
        list.stream().sorted((g1, g2) -> ((String) g1.getFirstName()).compareTo(g2.getFirstName()))
                .forEach(contact -> System.out.println(contact.getFirstName() + " " + contact.getLastName()));
    }

}
