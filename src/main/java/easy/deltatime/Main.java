package easy.deltatime;

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

    public static void main(String[] args) throws IOException {
        Main deltatime = new Main();
        deltatime.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line: lines) {
            String[] dates = line.split(" ");
            Integer firstDateSeconds = convertToS(dates[0]);
            Integer secondDateSeconds = convertToS(dates[1]);
            Integer absSdifference = Math.abs(firstDateSeconds - secondDateSeconds);
            printDate(absSdifference);
        }
    }

    private void printDate(Integer absSdifference) {
        Integer hours = absSdifference / 3600;
        Integer minutes = (absSdifference / 60) % 60;
        Integer seconds = (absSdifference % 60);
        System.out.println(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }

    private Integer convertToS(String date) {
        String[] parts = date.split(":");
        Integer hoursInS = Integer.parseInt(parts[0]) * 60 * 60;
        Integer minutesInS = Integer.parseInt(parts[1]) * 60;
        Integer secondsInS = Integer.parseInt(parts[2]);
        return hoursInS + minutesInS + secondsInS;
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
