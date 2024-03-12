package detail_tracker.validation;

import javafx.scene.control.TextField;

public class NameValidator {
    private static final String NAME_PATTERN = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";

    /* 
    public static boolean isValidName(TextField nameField) {
        String text = nameField.getText().trim();
        return text.matches(NAME_PATTERN);
    }
    /* */

    public static ValidationResult isValidName(TextField nameField) {
        String text = nameField.getText().trim();
        if (text.isEmpty()) {
            return new ValidationResult(false, "Name field is empty");
        }
        if (!text.matches(NAME_PATTERN)) {
            return new ValidationResult(false, "Name field is invalid");
        }
        return new ValidationResult(true, null);
    }
}
