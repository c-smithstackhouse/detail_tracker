package detail_tracker.validation;

import javafx.scene.control.TextField;
import detail_tracker.validation.ValidationResult;

public class ClientValidator {

    public static ValidationResult isValidClient(TextField firstNameField, TextField middleInitialField, TextField lastNameField,
                                        TextField address1Field, TextField address2Field,
                                        TextField cityField, TextField zipCodeField, TextField mobilePhoneField,
                                        TextField landLineField, TextField emailField) {
        ValidationResult result;

        result = isValidName(firstNameField);
        if (!result.isValid()) return result;

        result = MiddleInitialValidator.isValidMiddleInitial(middleInitialField);
        if (!result.isValid()) return result;

        result = isValidName(lastNameField);
        if (!result.isValid()) return result;

        result = isValidAddress(address1Field);
        if (!result.isValid()) return result;

        result = isValidCity(cityField);
        if (!result.isValid()) return result;

        result = isValidZipCode(zipCodeField);
        if (!result.isValid()) return result;

        result = isValidEmail(emailField);
        if (!result.isValid()) return result;

        result = isValidPhone(mobilePhoneField, landLineField);
        if (!result.isValid()) return result;

        return new ValidationResult(true, null);
    }

    private static ValidationResult isValidName(TextField nameField) {
        return NameValidator.isValidName(nameField);
    }

    private static ValidationResult isValidMiddleInitial(TextField middleInitialField) {
        return MiddleInitialValidator.isValidMiddleInitial(middleInitialField);
    }

    private static ValidationResult isValidAddress(TextField addressField) {
        return AddressValidator.isValidAddress(addressField);
    }

    private static ValidationResult isValidCity(TextField cityField) {
        return CityValidator.isValidCity(cityField);
    }

    private static ValidationResult isValidZipCode(TextField zipCodeField) {
        return ZipCodeValidator.isValidZip(zipCodeField);
    }

    private static ValidationResult isValidEmail(TextField emailField) {
        return EmailValidator.isValidEmail(emailField);
    }

    private static ValidationResult isValidPhone(TextField mobilePhoneField, TextField landLineField) {
        // Validate the phone fields. At least one must be filled.
        ValidationResult mobileResult = PhoneValidator.isValidPhone(mobilePhoneField);
        ValidationResult landLineResult = PhoneValidator.isValidPhone(landLineField);
        if (!mobileResult.isValid() && !landLineResult.isValid()) {
            return new ValidationResult(false, "At least one phone number must be valid");
        }
        return new ValidationResult(true, null);
    }
}