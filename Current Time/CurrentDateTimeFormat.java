import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurrentDateTimeFormat {
    
    private CurrentDateTime currentDateTime;
    private DateTimePattern dateTimePattern;
    private String format;
    private String result;
    private Pattern[] pattern;

    public CurrentDateTimeFormat(CurrentDateTime currentDateTimeObject, String format){
        addCurrentDateTime(currentDateTimeObject);
        setFormat(format);
        setDateTimePattern();
        System.out.println(getResult());
    }

    public void addCurrentDateTime(CurrentDateTime currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    public CurrentDateTime getCurrentDateTime() {
        return currentDateTime;
    }

    public void setDateTimePattern() {
        switch(matchDateTimePatternWithFormat()){
            case 0 : {
                this.dateTimePattern = DateTimePattern.YEAR_MONTH_DAY;
                setResult0(result);
            }; break;

            case 1: {
                this.dateTimePattern = DateTimePattern.YEAR_MONTH_DAY_HOURS_MINUTES_SECONDS;
                setResult1(result);
            }

            case 2: {
                
            }
        }
    }

    public int matchDateTimePatternWithFormat(){
        String[] regexArray = DateTimePattern.getRegexArrayAll();
        System.out.println(Arrays.toString(regexArray));
        Matcher matcher= null;
        this.pattern = new Pattern[regexArray.length];
        for(int i = 0; i<regexArray.length; i++){
            this.pattern[i] = Pattern.compile(regexArray[i], Pattern.CASE_INSENSITIVE);
            matcher = pattern[i].matcher(getFormat());
            if(matcher.matches()){
                //System.out.println(regexArray[i]);
                return i;
            }
        }
        return -1;
    }

    public DateTimePattern getDateTimePattern() {
        return dateTimePattern;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
/*

    this was an alternative method but I wanted apply my knowledge of enum types and combine that with regular expressions
    this code below may not work because i played around with it to see what would happen. so it should wokr if modifed.

    public String convertCurrentDateTimeFormat(){
        String regex = getDateTimePattern().toString();
        System.out.println(regex);
        //Pattern dateTimeFormat = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        //Matcher matcher1 = dateTimeFormat.matcher(getDateTimePattern());
        return (this.getCurrentDateTime().YearToString() + "/" + this.getCurrentDateTime().MonthToString() + "/" + this.getCurrentDateTime().DayToString());
    }
*/
    public void setResult0(String result) {
        this.result = this.getCurrentDateTime().YearToString() + "/" + this.getCurrentDateTime().MonthToString() + "/" + this.getCurrentDateTime().DayToString();
    }

    public void setResult1(String result) {
        this.result = this.getCurrentDateTime().YearToString() + "/" + this.getCurrentDateTime().MonthToString() + "/" + this.getCurrentDateTime().DayToString() + " " + this.getCurrentDateTime().HoursToString() + ":" + this.getCurrentDateTime().MinutesToString() + ":" + this.getCurrentDateTime().SecondsToString();
    }

    public String getResult() {
        return result;
    }

    public static void main(String[] args) {
        CurrentDateTime cdt = new CurrentDateTime();
        CurrentDateTimeFormat cdtf = new CurrentDateTimeFormat(cdt, "YYYY/MM/DD HH:MM:SS");
    }
    
}