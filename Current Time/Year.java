public class Year extends DateTimeClass {

    boolean isLeap;
    int year;
    //private final long YEARINMILLIS = 31556952000L;
    private final long YEARINMILLIS = 365*24*60*60*1000L;
    private final long LEAPINMILLIS = 366*24*60*60*1000L;
    // for 366 days 31622400000L

    public Year(long timeInMilliseconds) {
        setYear(timeInMilliseconds);
    }

    public void setYear(long timeInMilliseconds) {
        int startYear = 1970;
        long remainderPeriod = timeInMilliseconds;
        while(remainderPeriod>getLEAPINMILLIS()){
            if(startYear%4 == 0){
                //leap year 
                remainderPeriod = (remainderPeriod - getLEAPINMILLIS());
            }
            else{
                remainderPeriod = (remainderPeriod - getYEARINMILLIS());
            }
            startYear++;
        }
        this.year = startYear;
        if(startYear%4==0){
            setLeap(true);
            this.setRemainderToConvert(remainderPeriod);
        }
        else{
            setLeap(false);
            this.setRemainderToConvert(remainderPeriod);
        }
    }

    public void setLeap(boolean isLeap) {
        this.isLeap = isLeap;
    }

    public boolean isLeap() {
        return isLeap;
    }

    public int getYear() {
        return this.year;
    }

    public long getYEARINMILLIS() {
        return YEARINMILLIS;
    }

    public long getLEAPINMILLIS() {
        return LEAPINMILLIS;
    }
}