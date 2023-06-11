package nowcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * HJ8 合并表记录
 */
public class NowCoder_HJ8 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new TreeMap<Integer,Integer>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < num; i++) {
                String line = scanner.nextLine();
                int key = Integer.parseInt(line.split(" ")[0]);
                int val = Integer.parseInt(line.split(" ")[1]);
                map.put(key, map.getOrDefault(key, 0) + val);
            }
            map.forEach((key, val) -> {
                System.out.println(key + " " + val);
            });
        }
    }
}
