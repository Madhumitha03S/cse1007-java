
/**
A single Toblerone bar has a sequence of 9 triangles.
Develop a Java program such that the customer can order for 
Toblerone bars with customized sides and angles of the triangle. 
The customer has to input the length of the three sides and 
the three angles of a triangle he prefers. 
However the bars can be made only if the lengths are in the range of 3 to 10cms and 
the sum of the three angles is 180. 
The 3 lengths and 3 angles specified by a customer will be applied on all the 9 triangles of a single bar.
The customer must also input the number of bars (quantity) he wants to order. 
Based on cutomization and quantity order display the price. 
*/

/**
 * 1. If length of all three sides are same and all three angles are same,
 * then cost of a triangle is: Rs. 10
 * 2. If any 2 sides have same length and any one of the angle is 90,
 * then the cost of a triangle is: Rs. 15
 * 3. If any 2 sides have same length and any one of the angle is obtuse (>90),
 * then the cost of a triangle is: Rs. 20
 * 4. If any 2 sides have same length and all the three angles are acute (<90),
 * then the cost of a triangle is: Rs. 25
 * 5. If all the 3 sides have different lengths and any one of the angle is 90,
 * then the cost of a triangle is: Rs. 30
 * 6. If all the 3 sides have different lengths and any one of the angle is
 * obtuse (>90),
 * then the cost of a triangle is: Rs. 35
 * 7. If all the 3 sides have different lengths and all the three angles are
 * acute (<90),
 * then the cost of a triangle is: Rs. 40
 * If the sum of the angles is not 180, display an error as: incorrectangle
 * If the length of any of the 3 sides is not in the range of 3-10 (3 and 10
 * inclusive),
 * display an error as: incorrectside
 */

import java.util.*;

public class Toblerone {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int side[] = new int[3];
        int angle[] = new int[3];
        int angleSum = 0;
        boolean make = true;
        // Accepting the values of the sides and angles
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter side " + i + ": ");
            side[i] = scan.nextInt();
            // Checking the range of side value
            if (side[i] < 3 || side[i] > 10) {
                System.out.print("incorrectside");
                make = false;
                break;
            }
            System.out.print("Enter angle " + i + ": ");
            angle[i] = scan.nextInt();
            angleSum += angle[i];
        }

        int numBars;
        int triangleCost = 10;
        int barPrice;
        int totalPrice;

        if (make == true) {

            // Checking the angle value
            if (angleSum != 180) {
                System.out.println("incorrectangle");
                make = false;
            }
            // Calculating the cost of a triangle
            if (side[0] == side[1] || side[1] == side[2] || side[2] == side[0]) {
                if (side[0] == side[1] && side[1] == side[2]) {
                    if (angle[0] == angle[1] && angle[1] == angle[2]) {
                        triangleCost = 10;
                    }
                }
                if (angle[0] == 90 || angle[1] == 90 || angle[2] == 90) {
                    triangleCost = 15;
                } else if (angle[0] > 90 || angle[1] > 90 || angle[2] > 90) {
                    triangleCost = 20;
                } else if (angle[0] < 90 && angle[1] < 90 && angle[2] < 90) {
                    triangleCost = 25;
                }
            } else {
                if (angle[0] == 90 || angle[1] == 90 || angle[2] == 90) {
                    triangleCost = 30;
                } else if (angle[0] > 90 || angle[1] > 90 || angle[2] > 90) {
                    triangleCost = 35;
                } else if (angle[0] < 90 && angle[1] < 90 && angle[2] < 90) {
                    triangleCost = 40;
                }
            }

            // Calculating the total price
            System.out.print("Number of bars: ");
            numBars = scan.nextInt();
            barPrice = 9 * triangleCost;
            totalPrice = numBars * barPrice;
            System.out.println("\nTotal price: " + totalPrice);
        }
        scan.close();
    }
}
