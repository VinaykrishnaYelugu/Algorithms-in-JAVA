// Dijkstra's Algo works for both directed and directed graphs

import java.util.Scanner;

class RnD
{
    public int n,sv,r;
    public double weight;
    public boolean[] visit;
    public int[] parent,Q;
    public double[][] M;
    public double[] distance;

    public void read()
    {
        int i,j,v1=-1,v2=-1;
        String str;
        try( Scanner sc = new Scanner(System.in) )
        {
           System.out.print("Enter number of vertices :  ");
           n = sc.nextInt();
           M = new double[n][n];
           visit = new boolean[n];
           parent = new int[n] ;
           Q = new int[n];
           distance = new double[n];

           System.out.print("Enter cost matrix :  ");
           for( i=0 ; i<n ; i++ )
           {
              visit[i] = false;
              parent[i] = -1;
              Q[i] = -1;
              distance[i] = Double.MAX_VALUE;
              for( j=0 ; j<n ; j++ )
                    M[i][j] = -1;
           }
           System.out.println("Enter all the edges");
           while( true )
           {
               str = null;
               System.out.println("Enter ''stop'' to stop adding vertices or else ''yes'' ");
               str = sc.next();
               if( str.equals("stop") )
                  break;
               System.out.println("Enter the 2 vertices forming an edge");
               System.out.println("Vertex-1 ?  :    "); v1 = sc.nextInt();
               System.out.println("Vertex-2 ?  :    "); v2 = sc.nextInt();
               System.out.println("Weight   ?  :    "); weight = sc.nextDouble();
               add_edge(v1,v2,weight);
           }
           System.out.println("Enter starting vertex :  ");
           sv = sc.nextInt();
        }
    }

    public void display()
    {
        int i,j;
        System.out.println("\nMatrix =>");
        for( i=0 ; i<n ; i++ )
        {
            for( j=0 ; j<n ; j++ )
               System.out.print(" "+M[i][j]+" ");
            System.out.println();
        }
        System.out.println("Distance  Parents  Visit ");
        for( i=0 ; i<n ; i++ )
           System.out.println(distance[i]+"     "+parent[i]+"      "+visit[i]);
    }

    public void add_edge(int v1,int v2,double weight)
    {
        M[v1][v2] = weight;
    }
}

class Dijkstras_class
{
     public void display_Q(RnD o)
     {
         System.out.println("\nQueue =>");
         for( int i=0 ; i<=o.r ; i++ )
           System.out.print(" "+o.Q[i]+" ");
         System.out.println();
     }

     public void vertex(RnD o,int w)
     {
        int v=w;
        do
        {
            if( o.visit[v]==false )
            {
                o.Q[++o.r]=v; 
                return;
            }
            v = (v+1)%o.n;
        }while( v!=w );
     }

     public void Dijkstras_algo(RnD o)
     {
         int v,u;
         double x;
         o.r = -1;
         v = o.sv;

        while( true )
        {
            if( o.r==o.n-1 )
               break;
            vertex(o,v);
            v = o.Q[o.r];
            if( o.r==0 )
               { System.out.println("$"); o.distance[v]=0; }
            System.out.println("~~~~~~~~~~~~~~"+v+"~~~~~~~~~~~~~~~~~");
            for( u=0 ; u<o.n ; u++ ) // finding all adjacent unvisited vertices to 'v' 
            {
                if( o.M[v][u]!=-1 && o.visit[u]==false )
                {
                    x = o.distance[v]+o.M[v][u];
                    if( x<o.distance[u] )
                    {
                        o.distance[u] = x;
                        o.parent[u] = v;
                    }
                }  
            }
            o.visit[v] = true;
            display_Q(o);
            o.display();
        }
     }

     public void MST(RnD o)
     {
        int u,u1;
        double sum=0;
        System.out.println("Minimum Spanning Tree =>");
        for( u=0 ; u<o.n ; u++ )
         { 
            u1 = o.Q[u];
            if( o.parent[u1]==-1 )
               continue;
            sum += o.M[o.parent[u1]][u1];
            System.out.println("("+o.parent[u1]+","+u1+") =>"+o.M[o.parent[u1]][u1]);
         }
         System.out.println("Minimum cost =>"+sum);
     }
}

class Dijkstras_Main
{
    public static void main( String args[] )
    {
        RnD o = new RnD();
        o.read();
        o.display();
        Dijkstras_class o1 = new Dijkstras_class();
        o1.Dijkstras_algo(o);
        o1.MST(o);
    }
}
