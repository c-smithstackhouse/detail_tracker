package detail_tracker.validation;

import javafx.scene.control.TextField;

public class AddressValidator {
    private static final String STREET_NAME_PATTERN = "^[a-zA-Z0-9 ]+$";

    /* 
    public static boolean isValidStreetName(TextField addressField) {
        String text = addressField.getText().trim();
        return text.matches(STREET_NAME_PATTERN);
    }
    */

    public static ValidationResult isValidAddress(TextField addressField) {
        String text = addressField.getText().trim();
        if (text.isEmpty()) {
            return new ValidationResult(false, "Address field is empty");
        }
        if (!text.matches(STREET_NAME_PATTERN)) {
            return new ValidationResult(false, "Address field is invalid");
        }
        return new ValidationResult(true, null);
    }
}