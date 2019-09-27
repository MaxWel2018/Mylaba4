package lesson6.task4.utility;

public class RegexTemplate {

    public static final String REGEX_FOR_NAME = "[A-Za-z]{2,20}";
    public static final String REGEX_FOR_NUMBER = "[0-9]{1,3}";
    public static final String REGEX_FOR_PHONE_NUMBER = "[0-9]{10}";
    public static final String REGEX_FOR_BIRTHDAY = "^\\d{4}-\\d{2}-\\d{2}$";

    private RegexTemplate() {
    }



}
