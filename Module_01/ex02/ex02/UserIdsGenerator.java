package ex01;

public class UserIdsGenerator {
    private static int id = 110;
    private UserIdsGenerator() {}
    private static final UserIdsGenerator INSTANCE = new UserIdsGenerator();
    public static UserIdsGenerator getInstance() {
        return UserIdsGenerator.INSTANCE;
    }
    public int generateId() {
        id++;
        return (id);
    }
}