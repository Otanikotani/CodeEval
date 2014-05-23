package easy.calculatedistance;

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
        Main calculatedistance = new Main();
        calculatedistance.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line: lines) {
//            System.out.println(line);
            String[] points = line.split("\\) \\(");
            String point1 = points[0];
            String[] coords1 = point1.substring(1, point1.length()).split(",");
            int x1 = Integer.parseInt(coords1[0].trim());
            int y1 = Integer.parseInt(coords1[1].trim());

            String point2 = points[1];
            String[] coords2 = point2.substring(0, point2.length() - 1).split(",");
            int x2 = Integer.parseInt(coords2[0].trim());
            int y2 = Integer.parseInt(coords2[1].trim());
            System.out.println((int)Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1)));
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
