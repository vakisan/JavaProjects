#Current Time Application

#What did I learn from this?

The application is designed mainly from scratch. it only used the System class to get time and Patter class for matching regular expressions to A string value.
In this program, I set by wanting to use switch statements as i have not used them near enough up until enough. I also demonstrate the use of regular expression to format dates into a specific format.
The following methods i used for the first time:

Boolean b = Pattern.matches();
Pattern p = Pattern.compile();
Matcher m = p.matcher();
boolean b = m.matches();

I also read up on StringBuilder and StringBuffer classes and CharSequences class.
StringBuilder and StringBuffer enable the creating of String-Like Objects but these are mutable as using == to proove if concatenating or appending:
StringBuilder is faster but not thread safe. I havent researched on thread safety but I believe it refers to the ability to execute another branch to perform tasks coincidentally. String buffer appears to be thread safe.

#Program Structure

The program is structure into Objects that represent various components of time. each time component computes the value of time using an algorithm i designed myself.
finally, I also created a functionality to present the time output using various format. i have only added 4 so far. The formats utilise regex expressions to find the users desired pattern of time display.

#Functionality

This application gets the time of the JVM using the System.currentTimeMillis(). The application process this time in millisecconds to the standard time output that we are accustomed to seeing.
This program needed to account for Leap Years since 01/01/1970 and also account for the monthly variation of days in months.

#Future Work

I plan to add a functionality to allow user to refresh the time either when desried or by creating a timer.
furthermore, I plan to complete the Enum classes and add further regex to display date and time with more formats.

