import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(
                -2, -5, -2, -4, 3, -6, -2,
                -1, 5, 1, 1, 0, -1, 0, 3, -1,
                2, 5, 2, 4, 4, 0, 6, 1, 4, 6, -1, 2, 4, 7, 11
        ));

        long cntNeg = temp.stream().filter(i -> i < 0).count();
        System.out.println("Количество дней с отрицательной температурой: " + cntNeg);
        boolean hasTemp10 = temp.stream().anyMatch(i -> i > 10);
        System.out.println("В дневнике темпаратуры за марты " + (hasTemp10 ? "есть дни, в которые темп выше 10": "нет дней, когда темп выше 10"));
        int m = temp.stream().limit(7).max((a, b) -> Integer.compare(a, b)).get();
        System.out.println("Максимальная температура за первую неделю: " + m);
        double avg = temp.stream().mapToInt(x -> x).average().getAsDouble();
        System.out.printf("Средняя температура за месяц: %.2f\n", avg);

        String text = "They used 233 features including 227\n" +
                "stylometric features and six novel social network-specific features\n" +
                "like character-based ones numbers of alphabets, uppercase\n" +
                "characters, special characters, word-based ones the total number of\n" +
                "words, average word length, the number of words with 1 char,\n" +
                "syntactic ones numbers of punctuation marks and functional\n" +
                "words, the total number of sentences and many others";
        ArrayList<String> words = new ArrayList<>(Arrays.asList(text.split("[\\s,]+")));
        long cnt = words.stream().filter(s -> s.endsWith("es")).count();
        System.out.println("Количество слов, оканчивающийся на \"es\": " + cnt);
        words.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println("Слова упорядоченные по возрастанию длины: " + words);
        long numberSum = words.stream().filter(s -> s.matches("\\d+")).mapToInt(x -> Integer.parseInt(x)).sum();
        System.out.println("Количество чисел в тексте: " + numberSum);
    }
}