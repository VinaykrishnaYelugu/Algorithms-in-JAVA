import java.util.Scanner;

class BFS_Class
{
    public void bfs(int x,read_display o)
    {
       if( o.visit[x]==true )
          return;
       
       o.visit[x]=true;
       o.count++;
       for( int i=0 ; i<o.n ; i++ )
       {
           if( o.M[o.n*x+i]==1 )
           {
                if( o.visit[i]==false && o.Q_visit[i]==false )
                {
                    o.Q[++o.r] = i;
                    o.Q_visit[i] = true;
                }
                else if( o.visit[i]==true && o.parent[x]!=i )
                    o.cycle = true ;
           }
       }
       System.out.print(" "+x+" ");
       o.f++;
       if( o.f>o.r )
         { o.f=0; o.r=-1; return; }
       bfs(o.Q[o.f],o);
    }

    public void BFS(read_display o)
    {
       int i=o.sv,k=0;
       o.count = 0;
       o.f = 0;
       o.r = -1;
       do
       {
         if( o.visit[i]==false )
         {
            System.out.println("Component-"+(++k));
            o.cycle = false;
            o.parent[i] = i;
            o.Q[++o.r] = i;
            o.Q_visit[i] = true;
            bfs(o.Q[o.f],o);
            if( i==o.sv )
            {
                if( o.count==o.n )
                   System.out.println("\nGraph is Connected !!");
                else
                   System.out.println("\nGraph is Disconnected !!");
            }
            if( o.cycle==true )
              System.out.println("Component-"+k+" is Cyclic");
            else
              System.out.println("Component-"+k+" is Acyclic");
         }
         i = (i+1)%o.n;
       }while( i!=o.sv );
    }
}

class read_display
{
    public int n,sv,count;
    public boolean cycle;
    public int[] M,parent;
    public boolean[] Q_visit,visit;
    public int[] Q;
    public int f,r;

    public void read()
    {
       int i,j;
       try( Scanner sc = new Scanner(System.in) )
       {
          System.out.print("Enter number of vertices :   ");
          n = sc.nextInt();
          M = new int[(n*n)];
          visit = new boolean[n];
          Q_visit = new boolean[n];
          parent = new int[n];
          Q = new int[n];
          System.out.println("Enter Adjacency Matrix=>");
          for( i=0 ; i<n ; i++ )
          {
            visit[i] = false;
            Q_visit[i] = false;
            parent[i] = -1;
            Q[i] = -1;
            for( j=0 ; j<n ; j++ )
            {
                M[n*i+j] = sc.nextInt();
            }
          }
          System.out.print("Enter starting vertex : ");
          sv = sc.nextInt();
       }
    }

    public void display()
    {
        int i,j;
        System.out.println("Vertex no.  Visit   Parent");
        for( i=0 ; i<n ; i++ )
            System.out.println("  "+i+"     "+visit[i]+"       "+parent[i]);
        System.out.println("\nAdjacency matrix=> ");
        for( i=0 ; i<n ; i++ )
        {
            for( j=0 ; j<n ; j++ )
              System.out.print(" "+M[n*i+j]+" ");
            System.out.println();
        }
    }
}

public class BFS_Main
{
    public static void main( String args[] )
    {
       read_display o = new read_display();
       o.read();
       o.display();

       BFS_Class o1 = new BFS_Class();
       o1.BFS(o);
       o.display();
    }
}