import java.util.Scanner;

class data
{
    private double[] A;
    private double x;
    private int n;
    Scanner sc = new Scanner(System.in);

    public int get_n()
    { return n; }

    public void set_x()
    {
        System.out.print("Enter x value in P(x) :  ");
        x = sc.nextDouble();
    }

    public double get_x()
    {  return x; }

    public void set_polynomial()
    {  
        System.out.print("Enter the maximum degree of polynomial :  ");
        n = sc.nextInt();
        A = new double[(n+1)];
        for( int i=n ; i>=0 ; i-- )
        { 
            System.out.print("Enter co-efficient of A"+i+" :  ");  
            A[i] = sc.nextInt();
        }
    }

    public double[] get_polynomial()
    {   return A;    }
}

class solve
{
    public solve(data o)
    {
        int i;
        double[] A = o.get_polynomial();
        double sum,x=o.get_x(),X;
        int n = o.get_n();
        sum = 0;
        X = 1;
        for( i=0 ; i<=n ; i++ )
        {
            if( i>0 )
              X*=x;
            sum+=(A[i]*X);
        }

        System.out.println("\n P("+x+") = "+sum);
    }
}

public class polynomial_solve
{
    public static void main( String args[] )
    {
       data o = new data();
       o.set_polynomial();
       o.set_x();
       solve o1 = new solve(o);
    }
}