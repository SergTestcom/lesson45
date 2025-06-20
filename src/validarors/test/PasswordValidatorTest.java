package validarors.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import validarors.utils.PasswordValidator;

import javax.annotation.processing.SupportedAnnotationTypes;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {
    static PasswordValidator validator;

    @BeforeAll
    static void setUpAll(){
        validator = new PasswordValidator();

    }

    @Test
    void testValidPassword(){
        validator.isStrong("Qwer1!ty");
        assertTrue(validator.isStrong("Qwertty0!"));
        assertTrue(validator.isStrong("Qwertty0?"));
        assertTrue(validator.isStrong("Qwertty0@"));
        assertTrue(validator.isStrong("Qwertty0#"));
    }

    @Test
    void testSymbolsLessThan8(){
        //TODO

    }

    @Test
    void testInvalidSpecSymbol(){
        assertFalse(validator.isStrong("Qwerty0 "));
        assertFalse(validator.isStrong("Qwe^rty0"));
        assertFalse(validator.isStrong("~Qwerty0"));

    }

    @Test
    void testNoUpperCase(){
        assertFalse(validator.isStrong("qwerty2!"));
    }

    @Test
    void testNoLowerCase(){
        assertFalse(validator.isStrong("QWE§RTY2!"));

    }

    @Test
    void testNull() {
         assertFalse(validator.isStrong(null));

    }

}
