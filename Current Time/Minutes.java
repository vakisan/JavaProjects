public class Minutes extends DateTimeClass{

    private int minutes;
    private final long MINUTESINMILLIS = 60*1000L;

    public Minutes(DateTimeClass hours){
        setMinutes(hours);
    }

    public void setMinutes(DateTimeClass hours) {
        this.minutes = (int) (hours.getRemainderToConvert()/getMINUTESINMILLIS());
        this.setRemainderToConvert(hours, getMINUTESINMILLIS());
    }

    public int getMinutes() {
        return minutes;
    }

    public long getMINUTESINMILLIS() {
        return MINUTESINMILLIS;
    }

    
}