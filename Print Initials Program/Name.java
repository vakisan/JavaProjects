import java.util.Scanner;

public class Name implements FirstName, LastName {

    private String lastName;
    private String firstName;

    public Name() {
        System.out.println("Setting up Name Instance Fields");
        setName();
        // setFirstName(getNamePart(0));
        // setLastName(getNamePart(1));
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName() {
        String input = null;
        input = userInput("Please enter your ", "First Name: ");
        setFirstName(input);
        input = null;
        input = userInput("Please enter your ", "Last Name: ");
        setLastName(input);
        confirmName();
    }

    public String userInput(String message, String lastNameOrFirstName) {
        String input = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println(message + lastNameOrFirstName);
        try {
            input = scanner.nextLine();
        } catch (Exception e) {

        }
        // closing scanner prevents the use of scanner class in this method.
        // scanner.close();
        return input;
    }

    public void confirmName() {
        System.out.println("");
        String input = toString();
        while (!((input.equals("Y")) || (input.equals("Yes")) || (input.equals("yes")) || (input.equals("no"))
                || (input.equals("No")) || (input.equals("n")) || (input.equals("N")) || (input.equals("y")))) {
            System.out.println("");
            System.out.println("We did not recognise your entry. Please try again");
            input = toString();
        }
        if (input.charAt(0) == 'N' || input.charAt(0) == 'n') {
            setName();
        } else {
            // end of algorithm
        }
    }

    @Override
    public String toString() {
        System.out.println("Your Full name is : " + getFirstName() + " " + getLastName());
        System.out.println("Your First Name is : " + getFirstName());
        System.out.println("Your Last Name is : " + getLastName());
        String input = userInput("Is this correct? ", "Yes or No");
        return input;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }
}