package test.java;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.easymock.EasyMock;
import static org.powermock.api.easymock.PowerMock.mockStatic;
import static org.powermock.api.easymock.PowerMock.replay;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.bw.addressbookweb.dao.AddressBookDaoDB;
import com.bw.addressbookweb.model.AddressBookEntry;
import com.mysql.jdbc.Connection;

@RunWith(PowerMockRunner.class)
@PrepareForTest({DriverManager.class, AddressBookDaoDB.class})
public class AddressBookDaoDBTest {
	private AddressBookDaoDB addressBookDaoDB;
	//private ArrayList<AddressBookEntry> addressBook;
	
	@Before
	public void Setup(){
		addressBookDaoDB = new AddressBookDaoDB();
	}
	
	@Test
	public void getAddressBookTest(){
		
	}
	
	@Test
	public void deleteEntryTest(){
		
		try {
		
			Connection conn = EasyMock.createMock(Connection.class);
			Field field = addressBookDaoDB.getClass().getDeclaredField("deleteStatement");
			Field url = addressBookDaoDB.getClass().getDeclaredField("url");
			Field username = addressBookDaoDB.getClass().getDeclaredField("username");
			Field password = addressBookDaoDB.getClass().getDeclaredField("password");
			field.setAccessible(true);
			url.setAccessible(true);
			username.setAccessible(true);
			password.setAccessible(true);
			String deleteStatement = (String) field.get(addressBookDaoDB);
			
			mockStatic(DriverManager.class);
			EasyMock.expect(DriverManager.getConnection((String) url.get(addressBookDaoDB), 
					(String) username.get(addressBookDaoDB), (String) password.get(addressBookDaoDB))).andReturn(conn);
			EasyMock.expect(DriverManager.getConnection(null))
            .andReturn(null);
			replay(DriverManager.class);
			PreparedStatement stmt = EasyMock.createMock(PreparedStatement.class);
			
			EasyMock.expect(conn.prepareStatement(deleteStatement)).andReturn(stmt);
			conn.close();
			EasyMock.expectLastCall();
			EasyMock.replay(conn);
			stmt.setInt(1,1);
			EasyMock.expect(stmt.executeUpdate()).andReturn(0);		
			stmt.close();
			EasyMock.expectLastCall();
			EasyMock.replay(stmt);
			assertTrue(addressBookDaoDB.deleteEntry(1));
			
			EasyMock.verify(conn);
			EasyMock.verify(stmt);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
	public void clearDown(){
		
	}

}
