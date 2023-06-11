package nowcoder;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * HJ33 整数与IP地址间的转换
 */
public class NowCoder_HJ33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String ip = scanner.nextLine();
            Long ipNum = scanner.nextLong();
            System.out.println(ip2Num(ip));
            System.out.println(num2Ip(ipNum, 4));
        }
    }

    public static long ip2Num(String ip) {
        String[] array = ip.split("\\.");
        String result = "";
        for (int i = 0; i < array.length; i++) {
            int num = Integer.parseInt(array[i]); // int
            String num2 = Integer.toBinaryString(num);// 十进制 -> 二进制
            // 补位 0
            while (num2.length() < 8) {
                num2 = "0" + num2;
            }
            // 单个
            result += num2;
        }
        return Long.parseLong(result, 2);  // 二进制 转 10进制
    }

    public static String num2Ip(Long num, int N) {
        // 10 进制 -> 2进制
        String num2 = Long.toBinaryString(num);
        while (num2.length() < N * 8) {
            num2 = "0" + num2;
        }
        // 2进制 -> 10进制
        String ans = "";
        for (int i = 0; i < N; i++) {
            String str = num2.substring(i * 8, (i + 1) * 8);
            long num10 = Long.parseLong(str, 2);
            ans += num10 + ".";
        }
        return ans.substring(0, ans.length() - 1);
    }

    // 递归方式
    public static String ip2Num2(String ip) {
        String s = "";
        String[] array = ip.split("\\.");
        for (int i = 0; i < array.length; i++) {
            String str = array[i];
//            System.out.println(str);
            String ipNum = decimalToBinary(Integer.parseInt(str), "");
            s += String.format("%08s", ipNum);
        }
        return s;
    }

    /**
     * 十进制 转 二进制
     *
     * @param num
     */
    public static String decimalToBinary(int num, String str) {
        if (num < 1) {
            return "";
        }
        str = decimalToBinary(num / 2, str);
        int val = num % 2;  // 余数
        return str + val;
    }


}
