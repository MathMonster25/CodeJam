/*
* Only works with N % K == 0
*/

import java.util.Scanner;

public class Solution_5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = scan.nextInt();
            int K = scan.nextInt();
            int[][] output = new int[N][N];

            if (K % N != 0) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
                continue;
            }

            for (int i = 0; i < N; i++) {
                output[i][i] = K / N;
            }

            int index = 1;
            for (int i = 1; i <= N; i++) {
                if (i == K / N) continue;
                output[0][index] = i;
                index++;
            }

            for (int i = 1; i < N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (j == K / N) continue;
                    A: for (int l = N-1; l >= 0; l--) {
                        for (int k = i-1; k >= 0; k--) {
                            if (output[k][l] == j || output[i][l] != 0) continue A;
                            if (output[k][l] != j && k == 0 && output[i][l] != K / N) {
                                output[i][l] = j;
                                break A;
                            }
                        }
                    }
                }
            }

            System.out.println("Case #" + t + ": POSSIBLE");
            for (int[] arr : output) {
                for (int num : arr) {
                    System.out.print(num + " ");
                }
                System.out.print("\n");
            }
        }
    }
}
