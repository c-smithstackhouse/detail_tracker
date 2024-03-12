package detail_tracker.validation;

import javafx.scene.control.TextField;

public class CityValidator {
    private static final String CITY_NAME_PATTERN = "^[a-zA-Z ]+$";

    /* 
    public static boolean isValidCityName(TextField cityField) {
        String text = cityField.getText().trim();
        return text.matches(CITY_NAME_PATTERN);
    }
    */

    public static ValidationResult isValidCity(TextField cityField) {
        String text = cityField.getText().trim();
        if (text.isEmpty()) {
            return new ValidationResult(false, "City field is empty");
        }
        if (!text.matches(CITY_NAME_PATTERN)) {
            return new ValidationResult(false, "City field is invalid");
        }
        return new ValidationResult(true, null);
    }
}