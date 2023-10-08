import java.util.Scanner;

class DFS_class
{
    public void indegree_func(RD o)
    {
       int i,j;
       int n=o.nv;
       for( i=0 ; i<n ; i++ )
          for( j=0 ; j<n ; j++ )
                if( o.M[j][i]==1 )
                   o.indegree[i]++;
    }

    public int vertex(RD o,int u)
    {
        int i=u;
        do
        {
          if( o.indegree[i]==0 && o.visit[i]==false )
              return i;
          i = (i+1)%o.nv;
        }while( i!=u );
        return -1;
    }

    public void  Source_removal(RD o,int SV)
    {
        int v=SV,i;
        System.out.print("Topological order : ");
        do
        {
           v = vertex(o,v);
           if( v==-1 )
               break;
           o.count++;
           o.visit[v] = true;
           System.out.print(" "+v+" ");
           for( i=0 ; i<o.nv ; i++ )
           {
              if( o.M[v][i]==1 )
                {
                    o.indegree[i]--;
                    o.M[v][i] = 0;
                }
           }
        }while( o.count!=o.nv );
        if( o.count!=o.nv)
           System.out.println("\nTopological Sorting not possible !!");
    } 
}

class RD
{
    public int nv,sv,count;
    public int[][] M;
    public int[] indegree;
    public boolean[] visit;

    public void read()
    {
        try( Scanner sc = new Scanner(System.in) )
        {
            int i,j;
            System.out.print("Enter number of vertices :  ");
            nv = sc.nextInt();
            System.out.println("Enter Adjacency Matrix :  ");
            M = new int[nv][nv];
            visit = new boolean[nv];
            indegree = new int[nv];
            for( i=0 ; i<nv ; i++ )
            {
                visit[i] = false;
                indegree[i] = 0;
                for( j=0 ; j<nv ; j++ )
                    M[i][j] = sc.nextInt();
            }
            System.out.print("Enter starting vertex :  ");
            sv = sc.nextInt();
        }
    }

    public void display()
    {
        int i,j;
        System.out.println("\nAdjacency Matrix => ");
        for( i=0 ; i<nv ; i++ )
        {
            for( j=0 ; j<nv ; j++ )
                System.out.print(M[i][j]+"  ");
            System.out.println();
        }
        System.out.println("Indegree"+"  "+"visit");
        for( i=0 ; i<nv ; i++ )
           System.out.println("  "+indegree[i]+"       "+visit[i]);
   }
}

public class TS_SR_1_0 
{
    public static void main( String args[] )
    {
       RD o = new RD();
       o.read();
       o.display();
       DFS_class o1 = new DFS_class();
       o1.indegree_func(o);
       o1.Source_removal(o,o.sv);
    }
}
