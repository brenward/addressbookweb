package test.java;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.easymock.EasyMock;
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
	public void showHomeTest(){
		AddressBookDao addressBookDao;
		
		try{
			//Mocks the private field addressbookDao
			addressBookDao = EasyMock.createMock(AddressBookDaoDB.class);
			Field field = addressBookController.getClass().getDeclaredField("addressBookDao");
			field.setAccessible(true);
			field.set(addressBookController, addressBookDao);
			
			//Mocks the model to be passed in
			Model model = EasyMock.createMock(Model.class);
			
			//Mocked address book to return when getAddressBook called 
			ArrayList<AddressBookEntry> mockedAddressBook = new ArrayList<AddressBookEntry>();
			AddressBookEntry entry1 = new AddressBookEntry(1,"fname","lname",new Address("add1","add2","town","city"),"123","test@test.ie","1ft");
			mockedAddressBook.add(entry1);
			EasyMock.expect(addressBookDao.getAddressBook()).andReturn(mockedAddressBook);			
			EasyMock.replay(addressBookDao);
			
			//Testing method
			String test = addressBookController.showHome(model);	
			assertEquals("home", test);
			EasyMock.verify(addressBookDao);
		}catch(Exception e){
			System.out.println("No such field exception");
			e.printStackTrace();
		}	
	}
	
	@Test
	public void showDeleteTest(){
		AddressBookDao addressBookDao;
		
		try{
			addressBookDao = EasyMock.createMock(AddressBookDaoDB.class);
			Field field = addressBookController.getClass().getDeclaredField("addressBookDao");
			field.setAccessible(true);
			field.set(addressBookController, addressBookDao);
			
			Model model = EasyMock.createMock(Model.class);
			ArrayList<AddressBookEntry> mockedAddressBook = new ArrayList<AddressBookEntry>();
			AddressBookEntry entry1 = new AddressBookEntry(1,"fname","lname",new Address("add1","add2","town","city"),"123","test@test.ie","1ft");
			mockedAddressBook.add(entry1);
			EasyMock.expect(addressBookDao.getAddressBook()).andReturn(mockedAddressBook);
			
			EasyMock.replay(addressBookDao);
			String test = addressBookController.showDelete(model);	
			assertEquals("delete", test);
			EasyMock.verify(addressBookDao);
		}catch(Exception e){
			System.out.println("No such field exception");
			e.printStackTrace();
		}	
	}
	
	@Test
	public void showEditTest(){
		AddressBookDao addressBookDao;
		
		try{
			addressBookDao = EasyMock.createMock(AddressBookDaoDB.class);
			Field field = addressBookController.getClass().getDeclaredField("addressBookDao");
			field.setAccessible(true);
			field.set(addressBookController, addressBookDao);
			
			Model model = EasyMock.createMock(Model.class);
			ArrayList<AddressBookEntry> mockedAddressBook = new ArrayList<AddressBookEntry>();
			AddressBookEntry entry1 = new AddressBookEntry(1,"fname","lname",new Address("add1","add2","town","city"),"123","test@test.ie","1ft");
			mockedAddressBook.add(entry1);
			EasyMock.expect(addressBookDao.getAddressBook()).andReturn(mockedAddressBook);
			
			EasyMock.replay(addressBookDao);
			String test = addressBookController.showEdit(model);	
			assertEquals("edit", test);
			EasyMock.verify(addressBookDao);
		}catch(Exception e){
			System.out.println("No such field exception");
			e.printStackTrace();
		}	
	}
	
	@Test
	public void showAddTest(){
		AddressBookDao addressBookDao;
		
		try{
			addressBookDao = EasyMock.createMock(AddressBookDaoDB.class);
			Field field = addressBookController.getClass().getDeclaredField("addressBookDao");
			field.setAccessible(true);
			field.set(addressBookController, addressBookDao);
			
			Model model = EasyMock.createMock(Model.class);
			ArrayList<AddressBookEntry> mockedAddressBook = new ArrayList<AddressBookEntry>();
			AddressBookEntry entry1 = new AddressBookEntry(1,"fname","lname",new Address("add1","add2","town","city"),"123","test@test.ie","1ft");
			mockedAddressBook.add(entry1);
			EasyMock.expect(addressBookDao.getAddressBook()).andReturn(mockedAddressBook);
			
			EasyMock.replay(addressBookDao);
			String test = addressBookController.showAdd(model);	
			assertEquals("add", test);
			EasyMock.verify(addressBookDao);
		}catch(Exception e){
			System.out.println("No such field exception");
			e.printStackTrace();
		}	
	}
		
	@Test
	public void sortByNameTest(){
		AddressBookDao addressBookDao;
		
		try{
			addressBookDao = EasyMock.createMock(AddressBookDaoDB.class);
			Field field = addressBookController.getClass().getDeclaredField("addressBookDao");
			field.setAccessible(true);
			field.set(addressBookController, addressBookDao);
			
			Model model = EasyMock.createMock(Model.class);
			ArrayList<AddressBookEntry> mockedAddressBook = new ArrayList<AddressBookEntry>();
			AddressBookEntry entry1 = new AddressBookEntry(1,"fname","lname",new Address("add1","add2","town","city"),"123","test@test.ie","1ft");
			AddressBookEntry entry2 = new AddressBookEntry(1,"fname","lname",new Address("add1","add2","town","city"),"123","test@test.ie","2ft");
			mockedAddressBook.add(entry1);
			mockedAddressBook.add(entry2);
			addressBookDao.sortByName();
			EasyMock.expect(addressBookDao.getAddressBook()).andReturn(mockedAddressBook);
			
			EasyMock.replay(addressBookDao);
			String test = addressBookController.sortByName(model);	
			assertEquals("home", test);
			EasyMock.verify(addressBookDao);
		}catch(Exception e){
			System.out.println("No such field exception");
			e.printStackTrace();
		}	
	}
	
	@Test
	public void sortByZipTest(){
		AddressBookDao addressBookDao;
		
		try{
			addressBookDao = EasyMock.createMock(AddressBookDaoDB.class);
			Field field = addressBookController.getClass().getDeclaredField("addressBookDao");
			field.setAccessible(true);
			field.set(addressBookController, addressBookDao);
			
			Model model = EasyMock.createMock(Model.class);
			ArrayList<AddressBookEntry> mockedAddressBook = new ArrayList<AddressBookEntry>();
			AddressBookEntry entry1 = new AddressBookEntry(1,"fname","lname",new Address("add1","add2","town","city"),"123","test@test.ie","1ft");
			AddressBookEntry entry2 = new AddressBookEntry(1,"fname","lname",new Address("add1","add2","town","city"),"123","test@test.ie","2ft");
			mockedAddressBook.add(entry1);
			mockedAddressBook.add(entry2);
			addressBookDao.sortByZip();
			EasyMock.expect(addressBookDao.getAddressBook()).andReturn(mockedAddressBook);
			
			EasyMock.replay(addressBookDao);
			String test = addressBookController.sortByZip(model);	
			assertEquals("home", test);
			EasyMock.verify(addressBookDao);
		}catch(Exception e){
			System.out.println("No such field exception");
			e.printStackTrace();
		}	
	}
	
	@Test
	public void showEntryAddedTest(){
		AddressBookDao addressBookDao;
		
		try{
			addressBookDao = EasyMock.createMock(AddressBookDaoDB.class);
			Field field = addressBookController.getClass().getDeclaredField("addressBookDao");
			field.setAccessible(true);
			field.set(addressBookController, addressBookDao);
			
			Model model = EasyMock.createMock(Model.class);
			HttpServletRequest request = EasyMock.createMock(HttpServletRequest.class);
			EasyMock.expect(request.getParameter("fname")).andReturn("1");
			EasyMock.expect(request.getParameter("lname")).andReturn("1");
			EasyMock.expect(request.getParameter("address1")).andReturn("1");
			EasyMock.expect(request.getParameter("address2")).andReturn("1");
			EasyMock.expect(request.getParameter("town")).andReturn("1");
			EasyMock.expect(request.getParameter("city")).andReturn("1");
			EasyMock.expect(request.getParameter("phone")).andReturn("1");
			EasyMock.expect(request.getParameter("email")).andReturn("1");
			EasyMock.expect(request.getParameter("zip")).andReturn("1");
			EasyMock.replay(request);
			
			ArrayList<AddressBookEntry> mockedAddressBook = new ArrayList<AddressBookEntry>();
			AddressBookEntry entry1 = new AddressBookEntry(1,"fname","lname",new Address("add1","add2","town","city"),"123","test@test.ie","1ft");
			AddressBookEntry entry2 = new AddressBookEntry(1,"fname","lname",new Address("add1","add2","town","city"),"123","test@test.ie","2ft");
			AddressBookEntry entry3 = new AddressBookEntry(0,"1","1",new Address("1","1","1","1"),"1","1","1");
			mockedAddressBook.add(entry1);
			mockedAddressBook.add(entry2);
			EasyMock.expect(addressBookDao.createEntry(entry3)).andReturn(true);
			EasyMock.expect(addressBookDao.getAddressBook()).andReturn(mockedAddressBook);
			
			EasyMock.replay(addressBookDao);
			String test = addressBookController.showEntryAdded(model, request);	
			assertEquals("home", test);
			EasyMock.verify(request);
			EasyMock.verify(addressBookDao);
		}catch(Exception e){
			System.out.println("No such field exception");
			e.printStackTrace();
		}	
	}
	
	
	@Test
	public void showEntryDeletedTest(){
		AddressBookDao addressBookDao;
		
		try{
			addressBookDao = EasyMock.createMock(AddressBookDaoDB.class);
			Field field = addressBookController.getClass().getDeclaredField("addressBookDao");
			field.setAccessible(true);
			field.set(addressBookController, addressBookDao);
			
			Model model = EasyMock.createMock(Model.class);
			HttpServletRequest request = EasyMock.createMock(HttpServletRequest.class);
			EasyMock.expect(request.getParameter("id")).andReturn("1");
			EasyMock.expect(request.getParameter("id")).andReturn("1");
			EasyMock.replay(request);
			
			ArrayList<AddressBookEntry> mockedAddressBook = new ArrayList<AddressBookEntry>();
			AddressBookEntry entry1 = new AddressBookEntry(1,"fname","lname",new Address("add1","add2","town","city"),"123","test@test.ie","1ft");
			AddressBookEntry entry2 = new AddressBookEntry(1,"fname","lname",new Address("add1","add2","town","city"),"123","test@test.ie","2ft");
			mockedAddressBook.add(entry1);
			mockedAddressBook.add(entry2);
			EasyMock.expect(addressBookDao.deleteEntry(1)).andReturn(true);
			EasyMock.expect(addressBookDao.getAddressBook()).andReturn(mockedAddressBook);
			
			EasyMock.replay(addressBookDao);
			String test = addressBookController.showEntryDeleted(model, request);	
			assertEquals("home", test);
			EasyMock.verify(request);
			EasyMock.verify(addressBookDao);
		}catch(Exception e){
			System.out.println("No such field exception");
			e.printStackTrace();
		}	
	}
	
	@Test
	public void showEntryEditedTest(){
		AddressBookDao addressBookDao;
		
		try{
			addressBookDao = EasyMock.createMock(AddressBookDaoDB.class);
			Field field = addressBookController.getClass().getDeclaredField("addressBookDao");
			field.setAccessible(true);
			field.set(addressBookController, addressBookDao);
			
			Model model = EasyMock.createMock(Model.class);
			HttpServletRequest request = EasyMock.createMock(HttpServletRequest.class);
			EasyMock.expect(request.getParameter("id")).andReturn("0");
			EasyMock.expect(request.getParameter("fname")).andReturn("1");
			EasyMock.expect(request.getParameter("lname")).andReturn("1");
			EasyMock.expect(request.getParameter("address1")).andReturn("1");
			EasyMock.expect(request.getParameter("address2")).andReturn("1");
			EasyMock.expect(request.getParameter("town")).andReturn("1");
			EasyMock.expect(request.getParameter("city")).andReturn("1");
			EasyMock.expect(request.getParameter("phone")).andReturn("1");
			EasyMock.expect(request.getParameter("email")).andReturn("1");
			EasyMock.expect(request.getParameter("zip")).andReturn("1");
			EasyMock.expect(request.getParameter("id")).andReturn("0");
			EasyMock.replay(request);
			
			ArrayList<AddressBookEntry> mockedAddressBook = new ArrayList<AddressBookEntry>();
			AddressBookEntry entry1 = new AddressBookEntry(1,"fname","lname",new Address("add1","add2","town","city"),"123","test@test.ie","1ft");
			AddressBookEntry entry2 = new AddressBookEntry(1,"fname","lname",new Address("add1","add2","town","city"),"123","test@test.ie","2ft");
			AddressBookEntry entry3 = new AddressBookEntry(0,"1","1",new Address("1","1","1","1"),"1","1","1");
			mockedAddressBook.add(entry1);
			mockedAddressBook.add(entry2);
			EasyMock.expect(addressBookDao.editEntryByID(0, entry3)).andReturn(true);
			EasyMock.expect(addressBookDao.getAddressBook()).andReturn(mockedAddressBook);
			
			EasyMock.replay(addressBookDao);
			String test = addressBookController.showEntryEdited(model, request);	
			assertEquals("home", test);
			EasyMock.verify(request);
			EasyMock.verify(addressBookDao);
		}catch(Exception e){
			System.out.println("No such field exception");
			e.printStackTrace();
		}	
	}
	
	@After
	public void clearDown(){
		
	}
}
