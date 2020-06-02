
abstract class DateTimeClass {

    private long remainderToConvert;

    public void setRemainderToConvert(DateTimeClass child, long conversionFactor) {
        this.remainderToConvert = child.getRemainderToConvert() % conversionFactor;
    }

    // for year calculation only
    public void setRemainderToConvert(long timeInMilliseconds, long conversionFactor) {
        this.remainderToConvert = timeInMilliseconds % conversionFactor;
    }

    public void setRemainderToConvert(long timeInMilliseconds) {
        this.remainderToConvert = timeInMilliseconds;
    }

    public long getRemainderToConvert() {
        return remainderToConvert;
    }
}