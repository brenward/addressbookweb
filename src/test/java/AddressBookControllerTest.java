package test.java;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.easymock.EasyMock;
import org.easymock.EasyMockSupport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;

import com.bw.addressbookweb.controller.AddressBookController;
import com.bw.addressbookweb.dao.AddressBookDao;
import com.bw.addressbookweb.dao.AddressBookDaoDB;
import com.bw.addressbookweb.model.Address;
import com.bw.addressbookweb.model.AddressBookEntry;

public class AddressBookControllerTest{
	AddressBookController addressBookController;
	
	@Before
	public void setup(){
		addressBookController = new AddressBookController();
		
		
	}
	
	@Test
	public void testTest(){
		Model model = EasyMock.createMock(Model.class);
		ArrayList<AddressBookEntry> mockedAddressBook = new ArrayList<AddressBookEntry>();
		AddressBookEntry entry1 = new AddressBookEntry(1,"fname","lname",new Address("add1","add2","town","city"),"123","test@test.ie","1ft");
		mockedAddressBook.add(entry1);
		AddressBookDao addressBookDao = EasyMock.createMock(AddressBookDaoDB.class);
		EasyMock.expect(addressBookDao.getAddressBook()).andReturn(mockedAddressBook);
		
		EasyMock.replay(addressBookDao);
		addressBookController.setAddressBookDao(addressBookDao);
		String test = addressBookController.showHome(model);	
		assertEquals("home", test);

		EasyMock.verify(addressBookDao);
		
	}
	
	@After
	public void clearDown(){
		
	}
}
