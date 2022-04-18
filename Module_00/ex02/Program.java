import java.util.Scanner;

public class Program{
    public static void main (String args[]){
        int count = 0;

        while (true)
        {
            Scanner	number = new Scanner(System.in);
            System.out.print("->");

            int	num = number.nextInt();
            int res;
            int n = num;
            int	i = 2;
            boolean simple = true;

            if (num == 42)
            {
                System.out.print("Count of coffee - request - " + count + "\n");
                break;
            } else if (num <= 1) {
                continue;
            } else if (num == 2 || num == 3) {
                count += 1;
            } else {
                res = 0;
                while (n > 0)
                {
                    res = res + (n % 10);
                    n = n / 10;
                }
                while (i <= ft_sqrt(res))
                {
                    if (res % i == 0) {
                        simple = false;
                        break;
                    }
                    i++;
                }
                if (simple)
                    count += 1;
            }
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