/*
* IDK if this works. Worked in personal tests, failed in Code Jam
*/

import java.util.*;

public class Solution {

    static enum Changes {
        NONE,
        FLIP,
        REVERSE,
        BOTH
    }
    static Changes changed = Changes.NONE;

    static boolean isSame = false;
    static boolean isDiff = false;
    static int same = -1;
    static int prevSame = 0;
    static int diff = -1;
    static int prevDiff = 0;

    static int B;
    
    static Scanner scan;

    public static void main(String[] args) {
        scan = new Scanner(System.in);

        int T = scan.nextInt();

        for (int t = 1; t <= T; t++) {
            B = scan.nextInt();
            int[] bits = new int[B];
            int numKnown = 0;

            for (int i = 1; i <= 5; i++) {
                System.out.println(i);
                bits[i-1] = scan.nextInt();
                System.out.println(B-(i-1));
                bits[B-i] = scan.nextInt();

                if (!isSame) {
                    isSame = bits[i - 1] == bits[B - i];
                    if (isSame) {
                        same = i;
                        prevSame = bits[i-1];
                    }
                }
                if (!isDiff) {
                    isDiff = bits[i - 1] != bits[B - i];
                    if (isDiff) {
                        diff = i;
                        prevDiff = bits[i-1];
                    }
                }

                numKnown += 2;
            }

            int bitsFromLoop = 0;

            while (numKnown < B) {
                int checkedBits = checkForChange();

                if (checkedBits == 1) {
                    for (int i = 1; i <= 4; i++) {
                        if (numKnown == B) break;
                        System.out.println(5 + i + bitsFromLoop);
                        int bit1 = scan.nextInt();
                        System.out.println(B - (4 + i + bitsFromLoop));
                        int bit2 = scan.nextInt();

                        bits[4 + i + bitsFromLoop] = convertBit(bit1, bit2);
                        bits[B - (5 + i + bitsFromLoop)] = convertBit(bit2, bit1);

                        numKnown += 2;
                    }
                    System.out.println(1);
                    scan.nextInt();
                }
                else {
                    for (int i = 1; i <= 4; i++) {
                        if (numKnown == B) break;
                        System.out.println(5 + i + bitsFromLoop);
                        int bit1 = scan.nextInt();
                        System.out.println(B - (4 + i + bitsFromLoop));
                        int bit2 = scan.nextInt();

                        bits[4 + i + bitsFromLoop] = convertBit(bit1, bit2);
                        bits[B - (5 + i + bitsFromLoop)] = convertBit(bit2, bit1);

                        numKnown += 2;
                    }
                }

                bitsFromLoop += 4;
            }

            String output = "";
            for (int bit : bits) {
                output = output + bit;
            }
            System.out.println(output);
            String valid = scan.next();
            if (!valid.equals("y")) break;
        }
    }

    static int convertBit(int bit1, int bit2) {
        if (changed == Changes.NONE) {
            return bit1;
        }
        else if (changed == Changes.REVERSE) {
            return bit2;
        }
        else if (changed == Changes.FLIP) {
            return bit1 == 0 ? 1 : 0;
        }
        else {
            if (bit1 == bit2) {
                return bit1 == 0 ? 1 : 0;
            }
            else {
                return bit1;
            }
        }
    }

    static int checkForChange() {
        if (isSame) {
            if (isDiff) {
                System.out.println(same);
                int sameVal = scan.nextInt();
                System.out.println(diff);
                int diffVal = scan.nextInt();

                boolean sameSame = sameVal == prevSame;
                boolean diffSame = diffVal == prevDiff;

                if (!sameSame) {
                    if (!diffSame) {
                        changed = Changes.FLIP;
                    } else {
                        changed = Changes.BOTH;
                    }
                } else if (!diffSame) {
                    changed = Changes.REVERSE;
                } else {
                    changed = Changes.NONE;
                }

                return 2;
            }
            else {
                System.out.println(same);
                int sameVal = scan.nextInt();

                if (sameVal != prevSame) {
                    changed = Changes.FLIP;
                } else {
                    changed = Changes.NONE;
                }

                return 1;
            }
        }
        else {
            System.out.println(diff);
            int diffVal = scan.nextInt();

            if (diffVal != prevDiff) {
                changed = Changes.REVERSE;
            } else {
                changed = Changes.NONE;
            }

            return 1;
        }
    }
}
