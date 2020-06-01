import java.util.Scanner;

public class IntegerInput extends Input {

    int integer;

    public IntegerInput(String message) {
        super(message);
        setInteger();
        setInput();
    }

    @Override
    public void modifyInput(String userInput) {
        this.input = userInput;

    }

    public void setInteger() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(this.inputMessage);
        while (!scanner.hasNextInt()) {
            System.out.println("Your entry was not recognised. Please enter an integer.");
            scanner.nextLine();
        }
        this.integer = scanner.nextInt();
        System.out.println(toString());
    }

    public int getInteger() {
        return this.integer;
    }

    @Override
    public void setInput() {
        this.input = String.valueOf(getInteger());
    }

    @Override
    public String toString() {
        return "The integer you have entered is : " + getInteger();
    }
}