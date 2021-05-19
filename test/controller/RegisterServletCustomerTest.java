/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.sql.SQLException;
import model.Customer;
/**
 *
 * @author ormus
 */
public class RegisterServletCustomerTest {
    
    public RegisterServletCustomerTest() {
    }

    /**
     * Test of doPost method, of class RegisterServletCustomer.
     * @throws java.sql.SQLException
     */
    @Test
    public void testDoPost() throws SQLException {
        System.out.println("Register Customer");
        
        HttpSession session = mock(HttpSession.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("email")).thenReturn("bcde@iobay.com");
        when(request.getParameter("password")).thenReturn("asdf1234");
        when(request.getParameter("mobile")).thenReturn("123456");
        when(request.getParameter("fname")).thenReturn("First");
        when(request.getParameter("lname")).thenReturn("Last");
        when(request.getParameter("street")).thenReturn("Street");
        when(request.getParameter("city")).thenReturn("City");
        when(request.getParameter("state")).thenReturn("NSW");
        when(request.getParameter("postcode")).thenReturn("4444");
        when(request.getParameter("country")).thenReturn("Australia");
        
        Customer customer = new Customer(
                "bcde@iotbay.com",
                "asdf1234",
                "123456",
                "First",
                "Last",
                "Street",
                "City",
                "NSW",
                "4444",
                "Australia"
        );
        assertEquals(customer, (Customer) session.getAttribute("customer"));
    }
    
}
