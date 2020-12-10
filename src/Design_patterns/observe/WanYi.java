package Design_patterns.observe;

/**
 * @author zhangsy
 * @date 2020/9/10 18:04
 */
public class WanYi implements Observe {

    private WeatherData weatherData;

    public WeatherData getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public void update(WeatherData weatherData) {
        this.weatherData = weatherData;
        display();
    }

    private void display() {
        System.out.println("===网易网站====");
        System.out.println("***网易网站 气温 : " + weatherData.getTemperatrue()+ "***");
        System.out.println("***网易网站 气压: " + weatherData.getPressure() + "***");
        System.out.println("***网易网站 湿度: " + weatherData.getHumidity() + "***");
    }
}
