package nowcoder;

import java.util.Scanner;

/**
 * HJ106 字符逆序
 */
public class NowCoder_HJ106 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();

            for (int i = str.length() -1; i >= 0; i--) {
                char ch = str.charAt(i);
                System.out.print(ch);
            }

        }
    }
}
