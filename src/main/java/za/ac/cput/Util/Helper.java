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
        email = email.trim();

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
       boolean isValidEmail = email.matches(emailRegex);
       if (!isValidEmail){
           System.out.println("Email is not valid");
       }
       return isValidEmail;
    }
    public static boolean isValidPhone(String phone) {
        if (phone == null || phone.isEmpty()){
            System.out.println("Phone is null or empty");
            return false;
        }

        phone = phone.trim();


        String phoneRegex = "^(\\+?[0-9]{1,3})?([0-9]{10})$";
        boolean isValidPhone = phone.matches(phoneRegex);
        if (!isValidPhone){
            System.out.println("Phone is not valid");

        }
        return isValidPhone;
    }
}
