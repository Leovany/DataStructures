package nowcoder;

import java.util.*;

/**
 * HJ68 成绩排序
 */
public class NowCoder_HJ68 {
    public static void main(String[] args) {
        List<String[]> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = Integer.parseInt(scanner.nextLine());
            int sortIndex = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < count; i++) {
                String line = scanner.nextLine();
                String name = line.split(" ")[0];
                int score = Integer.parseInt(line.split(" ")[1]);

                String[] array = new String[]{name, score + ""};
                list.add(array);
            }
            // 排序
            if (sortIndex == 0) {
                // 0代表从高到低
                Collections.sort(list, new Comparator<String[]>() {
                    @Override
                    public int compare(String[] o1, String[] o2) {
                        return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
                    }
                });
            } else if (sortIndex == 1) {
                // 1代表从低到高
                Collections.sort(list, new Comparator<String[]>() {
                    @Override
                    public int compare(String[] o1, String[] o2) {
                        return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
                    }
                });
            }


            list.forEach(item -> {
                System.out.println(item[0] + " " + item[1]);
            });
        }
    }


}
