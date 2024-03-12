package detail_tracker.validation;

import javafx.scene.control.TextField;

public class ZipCodeValidator {
    private static final String ZIP_CODE_PATTERN = "\\d{5}";

/*     public static boolean isValidZipCode(TextField zipCodeField) {
        String text = zipCodeField.getText().trim();
        return text.matches(ZIP_CODE_PATTERN);
    } */

    public static ValidationResult isValidZip(TextField zipCodeField) {
        String text = zipCodeField.getText().trim();
        if (text.isEmpty()) {
            return new ValidationResult(false, "Name field is empty");
        }
        if (!text.matches(ZIP_CODE_PATTERN)) {
            return new ValidationResult(false, "Name field is invalid");
        }
        return new ValidationResult(true, null);
    }
}