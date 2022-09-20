import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class SimpletonCalculator {
    private static List<String> results = new ArrayList<>();
    static Scanner s = new Scanner(System.in);
    static String rs = "";
    static String s1 = "0";
    static BigDecimal n1 = new BigDecimal(0);
    static BigDecimal n2 = new BigDecimal(0);
    static BigDecimal n3 = new BigDecimal(0);
    
    public static void main(String[] args) {
        System.out.println("Введите число.");
        n1 = Number(s, n1);
        while (true) {
            System.out.println("Введите оператор.");
            s1 = Operator(s, s1);
            System.out.println("Введите число.");
            n2 = Number(s, n2);
            switch (s1) {
                case "+":
                    n3 = n1.add(n2);
                    rs = n1 + " + " + n2 + " = " + n3;
                    break;
                case "-":
                    n3 = n1.subtract(n2);
                    rs = n1 + " - " + n2 + " = " + n3;
                    break;
                case "*":
                    n3 = n1.multiply(n2);
                    rs = n1 + " * " + n2 + " = " + n3;
                    break;
                case "/":
                    try {
                        n3 = n1.divide(n2);
                    } catch (ArithmeticException e) {
                        n3 = n1.divide(n2, Math.max(n1.scale(), n2.scale()), RoundingMode.HALF_EVEN);
                    }
                    rs = n1 + " / " + n2 + " = " + n3;
                    break;
                case "log":
                    n3 = BigDecimal.valueOf(Math.log(n2.doubleValue()) / Math.log(n1.doubleValue()));
                    rs = "log (" + n1 + ") " + n2 + " = " + n3;
                    break;
            }
                    System.out.println("=" + n3);
                results.add(rs);
                n1 = n3;
            }
        }

static BigDecimal Number(Scanner sc, BigDecimal d1) {
        checkForWords(sc);
        try {
            d1 = sc.nextBigDecimal();
            sc.nextLine();
            return d1;
        } catch (InputMismatchException e) {
            System.out.println("Введите число.");
            sc.nextLine();
            return Number(sc, d1);
        }
    }

static String Operator(Scanner sc, String s1) {
        checkForWords(sc);
        s1 = sc.next();
        if (s1.equals("+") || s1.equals("-") || s1.equals("*") || s1.equals("/")|| s1.equals("^")|| s1.equals("log")) {
            return s1;
        }
        else {
            sc.nextLine();
            System.out.println("Введите оператор.");
            return Operator(sc, s1);
        }
    }
static void checkForWords(Scanner sc) {
        if (sc.hasNext("exit")) { 
            System.out.println("Выход из программы.");
            System.exit(155);
        }
        if (sc.hasNext("results")) { 
            for (int i = 0; i < results.size(); i++) {
                System.out.println((i + 1) + ") " + results.get(i));
            }
        }
    }
}







