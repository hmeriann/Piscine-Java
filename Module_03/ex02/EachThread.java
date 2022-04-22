public class EachThread implements Runnable {
    int from;
    int to;
    int sectionSize;
    int[] randomArray;
    int threadsCount;
    int sumByThread;

    EachThread(int from, int to, int sectionSize, int[] randomArray, int threadsCount) {
        this.from = from;
        this.to = to;
        this.sectionSize = sectionSize;
        this.randomArray = randomArray;
        this.threadsCount = threadsCount;
    }


    @Override
    public void run() {
        sumByThread = Program.getSumEachThread(from, to, randomArray);
        System.out.print("Thread " + threadsCount + " from ");
        System.out.println(from + " to " + to + " sum is " + sumByThread);
//
//        for (int i = 0; i < (i * threadsCount + this.sectionSize); i++) {
//            sumByThread = sumByThread + randomArray[i];
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }
}