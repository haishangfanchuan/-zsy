package Design_patterns.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangsy
 * @date 2020/9/10 17:57
 *
 * 气象站（主题）
 */
public class WeatherCenter implements Subject{

    //list集合存储注册的观察者
    private List<Observe> list = new ArrayList<>();

    private WeatherData weatherData;



    public WeatherData getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public void addObserve(Observe observe) {
        list.add(observe);
    }

    @Override
    public void removeObserve(Observe observe) {
        if(list.contains(observe))
            list.remove(observe);
        else throw new RuntimeException("observe对象不存在");
    }

    @Override
    public void notifyObserve() {
        for(Observe observe : list){
            observe.update(weatherData);
        }
    }
}
