import java.util.Scanner;

class RnD
{
    public int n;
    public int[][] R;

    public void read()
    {
        try( Scanner sc = new Scanner(System.in) )
        {
            int i,j;
            System.out.print("Enter number of vertices :   ");
            n = sc.nextInt();
            R = new int[n][n];
            System.out.println("Enter Adjacency Matrix =>  ");
            for( i=0 ; i<n ; i++ )
                for( j=0 ; j<n ; j++ )
                    R[i][j] = sc.nextInt();
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
                     System.out.print(" "+R[i][j]+" ");
               }
            System.out.println();
        }
    }

    public int Min( int a,int b )
    {
        return ( (a<b) ? a : b ) ;
    }
}

class Floyds_class extends RnD
{
    public void Floyds_algo()
    {
        int i,j,k;
        for( k=0 ; k<n ; k++ )
            for( i=0 ; i<n ; i++ )
                for( j=0 ; j<n ; j++ )
                    R[i][j] = Min( R[i][j] , (R[i][k]+R[k][j]) ) ;
    }
}

public class Floyds_Main
{
    public static void main( String args[] )
    {
        Floyds_class o = new Floyds_class();;
        o.read();
        o.display();
        o.Floyds_algo();
        o.display();
    }
}