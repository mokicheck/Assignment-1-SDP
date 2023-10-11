import java.util.Scanner;

public class AuthenticationExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 
        UserSingleton user = UserSingleton.getInstance();
        System.out.print("Введите имя пользователя: ");
        String username = scanner.nextLine();
        user.setUsername(username);

        // 
        AuthenticationStrategy passwordAuth = (inputUsername, password) -> {
            
            return true;
        };

        AuthenticationStrategy oauthAuth = (inputUsername, oauthToken) -> {
            
            return true; 
        };

        //Аутентификация с разными стратегиями
        boolean passwordResult = authenticate(passwordAuth, username, getPasswordFromUser(scanner));
        boolean oauthResult = authenticate(oauthAuth, username, getOAuthTokenFromUser(scanner));

        //Вывод результатов аутентификации
        System.out.println("Password authentication result: " + passwordResult);
        System.out.println("OAuth authentication result: " + oauthResult);
    }

    //  метод для аутентификации с использованием стратегии
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
