public class Main {
    public static void main(String[] args) {
        System.out.println(checkValidate("test", "test", "test"));
        System.out.println(checkValidate("Login", "test", "Test"));
        System.out.println(checkValidate("Login!", "test", "test"));
        System.out.println(checkValidate("login", "Test!", "Test"));



    }

    public static boolean checkValidate(
            String login,
            String password,
            String confirmPassword) {
        try {
            return Data.validate(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Ошибка при валидации логина: " + e.getMessage());
            return false;
        } catch (WrongPasswordException e) {
            System.out.println("Ошибка при валидации пароля: " + e.getMessage());
            return false;
        }
    }
}