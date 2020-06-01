import java.util.Scanner;

abstract class Input {

    String input;
    String inputMessage;
    Scanner scanner;

    public Input(String message) {
        inputMessage = setInputMessage(message);
        scanner = setScanner();
        input = null;
    }

    public String setInputMessage(String inputMessage) {
        return this.inputMessage = inputMessage;
    }

    public Scanner setScanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    public String getInput() {
        return this.input;
    }

    public String getInputMessage() {
        return this.inputMessage;
    }

    abstract public void modifyInput(String newValue);

    abstract public String toString();
}