package detail_tracker.validation;

import javafx.scene.control.TextField;

public class PhoneValidator {
    private static final String PHONE_NUMBER_PATTERN = "\\d{10}";

/*     public static boolean isValidPhoneNumber(TextField phoneField) {
        String text = phoneField.getText().trim();
        return text.matches(PHONE_NUMBER_PATTERN);
    } */

    public static ValidationResult isValidPhone(TextField phoneField) {
        String text = phoneField.getText().trim();
        if (text.isEmpty()) {
            return new ValidationResult(false, "Name field is empty");
        }
        if (!text.matches(PHONE_NUMBER_PATTERN)) {
            return new ValidationResult(false, "Name field is invalid");
        }
        return new ValidationResult(true, null);
    }
}