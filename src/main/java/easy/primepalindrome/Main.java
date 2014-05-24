package easy.primepalindrome;

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
        Main primepalindrome = new Main();
        primepalindrome.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        int maxPalindrome = 0;
        for (int i = 0 ; i < 1000; i++) {
            if (isPrime(i) && isPalindrome(i)) {
                maxPalindrome = i;
            }
        }
        System.out.println(maxPalindrome);
    }

    public static boolean isPrime(int number) {
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) {
                // number is perfectly divisible - no prime
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(int number) {
        List<Integer> digits = new ArrayList<Integer>();
        while( number > 0) {
            digits.add(number % 10);
            number /= 10;
        }
        if (digits.size() == 2) {
            return digits.get(0) == digits.get(1);
        } else if (digits.size() == 3) {
            return digits.get(0) == digits.get(2);
        }
        return true;
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
