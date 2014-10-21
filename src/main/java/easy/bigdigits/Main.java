package easy.bigdigits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    static StringBuilder[] result = new StringBuilder[6];

    static {
        for (int i = 0; i < result.length; i++) {
            result[i] = new StringBuilder();
        }
    }

    public static void main(String[] args) throws IOException {
        Main bigdigits = new Main();
        bigdigits.solve(args);
        return;
    }

    public void solve(String[] args) throws IOException {
        List<String> lines = getLines(args);
        for (String line : lines) {
            List<Character> numbers = new ArrayList<Character>(line.length());
            for (int i = 0 ; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    numbers.add(line.charAt(i));
                }
            }
            for (Character ch: numbers) {
                drawNumber(ch);
            }
            for (int i = 0; i < 6; i++) {
                System.out.println(result[i].toString());
                result[i] = new StringBuilder();
            }
        }
    }

    private void drawNumber(Character ch) {
        switch (ch) {
            case '1':
                drawOne();
                return;
            case '2':
                drawTwo();
                return;
            case '3':
                drawThree();
                return;
            case '4':
                drawFour();
                return;
            case '5':
                drawFive();
                return;
            case '6':
                drawSix();
                return;
            case '0':
                drawZero();
                return;
            case '7':
                drawSeven();
                return;
            case '8':
                drawEight();
                return;
            case '9':
                drawNine();
                return;
        }
    }

    private static void drawOne() {
        result[0].append("--*--");
        result[1].append("-**--");
        result[2].append("--*--");
        result[3].append("--*--");
        result[4].append("-***-");
        result[5].append("-----");
    }

    private static void drawTwo() {
        result[0].append("***--");
        result[1].append("---*-");
        result[2].append("-**--");
        result[3].append("*----");
        result[4].append("****-");
        result[5].append("-----");
    }

    private static void drawThree() {
        result[0].append("***--");
        result[1].append("---*-");
        result[2].append("-**--");
        result[3].append("---*-");
        result[4].append("***--");
        result[5].append("-----");
    }

    private static void drawFour() {
        result[0].append("-*---");
        result[1].append("*--*-");
        result[2].append("****-");
        result[3].append("---*-");
        result[4].append("---*-");
        result[5].append("-----");
    }

    private static void drawFive() {
        result[0].append("****-");
        result[1].append("*----");
        result[2].append("***--");
        result[3].append("---*-");
        result[4].append("***--");
        result[5].append("-----");
    }

    private static void drawSix() {
        result[0].append("-**--");
        result[1].append("*----");
        result[2].append("***--");
        result[3].append("*--*-");
        result[4].append("-**--");
        result[5].append("-----");
    }

    private static void drawSeven() {
        result[0].append("****-");
        result[1].append("---*-");
        result[2].append("--*--");
        result[3].append("-*---");
        result[4].append("-*---");
        result[5].append("-----");
    }

    private static void drawEight() {
        result[0].append("-**--");
        result[1].append("*--*-");
        result[2].append("-**--");
        result[3].append("*--*-");
        result[4].append("-**--");
        result[5].append("-----");
    }

    private static void drawNine() {
        result[0].append("-**--");
        result[1].append("*--*-");
        result[2].append("-***-");
        result[3].append("---*-");
        result[4].append("-**--");
        result[5].append("-----");
    }

    private static void drawZero() {
        result[0].append("-**--");
        result[1].append("*--*-");
        result[2].append("*--*-");
        result[3].append("*--*-");
        result[4].append("-**--");
        result[5].append("-----");
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
