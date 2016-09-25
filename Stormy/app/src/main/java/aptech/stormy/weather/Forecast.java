package aptech.stormy.weather;

public class Forecast {


    private Current mcurrentWeather;

    public Current getMcurrentWeather() {
        return mcurrentWeather;
    }

    public void setMcurrentWeather(Current mcurrentWeather) {
        this.mcurrentWeather = mcurrentWeather;
    }

    public Hour[] getmHourlyForecast() {
        return mHourlyForecast;
    }

    public void setmHourlyForecast(Hour[] mHourlyForecast) {
        this.mHourlyForecast = mHourlyForecast;
    }

    public Day[] getmDailyForecast() {
        return mDailyForecast;
    }

    public void setmDailyForecast(Day[] mDailyForecast) {
        this.mDailyForecast = mDailyForecast;
    }

    private Hour[] mHourlyForecast;
    private Day[] mDailyForecast;

}
