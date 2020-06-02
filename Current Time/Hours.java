public class Hours extends DateTimeClass {
    private final long HOURSINMILLIS = 60*60*1000L;
    int hours;

    public Hours(DateTimeClass day , boolean isBST) {
        setHours(day , isBST);
    }

    public void setHours(DateTimeClass day ,boolean isBST) {
        if(isBST){
            this.hours = (int) (day.getRemainderToConvert() / getHOURSINMILLIS())+1;
            this.setRemainderToConvert(day, HOURSINMILLIS);
        }
        else{
            this.hours = (int) (day.getRemainderToConvert() / getHOURSINMILLIS());
            this.setRemainderToConvert(day, HOURSINMILLIS);
        }
    }

    public long getHOURSINMILLIS() {
        return HOURSINMILLIS;
    }

    public int getHours() {
        return this.hours;
    }
}