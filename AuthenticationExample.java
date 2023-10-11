import java.util.Scanner;

public class AuthenticationExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Шаг 1: Создайте экземпляр UserSingleton и установите имя пользователя
        UserSingleton user = UserSingleton.getInstance();
        System.out.print("Введите имя пользователя: ");
        String username = scanner.nextLine();
        user.setUsername(username);

        // Шаг 2: Определите стратегии аутентификации как анонимные классы (лямбда-выражения)
        AuthenticationStrategy passwordAuth = (inputUsername, password) -> {
            // Здесь может быть ваша реализация аутентификации по паролю
            return true; // Замените на вашу реальную логику
        };

        AuthenticationStrategy oauthAuth = (inputUsername, oauthToken) -> {
            // Здесь может быть ваша реализация аутентификации с использованием OAuth
            return true; // Замените на вашу реальную логику
        };

        // Шаг 3: Аутентификация с разными стратегиями
        boolean passwordResult = authenticate(passwordAuth, username, getPasswordFromUser(scanner));
        boolean oauthResult = authenticate(oauthAuth, username, getOAuthTokenFromUser(scanner));

        // Шаг 4: Вывод результатов аутентификации
        System.out.println("Password authentication result: " + passwordResult);
        System.out.println("OAuth authentication result: " + oauthResult);
    }

    // Шаг 3: Создайте метод для аутентификации с использованием стратегии
    private static boolean authenticate(AuthenticationStrategy strategy, String username, String credentials) {
        return strategy.authenticate(username, credentials);
    }

    // Метод для ввода пароля
    private static String getPasswordFromUser(Scanner scanner) {
        System.out.print("Введите пароль: ");
        return scanner.nextLine();
    }

    // Метод для ввода OAuth-токена
    private static String getOAuthTokenFromUser(Scanner scanner) {
        System.out.print("Введите OAuth-токен: ");
        return scanner.nextLine();
    }
}
