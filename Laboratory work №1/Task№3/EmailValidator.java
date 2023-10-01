class EmailValidating {
    public static boolean validateEmail(final String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        String[] parts = email.split("@");
        if (parts.length != 2) {
            return false;
        }

        if (parts[0].isEmpty() || parts[1].isEmpty()) {
            return false;
        }

        if (containsSpecialCharacters(parts[0]) || containsSpecialCharacters(parts[1])) {
            return false;
        }

        if (!parts[1].contains(".")) {
            return false;
        }

        return true;
    }

    private static boolean containsSpecialCharacters(String str) {
        String specialCharacters = "!#$%&'*+-/=?^_`{|}~";
        for (char c : str.toCharArray()) {
            if (specialCharacters.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
}