public class Seconds extends DateTimeClass{
    
    private int seconds;
    private final long SECONDSINMILLIS = 1000L;

    public Seconds(DateTimeClass minutes){
        setSeconds(minutes);
    }

    public void setSeconds(DateTimeClass minutes) {
        this.seconds = (int) (minutes.getRemainderToConvert()/getSECONDSINMILLIS());
        this.setRemainderToConvert(minutes, getSECONDSINMILLIS());
    }

    public int getSeconds() {
        return seconds;
    }

    public long getSECONDSINMILLIS() {
        return SECONDSINMILLIS;
    }
}