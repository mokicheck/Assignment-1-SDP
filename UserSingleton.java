public class UserSingleton {
    // Объявление поля для хранения единственного экземпляра класса
    private static UserSingleton instance;

    // Поле для хранения имени пользователя
    private String username;

    // Приватный конструктор, чтобы предотвратить создание экземпляров извне
    private UserSingleton() {}

    // Метод для получения экземпляра UserSingleton
    public static UserSingleton getInstance() {
        if (instance == null) {
            instance = new UserSingleton();
        }
        return instance;
    }

    // Метод для получения имени пользователя
    public String getUsername() {
        return username;
    }

    // Метод для установки имени пользователя
    public void setUsername(String username) {
        this.username = username;
    }
}
