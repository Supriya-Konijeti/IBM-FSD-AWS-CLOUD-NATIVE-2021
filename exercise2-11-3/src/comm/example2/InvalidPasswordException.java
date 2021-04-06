package comm.example2;

public class InvalidPasswordException extends Exception {
    int passwordConditionExceptionViolated = 0;

    public InvalidPasswordException(int conditionViolated) {
        super("Invalid Password:");
        passwordConditionExceptionViolated = conditionViolated;
    }

    public String printMessage() {
        switch (passwordConditionExceptionViolated) {
            case 1:
                return ("Password length should be not less than " + "8" + "characters");
            case 2:
                return ("Password length should contain atleast one digit between " + "0-9");
            case 3:
                return ("Password length should contain atleast one special characters");
            case 4:
                return ("Password length should contain atleast one upper case letter");
            case 5:
                return ("Password length should contain atleast one lower case character");

            default:
                return ("Illegal format");
        }
    }
}
