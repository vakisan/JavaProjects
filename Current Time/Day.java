public class Day extends DateTimeClass {

    private int day;
    private final long DAYINMILLIS = 24*60*60*1000L;

    public Day(DateTimeClass month) {
        setDay(month);
    }

    public void setDay(DateTimeClass month) {
        this.day = (int) (month.getRemainderToConvert() / getDAYINMILLIS()) + 1;
        this.setRemainderToConvert(month, DAYINMILLIS);
    }

    public long getDAYINMILLIS() {
        return DAYINMILLIS;
    }

    public int getDay() {
        return this.day;
    }
}
