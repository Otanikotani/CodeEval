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
            String[] periods = line.split(";");
            long minDate = Long.MAX_VALUE;
            long maxDate = Long.MIN_VALUE;

            Map<Long, Long> unsortedDates = new HashMap<Long, Long>();

            for (String period: periods) {
                String[] dates = period.split("-");
                Date fromDate = new SimpleDateFormat("MMM yyyy").parse(dates[0].trim());
                Date toDate = new SimpleDateFormat("MMM yyyy").parse(dates[1].trim());
                unsortedDates.put(fromDate.getTime(), toDate.getTime());
            }
            Map<Long, Long> sortedDates = new TreeMap<Long, Long>(unsortedDates);
            int monthsSum = 0;

            Map<Integer, int[]> yearMap = new HashMap<Integer, int[]>();

            for (Map.Entry<Long, Long> entry: sortedDates.entrySet()) {
                long from = entry.getKey();
                long to = entry.getValue();
                Calendar fromCal = GregorianCalendar.getInstance();
                fromCal.setTimeInMillis(from);
                Calendar toCal = GregorianCalendar.getInstance();
                toCal.setTimeInMillis(to);
                int fromYear = fromCal.get(Calendar.YEAR);
                int fromMonth = fromCal.get(Calendar.MONTH);
                int toYear = toCal.get(Calendar.YEAR);
                int toMonth = toCal.get(Calendar.MONTH);

                if (!yearMap.containsKey(fromYear)) {
                    yearMap.put(fromYear, new int[12]);
                }
                if (!yearMap.containsKey(toYear)) {
                    yearMap.put(toYear, new int[12]);
                }

                if (fromYear == toYear) {
                    for (int i = fromMonth; i <= toMonth; i++) {
                        yearMap.get(fromYear)[i] = 1;
                    }
                } else {
                    for (int i = fromMonth; i < 12; i++) {
                        yearMap.get(fromYear)[i] = 1;
                    }
                    for (int i = 0; i <= toMonth; i++) {
                        yearMap.get(toYear)[i] = 1;
                    }

                    for (int i = fromYear + 1; i < toYear; i++) {
                        for (int j = 0; j < 12; j++) {
                            if (!yearMap.containsKey(i)) {
                                yearMap.put(i, new int[12]);
                            }
                            yearMap.get(i)[j] = 1;
                        }
                    }
                }
            }
            for (Map.Entry<Integer, int[]> yearEntry: yearMap.entrySet()) {
                for (int i = 0 ; i < yearEntry.getValue().length; i++) {
                    monthsSum += yearEntry.getValue()[i];
                }
            }
            System.out.println(monthsSum / 12);

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
