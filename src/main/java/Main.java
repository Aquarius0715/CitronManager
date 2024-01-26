import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static boolean checkTelNumber(String telNumber) {
        Pattern pattern = Pattern.compile("^(070|080|090)\\d{4}\\d{4}$");
        Matcher matcher = pattern.matcher(removeSymbol(telNumber));
        return !matcher.find();
    }

    static boolean checkPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^0\\d{9,10}$");
        Matcher matcher = pattern.matcher(removeSymbol(phoneNumber));
        return !matcher.find();
    }

    static boolean checkZipCode(String zipCode) {
        Pattern pattern = Pattern.compile("^[0-9]{7}$");
        Matcher matcher = pattern.matcher(removeSymbol(zipCode));
        return matcher.find();
    }
    static String removeSymbol(String number) {
        return number.replaceAll("-", "")
                .replaceAll("\\(", "")
                .replaceAll("\\)", "")
                .replaceAll(" ", "");
    }
    public static void main(String[] args) {
        System.out.println(checkPhoneNumber("0438999970540"));
    }
}
