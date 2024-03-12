package detail_tracker.validation;

import javafx.scene.control.TextField;

public class EmailValidator {
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";

    /*
    public static boolean isValidEmail(TextField emailField) {
        String text = emailField.getText().trim();
        return text.matches(EMAIL_PATTERN);
    }
    */

    public static ValidationResult isValidEmail(TextField emailField) {
        String text = emailField.getText().trim();
        if (text.isEmpty()) {
            return new ValidationResult(false, "Name field is empty");
        }
        if (!text.matches(EMAIL_PATTERN)) {
            return new ValidationResult(false, "Name field is invalid");
        }
        return new ValidationResult(true, null);
    }
}