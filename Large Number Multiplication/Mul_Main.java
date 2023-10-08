import java.util.Scanner;

class data
{
    private int n1,n2;
    Scanner sc = new Scanner(   System.in );

    public void set_nums()
    {
        System.out.print("Enter number-1 :   ");
        n1 = sc.nextInt();
        System.out.print("Enter number-2 :  ");
        n2 = sc.nextInt();
    }

    public int get_num1()
    {  return n1;  }

    public int get_num2()
    {  return n2;  }
}

class Mul_Class
{
    public int number_of_digits(int n)
    {
       int nd=0;
       while( n!=0 )
       {  n/=10; nd++;  }
       return nd;
    }
    public int large_num_multiplication(int n1,int n2)
    {
       int nd1=0,nd2=0,num1=n1,num2=n2;
       nd1 = number_of_digits(n1);
       nd2 = number_of_digits(n2);
       int a0,a1,b0,b1,c0,c1,c2;
       int N=nd1/2;
       a0 = a1 = b0 = b1 =0;
       c0 = a0*b0;
       c2 = a1*b1;
       c1 = (a0+a1)*(b0+b1)-c0-c2;


       if( nd1==1 || nd2==2 )
       {
           a0 = num1%10; 
           num1/=10;
           a1 = num1%10; 
           b0 = num2%10; 
           num2/=10;
           b1 = num2%10;
           return ( )
       }
       else
         return large_num_multiplication(n1,n2);
    }

    public void Multiplication( data o )
    {
       int n1 = o.get_num1();
       int n2 = o.get_num2();
       large_num_multiplication(n1,n2);
    }
}

public class Mul_Main
{
    public static void main( String args[] )
    {

    }
}