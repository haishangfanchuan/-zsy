package niucode;

/**
 * @author shengyun
 * @date 2021/1/5
 *
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:
 * 首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,
 * 并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？
 * (注：小朋友的编号是从0到n-1)
 *
 * 如果没有小朋友，请返回-1
 * 示例1
 * 输入
 * 5,3
 * 返回值
 * 3
 */
public class 孩子们的游戏_圆圈中最后剩下的数 {

    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(5,3));
    }

    public static int LastRemaining_Solution(int n, int m) {
        //0-1-2-3-4
        int[] flag = new int[n];
        int temp = n, start = 0, step = 1;
        while (temp > 1) {
            int out = 0;
            while (step < m) {
                out = (1 + start) % n;
                step++;
                //走到出列的小朋友位置,剩余步数不变,继续先前移动一位
                while (flag[out] == 1) {
                    out = (out + 1) % n;
                }
                start = out;
            }
            System.out.println(out + " 号小朋友出列唱歌，并且得到一份随机礼物");
            flag[out] = 1;
            start = (out + 1) % n;
            while (flag[start] == 1) {
                start = (start + 1) % n;
            }
            temp--;
            step = 1;
        }
        return start;
    }
}
