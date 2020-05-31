public class Initial extends Name {

    private char firstNameInitial;
    private char lastNameInitial;

    public Initial() {
        super();
        setFirstNameInitial(super.getFirstName().charAt(0));
        setLastNameInitial(super.getLastName().charAt(0));
        System.out.println(this.confirmInitials());
    }

    public void setFirstNameInitial(char firstNameCharacter) {
        this.firstNameInitial = firstNameCharacter;
    }

    public void setLastNameInitial(char lastNameCharacter) {
        this.lastNameInitial = lastNameCharacter;
    }

    public char getFirstNameInitial() {
        return this.firstNameInitial;
    }

    public char getLastNameInitial() {
        return this.lastNameInitial;
    }

    public String confirmInitials() {
        return "Your initials are : " + new String(new char[] { getFirstNameInitial(), getLastNameInitial() });
    }
}