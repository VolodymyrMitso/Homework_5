package mitso.m.homework_5;

public class Constants {

    public static final String TO = "To:";
    public static final String SUBJECT = "Subject:";

    public static final String TEL = "tel:+380995339692";

    public static final int PERMISSION_REQUEST_CALL_PHONE = 1;

    public static final int DIALOG = 1;
    public static final String DIALOG_MESSAGE = "Want to try again?";
    public static final String DIALOG_POSITIVE = "YES";
    public static final String DIALOG_NEGATIVE = "NO";



    public static final String WARNING_EMPTY_ALL =
                    "All fields are empty:\n".toUpperCase() +
                    "- Add a recipient\n" +
                    "- Add a subject\n" +
                    "- Write a message text";

    public static final String WARNING_EMPTY_TO_AND_TEXT =
                    "Important fields are empty:\n".toUpperCase() +
                    "- Add a recipient\n" +
                    "- Write a message text";

    public static final String WARNING_EMPTY_TO =
                    "Important field is empty:\n".toUpperCase() +
                    "- Add a recipient";

    public static final String WARNING_EMPTY_TEXT =
                    "Important field is empty:\n".toUpperCase() +
                    "- Write a message text";



    public static final String WARNING_EMAIL_INCORRECT_INPUT =
            "Incorrect input - email address:\n".toUpperCase() +
                    "- must contains symbols [@] and [.]\n" +
                    "- EXAMPLE: somebody@gmail.com\n" +
                    "- EXAMPLE: somebody@yahoo.com\n";
}