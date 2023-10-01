import java.util.Arrays;
import java.util.Comparator;

class StringSorter {
    private static class UppercaseLetterCountComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            int uppercaseCount1 = countUppercaseLetters(s1);
            int uppercaseCount2 = countUppercaseLetters(s2);

            return Integer.compare(uppercaseCount2, uppercaseCount1);
        }

        private int countUppercaseLetters(String str) {
            int count = 0;
            for (char c : str.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    count++;
                }
            }
            return count;
        }
    }

    public static String[] sortByUppercaseLetterCount(String[] arr) {
        Arrays.sort(arr, new UppercaseLetterCountComparator());
        return arr;
    }
}