/*
*This file outputs correct information, but "skips test case" when run in Code Jam
*/

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int T = scan.nextInt();
        int n;
        int[] starts;
        Map<Integer, Integer> times;
        Map<Integer, String> order;
        
        for (int t = 1; t <= T; t++) {
            n = scan.nextInt();
            times = new HashMap<Integer, Integer>();
            order = new HashMap<Integer, String>();
            starts = new int[n];
            String answer = "";
            String prev = "J";
            
            for (int i = 0; i < n; i++) {
                starts[i] = scan.nextInt();
                int end = scan.nextInt();
                
                times.put(starts[i], end);
            }
            
            int[] original = new int[n];
            System.arraycopy(starts, 0, original, 0, n);
            Arrays.sort(starts);
            
            order.put(starts[0], "J");
            int prevJ = times.get(starts[0]);
            int prevC = 0;
            
            for (int i = 1; i < n; i++) {
                if (starts[i] < times.get(starts[i-1])) {
                    if (prev.equals("J")) {
                        if (prevC <= starts[i]) {
                            order.put(starts[i], "C");
                            prev = "C";
                            prevC = times.get(starts[i]);
                        }
                        else {
                            answer = "IMPOSSIBLE";
                            break;
                        }
                    }
                    else {
                        if (prevJ <= starts[i]) {
                            order.put(starts[i], "J");
                            prev = "J";
                            prevJ = times.get(starts[i]);
                        }
                        else {
                            answer = "IMPOSSIBLE";
                            break;
                        }
                    }
                }
                else {
                    answer = answer + prev;
                    if (prev.equals("J")) {
                        prevJ = times.get(starts[i]);
                    }
                    else {
                        prevC = times.get(starts[i]);
                    }
                }
            }
            
            if (!answer.equals("IMPOSSIBLE")) {
                for (int i = 0; i < n; i++) {
                    if (order.get(original[i]) != null) {
                        answer = answer + order.get(original[i]);
                    }
                }
            }
            
            System.out.println("Case #" + t + ": " + answer);
        }
    }
}
