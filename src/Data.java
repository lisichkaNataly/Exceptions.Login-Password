import java.util.Objects;

public class Data {

    private static final String INVALID_LENGTH = "Длина может быть от 1 до 20 символов";
    private static final String INVALID_SYMBOL = "Строка должна содержать в себе только латинские буквы, цифры и знак подчеркивания";
    private static final String PASSWORDS_NOT_MATCH = "Пароли и подтверждение пароля не совпадает";

    public static boolean validate(
            String login,
            String password,
            String confirmPassword) {
        if (isLengthNotInRange(login, 1, 20)) {
            throw new WrongLoginException(INVALID_LENGTH);
        }
        if (isSymbolIsNotValid(login)) {
            throw new WrongLoginException(INVALID_SYMBOL);
        }
        // проверка логина с помощью регулярного выражения
        if (!isValid(login)) {
            throw new WrongLoginException("Validation Failed");
        }
        if (isLengthNotInRange(password, 1, 20)) {
            throw new WrongPasswordException(INVALID_LENGTH);
        }
        if (isSymbolIsNotValid(password)) {
            throw new WrongPasswordException(INVALID_SYMBOL);
        }
        if (!Objects.equals(password, confirmPassword)) {
            throw new WrongPasswordException(PASSWORDS_NOT_MATCH);
        }
        return true;
    }
    //метод проверки с помощью регулярного выражения
    public static boolean isValid(String value) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        return value.matches("^[a-zA-Z0-9_]{1,20}$");
    }

    private static boolean isLengthNotInRange(String value, int min, int max) {
        if (value == null) {
            return true;
        }
        int length = value.length();
        return length < min || length > max;
    }

    private static boolean isSymbolIsNotValid(String value) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        for (char c : value.toCharArray()) {
            boolean symbolMatches = (c >= 'a' && c <= 'z')
                    || (c >= 'A' && c <= 'Z')
                    || (Character.isDigit(c))
                    || (c == '_');
            if (!symbolMatches) {
                return true;
            }
        }
        return false;
    }


}
