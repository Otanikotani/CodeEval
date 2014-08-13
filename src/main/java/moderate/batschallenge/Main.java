package moderate.batschallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        Main batsChallenge = new Main();
        batsChallenge.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line: lines) {
            String[] parts = line.split(" ");
            int length = Integer.parseInt(parts[0]);
            int distance = Integer.parseInt(parts[1]);
            int numberOfBats = Integer.parseInt(parts[2]);
            Set<Integer> hangingBats = new TreeSet<Integer>();
            for (int i = 3; i < parts.length; i++ ){
                hangingBats.add(Integer.parseInt(parts[i]));
            }
            if (numberOfBats == 0) {
                System.out.println((length - 12) / distance  + 1);
            } else {
                int answer = 0;
                Integer hangingBatIndex = 0;
                Integer position = 6;

                Iterator iterator = hangingBats.iterator();

                if (iterator.hasNext()) {
                    hangingBatIndex = (Integer) iterator.next();
                } else {
                    answer += untilNextBat(hangingBatIndex, position, length, distance);
                }
                System.out.println("invalid");
            }
        }
    }

    private int untilNextBat(Integer hangingBatIndex, Integer position, int length, int distance) {
        if ((hangingBatIndex - position) > distance) {
            int result = (hangingBatIndex - position) / distance;
            position = hangingBatIndex;
            return result;
        } else {
            return 0;
        }
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
