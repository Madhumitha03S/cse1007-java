
/**A new species of flower was discovered. The petal arrangement in the flower follows a pattern. 
 * In every layer there are red and orange petals. 
 * It has 2 red and 3 orange petals always in the inner layer. 
 * In ith layer the number of red petals will be equal to the number of orange petals in i-1th layer 
 * and number of orange petals will be equal to total of red and orange petals of the i-1th layer. 
 * For a given layer, find the number of petals. */

import java.util.*;

public class PetalPattern {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int red[] = new int[10];
        int orange[] = new int[10];
        int total[] = new int[10];
        red[0] = 2;
        orange[0] = 3;
        for (int i = 1; i < 10; i++) {
            red[i] = orange[i - 1];
            orange[i] = red[i - 1] + orange[i - 1];
            total[i] = red[i] + orange[i];
        }
        System.out.print("Enter the layer number: ");
        int layerNum = scan.nextInt();
        System.out.println("Number of petals: " + total[layerNum - 1]);
        scan.close();
    }
}
