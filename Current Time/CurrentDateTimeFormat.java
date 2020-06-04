/* 
Creating this class taught me:
1) How to use regular expressions to match a string.
    - Pattern.matches(regex , charsequence)  - 

    this method of Pattern Class can take in parameters of a string which contains the regex,
    it also takes in charsequence.
    charsequence is an interface which is implemented by mutable and immutable classes.
    the String class implements charsequence.
    we can have the same value stored in either types. Howwever they will not be equal.
    ie : assertNotEquals( ) 

    The parameter passed for the charsequence could be a string/stringbuilder/stringbuffer hence
    charsequence is a good option as parameter when different mutable or immutable string related objects are needed.

    - Pattern p = Pattern.compile(regex , flag)

    this is used if needing to reuse the regex for multiple checks. flags can be passed to ignore for instance cases.
    Pattern classes appears to use static methods mainly.

    -Matcher m = p.matcher(stringtocheckformatch)
    
    multiple pattern object can be used with a single matcher object. the matcher objects looks for matches  with its parameters against the regex that was compiled to p.
    other methods can be used to get more details on the matches.
    if matches are made we we can call m.matches() which will check for matches in the matcher object and return boolean.

2) differences between String, StringBuilder and StringBufer -

strings are immutable, if we create a string then wish to change it an y reassignment made will create a new string object;
we can proove this by using == operator to show that previous instance and new instance are not the same object.

StringBuilder and StringBuffer are mutable. we can modify them using append and also use concat but the object reference will remain the same.

StringBuilder is prefered over stringbuffer due to speed. however string buffer provides tread safety in contrast to StringBuffer.
*/

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
                setResult0();
            }; break;

            case 1: {
                this.dateTimePattern = DateTimePattern.YEAR_MONTH_DAY_HOURS_MINUTES_SECONDS;
                setResult1();
            }; break;

            case 2: {
                this.dateTimePattern = DateTimePattern.DAY_MONTH_YEAR;
                setResult2();
            } break;

            case 3: {
                this.dateTimePattern = DateTimePattern.DAY_MONTH_YEAR_HOURS_MINUTES_SECONDS;
                setResult3();
            } break;

            default: {
                this.dateTimePattern = DateTimePattern.DAY_MONTH_YEAR_HOURS_MINUTES_SECONDS;
                setResult3();
            }
        }
    }

    public int matchDateTimePatternWithFormat(){
        String[] regexArray = DateTimePattern.getRegexArrayAll();
        Matcher matcher= null;
        this.pattern = new Pattern[regexArray.length];
        for(int i = 0; i<regexArray.length; i++){
            this.pattern[i] = Pattern.compile(regexArray[i], Pattern.CASE_INSENSITIVE);
            matcher = pattern[i].matcher(getFormat());
            if(matcher.matches()){
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
    public void setResult0() {
        this.result = this.getCurrentDateTime().YearToString() + "/" + this.getCurrentDateTime().MonthToString() + "/" + this.getCurrentDateTime().DayToString();
    }

    public void setResult1() {
        this.result = this.getCurrentDateTime().YearToString() + "/" + this.getCurrentDateTime().MonthToString() + "/" + this.getCurrentDateTime().DayToString() + " " + this.getCurrentDateTime().HoursToString() + ":" + this.getCurrentDateTime().MinutesToString() + ":" + this.getCurrentDateTime().SecondsToString();
    }

    public void setResult2() {
        this.result = this.getCurrentDateTime().DayToString() + "/" + this.getCurrentDateTime().MonthToString() + "/" + this.getCurrentDateTime().YearToString();
    }

    public void setResult3() {
        this.result = this.getCurrentDateTime().DayToString() + "/" + this.getCurrentDateTime().MonthToString() + "/" + this.getCurrentDateTime().YearToString() + " " + this.getCurrentDateTime().HoursToString() + ":" + this.getCurrentDateTime().MinutesToString() + ":" + this.getCurrentDateTime().SecondsToString();
    }
    

    public String getResult() {
        return result;
    }    
}