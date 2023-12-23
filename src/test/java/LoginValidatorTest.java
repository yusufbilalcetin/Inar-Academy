package test.java;

import main.java.LoginValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class LoginValidatorTest {

    @Test
    void testValidUsername() {
        LoginValidator validator = new LoginValidator();
        assertTrue(validator.validateUsername("user@gmail.com"));
    }

    @Test
    void testUsernameWithoutAtSymbol() {
        LoginValidator validator = new LoginValidator();
        assertFalse(validator.validateUsername("usergmail.com"));
    }

    @Test
    void testUsernameWithoutDomain() {
        LoginValidator validator = new LoginValidator();
        assertFalse(validator.validateUsername("user@"));
    }

    @Test
    void testUsernameWithInvalidCharacters() {
        LoginValidator validator = new LoginValidator();
        assertFalse(validator.validateUsername("user@#$%.com"));
    }

    @Test
    void testEmptyUsername() {
        LoginValidator validator = new LoginValidator();
        assertFalse(validator.validateUsername(""));
    }

    @Test
    void testNullUsername() {
        LoginValidator validator = new LoginValidator();
        assertFalse(validator.validateUsername(null));
    }

    @Test
    void testValidPassword() {
        LoginValidator validator = new LoginValidator();
        assertTrue(validator.validatePassword("P@ssw0rd"));
    }

    @Test
    void testPasswordExactly_8_CharactersWithSpecialCharacters() {
        LoginValidator validator = new LoginValidator();
        assertTrue(validator.validatePassword("P@ssw0rd"));
    }

    @Test
    void testPasswordExactly_16_CharactersWithSpecialCharacters() {
        LoginValidator validator = new LoginValidator();
        assertTrue(validator.validatePassword("ThisIsExactly16@"));
    }

    @Test
    void testPasswordLessThan_8_Characters() {
        LoginValidator validator = new LoginValidator();
        assertFalse(validator.validatePassword("Pass@1"));
    }

    @Test
    void testPasswordMoreThan16Characters() {
        LoginValidator validator = new LoginValidator();
        assertFalse(validator.validatePassword("ThisIsAVeryLongPasswordWithMoreThan16Characters"));
    }

    @Test
    void testPasswordWithoutNumber() {
        LoginValidator validator = new LoginValidator();
        assertFalse(validator.validatePassword("PasswordWithoutNumber@"));
    }

    @Test
    void testPasswordWithoutSpecialCharacter() {
        LoginValidator validator = new LoginValidator();
        assertFalse(validator.validatePassword("PasswordWithoutSpecialCharacter123"));
    }

    @Test
    void testEmptyPassword() {
        LoginValidator validator = new LoginValidator();
        assertFalse(validator.validatePassword(""));
    }

    @Test
    void testNullPassword() {
        LoginValidator validator = new LoginValidator();
        assertFalse(validator.validatePassword(null));
    }
}
