import java.util.Scanner;

class RnD
{
    private int n,k;

    public void read()
    {
        try( Scanner sc = new Scanner( System.in ) )
        {
            System.out.print("Enter ''n'' :  ");  n = sc.nextInt();
            System.out.print("Enter ''k'' :  "); k = sc.nextInt();
        }
    }

    public void display(double nck)
    {
       System.out.println("nck = "+nck);
    }

    public int get_n()
    {
        return n;
    }
 
    public int get_k()
    {
        return k;
    }

}

class compute
{
    private double[][] T;

    public double compute_table(RnD o)
    {
        int n = o.get_n();
        int k = o.get_k();
        T = new double[(n+1)][(k+1)];
        for( int i=0 ; i<=n ; i++ )
         for( int j=0 ; j<=k ; j++ )
            {
                if( j==0 || j==i )
                   T[i][j] = 1;
                else
                   T[i][j] = 0;
            }
        C(n,k);
        for( int i=0 ; i<=n ; i++ )
         {
            for( int j=0 ; j<=k ; j++ )
                System.out.print(" "+T[i][j]+" ");
            System.out.println();
         }
        return  T[n][k];
    }

    public void C(int n,int k)
    {
        if( T[n][k]==0 )
        {
                C((n-1),k);
                C((n-1),(k-1));
                T[n][k] = T[n-1][k]+T[n-1][k-1] ;
                System.out.println(" n="+n+" k="+k+" nck="+T[n][k]);
        }
    }
}

public class nck_Main
{
    public static void main( String args[] )
    {
         RnD o = new RnD();
         o.read();
         compute o1 = new compute();
         o.display(o1.compute_table(o));
    }
}