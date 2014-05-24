package easy.workingexperience;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        Main workingexperience = new Main();
        try {
            workingexperience.solve(args);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return;
    }

    public void solve(String[] args) throws IOException, ParseException {
        List<String> lines = getLines(args);
        for (String line: lines) {
//            System.out.println(line);
            String[] periods = line.split(";");
            long minDate = Long.MAX_VALUE;
            long maxDate = Long.MIN_VALUE;
            for (String period: periods) {
                String[] dates = period.split("-");
                for (String dateStr: dates) {
                    Date date = new SimpleDateFormat("MMM yyyy").parse(dateStr.trim());
                    minDate = Math.min(date.getTime(), minDate);
                    maxDate = Math.max(date.getTime(), maxDate);
                }
            }
            Calendar minCal = GregorianCalendar.getInstance();
            minCal.setTimeInMillis(minDate);
            Calendar maxCal = GregorianCalendar.getInstance();
            maxCal.setTimeInMillis(maxDate);
            System.out.println(maxCal.get(Calendar.YEAR) - minCal.get(Calendar.YEAR));
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
