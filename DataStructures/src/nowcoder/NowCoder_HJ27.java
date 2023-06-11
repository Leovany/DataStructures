package nowcoder;

import java.util.*;

/**
 * HJ27 查找兄弟单词
 */
public class NowCoder_HJ27 {
    private static List<String> getBrotherWord(String[] workArr, String word) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < workArr.length; i++) {
            String nowWord = workArr[i];
            // 判断
            if (isBrotherWord(nowWord, word)) {
                list.add(nowWord);
            }
        }

        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] arr = line.split(" ");
            int count = Integer.parseInt(arr[0]);
            String[] workArr = Arrays.copyOfRange(arr, 1, count + 1);
            String work = arr[arr.length - 2];
            int k = Integer.parseInt(arr[arr.length - 1]);

            List<String> list = getBrotherWord(workArr, work);
            System.out.println(list.size());
            if (list.size() >= k) {
                System.out.println(list.get(k - 1));
            }
        }
    }

    private static boolean isBrotherWord(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        if (word1.equals(word2)) {
            return false;
        }
        char[] word1Arr = word1.toCharArray();
        char[] word2Arr = word2.toCharArray();

        Arrays.sort(word1Arr);
        Arrays.sort(word2Arr);
        return new String(word1Arr).equals(new String(word2Arr));
    }
}
