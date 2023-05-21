package recursion;

/**
 * 八皇后问题（国际象棋）
 */
public class Queen8 {
    public static void main(String[] args) {
        int count = 8;
        Queen8 queen = new Queen8(count);
        queen.check(0);
        System.out.printf("总共%d摆法,判断了%d次", queen.totalCount, queen.judgeCount);

    }

    // 1. 定义数据结构

    // 皇后次数
    private int maxSize;
    // 定义数组array,保存每次成功摆法的皇后位置，index=行，val=列
    private int[] arr = null;
    // 总共多少种摆法
    public int totalCount = 0;
    // 判断次数
    public int judgeCount = 0;

    public Queen8(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];

    }

    // 2. 摆放方法

    /**
     * 皇后的摆法
     *
     * @param n 第几个皇后，从0开始
     */
    public void check(int n) {
        // 退出条件
        if (n == maxSize) {

            // 最后+1个，因为是从0开始，所以 n+1 = maxSize，
            print();
            return;
        }
        // 同一个行中的每一列，依次放入皇后,并判断是否冲突
        for (int i = 0; i < maxSize; i++) {
            // 先放进去
            arr[n] = i;

            if (isConflict(n)) {
                // 如冲突了，摆放下一列 col++
                continue;
            }
            // 没冲突，摆放下一行
            check(n + 1);
        }

    }

    // 3. 判断冲突方法

    /**
     * 判断当前皇后，跟之前的皇后们，是否有冲突
     *
     * @param n 第几个皇后，从0开始
     * @return
     */
    private boolean isConflict(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            // 1. 行冲突-默认避免
            // 2. 列冲突
            if (arr[i] == arr[n]) {
                return true;
            }
            // 3. 斜线冲突- 行差=列差
            if (Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return true;
            }
        }
        // 没有冲突
        return false;
    }

    /**
     * 将皇后摆法位置输出
     */
    private void print() {
        totalCount++;
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s ", arr[i]);
        }
        System.out.println("");

    }
}
