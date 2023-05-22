import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final String[] zaman = { "Barok", "Klasik", "Romantik" };
        final String[] karakteristikBarok = { "homofon", "tempo tetap" };
        final String[] karakteristikKlasik = { "seimbang", "melodi elegan" };
        final String[] karakteristikRomantik = { "ekspresif", "emosional" };
        System.out.println("Program Identifikasi Zaman Karya Musik");
        System.out.println("Masukkan karakteristik musik (setiap karakteristik dipisahkan dengan " + "', ')");
        System.out.println("Contoh masukan: homofon, tempo tetap");
        System.out.print("> ");
        String input = System.console().readLine();
        String[] karakteristikInput = input.split("(,\s)", 0);
        String[] karakteristikInputLC = new String[karakteristikInput.length];
        for (int i = 0; i < karakteristikInput.length; i++) {
            karakteristikInputLC[i] = karakteristikInput[i].toLowerCase();
        }
        int[] countOccurence = new int[3];
        int maxOccurence = 0;
        long startTime = 0;
        long endTime = 0;

        // Brute Force Algorithm
        startTime = System.nanoTime();
        Arrays.fill(countOccurence, 0);
        for (int i = 0; i < karakteristikInputLC.length; i++) {
            for (int j = 0; j < karakteristikBarok.length; j++) {
                if (PatternMatcher.bruteForce(karakteristikInputLC[i], karakteristikBarok[j]) != -1) {
                    countOccurence[0]++;
                }
            }
            for (int j = 0; j < karakteristikKlasik.length; j++) {
                if (PatternMatcher.bruteForce(karakteristikInputLC[i], karakteristikKlasik[j]) != -1) {
                    countOccurence[1]++;
                }
            }
            for (int j = 0; j < karakteristikRomantik.length; j++) {
                if (PatternMatcher.bruteForce(karakteristikInputLC[i], karakteristikRomantik[j]) != -1) {
                    countOccurence[2]++;
                }
            }
        }
        maxOccurence = Arrays.stream(countOccurence).max().getAsInt();
        System.out.println();
        System.out.println("Algoritma Brute Force");
        for (int i = 0; i < 3; i++) {
            if (countOccurence[i] == maxOccurence) {
                System.out.println(zaman[i]);
            }
        }
        endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + " nanoseconds");

        // KMP Algorithm
        startTime = System.nanoTime();
        Arrays.fill(countOccurence, 0);
        for (int i = 0; i < karakteristikInputLC.length; i++) {
            for (int j = 0; j < karakteristikBarok.length; j++) {
                if (PatternMatcher.KMP(karakteristikInputLC[i], karakteristikBarok[j]) != -1) {
                    countOccurence[0]++;
                }
            }
            for (int j = 0; j < karakteristikKlasik.length; j++) {
                if (PatternMatcher.KMP(karakteristikInputLC[i], karakteristikKlasik[j]) != -1) {
                    countOccurence[1]++;
                }
            }
            for (int j = 0; j < karakteristikRomantik.length; j++) {
                if (PatternMatcher.KMP(karakteristikInputLC[i], karakteristikRomantik[j]) != -1) {
                    countOccurence[2]++;
                }
            }
        }
        maxOccurence = Arrays.stream(countOccurence).max().getAsInt();
        System.out.println();
        System.out.println("Algoritma KMP");
        for (int i = 0; i < 3; i++) {
            if (countOccurence[i] == maxOccurence) {
                System.out.println(zaman[i]);
            }
        }
        endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + " nanoseconds");

        // Boyer-Moore Algorithm
        startTime = System.nanoTime();
        Arrays.fill(countOccurence, 0);
        for (int i = 0; i < karakteristikInputLC.length; i++) {
            for (int j = 0; j < karakteristikBarok.length; j++) {
                if (PatternMatcher.boyerMoore(karakteristikInputLC[i], karakteristikBarok[j]) != -1) {
                    countOccurence[0]++;
                }
            }
            for (int j = 0; j < karakteristikKlasik.length; j++) {
                if (PatternMatcher.boyerMoore(karakteristikInputLC[i], karakteristikKlasik[j]) != -1) {
                    countOccurence[1]++;
                }
            }
            for (int j = 0; j < karakteristikRomantik.length; j++) {
                if (PatternMatcher.boyerMoore(karakteristikInputLC[i], karakteristikRomantik[j]) != -1) {
                    countOccurence[2]++;
                }
            }
        }
        maxOccurence = Arrays.stream(countOccurence).max().getAsInt();
        System.out.println();
        System.out.println("Algoritma Boyer-Moore");
        for (int i = 0; i < 3; i++) {
            if (countOccurence[i] == maxOccurence) {
                System.out.println(zaman[i]);
            }
        }
        endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + " nanoseconds");
    }

}
