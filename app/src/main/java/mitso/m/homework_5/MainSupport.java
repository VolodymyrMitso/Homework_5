package mitso.m.homework_5;

import android.content.Context;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainSupport {

    public static boolean emptyFieldsCheck(Context context, String to, String subject, String messageText) {
        boolean result = false;
        if (to.isEmpty() && subject.isEmpty() && messageText.isEmpty())
            Toast.makeText(context, Constants.WARNING_EMPTY_ALL, Toast.LENGTH_LONG).show();
        else if (to.isEmpty() && messageText.isEmpty())
            Toast.makeText(context, Constants.WARNING_EMPTY_TO_AND_TEXT, Toast.LENGTH_LONG).show();
        else if (to.isEmpty())
            Toast.makeText(context, Constants.WARNING_EMPTY_TO, Toast.LENGTH_LONG).show();
        else if (messageText.isEmpty())
            Toast.makeText(context, Constants.WARNING_EMPTY_TEXT, Toast.LENGTH_LONG).show();
        else {
            result = true;
        }
        return result;
    }

    public static boolean emailAddressCheck(Context context, String string) {
        boolean result = false;
        Pattern p = Pattern.compile("(.)+(@)(.)+(\\.)(.)+");
        Matcher m = p.matcher(string);
        if (!m.find())
            Toast.makeText(context, Constants.WARNING_EMAIL_INCORRECT_INPUT, Toast.LENGTH_LONG).show();
        else
            result = true;
        return result;
    }
}
