public class Program {
    public static void main(String[] args) throws InterruptedException {
        int count;
        if (args.length != 1) {
            System.out.println("Wrong count of arguments\nUsage: \"--count=\"<quantity>");
            System.exit(1);
        }
        if (!args[0].startsWith("--count=")) {
            System.out.println("Wrong flag.\nUsage: \"--count=\"<quantity>");
            System.exit(1);
        }
        count = getCount(args[0]);
        Thread egg = new Thread(new Egg(count));
        Thread hen = new Thread(new Hen(count));

        egg.start();
        hen.start();

        egg.join();
        hen.join();

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