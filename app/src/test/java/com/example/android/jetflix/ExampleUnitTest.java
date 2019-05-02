package com.example.android.jetflix;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void equallen(){
       Signup ob=new Signup();
        assertEquals(true,ob.check_Phone_no("8194997428"));

    }
    @Test
    public void notequallen(){
        Signup ob=new Signup();
        assertEquals(false,ob.check_Phone_no("819499742"));
        assertEquals(false,ob.check_Phone_no("81949974223"));
    }
    @Test
    public void greaterlen(){
        Signup ob=new Signup();

        assertEquals(false,ob.check_Phone_no("81949974223"));
    }
    @Test
    public void smallerlen(){
        Signup ob=new Signup();

        assertEquals(false,ob.check_Phone_no("819499742"));
    }

}
