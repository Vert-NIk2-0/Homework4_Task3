import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaTask3 {
    public static void main(String[] args) {
        String text = "Жили-были три китайца: Як, Як-цедрак, Як-цедрак-цедрак-цедрони!!!. " +
                "Жили-были три китайки: Цыпа, Цыпа-дрыпа, Цыпа-дрыпа-дрымпампони!!. " +
                "Все они переженились: Як на Цыпе, Як-цедрак на Цыпе-дрыпе!, " +
                "Як-цедрак-цедрак-цедрони на Цыпе-дрыпе-дрымпампони!!!!. " +
                "И у них родились дети. У Яка с Цыпой — Шах, у Яка-цедрака с Цыпой-дрыпой — Шах-шарах, " +
                "у Яка-цедрака-цедрака-цедрони с Цыпой-дрыпой-дрымпампони — Шах-шарах-шарах-широни!.";

        ExclamationMarks(text);

        replacingSigns(text);
    }

    public static void ExclamationMarks (String text) {
        String[] stringArray = text.split("\\.");
        int[] countExclamationMarkArray = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            Pattern pattern = Pattern.compile("!");
            Matcher matcher = pattern.matcher(stringArray[i]);
            while (matcher.find()) {
                countExclamationMarkArray[i]++;
            }

        }

        for (int i = 0; i < countExclamationMarkArray.length - 1; i++) {
            for (int j = i + 1; j < countExclamationMarkArray.length; j++) {
                if (countExclamationMarkArray[i] > countExclamationMarkArray[j]) {
                    countExclamationMarkArray[j] ^= countExclamationMarkArray[i];
                    countExclamationMarkArray[i] ^= countExclamationMarkArray[j];
                    countExclamationMarkArray[j] ^= countExclamationMarkArray[i];

                    String s = stringArray[j];
                    stringArray[j] = stringArray[i];
                    stringArray[i] = s;
                }
            }
            System.out.print(stringArray[i].trim() + "\t(" + countExclamationMarkArray[i] + ")\n");
        }
        System.out.println(stringArray[stringArray.length - 1].trim() + "\t(" + countExclamationMarkArray[stringArray.length - 1] + ")\n");
    }

    public static void replacingSigns (String text) {
        String[] stringArray = text.split("\\.");
        for (int i = 0; i < stringArray.length; i++) {
            Pattern pattern = Pattern.compile("[^A-Za-zА-Яа-я]+");
            Matcher matcher = pattern.matcher(stringArray[i]);
            String s = matcher.replaceAll(" ");
            System.out.println(s.trim());
        }

    }
}