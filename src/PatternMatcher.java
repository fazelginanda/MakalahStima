public class PatternMatcher {
    public static int bruteForce(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        for (int i = 0; i <= (n - m); i++) {
            int j = 0;
            while ((j < m) && (text.charAt(i + j) == pattern.charAt(j))) {
                j++;
            }
            if (j == m) {
                return i;
            }
        }
        return -1;
    }

    public static int KMP(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int b[] = computeBorder(pattern);
        int i = 0;
        int j = 0;

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                if (j == m - 1) {
                    return i - m + 1; // match
                }
                i++;
                j++;
            } else if (j > 0) {
                j = b[j - 1];
            } else {
                i++;
            }
        }
        return -1; // no match
    }

    public static int[] computeBorder(String pattern) {
        int b[] = new int[pattern.length()];
        int fail[] = { 0 };
        int m = pattern.length();
        int j = 0;
        int i = 1;

        while (i < m) {
            if (pattern.charAt(j) == pattern.charAt(i)) {
                // j +1 chars match
                b[i] = j + 1;
                i++;
                j++;
            } else if (j > 0) { // j follows matching prefix
                j = b[j - 1];
            } else { // no match
                b[i] = 0;
                i++;
            }
        }
        return fail;
    }

    public static int boyerMoore(String text, String pattern) {
        int last[] = buildLast(pattern);
        int n = text.length();
        int m = pattern.length();
        int i = m - 1;

        if (i > n - 1) {
            return -1;
        } else {
            int j = m - 1;
            do {
                if (pattern.charAt(j) == text.charAt(i)) {
                    if (j == 0) {
                        return i;
                    } else {
                        i--;
                        j--;
                    }
                } else {
                    int lo = last[text.charAt(i)];
                    i = i + m - Math.min(j, 1 + lo);
                    j = m - 1;
                }
            } while (i <= n - 1);
            return -1;
        }
    }

    public static int[] buildLast(String pattern) {
        int last[] = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        for (int i = 0; i < pattern.length(); i++) {
            last[pattern.charAt(i)] = i;
        }
        return last;
    }
}
