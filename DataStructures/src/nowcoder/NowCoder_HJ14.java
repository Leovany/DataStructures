package nowcoder;

import java.util.*;

/**
 * HJ14 字符串排序
 */
public class NowCoder_HJ14 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = Integer.parseInt(scanner.nextLine());
            for(int i =0;i<num;i++){
                String str = scanner.nextLine();
                list.add(str);
            }
            // 排序
            Collections.sort(list);
            // 输出
            list.forEach(item->{
                System.out.println(item);
            });

        }


    }
}
