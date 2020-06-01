import java.util.Scanner;

public class NumberInput {

    private int number;

    public NumberInput() {
        this.setNumber();
        printMessage(this.confirmStatement());
        while (!isConfirmed()) {
            setNumber();
        }
        printMessage("You have confirmed " + this.confirmStatement());
    }

    public void setNumber() {
        Scanner scanner = new Scanner(System.in);
        printMessage("Please enter an integer");
        while (!scanner.hasNextInt()) {
            System.out.println("Your input was not recognised as a integer. Please try again.");
            printMessage("Please enter an integer");
            scanner.nextLine();
        }
        this.number = scanner.nextInt();
    }

    public int incrementNumber(int increment) {
        return this.number + 1;
    }

    public int getNumber() {
        return this.number;
    }

    private String confirmStatement() {
        return "Your input is : " + this.getNumber();
    }

    private boolean isConfirmed() {
        System.out.print("Should this number be accepted? Please enter yes or no : ");
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

    private boolean isYesNo(String response) {
        if (response.charAt(0) == 'n' || response.charAt(0) == 'N') {
            return false;
        } else {
            return true;
        }
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

}