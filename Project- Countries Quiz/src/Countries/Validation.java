package Countries;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
/*
 * Validation.java
 * <pre>
 *   Project     <b>CountriesGUI Database</b>
 *   Description This class providing all of the validation methods that are nedded
 *   Platform    Java(TM) SE Runtime Environment 1.8.0_151
 *   System      Windows 10 version 
 *   Course      <i>CS 142 Winter 2018</i>
 * </pre>
 *
 * @author:	Sanyapoom Sirijirakarn and Quynh Duc Vu
 * @version: 	1.00
 */
public class Validation 
{
    /*
     * Method: isDouble(String fieldValue)
     * Description: This is a class to check double
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem fieldValue
     * @return mat.matches()
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public static boolean isDouble(String fieldValue) {
        Pattern pat = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher mat = pat.matcher(fieldValue);
        return mat.matches();
    }
    /*
     * Method: isDouble(String fieldValue, double lower, double upper)
     * Description: This is a class to check double
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem fieldValue, lower, upper
     * @return result
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public static boolean isDouble(String fieldValue, double lower, double upper) {
        boolean result = true;
        Pattern pat = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher mat = pat.matcher(fieldValue);
        if (mat.matches()) {
            try {
                double num = Double.parseDouble(fieldValue);
                if (num < lower || num > upper) {
                    result = false;
                }
            } catch (NumberFormatException exp) {
                result = false;
            }
        } else {
            result = false;
        }
        return result;
    }
    /*
     * Method: isInteger(String fieldValue)
     * Description: This is a class to check integer
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem fieldValue
     * @return mat.matches()
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public static boolean isInteger(String fieldValue) {
        Pattern pat = Pattern.compile("\\d+");
        Matcher mat = pat.matcher(fieldValue);
        return mat.matches();
    }
    /*
     * Method: isEmpty(JTextField fieldValue)
     * Description: This is a class to check empty
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem fieldValue
     * @return true/false
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public static boolean isEmpty(JTextField fieldValue) {
        String input = fieldValue.getText();
        if (input.length() <= 0 || input.equals("")) {
            return true;
        } else {
            return false;
        }
    }
    /*
     * Method: isValidName(String input)
     * Description: This is a class to check name
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem input
     * @return result
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */
    public static boolean isValidName(String input) {
        final short MAX_LENGTH = 30;
        final short MIN_LENGTH = 2;
        boolean result = true;
        Pattern pat = Pattern.compile("[a-zA-Z ]+");
        Matcher mat = pat.matcher(input);
        
        if (!mat.matches() || input.length() > MAX_LENGTH || input.length() < MIN_LENGTH) {
            result = false;
        }
        return result;
    }
}
