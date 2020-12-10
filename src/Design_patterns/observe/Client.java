package Design_patterns.observe;

/**
 * @author zhangsy
 * @date 2020/9/10 19:20
 */
public class Client {
    public static void main(String[] args) {
        WeatherCenter subject = new WeatherCenter();
        subject.setWeatherData(new WeatherData(32f,1000f,20f));
        //添加观察者
        subject.addObserve(new WanYi());
        subject.addObserve(new Baidu());
        //唤醒所有观察者
        subject.notifyObserve();
    }
}
