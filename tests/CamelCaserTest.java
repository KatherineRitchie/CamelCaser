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
        IllegalArgumentException e = new IllegalArgumentException();
        assertEquals(e, CamelCaser.camelCase("£ %^( $*)@"));
    }

    @Test
    public void invalidCharacterTestTwo() {
        IllegalArgumentException e = new IllegalArgumentException();
        assertEquals(e, CamelCaser.camelCase("hello ^^^ &&&"));
    }

    @Test
    public void invalidCharacterTestThree() {
        IllegalArgumentException e = new IllegalArgumentException();
        assertEquals(e, CamelCaser.camelCase("h£ll0"));
    }

    @Test
    public void invalidFormatTestOne() {
        IllegalArgumentException e = new IllegalArgumentException();
        assertEquals(e, CamelCaser.camelCase("this is 3invalid"));
    }

    @Test
    public void invalidFormatTestTwo() {
        IllegalArgumentException e = new IllegalArgumentException();
        assertEquals(e, CamelCaser.camelCase("1this 2is 3also 4invalid"));
    }

    @Test
    public void invalidFormatTestThree() {
        IllegalArgumentException e = new IllegalArgumentException();
        assertEquals(e, CamelCaser.camelCase("12345 sad test"));
    }

    @Test
    public void nullTest() {
        IllegalArgumentException e = new IllegalArgumentException();
        assertEquals(e, CamelCaser.camelCase(null));
    }
}