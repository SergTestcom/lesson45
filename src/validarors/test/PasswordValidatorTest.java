package validarors.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import validarors.utils.PasswordValidator;

import javax.annotation.processing.SupportedAnnotationTypes;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {
    static PasswordValidator validarot;

    @BeforeAll
    static void setUpAll(){
        validarot = new PasswordValidator();

    }

    @Test
    void testValidPassword(){
        assertTrue(PasswordValidator.isStrong("Qwertty0!"));
        assertTrue(PasswordValidator.isStrong("Qwertty0?"));
        assertTrue(PasswordValidator.isStrong("Qwertty0@"));
        assertTrue(PasswordValidator.isStrong("Qwertty0#"));
    }

    @Test
    void testSymbolsLessThan8(){
        //TODO

    }

    @Test
    void testInvalidSpecSymbol(){
        assertFalse(PasswordValidator.isStrong("Qwerty0 "));
        assertFalse(PasswordValidator.isStrong("Qwe^rty0"));
        assertFalse(PasswordValidator.isStrong("~Qwerty0"));

    }

    @Test
    void testNoUpperCase(){
        assertFalse(PasswordValidator.isStrong("qwerty2!"));
    }

    @Test
    void testNoLowerCase(){
        assertFalse(PasswordValidator.isStrong("QWE§RTY2!"));

    }

    @Test
    void testNull() {
         assertFalse(PasswordValidator.isStrong(null));

    }

}
