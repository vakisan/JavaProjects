import java.util.Scanner;

public class Temperature {

    Fahrenheit fahrenheit;
    Celcius celcius;
    static String temperatureMode;

    public Temperature() {
        setTemperatureMode();
        if ((getTemperatureMode().charAt(0) == 'C') || (getTemperatureMode().charAt(0) == 'c')) {
            setCelcius();
            setFahrenheit(this.celcius);
            // System.out.println("completed celcius block");
        } else {
            setFahrenheit();
            System.out.println("completed farh constructor");
            setCelcius(getFahrenheit());
        }
        System.out.println(print());
    }

    public String askDegreeType(Scanner scanner) {
        System.out.println("Please select the temperature mode you wish to use?");
        System.out.println("Enter Celcius or Fahrenheit");
        while (!(scanner.hasNext("Celcius") || scanner.hasNext("celcius") || scanner.hasNext("Fahrenheit")
                || scanner.hasNext("fahrenheit"))) {
            System.out.print("Your entry was not recognised. Please enter Celcius or Fahrenheit : ");
            scanner.nextLine();
        }
        return scanner.nextLine();
    }

    public void setTemperatureMode() {
        Scanner scanner = new Scanner(System.in);
        String degreeMode = askDegreeType(scanner);
        Temperature.temperatureMode = degreeMode;
    }

    public String getTemperatureMode() {
        return temperatureMode;
    }

    public void setCelcius() {
        this.celcius = new Celcius();
    }

    public void setCelcius(Fahrenheit f) {
        this.celcius = f.convertToCelcius();
    }

    public void setFahrenheit() {
        this.fahrenheit = new Fahrenheit();
    }

    public void setFahrenheit(Celcius c) {
        this.fahrenheit = c.convertToFahrenheit();
    }

    public Celcius getCelcius() {
        return celcius;
    }

    public Fahrenheit getFahrenheit() {
        return fahrenheit;
    }

    public String print() {
        return "In Celcius : " + this.celcius.getDegreeValue() + new String(this.celcius.getDegreeSymbol()) + " "
                + "\nIn Fahrenheit : " + this.fahrenheit.getDegreeValue()
                + new String(this.fahrenheit.getDegreeSymbol());
    }

}