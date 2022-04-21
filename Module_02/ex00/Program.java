

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class Program {
    private static final String SIGN = "/Users/zu/Documents/School21/Level5/Piscine-Java/Module_02/ex00/signatures.txt";
    private static final String RESULT = "/Users/zu/Documents/School21/Level5/Piscine-Java/Module_02/ex00/result.txt";

    public static void main(String[] args) throws IOException {
        Parser parser = new Parser(new File(SIGN));

        Map<short[], String> parsedSigns = parser.parseToHashMap();
        List<String> res = new FileReader().getTypes(parsedSigns);
        makeRes(res);
    }

    public static void makeRes(List<String> res) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(RESULT);

        for (String line : res) {
            outputStream.write((line + '\n').getBytes(StandardCharsets.UTF_8));
        }
    }
}