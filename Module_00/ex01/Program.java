import java.util.Scanner;

public class Program{
	public static void main (String args[]){
		Scanner	number = new Scanner(System.in);
		System.out.print("->");
		Integer num = number.nextInt();

		if (num.isEmpty())
		{
			System.err.print("IllegalArgument");
//			System.exit(1);
		}
		System.out.println(number);
	}
}