package easy.multiplicationtables;

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
        Main multiplicationtables = new Main();
        multiplicationtables.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        for (int i = 1; i <= 12; i++) {
            StringBuilder sb = new StringBuilder();
            String delimiter = " ";
            for (int j = 1; j <= 12; j++) {
                if (i * j < 10) {
                    delimiter = "   ";
                } else if (i * j < 100) {
                    delimiter = "  ";
                } else {
                    delimiter = " ";
                }
                sb.append(delimiter).append(i * j);
            }
            System.out.println(sb.toString().trim());
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
