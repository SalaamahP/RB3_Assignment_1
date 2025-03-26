/*Helper.java
Helper class
Author: Salaamah Peck (230207170)
Date: 25 March 2025
*/

package za.ac.cput.Util;

public class Helper {
    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()){
            return false;
        }
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        return email.matches(emailRegex);
    }
    public static boolean isValidPhone(String phone) {
        if (phone == null || phone.isEmpty()){
            return false;
        }
        String phoneRegex = "^[0-9]{10}$";
        return phone.matches(phoneRegex);
    }
}
