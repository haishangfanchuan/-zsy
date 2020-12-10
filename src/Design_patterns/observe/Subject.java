package Design_patterns.observe;

/**
 * @author zhangsy
 * @date 2020/9/10 17:55
 *
 * 主题
 */
public interface Subject {
    //添加观察者
    void addObserve(Observe observe);
    //移除观察者
    void removeObserve(Observe observe);
    //通知观察者
    void notifyObserve();
}
