
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FileReader implements SignReader {
    private final String DONE = "DONE";
    private final String NOTDONE = "NOTDONE";

    public List<String> getTypes(Map<short[], String> map) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<String> res = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals(TER)) {
            boolean isDone = false;

            for (short[] key : map.keySet()) {
                FileInputStream fileScanner = new FileInputStream(input);

                short[] fileContent = getBytes(key.length, fileScanner);
                fileScanner.close();
                if (isEqualBytes(key, fileContent)) {
                    res.add(map.get(key));
                    isDone = true;
                    break;
                }
            }
            System.out.println(isDone ? DONE : NOTDONE);
            input = scanner.nextLine();
        }
        return (res);
    }

    private static short[] getBytes(int len, FileInputStream fileScanner) throws IOException {
        short[] bytes = new short[len];

        for (int i = 0; i < len; i++) {
            bytes[i] = (short) fileScanner.read();
        }
        return (bytes);
    }

    private static boolean isEqualBytes(short[] key, short[] fileContent) {
        for (int i = 0; i < key.length; i++) {
            if (key[i] != fileContent[i])
                return (false);
        }
        return (true);
    }
}