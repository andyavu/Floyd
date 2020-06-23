package cs3310ec;

import java.util.*;

public class CS3310EC 
{
    public static void main(String[] args)
    {
        // 99 = infinity in this case
        // matrix from lecture
        int W[][] = {{ 0,  1, 99,  1,  5}, 
                     { 9,  0,  3,  2, 99}, 
                     {99, 99,  0,  4, 99}, 
                     {99, 99,  2,  0,  3}, 
                     { 3, 99, 99, 99,  0}};
        
        // in-class matrix
//        int W[][] = {{ 0,  1,  5, 10},
//                     { 5,  0,  2,  6},
//                     { 4,  9,  0 , 5},
//                     { 7,  2,  1,  0}};
        
        Floyd f = new Floyd(W);
        
        // print matrix W
        System.out.println("Matrix 'W'");
        f.printMatrix(W);
        
        // Floyd's Algorithm
        f.FloydsAlgorithm();
        
        // print matrix D
        System.out.println("\nMatrix 'D'");
        f.printD();
        
        // print matrix P
        System.out.println("\nMatrix 'P'");
        f.printP();
        
        Scanner userInput = new Scanner(System.in);
        
        while(true)
        {
            System.out.print("\nEnter 'start' vertex: ");
            int start = userInput.nextInt();
            System.out.print("Enter 'end' vertex: ");
            int end = userInput.nextInt();
            
            f.clearPath();
            f.findPath(start - 1, end - 1);
            f.printPath();
            f.printWeight(start - 1, end - 1);
        }
    }
}
