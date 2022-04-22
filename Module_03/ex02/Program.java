import java.util.Random;

public class Program {
    public static void main(String[] args) throws InterruptedException {
        int arrSize;
        int threadsCount;
        int[] sum = new int[1];
        int sectionSize = 0;
        int sumArrayElements = 0;
        int[] randomArray;
        Object lock = new Object();

        if (args.length != 2) {
            System.out.println("Wrong count of arguments\nUsage: \"--arraySize=<number of array elements : 0..2_000_000> --threadsCount=<threads count>\"");
            System.exit(1);
        }
        if (!args[0].startsWith("--arraySize=") && !args[1].startsWith("--threadsCount=")) {
            System.out.println("Wrong flags\nUsage: \"--arraySize=<number of array elements : 0..2_000_000> --threadsCount=<threads count>\"");
            System.exit(1);
        }
        arrSize = getCount(args[0]);
        if (arrSize < 0 || arrSize > 2_000_000) {
            System.out.println("Wrong array size\nUsage: \"--arraySize=<number of array elements : 0..2_000_000> --threadsCount=<threads count>\"");
            System.exit(1);
        }
        threadsCount = getCount(args[1]);
        if (arrSize < threadsCount){
            System.out.println("Wrong threads count\nThreads count should be less than array size\"");
            System.exit(1);
        }

        randomArray = new int[arrSize];
        for (int i = 0; i < arrSize; i++)
        {
            randomArray[i] = (int) Math.round((Math.random() * 2000) - 1000);
            sumArrayElements += randomArray[i];
        }
        System.out.println("Sum: " + sumArrayElements);

        sectionSize = (arrSize / (threadsCount - 1));

        for (int i = 0; i < (threadsCount); i++)
        {
            int from = i * sectionSize;
            int to = (i + 1) * sectionSize;

            if (i == (threadsCount - 1)) {
                to = arrSize;
            }

            Thread eachThread = new Thread(new EachThread(from, to, sum, randomArray, i, lock));

            try {
                eachThread.start();
                eachThread.join();
            } catch (InterruptedException e) {
                System.err.println(e.getStackTrace());
                System.exit(1);
            }
        }
        System.out.println("Sum by threads: " + sum[0]);

    }

    private static int getCount(String arg) {
        String str[] = arg.split("=");
        int i = 0;

        if (str.length != 2) {
            System.out.println("Count not set.\nUsage: \"--count=\"<quantity>");
            System.exit(1);
        }
        try {
            i = Integer.parseInt(str[1]);
        } catch (NumberFormatException e) {
            System.err.println(e.getStackTrace());
            System.exit(1);
        }
        return (i);
    }

}