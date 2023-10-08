import java.util.Scanner;

class read
{
    public int m,n;
    public read()
    {
       try( Scanner sc = new Scanner(System.in) )
       {
         System.out.println("Enter two numbers =>");
         System.out.print("Number-1 ?  :  "); m = sc.nextInt();
         System.out.print("Number-2 ?  :  "); n = sc.nextInt();
       }
    }
}

class euclid extends read
{
    euclid()
    {
        int r;
        int m = super.m;  // super.m and super.n refrers to value of m,n in read constructor
        int n = super.n;  // m,n represents refers to values of local m,n ( these m,n values will change for further child classes)
        while( n!=0 )    
        {
            r = m%n ;
            m = n;       // Note: Here local m,n values are being changed ( over riding ) but super.m, super.n will remain same
            n = r;
        }
        System.out.println("GCD of "+super.m+" and "+super.n+" by Euclid method :  "+m);
    }
}

class consecutive_check extends euclid
{
    consecutive_check()
    {
        int m = super.m;  // super.m and super.n refrers to value of m,n in euclid constructor
        int n = super.n;  // m,n represents refers to values of local m,n       
        int min = (m<n) ? m : n;

        while( true )
        {
           if( m%min==0 )
            {
                if( n%min==0 )
                   break;
                else              // Note: Here local m,n values are not being modified 
                   min--;
            }
           else
            min--;
        }
        System.out.println("GCD of "+m+" and "+n+" by Consecutive check method :  "+min);
    }
}

class modified_euclid extends consecutive_check
{
    modified_euclid()
    {
        int temp; 
        int M=m;                //As m,n values in consecutive check are not modified, we can use directly
        int N=n;
        while( n>0 )
        {
            if( m<n )
             {  
                temp=m; 
                m=n; 
                n=temp;        //Note: Values of m,n are being changed ( over riding )
             }
            m = m-n;
        }
        System.out.println("GCD of "+M+" and "+N+" by Modiifed Euclid method :  "+m); 
                            // M,N stores original M,N values
    }
}

public class GCD_Main
{
    public static void main( String args[] )
    {
        modified_euclid o = new modified_euclid();
        o = null;
    }
}