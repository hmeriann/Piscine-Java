import java.util.Random;

public class Program {

    private int sumInThread;

    Program() { this.sumInThread = 0; }

    int getSumInThread() { return this.sumInThread; }


    public static void main(String[] args) throws InterruptedException {
        int arrSize;
        int threadsCount;
        int sectionSize;
        int sumArrayElements = 0;
        int sumByAllThreads = 0;
        int[] randomArray;

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

        randomArray = new int[arrSize];
        for (int i = 0; i < arrSize; i++)
        {
//            randomArray[i] = new Random().nextInt((1_001 - (-1_000))) + (-1_000);
            randomArray[i] = (int) Math.round((Math.random() * 2000) - 1000);
            System.out.print(randomArray[i]+ "->");
            sumArrayElements += i;
        }
        System.out.println("Sum: " + sumArrayElements);

        threadsCount = getCount(args[1]);
        sectionSize = arrSize / threadsCount;

        for (int i = 0; i < (threadsCount - 1); i++)
        {
            int from = i * (sectionSize - 1);
            int to = i + (sectionSize - 1);
            Thread eachThread = new Thread(new EachThread(from, to, sectionSize, randomArray, i));
            eachThread.start();
//            sumByAllThreads = sumByAllThreads;
            eachThread.join();
        }
        Thread lastThread = new Thread(new EachThread((sectionSize*(threadsCount - 1)), (arrSize - 1), sectionSize, randomArray, threadsCount));
        lastThread.start();
        lastThread.join();
        System.out.println("Sum by threads: " + sumByAllThreads);

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

    public static int getSumEachThread(int from, int to, int[] randomArray) {
        int sum = 0;

        for (int i = from; i < to; i++)
            sum += randomArray[i];
        return sum;
    }

//    public static int getTotalSum() {
//        int total = 0;
//
//
//        return total;
//    }
}