
/**
 * On a certain day at an ATM of a bank there was an attempt of capturing
 * 3-digit PIN using a mirror set on the top of the wall by some intruder. All
 * the customers who used the ATM that particular day were asked to change their
 * PIN. The change of PIN requires three hours of time. The police wanted to
 * stop misuse of the PIN immediately and hence wanted to find PIN at high risk. 
 * The police assume that the PIN which is an exact mirror image of the
 * original PIN is at high risk. Help the police using a python program 
 * to get the PIN from user and display "RISKY" if PIN is
 * an exact mirror image and "NOT RISKY" if not an exact mirror image. Note: The
 * PIN will be the same as its mirror image if the digits are 0, 1 or 8 and the
 * PIN is a palindrome.
 */

import java.util.*;

public class PinPalindrome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the pin: ");
        String pin = scan.nextLine();
        int count = 0;
        if (pin.length() == 3) {
            for (int i = 0; i < pin.length(); i++) {
                if (pin.charAt(i) == '0' || pin.charAt(i) == '1' || pin.charAt(i) == '8') {
                    count++;
                }
            }
            if (count == pin.length()) {
                if (pin.charAt(0) == pin.charAt(2)) {
                    System.out.println("RISKY");
                } else {
                    System.out.println("NOT RISKY");
                }
            } else {
                System.out.println("NOT RISKY");
            }
        } else {
            System.out.println("Enter a 3-digit pin number.");
        }
        scan.close();
    }
}
