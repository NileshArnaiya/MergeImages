package aptech.stormy.weather;

public class Day

{
    private Long mTime;
    private String mSummary;
    private Double mTempMax;
    private String mIcon;
    private String mTimezone;

    public Long getmTime() {
        return mTime;
    }

    public void setmTime(Long mTime) {
        this.mTime = mTime;
    }

    public String getmSummary() {
        return mSummary;
    }

    public void setmSummary(String mSummary) {
        this.mSummary = mSummary;
    }

    public Double getmTempMax() {
        return mTempMax;
    }

    public void setmTempMax(Double mTempMax) {
        this.mTempMax = mTempMax;
    }

    public String getmIcon() {
        return mIcon;
    }

    public void setmIcon(String mIcon) {
        this.mIcon = mIcon;
    }

    public String getmTimezone() {
        return mTimezone;
    }

    public void setmTimezone(String mTimezone) {
        this.mTimezone = mTimezone;
    }
}
