public class Fahrenheit extends Degree {

    public Fahrenheit() {
        super();
    }

    public Fahrenheit(float temperatureValue) {
        super(temperatureValue);
    }

    @Override
    public void setDegreeSymbol() {
        this.degreeSymbol = new char[] { 'F' };
    }

    public Celcius convertToCelcius() {
        float convertionResult = (((this.degreeValue - 32) * 5) / 9);
        Celcius celcius = new Celcius(convertionResult);
        System.out.println(celcius.toString());
        return celcius;
    }

}