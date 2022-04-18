

public class Program{
	public static void main (String args[]){
		int	number = 9999999;
		int	res = 0;

		if (number < 99999 || number > 999999)
		{
			System.out.print("You have to set 6-digit <number>\n");
			System.exit(1);
		}
		while (number > 0)
		{
			res = res + (number % 10);
			number = number / 10;
		}
		System.out.print(res);
	}
}