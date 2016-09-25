package aptech.stormy.weather;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import aptech.stormy.R;

public class Current {




    private String mIcon , mSummary;
    private long mTime ,mSunsetTime ,mSunriseTime;

    private double mTemp,mHumidity,mPrecipChance;



    public String getFormattedTime(){


        SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");
        formatter.setTimeZone(TimeZone.getDefault());
        Date d = new Date(getmTime() * 1000 +10000 * 80 );
        String theString = formatter.format(d);
        return  theString;


    }

    public int getIconId(){


        int iconId= R.drawable.clear_day;
        if (mIcon.equals("clear-day")) {
            iconId = R.drawable.clear_day;
        }
        else if (mIcon.equals("clear-night")) {
            iconId = R.drawable.clear_night;
        }
        else if (mIcon.equals("rain")) {
            iconId = R.drawable.rain;
        }
        else if (mIcon.equals("snow")) {
            iconId = R.drawable.snow;
        }
        else if (mIcon.equals("sleet")) {
            iconId = R.drawable.sleet;
        }
        else if (mIcon.equals("wind")) {
            iconId = R.drawable.wind;
        }
        else if (mIcon.equals("fog")) {
            iconId = R.drawable.fog;
        }
        else if (mIcon.equals("cloudy")) {
            iconId = R.drawable.cloudy;
        }
        else if (mIcon.equals("partly-cloudy-day")) {
            iconId = R.drawable.partly_cloudy;
        }
        else if (mIcon.equals("partly-cloudy-night")) {
            iconId = R.drawable.cloudy_night;
        }
    return iconId;
    }



    public void setmIcon(String mIcon) {
        this.mIcon = mIcon;
    }

    public String getmSummary() {
        return mSummary;
    }

    public void setmSummary(String mSummary) {
        this.mSummary = mSummary;
    }

    public long getmTime() {
        return mTime;
    }

    public void setmTime(long mTime) {
        this.mTime = mTime;
    }

    public int getmTemp() {
        return (int) Math.round(mTemp) -32 * (5/9);
    }

    public void setmTemp(double mTemp) {
        this.mTemp = mTemp;
    }

    public double getmHumidity() {
        return mHumidity;
    }

    public void setmHumidity(double mHumidity) {
        this.mHumidity = mHumidity;
    }

    public double getmPrecipChance() {
        double percent = mPrecipChance * 100;
        return (int)Math.round(percent);
    }

    public void setmPrecipChance(double mPrecipChance) {
        this.mPrecipChance = mPrecipChance;
    }


}
