import java.util.Scanner;

public class Program {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int weeks = 1;
        long minGrade = 0;

        while (weeks <= 18) {
            String weekInfo = scanner.next();
            if (weekInfo.equals("42"))
                break;
            int currWeek = scanner.nextInt();
            if (currWeek != weeks)
            {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            int currMin = 9;

            for (int i = 0; i < 5; i++) {
                int currNum = scanner.nextInt();
                if (currNum < 0 || currNum > 9)
                {
                    System.err.println("IllegalArgument");
                    System.exit(-1);
                }
                if (currNum < currMin)
                    currMin = currNum;
            }
            minGrade = (minGrade * 10) + currMin;
            weeks++;
        }
        for (int i = 1; i < weeks; i++)
        {
            long    num = minGrade / power(weeks - i);
            System.out.print("Week " + i + " ");

            while (num > 0)
            {
                System.out.print("=");
                num--;
            }
            System.out.println(">");
            minGrade = minGrade % power(weeks - i);
        }
        return;
    }

    private static long power(long weeks)
    {
        long res = 1;
        while (weeks != 1)
        {
            res = res * 10;
            weeks--;
        }
        return (res);
    }
}