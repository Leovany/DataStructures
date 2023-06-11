package nowcoder;

import leetcode.LeetCode_004;

import java.util.HashSet;
import java.util.Scanner;

public class NowCoder_HJ20 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            if (isPass(str)) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
    }

    public static boolean isPass(String str) {
        // 1. 长度超过8位
        if (str.length() <= 8) {
            return false;
        }
        // 2. 包括大小写字母.数字.其它符号,以上四种至少三种，其他符号不含空格或换行
        if (!isMoreKind(str)) {
            return false;
        }
        // 3. 不能有长度大于2的包含公共元素的子串重复
        if (isRepeat(str)) {
            return false;
        }
        return true;
    }

    public static boolean isMoreKind(String str) {
        int[] flagArray = new int[4];
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= 'A' && c <= 'Z') {
                flagArray[0] = 1;
            } else if (c >= 'a' && c <= 'z') {
                flagArray[1] = 1;
            } else if (c >= '0' && c <= '9') {
                flagArray[2] = 1;
            } else if (c != ' ' && c != '\n') {
                flagArray[3] = 1;
            }
        }
        int count = 0;
        for (int i = 0; i < flagArray.length; i++) {
            if (flagArray[i] == 1) {
                count += 1;
            }
        }
        return count >= 3;
    }

    public static boolean isRepeat(String str) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < str.length() - 3; i++) {
            String s = str.substring(i, i + 3);
            if (set.contains(s)) {
                return true;
            }
            set.add(s);
        }
        return false;

    }

}
