package cs3310ec;

import java.util.*;

public class Floyd 
{
    private int D[][], P[][];
    private ArrayList<String> path;
    
    public Floyd(int W[][])
    {
        D = new int[W.length][W.length];
        P = new int[W.length][W.length];
        path = new ArrayList();
        
         // copy W to D
        for (int i = 0; i < D.length; i++)
        {
            D[i] = W[i].clone();
        }
        
        // initialize matrix P
        for(int i = 0; i < P.length; i++)
        {
            for(int j = 0; j < P.length; j++)
            {
                P[i][j] = 0;
            }
        }
    }
        
    public void FloydsAlgorithm() 
    {        
        for(int k = 0; k < D.length; k++)
        {
            for(int i = 0; i < D.length; i++)
            {
                for(int j = 0; j < D.length; j++)
                {
                    if((D[i][k] + D[k][j]) < (D[i][j]))
                    {
                        P[i][j] = k + 1;
                        D[i][j] = D[i][k] + D[k][j];
                    }
                }
            }
        }
    }
    
    public void printD()
    {
        printMatrix(D);
    }
    
    public void printP()
    {
        printMatrix(P);
    }
    
    public void printMatrix(int matrix[][])
    {
        System.out.printf("%3s", "");
        for(int i = 0; i < matrix.length; i++)
        {
            System.out.printf("%5d", i + 1);
        }
        
        System.out.print("\n  ");
        for(int i = 0; i < matrix.length; i++)
        {
            System.out.print("-----");
        }
        System.out.println("----");
        
        for(int i = 0; i < matrix.length; i++)
        {
            System.out.print(i + 1 + " |");
            for(int j = 0; j < matrix.length; j++)
            {
                if(matrix[i][j] == 99)
                {
                    System.out.printf("%5s", "∞");
                }
                else
                {
                    System.out.printf("%5d", matrix[i][j]);
                }
            }
            System.out.println();
        }
    }
    
    public void findPath(int q, int r)
    {
        if(P[q][r] != 0)
        {
            findPath(q, P[q][r] - 1);
            findPath(P[q][r] - 1, r);
        }
        else
        {
            path.add("<v" + Integer.toString(q + 1) + ",v" + Integer.toString(r + 1) + ">");
        }
    }
    
    public void printPath()
    {
        System.out.print("Path: { ");
        for(int i = 0; i < path.size(); i++)
        {
            if(i == path.size() - 1)
            {
                System.out.println(path.get(i) + " }");
            }
            else
            {
                System.out.print(path.get(i) + " , ");
            }
        }
    }
    
    public void clearPath() 
    {
        path.clear();
    }
    
    public void printWeight(int q, int r)
    {
        System.out.println("Weight: " + D[q][r]);
    }
}
