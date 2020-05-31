import java.util.Scanner;
//this class is not longer being used. it was intended as test to see if i could create my own exception class.

public class YesNoException extends RuntimeException {

    final String yesNo = "Yes or No";
    final String isThisCorrect = "Is this correct?";

    public YesNoException() {
        super("Your input is not accepted. Please enter Yes or No");

    }

    public String userInput(String message) {
        String input = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        input = scanner.nextLine();
        return input;
    }

}