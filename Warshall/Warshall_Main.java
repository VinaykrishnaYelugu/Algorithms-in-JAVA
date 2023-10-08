import java.util.Scanner;

class RnD
{
    public int n;
    public boolean[][] R;

    public void read()
    {
        try( Scanner sc = new Scanner(System.in) )
        {
            int i,j;
            System.out.print("Enter number of vertices :   ");
            n = sc.nextInt();
            R = new boolean[n][n];
            System.out.println("Enter Adjacency Matrix =>  ");
            for( i=0 ; i<n ; i++ )
                for( j=0 ; j<n ; j++ )
                    R[i][j] = sc.nextBoolean();
        }
    }

    public void display()
    {
        int i,j;
        System.out.println("Adjacency Matrix representing transitive closure=> ");
        for( i=0 ; i<n ; i++ )
        {
            for( j=0 ; j<n ; j++ )
               {
                  if( R[i][j]==true )
                     System.out.print(" T ");
                  else
                     System.out.print(" F ");
               }
            System.out.println();
        }
    }
}

class Warshall_class extends RnD
{
    public void Warshall_algo()
    {
        int i,j,k;
        for( k=0 ; k<n ; k++ )
            for( i=0 ; i<n ; i++ )
                for( j=0 ; j<n ; j++ )
                    R[i][j] = R[i][j] || ( R[i][k] && R[k][j] ) ;
    }
}

public class Warshall_Main
{
    public static void main( String args[] )
    {
        Warshall_class o = new Warshall_class();;
        o.read();
        o.display();
        o.Warshall_algo();
        o.display();
    }
}