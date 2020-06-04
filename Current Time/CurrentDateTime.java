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
        displayDateTime();
    }

    public void displayDateTime(){
        String result = DayToString() + "/" + MonthToString() + "/" + YearToString() + " " + HoursToString() + ":" + MinutesToString() + ":" + SecondsToString();
        System.out.println(result);
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

    public int YearToString(){
        return this.getCurrentYear().getYear();
    }

    public int MonthToString(){
        return this.getCurrentMonth().getMonth();
    }

    public int DayToString(){
        return this.getCurrentDay().getDay();
    }

    public int HoursToString(){
        return this.getCurrentHours().getHours();
    }

    public int MinutesToString(){
        return this.getCurrentMinutes().getMinutes();
    }

    public int SecondsToString(){
        return this.getCurrentSeconds().getSeconds();
    }
}