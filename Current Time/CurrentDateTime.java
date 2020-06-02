public class CurrentDateTime {

    boolean isBST;
    private long currentDateTimeInMillis;
    Year currentYear;
    Month currentMonth;
    Day currentDay;
    Hours currentHours;
    Minutes currentMinutes;
    Seconds currentSeconds;

    public CurrentDateTime() {
        setBST(true);
        setCurrentDateTimeInMillis();
        setCurrentYear();
        setCurrentMonth();
        setCurrentDay();
        setCurrentHours();
        setCurrentMinutes();
        setCurrentSeconds();
        System.out.println(getCurrentYear().getYear() + " " + getCurrentMonth().getMonth() + " " + getCurrentDay().getDay() + " " + getCurrentHours().getHours() + " " + getCurrentMinutes().getMinutes() + " " +getCurrentSeconds().getSeconds());
    }

    public boolean isBST() {
        return isBST;
    }

    public void setBST(boolean isBST) {
        this.isBST = isBST;
    }

    public void setCurrentDateTimeInMillis() {
        this.currentDateTimeInMillis = System.currentTimeMillis();
    }

    public long getCurrentDateTimeInMillis() {
        return this.currentDateTimeInMillis;
    }

    public Year getCurrentYear() {
        return this.currentYear;
    }

    public void setCurrentYear() {
        this.currentYear = new Year(getCurrentDateTimeInMillis());
    }

    public void setCurrentMonth() {
        this.currentMonth = new Month(getCurrentYear());
    }

    public Month getCurrentMonth() {
        return currentMonth;
    }

    public void setCurrentDay() {
        this.currentDay = new Day(getCurrentMonth());
    }

    public Day getCurrentDay() {
        return currentDay;
    }

    public void setCurrentHours() {
        this.currentHours = new Hours(getCurrentDay(),isBST());
    }

    public Hours getCurrentHours() {
        return currentHours;
    }

    public void setCurrentMinutes() {
        this.currentMinutes = new Minutes(getCurrentHours());
    }

    public Minutes getCurrentMinutes() {
        return currentMinutes;
    }

    public void setCurrentSeconds() {
        this.currentSeconds = new Seconds(getCurrentMinutes());
    }

    public Seconds getCurrentSeconds() {
        return currentSeconds;
    }

    public static void main(String[] args) {
        CurrentDateTime cdt = new CurrentDateTime();
    }

}