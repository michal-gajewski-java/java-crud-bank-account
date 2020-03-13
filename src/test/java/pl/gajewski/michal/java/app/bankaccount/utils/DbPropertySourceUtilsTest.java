package pl.gajewski.michal.java.app.bankaccount.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DbPropertySourceUtilsTest {
    private static final String WRONG_KEY = "1";
    private static final String CORRECT_KEY = "db.id.name";

    @Test
    void givenWrongKey_WhenGetProperty_ThenValueEqualsNull() {
        //Given
        //When
        String value = DbPropertySourceUtils.getProperty(WRONG_KEY);
        //Then
        Assertions.assertNull(value, "Wrong value");
    }

    @Test
    void givenCorrectKey_WhenGetProperty_ThenValueEquals() {
        //Given
        //When
        String value = DbPropertySourceUtils.getProperty(CORRECT_KEY);
        //Then
        Assertions.assertEquals("src\\test\\resources\\ID.txt", value, "Wrong value");
    }
}

