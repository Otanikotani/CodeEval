package easy.morsecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        Main morsecode = new Main();
        morsecode.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        Map<String, String> transcode = new HashMap<String, String>();
        transcode.put("A", ".-");
        transcode.put("B", "-...");
        transcode.put("C", "-.-.");
        transcode.put("D", "-..");
        transcode.put("E", ".");
        transcode.put("F", "..-.");
        transcode.put("G", "--.");
        transcode.put("H", "....");
        transcode.put("I", "..");
        transcode.put("J", ".---");
        transcode.put("K", "-.-");
        transcode.put("L", ".-..");
        transcode.put("M", "--");
        transcode.put("N", "-.");
        transcode.put("O", "---");
        transcode.put("P", ".--.");
        transcode.put("Q", "--.-");
        transcode.put("R", ".-.");
        transcode.put("S", "...");
        transcode.put("T", "-");
        transcode.put("U", "..-");
        transcode.put("V", "...-");
        transcode.put("W", ".--");
        transcode.put("X", "-..-");
        transcode.put("Y", "-.--");
        transcode.put("Z", "--..");
        transcode.put("1", ".----");
        transcode.put("2", "..---");
        transcode.put("3", "...--");
        transcode.put("4", "....-");
        transcode.put("5", ".....");
        transcode.put("6", "-....");
        transcode.put("7", "--...");
        transcode.put("8", "---..");
        transcode.put("9", "----.");
        transcode.put("0", "-----");
        Map<String, String> reverse = new HashMap<String, String>();
        for (Map.Entry<String, String> entry: transcode.entrySet()) {
            reverse.put(entry.getValue(), entry.getKey());
        }
        for (String line : lines) {
            String[] morses = line.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String morseCode : morses) {
                if (reverse.get(morseCode) == null) {
                    sb.append(" ");
                } else {
                    sb.append(reverse.get(morseCode));

                }
            }
            System.out.println(sb.toString());
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
