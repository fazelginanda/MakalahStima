import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final String[] zaman = { "Barok", "Klasik", "Romantik" };
        final String[] karakteristikZaman = { "megah, kompleks, rumit, memiliki ornamen, " +
                "dinamik yang kontras, polifoni, memiliki trill, memiliki mordent, " +
                "kaya harmoni, integrasi vokal dan instrumen, banyak pergerakan, " +
                "pergerakan cepat, perubahan tempo dramatis, perubahan volume dramatis, menggunakan basso continuo",
                "jelas, terang, sederhana, struktur simetris, tekstur homofonik, perubahan tempo bertahap, " +
                        "artikulasi presisi, menggunakan sonata, integrasi vokal dan instrumen, " +
                        "kontras gelap terang, kontras tonic dominant, semua cadence terdengar sama",
                "menekankan ekspresi, ekspansi bentuk musik, banyak harmoni kromatik, " +
                        "kebebasan struktur, komposisi fleksibel, kedalaman emosional, naratif, " +
                        "instrument beragam, progresi harmoni tidak biasa, rubato, tempo fleksibel, " +
                        "rhythm fleksibel, peran konduktor luas, peran dinamik bertambah, leitmotif, " +
                        "menggunakan transformasi tematik, ekspresif, imajinatif" };

        System.out.println("Program Identifikasi Zaman Karya Musik");
        System.out.println("Masukkan karakteristik musik (setiap karakteristik dipisahkan dengan " + "', ')");
        System.out.println("Contoh masukan: megah, kompleks, rumit");
        System.out.print("> ");
        String input = System.console().readLine();
        String[] karakteristikInput = input.split("(,\s)", 0);
        String[] karakteristikInputLC = new String[karakteristikInput.length];
        for (int i = 0; i < karakteristikInput.length; i++) {
            karakteristikInputLC[i] = karakteristikInput[i].toLowerCase();
        }
        int[] countMatch = new int[3];
        int maxMatch = 0;
        long startTime = 0;
        long endTime = 0;

        /* ----ALGORITMA------ */
        // Algoritma Brute Force
        startTime = System.nanoTime();
        Arrays.fill(countMatch, 0);
        for (int i = 0; i < karakteristikInputLC.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (PatternMatcher.bruteForce(karakteristikZaman[j], karakteristikInputLC[i]) != -1) {
                    countMatch[j]++;
                }
            }
        }
        maxMatch = Arrays.stream(countMatch).max().getAsInt();
        System.out.println();
        System.out.println("Algoritma Brute Force");
        for (int i = 0; i < 3; i++) {
            if (countMatch[i] == maxMatch) {
                System.out.println(zaman[i]);
            }
        }
        endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + " nanoseconds");

        // Algoritma KMP
        startTime = System.nanoTime();
        Arrays.fill(countMatch, 0);
        for (int i = 0; i < karakteristikInputLC.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (PatternMatcher.KMP(karakteristikZaman[j], karakteristikInputLC[i]) != -1) {
                    countMatch[j]++;
                }
            }
        }
        maxMatch = Arrays.stream(countMatch).max().getAsInt();
        System.out.println();
        System.out.println("Algoritma KMP");
        for (int i = 0; i < 3; i++) {
            if (countMatch[i] == maxMatch) {
                System.out.println(zaman[i]);
            }
        }
        endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + " nanoseconds");

        // Algoritma Boyer-Moore
        startTime = System.nanoTime();
        Arrays.fill(countMatch, 0);
        for (int i = 0; i < karakteristikInputLC.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (PatternMatcher.boyerMoore(karakteristikZaman[j], karakteristikInputLC[i]) != -1) {
                    countMatch[j]++;
                }
            }
        }
        maxMatch = Arrays.stream(countMatch).max().getAsInt();
        System.out.println();
        System.out.println("Algoritma Boyer-Moore");
        for (int i = 0; i < 3; i++) {
            if (countMatch[i] == maxMatch) {
                System.out.println(zaman[i]);
            }
        }
        endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + " nanoseconds");
    }
}