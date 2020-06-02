public class Month extends DateTimeClass {

    private int month;
    private final long MONTH31INMILLIS = 31*24*60*60*1000L;
    private final long MONTH30INMILLIS = 30*24*60*60*1000L;
    private final long MONTH29INMILLIS = 29*24*60*60*1000L;
    private final long MONTH28INMILLIS = 28*24*60*60*1000L;

    public Month(Year year) {
        setMonth(year);
    }

    public void setMonth(Year year) {
        int month = 1;
        long remainder = year.getRemainderToConvert();
        while(remainder>getMONTH31INMILLIS()){
            if (month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
                remainder = remainder - getMONTH31INMILLIS();
                month++;
            }
            else if(month == 2){
                if(year.isLeap()){
                    remainder = remainder - getMONTH29INMILLIS();
                    month++;
                }
                else{
                    remainder = remainder - getMONTH28INMILLIS();
                    month++;
                }
            }
            else{
                remainder = remainder - getMONTH30INMILLIS();
                month++;
            }
        }
        this.month = month;
        this.setRemainderToConvert(remainder);
    }

    public int getMonth() {
        return month;
    }

    public long getMONTH31INMILLIS() {
        return MONTH31INMILLIS;
    }

    public long getMONTH28INMILLIS() {
        return MONTH28INMILLIS;
    }
    
    public long getMONTH29INMILLIS() {
        return MONTH29INMILLIS;
    }

    public long getMONTH30INMILLIS() {
        return MONTH30INMILLIS;
    }
}