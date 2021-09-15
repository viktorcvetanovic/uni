/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import cs102.dz12.domaci3.Main;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {

    public MainTest() {
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

    @Test(expected = NullPointerException.class)
    public void testExceptionNullPointer() {
        Main.parniBrojevi(null);
    }

    @Test
    public void textNegative() {
        int broj = Main.parniBrojevi(-52);
        assertEquals(broj, 1);
    }

    @Test
    public void test() {
        int broj = Main.parniBrojevi(22);
        assertEquals(broj, 2);
    }

    @Test
    public void testZero() {
        int broj = Main.parniBrojevi(0);
        assertEquals(broj, 0);
    }

}
