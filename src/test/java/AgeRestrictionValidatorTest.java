package test.java;


import main.java.AgeRestrictionValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AgeRestrictionValidatorTest {

    //BOUNDARY ANALYSIS//

    @Test
    void test_just_below_minimumAge() {
        AgeRestrictionValidator validator = new AgeRestrictionValidator();
        assertFalse(validator.isEligible(17));

    }

    @Test
    void test_age_at_minimumAge() {
        AgeRestrictionValidator validator = new AgeRestrictionValidator();
        assertTrue(validator.isEligible(18));

    }

    @Test
    void test_age_just_above_minimumAge() {
        AgeRestrictionValidator validator = new AgeRestrictionValidator();
        assertTrue(validator.isEligible(19));

    }

    @Test
    void test_age_just_below_maximumAge() {
        AgeRestrictionValidator validator = new AgeRestrictionValidator();
        assertTrue(validator.isEligible(64));

    }

    @Test
    void test_age_at_maximumAge() {
        AgeRestrictionValidator validator = new AgeRestrictionValidator();
        assertTrue(validator.isEligible(65));

    }

    @Test
    void test_age_just_above_maximumAge() {
        AgeRestrictionValidator validator = new AgeRestrictionValidator();
        assertFalse(validator.isEligible(66));

    }

    @Test
    void test_extremeLowAge() {
        AgeRestrictionValidator validator = new AgeRestrictionValidator();
        assertFalse(validator.isEligible(2));

    }

    @Test
    void test_extremeHighAge() {
        AgeRestrictionValidator validator = new AgeRestrictionValidator();
        assertFalse(validator.isEligible(198));

    }
}
