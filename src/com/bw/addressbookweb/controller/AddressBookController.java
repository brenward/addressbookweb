package com.bw.addressbookweb.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bw.addressbookweb.dao.AddressBookDao;
import com.bw.addressbookweb.model.Address;
import com.bw.addressbookweb.model.AddressBookEntry;

@Controller
public class AddressBookController {
	
	@Autowired
	AddressBookDao addressBookDao;
	
	@RequestMapping("/")
	public String showHome(Model model){
		System.out.println("showHome()");
		ArrayList<AddressBookEntry> addresses = addressBookDao.getAddressBook();
		model.addAttribute("addresses",addresses);
		return "home";		
	}
	
	@RequestMapping("/delete")
	public String showDelete(Model model){
		ArrayList<AddressBookEntry> addresses = addressBookDao.getAddressBook();
		model.addAttribute("addresses",addresses);
		return "delete";
		
	}
	
	@RequestMapping("/edit")
	public String showEdit(Model model){
		ArrayList<AddressBookEntry> addresses = addressBookDao.getAddressBook();
		model.addAttribute("addresses",addresses);
		return "edit";
		
	}
	
	@RequestMapping("/add")
	public String showAdd(Model model){
		ArrayList<AddressBookEntry> addresses = addressBookDao.getAddressBook();
		model.addAttribute("addresses",addresses);
		return "add";
		
	}
	
	@RequestMapping(value="/addentry", method=RequestMethod.POST)
	public String showEntryAdded(Model model, HttpServletRequest request){
		AddressBookEntry entry = new AddressBookEntry(
				0,
				request.getParameter("fname"),
				request.getParameter("lname"),
				new Address(request.getParameter("address1"), request.getParameter("address2"),	request.getParameter("town"),request.getParameter("city")),
				request.getParameter("phone"),
				request.getParameter("email"),
				request.getParameter("zip"));
		System.out.println(entry.toString());
		addressBookDao.createEntry(entry);
		ArrayList<AddressBookEntry> addresses = addressBookDao.getAddressBook();
		model.addAttribute("addresses",addresses);
		return "home";
	}
	
	@RequestMapping(value="/deleteentry", method=RequestMethod.POST)
	public String showEntryDeleted(Model model, HttpServletRequest request){
		System.out.println(request.getParameter("id"));
		addressBookDao.deleteEntry(Integer.parseInt(request.getParameter("id")));
		ArrayList<AddressBookEntry> addresses = addressBookDao.getAddressBook();
		model.addAttribute("addresses",addresses);
		return "home";
	}
	
	@RequestMapping(value="/editentry", method=RequestMethod.POST)
	public String showEntryEdited(Model model, HttpServletRequest request){
		AddressBookEntry entry = new AddressBookEntry(
				Integer.parseInt(request.getParameter("id")),
				request.getParameter("fname"),
				request.getParameter("lname"),
				new Address(request.getParameter("address1"), request.getParameter("address2"),	request.getParameter("town"),request.getParameter("city")),
				request.getParameter("phone"),
				request.getParameter("email"),
				request.getParameter("zip"));
		System.out.println(entry.toString());
		addressBookDao.editEntryByID(Integer.parseInt(request.getParameter("id")), entry);
		ArrayList<AddressBookEntry> addresses = addressBookDao.getAddressBook();
		model.addAttribute("addresses",addresses);
		return "home";
	}
	
	@RequestMapping("/sortbyname")
	public String sortByName(Model model){
		addressBookDao.sortByName();
		ArrayList<AddressBookEntry> addresses = addressBookDao.getAddressBook();
		model.addAttribute("addresses",addresses);
		return "home";	
	}
	
	@RequestMapping("/sortbyzip")
	public String sortByZip(Model model){
		addressBookDao.sortByZip();
		ArrayList<AddressBookEntry> addresses = addressBookDao.getAddressBook();
		model.addAttribute("addresses",addresses);
		return "home";	
	}
}
