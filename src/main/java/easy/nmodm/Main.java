package easy.nmodm;

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
        Main nmodm = new Main();
        nmodm.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line : lines) {
            String[] parts = line.split(",");
            Integer numberInt = Integer.parseInt(parts[0]);
            Integer test = Integer.parseInt(parts[0]);
            Integer mod = Integer.parseInt(parts[1]);
            if (numberInt < mod) {
                System.out.println(numberInt);
                continue;
            }
            while ((numberInt -= mod) > 0) ;
            if (numberInt == 0) {
                System.out.println(numberInt);
            } else {
                System.out.println(numberInt + mod);
            }
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
