import java.util.Arrays;

public enum DateTimePattern {
    
    YEAR_MONTH_DAY ("\\bY{1,4}\\b/M{1,2}\\b/D{1,2}", 0),
    YEAR_MONTH_DAY_HOURS_MINUTES_SECONDS ("Y{1,4}\\b/M{1,2}\\b/D{1,2}\\b H{1,2}:M{1,2}:S{1,2}\\b" , 1),
    DAY_MONTH_YEAR ("D{1,2}\\b/M{1,2}\\b/Y{1,4}", 2),
    DAY_MONTH_YEAR_HOURS_MINUTES_SECONDS ("D{1,2}\\b/M{1,2}\\b/Y{1,4}\\b H{1,2}:M{1,2}:S{1,2}\\b" , 3),
    DAY ("D*",4),
    MONTH ("M*" ,5),
    YEAR ("Y*" , 6),
    HOURS ("H*" ,7),
    MINUTES ("M*" , 8),
    SECONDS ("S*", 9);

    private String regex;
    private int code;
    public static String[] regexArrayAll;

    DateTimePattern(String regex, int code){
        setdateTimeFormat(regex);
        setCode(code);
    }

    public void setdateTimeFormat(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

    public static void setRegexArrayAll(){
        regexArrayAll = new String[10];
        int i = 0;
        for(DateTimePattern pattern : DateTimePattern.values()){
            regexArrayAll[i] = pattern.getRegex();
            i++;
        }
    }

    public static String[] getRegexArrayAll() {
        setRegexArrayAll();
        return regexArrayAll;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}