package comm.example2;

public class UserMainClass {
    public static void checkPassword(String password) throws InvalidPasswordException {
        if (!((password.length() >= 8))) {
            throw new InvalidPasswordException(1);
        }
        /*if (password.contains("")) {
            throw new InvalidPasswordException(2);
        }*/
        if (true) {
            int count = 0;
            for (int i = 0; i <= 9; i++) {
                String str1 = Integer.toString(i);
                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                throw new InvalidPasswordException(2);
            }
        }
        if (!(password.contains("@") || password.contains("#") || password.contains("!") || password.contains("~") ||
                password.contains("$") || password.contains("%") || password.contains("^") || password.contains("&") ||
                password.contains("*") || password.contains("(") || password.contains(")") || password.contains("-") || password.contains("+")
                || password.contains("/") || password.contains(":") || password.contains(".") || password.contains(",") || password.contains("<") || password.contains(">") ||
                password.contains("?") || password.contains("|"))) {
            throw new InvalidPasswordException(3);
        }
        if (true) {
            int count = 0;
            for (int i = 65; i <= 90; i++) {
                char c = (char) i;

                String str1 = Character.toString(c);
                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                throw new InvalidPasswordException(4);
            }
        }
        if (true) {
            int count = 0;
            for (int i = 90; i <= 122; i++) {
                char c = (char) i;

                String str1 = Character.toString(c);
                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                throw new InvalidPasswordException(5);
            }
        }

    }
}

