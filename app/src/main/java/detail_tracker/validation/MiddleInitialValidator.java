package detail_tracker.validation;

import javafx.scene.control.TextField;

public class MiddleInitialValidator {
    private static final String NAME_PATTERN = "^[a-zA-Z]$";
    
        public static ValidationResult isValidMiddleInitial(TextField middleInitialField) {
        String text = middleInitialField.getText().trim();
        if (text.isEmpty()) {
            return new ValidationResult(true, null);
        }
        if (!text.matches(NAME_PATTERN)) {
            return new ValidationResult(false, "Middle Initial field is invalid");
        }
        return new ValidationResult(true, null);
    }
}
