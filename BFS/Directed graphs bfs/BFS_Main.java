// BFS Traversal and cyclic nature for directed graphs

import java.util.Scanner;

class BFS_class
{
    public void bfs(int x,RnD o)
    {
       if( o.visit[x]==true )
          return;

       o.visit[x] = true;
       o.c_array[x] = true;
       o.count++;
       for( int i=0 ; i<o.n ; i++ )
       {
          if( o.M[x][i]==1 )
          {
             if( o.visit[i]==false && o.Q_visit[i]==false)
             {
                 o.Q[++o.r] = i;
                 o.Q_visit[i] = true;
             }
             else if( o.visit[i]==true && o.c_array[i]==true )
                 o.cycle = true;
          }
       }
       System.out.print(" "+x+" ");
       o.f++;
       if( o.f>o.r )
         { o.f=0; o.r=-1; }
       else 
          bfs(o.Q[o.f],o);
       o.c_array[x] = false;
    }

    public void BFS(RnD o)
    {
        int i=o.sv,k=0;
        o.count=0;
        o.f=0;
        o.r=-1;
        do
        {
            if( o.visit[i]==false )
            {
                System.out.println("\nComponent-"+(++k));
                o.cycle = false;
                o.Q[++o.r] = i;
                o.Q_visit[i] = true;
                bfs(o.Q[o.f],o);
                if( i==o.sv )
                {
                    if( o.count==o.n )
                       System.out.println("\nGraph is connected!!\n");
                    else
                       System.out.println("\nGraph is Disconnected\n");
                }
                if( o.cycle==true )
                   System.out.println("Component-"+k+" is Cyclic");
                else
                   System.out.println("Component-"+k+" is Acyclic");
            }
            i = (i+1)%o.n ;
        }while( i!=o.sv );
    }
}

class RnD
{
    public int n,sv,count,f,r;
    public int[][] M;
    public int[] parent,Q;
    public boolean cycle;
    public boolean[] visit,Q_visit,c_array;

    public void read()
    {
        int i,j;
        try( Scanner sc = new Scanner(System.in) )
        {
            System.out.print("Enter number of vertices :  ");
            n = sc.nextInt();
            M = new int[n][n];
            parent = new int[n];
            Q = new int[n];
            visit = new boolean[n];
            Q_visit = new boolean[n];
            c_array = new boolean[n];
            System.out.print("Enter Adjacency Matrix =>\n");
            for( i=0 ; i<n ; i++ )
            {
                parent[i] = -1;
                Q[i] = -1;
                visit[i] = false;
                c_array[i] = false;
                for( j=0 ; j<n ; j++ )
                    M[i][j] = sc.nextInt();
            }
            System.out.println("Enter starting vertex : ");
            sv = sc.nextInt();
        }
    }

    public void display()
    {
        int i,j;
        System.out.println("Vertex    visit      c_array");
        for( i=0 ; i<n ; i++ )
            System.out.println("  "+i+"         "+visit[i]+"           "+c_array[i]);
        System.out.println("\nAdjacency Matrix =>");
        for( i=0 ; i<n ; i++ )
        {
            for( j=0 ; j<n ; j++ )
               System.out.print(" "+M[i][j]+" ");
            System.out.println();
        }
    }
}

public class BFS_Main
{
    public static void main( String args[] )
    {
       RnD o = new RnD();
       o.read();
       o.display();

       BFS_class o1 = new BFS_class();
       o1.BFS(o);
       o.display();
    }
}