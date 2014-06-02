package moderate.passtriangle;

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

    List<List<Integer>> numbers;
    List<List<Integer>> cache;
    int maxDepth;

    public static void main(String[] args) throws IOException {
        Main passtriangle = new Main();
        passtriangle.solveCached(args);
//        passtriangle.solve(args);
        return;
    }

    public void solveCached(String[] args) throws IOException {
        List<String> lines = getLines(args);
        numbers = new ArrayList<List<Integer>>();
        cache = new ArrayList<List<Integer>>();
        for (String line : lines) {
            List<Integer> lineList = new ArrayList<Integer>();
            List<Integer> cacheList = new ArrayList<Integer>();
            for (String numberStr : line.split(" ")) {
                lineList.add(Integer.parseInt(numberStr));
                cacheList.add(-1);
            }
            numbers.add(lineList);
            cache.add(cacheList);
        }
        maxDepth = numbers.size() - 1;
        int sumCache = leftOrRightCache(1, 0, 0);
        System.out.println(sumCache + numbers.get(0).get(0));
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        numbers = new ArrayList<List<Integer>>();
        cache = new ArrayList<List<Integer>>();
        for (String line : lines) {
            List<Integer> lineList = new ArrayList<Integer>();
            List<Integer> cacheList = new ArrayList<Integer>();
            for (String numberStr : line.split(" ")) {
                lineList.add(Integer.parseInt(numberStr));
                cacheList.add(-1);
            }
            numbers.add(lineList);
            cache.add(cacheList);
        }
        maxDepth = numbers.size() - 1;
        int sum = leftOrRight(1, 0, 0);
        System.out.println(sum + numbers.get(0).get(0));
    }

    private int leftOrRightCache(int nextLine, int sum, int elementIndex) {
        List<Integer> lineList = numbers.get(nextLine);
        int left = lineList.get(elementIndex);
        int right = lineList.get(elementIndex + 1);
        if (nextLine == maxDepth)
            return sum + Math.max(left, right);

        int leftSum = cache.get(nextLine).get(elementIndex);
        if (leftSum == -1) {
            leftSum = leftOrRightCache(nextLine + 1, sum + left, elementIndex);
            cache.get(nextLine).set(elementIndex, leftSum - sum);
        } else {
            leftSum += sum;
        }

        int rightSum = cache.get(nextLine).get(elementIndex + 1);
        if (rightSum == -1) {
            rightSum = leftOrRightCache(nextLine + 1, sum + right, elementIndex + 1);
            cache.get(nextLine).set(elementIndex + 1, rightSum - sum);
        } else {
            rightSum += sum;
        }
        return Math.max(leftSum, rightSum);
    }


    private int leftOrRight(int nextLine, int sum, int elementIndex) {
        List<Integer> lineList = numbers.get(nextLine);
        int left = lineList.get(elementIndex);
        int right = lineList.get(elementIndex + 1);
        if (nextLine == maxDepth)
            return sum + Math.max(left, right);

        int leftSum = leftOrRight(nextLine + 1, sum + left, elementIndex);
        int rightSum = leftOrRight(nextLine + 1, sum + right, elementIndex + 1);
        return Math.max(leftSum, rightSum);
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
