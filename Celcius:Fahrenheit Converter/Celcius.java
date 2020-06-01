public class Celcius extends Degree {

    public Celcius() {
        super();
    }

    public Celcius(float temperatureValue) {
        super(temperatureValue);
    }

    @Override
    public void setDegreeSymbol() {
        this.degreeSymbol = new char[] { '°', 'C' };
    }

    public Fahrenheit convertToFahrenheit() {
        float convertionResult = (((this.degreeValue * 9) / 5) + 32);
        Fahrenheit fahrenheit = new Fahrenheit(convertionResult);
        System.out.println(fahrenheit.toString());
        return fahrenheit;
    }

}