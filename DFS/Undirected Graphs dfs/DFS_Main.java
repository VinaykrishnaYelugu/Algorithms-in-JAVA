import java.util.Scanner;

class DFS_Traversal
{
    private int count=0,cycle;

    public void dfs(int M[],int visit[],int n,int x,int parent)
    {
       if( visit[x]!=0 )
          return ;

       visit[x]=++count;
       System.out.println((x)+"-"+count+"  ");
       for( int i=0 ; i<n ; i++ )
       {
         if( M[n*x+i]==1 )
         {
            if( visit[i]==0 )
               dfs(M,visit,n,i,x);
            else if ( visit[i]!=1 && i!=parent )
               cycle=1;
         }
       }
    }

    public void DFS(int M[],int visit[],int n)
    {
       try( Scanner sc1 = new Scanner(System.in) )
       {
            int i,j=0,sv;
            System.out.print("Enter starting vertex( from 0 to + "+ (n-1) +"):  ");
            sv = sc1.nextInt();
            i=sv;
            do
            {
                if( visit[i]==0 )
                {
                    System.out.println("Component-"+(++j));
                    cycle=0;
                    dfs(M,visit,n,i,i);
                    if( i==sv )
                    {
                        if( count!=n )
                          System.out.println("Components of the graph are not connected");
                        else
                          System.out.println("Components of the graph are connected");
                    }

                    if( cycle==1 )
                          System.out.println("Component-"+j+" is Cyclic");
                    else
                        System.out.println("Component-"+j+" is Acyclic");
                }
                i = (i+1)%n;
            } while( i!=sv );
       }
    }
}

public class DFS_Main
{
    public static void main( String args[] )
    {
       try( Scanner sc = new Scanner(System.in) )
       {
            int n;
            System.out.print("Enter number of vertices :  "); 
            n = sc.nextInt();
            int[] M = new int[(n*n)];
            int[] visit = new int[n];

            System.out.print("Enter the adjacent matrix :  \n");
            for( int i=0 ; i<n ; i++ )
            {
                visit[i]=0;
                for( int j=0 ; j<n ; j++ )
                {
                    M[n*i+j] = sc.nextInt();
                }
            }

            DFS_Traversal o = new DFS_Traversal();
            o.DFS(M,visit,n);
       }
    }
}
