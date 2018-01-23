import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CamelCaserTest {

    @Test
    public void handoutTestCamelCase() {
        assertEquals("thisIsMyString", CamelCaser.camelCase("this is my string"));
    }

    @Test
    public void validTestWithNumbers() {
        assertEquals("val1dT3stW1thNumb3r5", CamelCaser.camelCase("val1d t3st w1th numb3r5"));
    }

    @Test
    public void upperCaseTest() {
        assertEquals("testPassesForCapitalisation", CamelCaser.camelCase("TEST PASSES FOR CAPITALISATION"));
    }

    @Test
    public void spaceAtBeginningTest() {
        assertEquals("noWeirdSpaceAtStart", CamelCaser.camelCase("            no weird space at start"));
    }

    @Test
    public void singleWordTest() {
        assertEquals("single", CamelCaser.camelCase("siNGle"));
    }

    @Test
    public void invalidCharacterTestOne() {
        try {
            CamelCaser.camelCase("£ %^( $*)@");
            fail("should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void invalidCharacterTestTwo() {
        try {
            CamelCaser.camelCase("hello ^^^ &&&");
            fail("should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void invalidCharacterTestThree() {
        try {
            CamelCaser.camelCase("h£ll0");
            fail("should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void invalidFormatTestOne() {
        try {
            CamelCaser.camelCase("this is 3invalid");
            fail("should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void invalidFormatTestTwo() {
        try {
            CamelCaser.camelCase("1this 2is 3also 4invalid");
            fail("should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void invalidFormatTestThree() {
        try {
            CamelCaser.camelCase("12345 sad test");
            fail("should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void nullTest() {
        try {
            CamelCaser.camelCase(null);
            fail("should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

}