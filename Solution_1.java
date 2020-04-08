import java.util.*;

public class Solution_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int T = scan.nextInt();
        int[][][] latinSquares = new int[T][][];
        
        for (int i = 0; i < T; i++) {
            int n = scan.nextInt();
            int[][] temp = new int[n][n];
            int trace = 0;
            int r = 0;
            int c = 0;
            
            for (int j = 0; j < n; j++) {
                int[] row = new int[n];
                
                for (int k = 0; k < n; k++) {
                    row[k] = scan.nextInt();
                    
                    if (k == j) trace += row[k];
                }
                
                boolean repeats = false;
                for (int k = 0; k < n; k++) {
                    for (int l = k+1; l < n; l++) {
                        if (row[k] == row[l]) {
                            repeats = true;
                            break;
                        }
                    }
                }
                if (repeats) r++;
                
                temp[j] = row;
            }
            
            for (int j = 0; j < n; j++) {
                int[] col = new int[n];
                
                for (int k = 0; k < n; k++) {
                    col[k] = temp[k][j];
                }
                
                boolean repeats = false;
                for (int k = 0; k < n; k++) {
                    for (int l = k+1; l < n; l++) {
                        if (col[k] == col[l]) {
                            repeats = true;
                            break;
                        }
                    }
                }
                if (repeats) c++;
            }
            
            latinSquares[i] = temp;
            
            System.out.println("Case #" + (i+1) + ": " + trace + " " + r + " " + c);
        }
    }
}
