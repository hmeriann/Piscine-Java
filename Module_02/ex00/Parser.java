
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Parser implements SignReader {
    private final Scanner scanner;

    public Parser(File signatures) throws FileNotFoundException {
        this.scanner = new Scanner((signatures));
    }

    private String getNextLine() {
        if (scanner.hasNextLine()) {
            return (scanner.nextLine());
        }
        return ("");
    }

    private String getValue(String line) {
        return (line.substring(0, line.indexOf(SEP)));
    }

    private String getKey(String line) {
        return (line.substring(line.indexOf(SEP) + 2));
    }

    private short[] makeBytesFromKey(String key) {
        int count = countBytes(key);
        short[] res = new short[count];

        Scanner keyPars = new Scanner(key).useRadix(16);

        for (int i = 0; i < count; i++) {
            res[i] = keyPars.nextShort();
        }
        return  (res);
    }

    private int countBytes(String key) {
        int count = 0;

        Scanner keyPars = new Scanner(key).useRadix(16);

        while (keyPars.hasNextShort()) {
            keyPars.nextShort();
            count++;
        }
        keyPars.close();
        return (count);
    }

    public Map<short[], String> parseToHashMap() {
        Map<short[], String> res = new HashMap<>();
        String line = this.getNextLine();

        while (!line.isEmpty()) {
            short[] key = makeBytesFromKey(getKey(line));
            String value = getValue(line);
            if (key.length > 0 && !value.isEmpty()) {
                res.put(key, value);
            }
            line = this.getNextLine();
        }
        return (res);
    }
}