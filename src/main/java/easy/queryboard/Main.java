package easy.queryboard;

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

    private int[][] board = new int[256][256];
    private static final String COL = "SetCol";
    private static final String ROW = "SetRow";
    private static final String QUERY_COL = "QueryCol";
    private static final String QUERY_ROW = "QueryRow";


    public static void main(String[] args) throws IOException {
        Main queryboard = new Main();
        queryboard.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line: lines) {
            if (line.startsWith(ROW)) {
                String[] params = line.substring(ROW.length() + 1).split(" ");
                int row = Integer.parseInt(params[0]);
                int value = Integer.parseInt(params[1]);
                for (int i = 0; i < 256; i++) {
                    board[row][i] = value;
                }
            } else if (line.startsWith(COL)) {
                String[] params = line.substring(COL.length() + 1).split(" ");
                int col = Integer.parseInt(params[0]);
                int value = Integer.parseInt(params[1]);
                for (int i = 0; i < 256; i++) {
                    board[i][col] = value;
                }
            } else if (line.startsWith(QUERY_COL)) {
                String[] params = line.substring(QUERY_COL.length() + 1).split(" ");
                int col = Integer.parseInt(params[0]);
                int sum = 0;
                for (int i = 0; i < 256; i++) {
                    sum += board[i][col];
                }
                System.out.println(sum);
            } else if (line.startsWith(QUERY_ROW)) {
                String[] params = line.substring(QUERY_ROW.length() + 1).split(" ");
                int row = Integer.parseInt(params[0]);
                int sum = 0;
                for (int i = 0; i < 256; i++) {
                    sum += board[row][i];
                }
                System.out.println(sum);
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
