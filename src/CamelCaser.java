import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.*;

public class CamelCaser {

    /**
     * Camel Cases a valid input
     * @param inputString String
     * @return String camelCasedOutput
     * @throws IllegalArgumentException
     */
    public static String camelCase(String inputString) throws IllegalArgumentException {
        if (!inputString.matches("[a-zA-Z0-9]+")) {

            System.out.println(ErrorConstants.INVALID_CHARACTER);
            throw new IllegalArgumentException();
        }
        if (inputString == null) {
            System.out.println("Null Input");
            throw new IllegalArgumentException();
        }
        String camelCasedOutput = "";
        inputString = inputString.toLowerCase();
        String[] inputStrArr = inputString.split("\\s+");
        for (int i = 0; i < inputStrArr.length; i++) {
            System.out.print(i + ": ");
            System.out.println(inputStrArr[i]);
        }
        for (int i = 0; i < inputStrArr.length; i++) {
            if (!inputStrArr[i].equals("")) {
                if (!camelCasedOutput.equals("")) {
                    String firstCharString = inputStrArr[i].substring(0,1);
                    inputStrArr[i] = inputStrArr[i].replaceFirst(firstCharString, firstCharString.toUpperCase());
                    if (firstCharString.matches("[0-9]")) {
                        System.out.println(ErrorConstants.INVALID_FORMAT);
                        throw new IllegalArgumentException();
                    }
                }
                camelCasedOutput = camelCasedOutput + inputStrArr[i];
            }
        }
        return camelCasedOutput;
    }
}
