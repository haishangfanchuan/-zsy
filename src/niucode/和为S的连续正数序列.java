package niucode;

import java.util.ArrayList;

/**
 * @author shengyun
 * @date 2021/1/4
 *
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 返回值描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * 示例1
 * 输入
 * 9
 * 返回值
 * [[2,3,4],[4,5]]
 */
public class 和为S的连续正数序列 {

    public static void main(String[] args) {
        System.out.println(FindContinuousSequence(9));
    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (sum <= 2) return lists;
        int temp = 1, count = 0, num = 1;
        int ans;
        if (sum % 2 == 0) ans = sum >> 1;
        else ans = (sum >> 1) + 1;
        while (temp <= ans) {
            count += num;
            num++;
            if (count == sum) {
                //将temp -> num 的所有整数放入到list中
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = temp; i < num ; i++) {
                    list.add(i);
                }
                lists.add(list);
                continue;
            }
            if (count > sum) {
                count = 0;
                temp++;
                num = temp;
            }
        }
        return lists;
    }
}
