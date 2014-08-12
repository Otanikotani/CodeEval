package easy.agedistribution;

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
        Main ageDistribution = new Main();
        ageDistribution.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line: lines) {
            int age = Integer.parseInt(line);
            String str = "This program is for humans";
            if (in(age, 0, 2))  {
                str = "Still in Mama's arms";
            } else if (in(age, 3, 4)) {
                str = "Preschool Maniac";
            } else if (in(age, 5, 11)) {
                str = "Elementary school";
            } else if (in(age, 12, 14)) {
                str = "Middle school";
            } else if (in(age, 15, 18)) {
                str = "High school";
            } else if (in(age, 19, 22)) {
                str = "College";
            } else if (in(age, 23, 65)) {
                str = "Working for the man";
            } else if (in(age, 66, 100)) {
                str = "The Golden Years";
            }
            System.out.println(str);
        }
    }

    private boolean in(int age, int i, int i1) {
        return age >= i && age <= i1;
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
