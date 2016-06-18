package com.bw.addressbookweb.controller;

import java.util.Scanner;

import com.bw.addressbookweb.dao.AddressBookDao;
import com.bw.addressbookweb.dao.AddressBookDaoDB;
import com.bw.addressbookweb.dao.AddressBookDaoFile;
import com.bw.addressbookweb.view.UserInterface;

public class AddressBookControllerOld {
	private AddressBookDao addressBookDao;
	private UserInterface userInterface;
	
	public AddressBookControllerOld(){
		addressBookDao = new AddressBookDaoFile();		
		userInterface = new UserInterface(new Scanner(System.in));
	}
	
	public static void main(String[] args) {
		AddressBookControllerOld  addressBookController = new AddressBookControllerOld();
		boolean exit = false;
		String input = addressBookController.userInterface.start();
		while(!exit){
			if(input.equalsIgnoreCase("q")){
				exit = true;
			}else if(input.equalsIgnoreCase("p")){
				addressBookController.addressBookDao.printAddressBook();
			}else if(input.equalsIgnoreCase("s")){
				input = addressBookController.userInterface.sort();
				if(input.equalsIgnoreCase("n")){
					addressBookController.addressBookDao.sortByName();
				}else if(input.equalsIgnoreCase("z")){
					addressBookController.addressBookDao.sortByZip();
				}
				addressBookController.addressBookDao.printAddressBook();
			}else if(input.equalsIgnoreCase("a")){
				boolean added = addressBookController.addressBookDao.createEntry(addressBookController.userInterface.addEditDeleteEntry());
				addressBookController.userInterface.added(added);
			}else if(input.equalsIgnoreCase("e")){
				boolean edited = addressBookController.addressBookDao.editEntryByID(addressBookController.userInterface.addressId(),addressBookController.userInterface.addEditDeleteEntry());
				addressBookController.userInterface.edited(edited);
			}else if(input.equalsIgnoreCase("d")){
				boolean deleted = addressBookController.addressBookDao.deleteEntry(addressBookController.userInterface.addressId());
				addressBookController.userInterface.deleted(deleted);
			}
			
			if(!exit){
				input = addressBookController.userInterface.start();
			}else{
				System.out.println("Exiting");
			}
		}

	}
}
