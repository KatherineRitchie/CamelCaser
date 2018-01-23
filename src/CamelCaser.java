import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.*;

public class CamelCaser {

    /**
     * Camel Cases a valid input
     * @param inputString String
     * @return String camelCasedOutput
     * @throws IllegalArgumentException invalid input
     */
    public static String camelCase(String inputString) throws IllegalArgumentException {

        //checks for null input
        if (inputString == null) {
            System.out.println("Null Input");
            throw new IllegalArgumentException();
        }

        String camelCasedOutput = "";
        inputString = inputString.toLowerCase();
        String[] inputStrArr = inputString.split("\\s+");

        //assembles output
        for (int i = 0; i < inputStrArr.length; i++) {
            if (!inputStrArr[i].equals("")) {

                //checks if input is exclusively alphanumerical
                if (!inputStrArr[i].matches("[a-zA-Z0-9]+")) {
                    System.out.println(ErrorConstants.INVALID_CHARACTER);
                    throw new IllegalArgumentException();
                }

                String firstCharString = inputStrArr[i].substring(0,1);
                //checks that word does not start with number
                if (firstCharString.matches("[0-9]")) {
                    System.out.println(ErrorConstants.INVALID_FORMAT);
                    throw new IllegalArgumentException();
                }

                //modifies second word to begin with a capital letter
                if (!camelCasedOutput.equals("")) {
                    inputStrArr[i] = inputStrArr[i].replaceFirst(firstCharString, firstCharString.toUpperCase());
                }

                camelCasedOutput = camelCasedOutput + inputStrArr[i];
            }
        }
        return camelCasedOutput;
    }
}
