/*Helper.java
Helper class
Author: Salaamah Peck (230207170)
Date: 25 March 2025
*/

package za.ac.cput.Util;

public class Helper {
    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()){
            System.out.println("Email is null or empty");
            return false;
        }


        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
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
