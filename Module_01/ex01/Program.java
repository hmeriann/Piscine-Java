package ex01;

public class Program {
    public static void main(String args[]){

for (int i = 0; i < 10; i++) {
                User tmp;
                if (i % 2 == 0) {
                    tmp = new User("Even", i);
                }	else {
                    tmp = new User("Odd", i);
                }
                System.out.println("User " + tmp.getName() + "\t#" + i + ", with\tid: <" + tmp.getIdentifier() + ">;");
        }
    }
}