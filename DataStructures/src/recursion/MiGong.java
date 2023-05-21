package recursion;

import java.util.Arrays;

/**
 * 迷宫地图（递归）
 */
public class MiGong {

    public static void main(String[] args) {
        int row = 8;
        int col = 7;
        System.out.println("======= 生成地图 ========");
        MiGong miGong = new MiGong();
        miGong.generate(row, col);
        System.out.println("======= 迷宫结果（深拷贝） ========");
        miGong.setTarget(6, 5);
        int[][] pathMap = miGong.findWay(1, 1);
        miGong.printMap(pathMap);

        System.out.println("======= 原地图（深拷贝） ========");
        miGong.printMap();

    }

    // 迷宫地图
    private int[][] map = null;
    // 终点
    private int targetX = 0;
    private int targetY = 1;

    /**
     * 生成迷宫
     */
    public void generate(int row, int col) {
        System.out.printf("====== 生成地图(%dx%d) ============\n", row, col);
        this.map = new int[row][col];

        // 地图
        for (int i = row; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = 0;
            }
        }

        // 墙
        for (int i = 0; i < row; i++) {
            map[i][0] = 1;
            map[i][col - 1] = 1;
        }
        for (int i = 0; i < col; i++) {
            map[0][i] = 1;
            map[row - 1][i] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;

        printMap(this.map);
    }

    private void printMap(int[][] map) {
        int row = map.length;
        int col = map[0].length;

        for (int i = 0; i < row; i++) {
            System.out.printf("第%d行: ", i);
            for (int j = 0; j < col; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void printMap() {
        printMap(this.map);
    }

    /**
     * 设置终点
     *
     * @param x
     * @param y
     */
    public void setTarget(int x, int y) {
        this.targetX = x;
        this.targetY = y;
    }

    /**
     * 查找路径
     *
     * @param fromI 启点
     * @param fromJ 启点
     * @return
     */
    public int[][] findWay(int fromI, int fromJ) {
        // 深拷贝
        // 一、错误
        //Arrays.copyOf(this.map, this.map.length);
        // 二、正确方式
        int row = this.map.length;
        int col = this.map[0].length;
        int[][] newMap = new int[row][col];
        for (int i = 0; i < this.map.length; i++) {
            // Arrays.copyOf 只适用于一维数组深拷贝，二维数组需要for遍历
            newMap[i] = Arrays.copyOf(this.map[i], this.map[i].length);
        }

        setWay(newMap, fromI, fromJ);
        return newMap;
    }

    /**
     * 使用递归回溯来给小球找路
     * 1. 约定 map[i][j] 为0=该点没有走过，1=墙，2=道路可以走，3=该点已经走过，但是走不通
     *
     * @param map 地图
     * @param i   从地图哪个位置出发 i
     * @param j   从地图哪个位置出发 j
     * @return
     */
    public boolean setWay(int[][] map, int i, int j) {
        if (map[targetX][targetY] == 2) {
            return true;
        }
        if (map[i][j] == 0) {
            // 0=初始(没走过)，1=墙，2=可达，3=死路
            map[i][j] = 2;
            // 行走策略：下右上左
            if (setWay(map, i + 1, j)) {        // 下
                return true;
            } else if (setWay(map, i, j + 1)) { // 右
                return true;
            } else if (setWay(map, i - 1, j)) { // 上
                return true;
            } else if (setWay(map, i, j - 1)) { // 左
                return true;
            } else {
                // 走不通，死路情况
                map[i][j] = 3;
                return false;
            }
        } else {
            // map[i][k]=1，2，3
            return false;
        }

    }


}
