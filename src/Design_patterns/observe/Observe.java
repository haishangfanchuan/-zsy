package Design_patterns.observe;

/**
 * @author zhangsy
 * @date 2020/9/10 17:54
 *
 * 观察者接口
 */
public interface Observe {
    void update(WeatherData weatherData);
}
