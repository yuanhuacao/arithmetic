package com.example.arithmetic.simple;

public class Hanoi {

    private  int count=1;
    /**
     *
     * @param n 盘子的数目
     * @param origin 源座
     * @param assist 辅助座
     * @param destination 目的座
     */
    public void hanoi(int n, char origin, char assist, char destination) {
        if (n == 1) {
            move(origin, destination);
        } else {
            hanoi(n - 1, origin, destination, assist);
            move(origin, destination);
            hanoi(n - 1, assist, origin, destination);
        }
    }

    // Print the route of the movement
    private void move(char origin, char destination) {
        System.out.println("第"+count+++"步:" + origin + "--->" + destination);
    }

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.hanoi(3, '源', '辅', '目');
    }
}
