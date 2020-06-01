import java.util.Scanner;

abstract public class Degree {

    float degreeValue;
    char[] degreeSymbol;

    public Degree() {
        setDegreeValue();
        setDegreeSymbol();
        printMessage(toString());
        while (!isConfirmed()) {
            setDegreeValue();
            setDegreeSymbol();
        }
    }

    public Degree(float temperatureValue) {
        setDegreeValue(temperatureValue);
        setDegreeSymbol();
    }

    public void setDegreeValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the Temperature value in " + Temperature.temperatureMode + " : ");
        while (!scanner.hasNextFloat()) {
            printMessage("The input provided is not a temperature. Please enter the Temperature value in "
                    + Temperature.temperatureMode + " : ");
            scanner.nextLine();
        }
        this.degreeValue = scanner.nextFloat();
    }

    public void setDegreeValue(float temperatureValue) {
        this.degreeValue = temperatureValue;
    }

    public float getDegreeValue() {
        return degreeValue;
    }

    abstract public void setDegreeSymbol();

    public char[] getDegreeSymbol() {
        return degreeSymbol;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public String toString() {
        return "The temperature you have set is " + this.getDegreeValue() + new String(this.getDegreeSymbol());
    }

    public boolean isConfirmed() {
        System.out.println("Should this temperature be accepted? Please enter yes or no : ");
        String response = null;
        Scanner scanner = new Scanner(System.in);
        while (!(scanner.hasNext("Yes") || scanner.hasNext("No") || scanner.hasNext("yes") || scanner.hasNext("no"))) {
            System.out.print("Your input was not recognised. Please enter yes or no : ");
            scanner.nextLine();
        }
        response = scanner.nextLine();
        if (isYesNo(response)) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isYesNo(String response) {
        if (response.charAt(0) == 'n' || response.charAt(0) == 'N') {
            return false;
        } else {
            return true;
        }
    }
}