package RubiksCube;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        String in;
        int order;
        Scanner sc = new Scanner(System.in);
        RubiksCube rc = new RubiksCube();
    
        do {
        System.out.println("input a combination of elements in the Rubiks Cube group to find their order. Enter a non valid input to leave: ");
        in = sc.next();
        order = rc.orderOf(in);
        System.out.println(order);
        } while(order != -1);
        
        
    }
}
