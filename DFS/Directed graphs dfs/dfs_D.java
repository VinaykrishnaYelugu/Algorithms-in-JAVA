// DFS Traversal and cycle detection in Directed Graph

import java.util.Scanner;

class dfs_class
{
    public void dfs(RnD o,int x)
    {
        if( o.visit[x]==true )
          return;
        
        System.out.print(" "+x+" ");
        o.visit[x] = true;
        o.c_array[x] = true;
        for( int i=0 ; i<o.n ; i++ )
        {
             if( o.M[x][i]==1 )
             {
                if( o.visit[i]==false )
                   dfs(o,i);
                else if( o.visit[i]==true && o.c_array[i]==true )                                                                                                                                            
                   o.cycle = true;
             }
        }
        o.c_array[x] = false;
    }

    public void DFS(RnD o)
    {
        int i=o.sv,k=0;
        o.count=0;
        do
        {
            if( o.visit[i]==false )
            {
                System.out.println("Component-"+(++k));
                o.cycle = false;
                dfs(o,i);
                if( i==o.sv )
                {
                    if( o.count!=o.n )
                      System.out.print("\nGraph is Disconnected!!");
                    else
                      System.out.print("\nGraph is Connected!!");
                }
                if( o.cycle==true )
                   System.out.print("\nComponent-"+k+" is Cyclic");
                else
                   System.out.print("\nComponent-"+k+" is Acyclic");
            }
            i = (i+1)%o.n;
        }while( i!=o.sv );
    }
}

class RnD 
{
    public int n,sv,count;
    public int[][] M;
    public boolean[] visit,c_array;
    public boolean cycle;

    public void read()
    {
        try ( Scanner sc = new Scanner(System.in) )
        {
           int i,j;
           System.out.print("Enter number of elements :  ");
           n = sc.nextInt();
           M = new int[n][n];
           visit = new boolean[n];
           c_array = new boolean[n];
           System.out.print("Enter Adjacency Matrix =>\n");
           for( i=0 ; i<n ; i++ )
           {
             visit[i] = false;
             c_array[i] = false;
             for( j=0 ; j<n ; j++ )
                 M[i][j] = sc.nextInt();
           }
           System.out.print("Enter starting vertex :  ");
           sv = sc.nextInt();
        }
    }

    public void display()
    {
        int i,j;
        System.out.println("Vertex    Visit     c_array");
        for( i=0 ; i<n ; i++ )
           System.out.println("  "+i+"         "+visit[i]+"       "+c_array[i]);
        System.out.println("\nAdjacenct Matrix=>\n");
        for( i=0 ; i<n ; i++ )
        {
            for( j=0 ; j<n ; j++ )
                System.out.print(" "+M[i][j]+" ");
            System.out.println();
        }
    }
}

public class dfs_D
{
    public static void main( String args[] )
    {
       RnD o = new RnD();
       o.read();
       o.display();

       dfs_class o1 = new dfs_class();
       o1.DFS(o);
      // o.display();
    }
}