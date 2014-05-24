package easy.datarecovery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        Main datarecovery = new Main();
        datarecovery.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line: lines) {
            String[] parts = line.split(";");
            String[] words = parts[0].split(" ");
            String[] orders = parts[1].split(" ");
            TreeMap<Integer, String> orderToWords = new TreeMap<Integer, String>();
            List<Integer> addedOrders = new ArrayList<Integer>();
            for (int i = 0; i < words.length; i++ ) {
                if (i > orders.length - 1) {
                    int missingKey = -1;
                    Collections.sort(addedOrders);
                    if (addedOrders.get(0) == 2) {
                        missingKey = 1;
                    } else {
                        int prevOrder = addedOrders.get(0);
                        for (int index = 1; index < addedOrders.size(); index++) {
                            if (addedOrders.get(index) != prevOrder + 1) {
                                missingKey = prevOrder + 1;
                                break;
                            }
                            prevOrder = addedOrders.get(index);
                        }
                        if (missingKey == -1) {
                            missingKey = addedOrders.size() + 1;
                        }
                    }
                    orderToWords.put(missingKey, words[i]);
                } else {
                    addedOrders.add(Integer.parseInt(orders[i]));
                    orderToWords.put(Integer.parseInt(orders[i]), words[i]);
                }
            }

            StringBuilder sb = new StringBuilder();
            String delimiter = "";
            for (String word: orderToWords.values()) {
                sb.append(delimiter).append(word);
                delimiter = " ";
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
