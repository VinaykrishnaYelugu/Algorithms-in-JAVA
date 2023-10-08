import java.util.Scanner;

class DFS_class
{
    public static int nv;
    public static boolean cycle;

    public static void dfs(int cv)
    {
        if( read_display.visit[cv]==true )
            return;

        read_display.visit[cv] = true;
        read_display.dfs_visit[cv] = true;
        int i,nv=read_display.n;
        for( i=0 ; i<nv ; i++ )
        {
            if( read_display.M[nv*cv+i]==1 )
            {
                if( read_display.visit[i]==false )
                dfs(i);
                else if( (read_display.visit[i]==true)&&(read_display.dfs_visit[i]==true) )
                cycle=true;
            }
        }
        read_display.stack[++(read_display.top)] = cv;
        read_display.dfs_visit[cv] = false;
    }

    public static void DFS()
    {
        int i;
        nv = read_display.n ;
        i = read_display.sv;
        do
        {
            if( read_display.visit[i]==false )
            {
                cycle=false; 
                dfs(i); 
                if( cycle==true )
                {
                    System.out.println("\nTopological Sorting not possible !!");
                    break;
                }
            }
            i = (i+1)%(nv);
        }while( i!=read_display.sv );
    }
}

class read_display
{
     public static int n,i,j,sv,top=-1 ;
     public static int [] M,stack;
     public static boolean[] visit,dfs_visit;

     public static void read_elements()
     {
        try( Scanner sc = new Scanner(System.in) )
        {
            System.out.print("Enter number of vertices :  ");
            n = sc.nextInt();
            M = new int[n*n];
            stack = new int[n];
            visit = new boolean[n];
            dfs_visit = new boolean[n];
            System.out.println("Enter Adjacency Matrix :  ");
            for( i=0 ; i<n ; i++ )
            {
                visit[i] = false ;
                dfs_visit[i] = false;
                stack[i] = -1;
                for( j=0 ; j<n ; j++ )
                    M[n*i+j] = sc.nextInt();
            }
            System.out.print("Enter starting vertex :  ");
            sv = sc.nextInt();
            sc.close();
        }
     }

     public void display_elements()
     {
        System.out.println("Adjacency Matrix=> ");
        for( int i=0 ; i<n ; i++ )
        {
            for( int j=0 ; j<n ; j++ )
                System.out.print(" "+M[n*i+j]+" ");
            System.out.println();
        }
     }
}

public class TS_DFS_1_0 
{
    public static void main( String args[] )
    {
      try{
            read_display.read_elements();
            read_display o1 = new read_display();
            o1.display_elements();
            DFS_class.DFS();
      }catch( Exception e) { System.out.println(e); }

      System.out.print("Topological order :  ");
      while( read_display.top>=0 )
        { System.out.print(" "+read_display.stack[read_display.top--]+" "); }
    }
}
