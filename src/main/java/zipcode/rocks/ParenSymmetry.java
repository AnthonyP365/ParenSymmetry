package zipcode.rocks;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParenSymmetry {

    public boolean isBalanced(String s) {
        int a = 0;
        int b = 0;
        int c = 0;
        boolean d = false;


        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                a += 1;
            } else if (s.charAt(i) == ')') {
                b += 1;
            } else {
                c += 1;
            }
            if ((a + b) % 2 == 0) {
                d = true;
            } else {
                d = false;
            }
        }
        // implement this method
        return d;
    }

    public void checkFile() throws FileNotFoundException {
        // open file named filename

        // for each line in the file
            // read the line
            // print whether or not the line's parenthesis are balanced
        try {
            File file = new File("/Users/anthony/Documents/Projects/ParenSymmetry/TestStrings0.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(isBalanced(line));
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        // CLOSE the file
    }

    public static void main(String[] args) throws FileNotFoundException {
        ParenSymmetry ps = new ParenSymmetry();

        Boolean b0 = ps.isBalanced("()");
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);
        ps.checkFile();
    }

    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}
