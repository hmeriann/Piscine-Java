package ex01;

public class User {
    private Integer identifier;
    private String  name;
    private Integer balance;

    public User() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        if (balance < 0)
            this.balance = 0;
        else
            this.balance = balance;
    }
}