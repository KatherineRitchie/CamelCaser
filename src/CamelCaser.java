import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CamelCaser {
    public static String camelCase(String inputString){
        /*if (inputString.contains([^A-Z][^0-9]))) {

            throw new IllegalArgumentException();
            System.out.println(ErrorConstants.INVALID_CHARACTER);
        }*/
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
                    /*if (firstCharString.charAt(0) == ([0-9])) {
                        System.out.println(ErrorConstants.INVALID_FORMAT);
                        throw new IllegalArgumentException();
                    }*/
                }
                camelCasedOutput = camelCasedOutput + inputStrArr[i];
            }
        }
        return camelCasedOutput;
    }
}
