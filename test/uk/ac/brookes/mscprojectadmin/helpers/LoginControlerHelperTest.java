/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.brookes.mscprojectadmin.helpers;

import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import uk.ac.brookes.mscprojectadmin.beans.User;

/**
 *
 * @author oussamak
 */
public class LoginControlerHelperTest {
    
    public LoginControlerHelperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of validateLoginDetails method, of class LoginControlerHelper.
     */
    @Test
    public void testValidateLoginDetails() {
        System.out.println("validateLoginDetails");
        String idNumber = "";
        String password = "";
        LoginControlerHelper instance = new LoginControlerHelper();
        Map expResult = null;
        Map result = instance.validateLoginDetails(idNumber, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isRegistered method, of class LoginControlerHelper.
     */
    @Test
    public void testIsRegistered() throws Exception {
        System.out.println("isRegistered");
        User user = null;
        LoginControlerHelper instance = new LoginControlerHelper();
        boolean expResult = false;
        boolean result = instance.isRegistered(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dashboardURL method, of class LoginControlerHelper.
     */
    @Test
    public void testDashboardURL() {
        System.out.println("dashboardURL");
        User user = null;
        LoginControlerHelper instance = new LoginControlerHelper();
        String expResult = "";
        String result = instance.dashboardURL(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
