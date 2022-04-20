package ex00;

public class Program {
    public static void main(String args[]){

        User    tom = new User();
        User    jerry = new User();

        tom.setIdentifier(1);
        tom.setName("Thomas");
        tom.setBalance(1000000);

        jerry.setIdentifier(2);
        jerry.setName("Jeremy");
        jerry.setBalance(-1000000);

        System.out.println("Created User <" + tom.getName() + "> with ID <" +  tom.getIdentifier() + ">.\n His balance is <" + tom.getBalance() + ">$.");
        System.out.println("Created User <" + jerry.getName() + "> with ID <" +  jerry.getIdentifier() + ">.\n His balance is <" + jerry.getBalance() + ">$.");

        Transaction toJerry = new Transaction(tom, jerry, 300);
        System.out.println("Created User <" + tom.getName() + "> with ID <" +  tom.getIdentifier() + ">.\n His balance is <" + tom.getBalance() + ">$.");
        System.out.println("Created User <" + jerry.getName() + "> with ID <" +  jerry.getIdentifier() + ">.\n His balance is <" + jerry.getBalance() + ">$.");

        Transaction negativeToJerry = new Transaction(tom, jerry, -400);
        System.out.println("Created User <" + tom.getName() + "> with ID <" +  tom.getIdentifier() + ">.\n His balance is <" + tom.getBalance() + ">$.");
        System.out.println("Created User <" + jerry.getName() + "> with ID <" +  jerry.getIdentifier() + ">.\n His balance is <" + jerry.getBalance() + ">$.");
    }
}