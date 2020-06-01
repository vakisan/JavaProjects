public class StringInput extends Input {

    public StringInput(String message) {
        super(message);
        System.out.println("You have entered : " + this.getInput());
    }

    @Override
    public void modifyInput(String newValue) {
        this.input = newValue;
    }

    @Override
    public String toString() {
        this.input = this.scanner.nextLine();
        System.out.println("The input is : " + this.getInput());
        return this.getInput();
    }
}