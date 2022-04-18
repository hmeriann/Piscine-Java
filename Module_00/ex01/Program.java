import java.util.Scanner;

public class Program{
	public static void main (String args[]){
		Scanner	number = new Scanner(System.in);
		System.out.print("->");

		int	num = number.nextInt();
		boolean simple = true;
//		int	count = 0;
		int	i = 2;

		if (num <= 1)
		{
			System.err.println("IllegalArgument");
			System.exit(-1);
		} else if (num == 2 || num == 3) {
//			count++;
			System.out.print(simple + " " + (i - 1) + "\n");
		} else
		{
			while (i <= ft_sqrt(num))
			{
				if (num % i == 0) {
					simple = false;
					break;
				}
				i++;
//				count++;
			}
			if (simple)
				System.out.print(simple + " " + (ft_sqrt(num) - 1) + "\n");
			else
				System.out.print(simple + " " + (ft_sqrt(num) - 1) + "\n");
		}
	}

	private static int	ft_sqrt(int num)
	{
		int i = 1;
		int res = 0;
		while (num > 0)
		{
			num = num - i;
			i += 2;
			res++;
		}
		return (res);
	}
}