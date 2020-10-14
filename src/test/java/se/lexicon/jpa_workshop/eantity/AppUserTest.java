package se.lexicon.jpa_workshop.eantity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.jpa_workshop.entity.AppUser;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Mehrdad Javan
 * Date: Oct, 2020
 */
public class AppUserTest {

    AppUser testObject;

    @BeforeEach
    public void setUp() {
        testObject = new AppUser(1, "Mehrdad", "Javan", "mehrdad.javan@lexicon.se");
    }

    @Test
    public void test_successfully_created() {
        assertEquals(1, testObject.getAppUserId());
        assertEquals("Mehrdad", testObject.getFirstName());
        assertEquals("Javan", testObject.getLastName());
        assertEquals("mehrdad.javan@lexicon.se", testObject.getEmail());
    }

    @Test
    public void test_equal(){
        AppUser isEqual =  new AppUser(1, "Mehrdad", "Javan", "mehrdad.javan@lexicon.se");
        assertTrue(testObject.equals(isEqual));
    }

    @Test
    public void test_hashCode(){
        AppUser  expected_obj =  new AppUser(1, "Mehrdad", "Javan", "mehrdad.javan@lexicon.se");
        assertEquals(expected_obj.hashCode(),testObject.hashCode());
    }

    @Test
    public void test_toString(){
        String toString = testObject.toString();
        assertTrue(toString.contains("1"));
        assertTrue(toString.contains("Mehrdad"));
        assertTrue(toString.contains("Javan"));
        assertTrue(toString.contains("mehrdad.javan@lexicon.se"));
    }
}
