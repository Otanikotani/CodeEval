package moderate.overlappingrectangles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Main {

    private int x1A;
    private int y1A;
    private int x2A;
    private int y2A;

    private int x1B;
    private int y1B;
    private int x2B;
    private int y2B;

    public static void main(String[] args) throws IOException {
        Main overlappingrectangles = new Main();
        overlappingrectangles.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line: lines) {
            String[] coords = line.split(",");
            x1A = Integer.parseInt(coords[0]);
            y1A = Integer.parseInt(coords[1]);
            x2A = Integer.parseInt(coords[2]);
            y2A = Integer.parseInt(coords[3]);
            int x3A = x2A;
            int y3A = y1A;
            int x4A = x1A;
            int y4A = y2A;

            x1B = Integer.parseInt(coords[4]);
            y1B = Integer.parseInt(coords[5]);
            x2B = Integer.parseInt(coords[6]);
            y2B = Integer.parseInt(coords[7]);
            int x3B = x2B;
            int y3B = y1B;
            int x4B = x1B;
            int y4B = y2B;

            boolean result = checkDot1(x1B, y1B) || checkDot1(x2B, y2B) || checkDot1(x3B, y3B) || checkDot1(x4B, y4B) ||
                             checkDot2(x1A, y1A) || checkDot2(x2A, y2A) || checkDot2(x3A, y3A) || checkDot2(x4A, y4A);
            System.out.println(result ? "True": "False");
        }
    }

    private boolean checkDot1(int x, int y) {
        return (x >= x1A && x <= x2A) && (y >= y2A && y <= y1A);
    }

    private boolean checkDot2(int x, int y) {
        return (x >= x1B && x <= x2B) && (y >= y2B && y <= y1B);
    }


    public List<String> getLines(String[] args) throws IOException {
        if (args.length > 0) {
            return Files.readAllLines(Paths.get(args[0]), Charset.defaultCharset());
        } else {
            String className = getClass().getSimpleName();
            String packageName = getClass().getPackage().getName();
            packageName = packageName.replaceAll(Pattern.quote("."), "/");
            InputStream is = this.getClass().getResourceAsStream("/" + packageName + "/" + className + "Sample.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            List<String> result = new ArrayList<String>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }
            return result;
        }
    }
}
