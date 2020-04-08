import java.util.Scanner;

public class Solution_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        
        for (int i = 1; i <= T; i++) {
            String str = scan.next();
            int[] digits = new int[str.length()];
            String[] parenthesis = new String[str.length()];
            
            for (int j = 0; j < str.length(); j++) {
                digits[j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
            int open = 0;
            for (int j = 0; j < str.length(); j++) {
                parenthesis[j] = "";
                if (open != digits[j]) {
                    if (open < digits[j]) {
                        while (open < digits[j]) {
                            parenthesis[j] = parenthesis[j] + "(";
                            open++;
                        }
                    }
                    else {
                        while (open > digits[j]) {
                            parenthesis[j] = parenthesis[j] + ")";
                            open--;
                        }
                    }
                }
            }
            
            String output = "";
            for (int j = 0; j < str.length(); j++) {
                output = output + parenthesis[j] + digits[j];
            }
            for (int j = 0; j < open; j++) {
                output = output + ")";
            }
            
            System.out.println("Case #" + i + ": " + output);
        }
    }
}
