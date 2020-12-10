package Design_patterns.observe;

/**
 * @author zhangsy
 * @date 2020/9/10 18:03
 *
 * 天气数据
 */
public class WeatherData {

    private float temperatrue;
    private float pressure;
    private float humidity;

    public WeatherData(float temperatrue, float pressure, float humidity) {
        this.temperatrue = temperatrue;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public float getTemperatrue() {
        return temperatrue;
    }

    public void setTemperatrue(float temperatrue) {
        this.temperatrue = temperatrue;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "temperatrue=" + temperatrue +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                '}';
    }
}
