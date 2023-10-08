import java.util.Scanner;

class RnD
{
   private int n;

   public int get_n()
   {
     return n;
   }

   public void set_n()
   {
      try( Scanner sc = new Scanner(System.in) )
      {
        System.out.print("Enter number of disks :  ");
        n = sc.nextInt();
      }
   }
}

class Tower_of_Hanoi
{
    private int[] S,D,I;
    private int ts,td,ti,nd,k=0;

    public void Represent(String source,String destination)
    {
        int[] stack1=S,stack2=S;
        int top1=-1,top2=-1;
        if( source.equals("Source") )
        {   stack1 = S; top1=ts;  }
        else if( source.equals("Destination") )
        {   stack1 = D; top1=td;  }
        else if( source.equals("Intermediate") )
        {   stack1 = I; top1=ti;  }

        if( destination.equals("Source") )
        {   stack2 = S; top2=ts;  }
        else if( destination.equals("Destination") )
        {   stack2 = D; top2=td;  }
        else if( destination.equals("Intermediate") )
        {   stack2 = I; top2=ti;  }

        stack2[++top2] = stack1[top1];
        stack1[top1--] = 0;

        if( source.equals("Source") )
        {   ts = top1;  }
        else if( source.equals("Destination") )
        {   td = top1 ;  }
        else if( source.equals("Intermediate") )
        {   ti = top1;  }

        if( destination.equals("Source") )
        {   ts = top2;  }
        else if( destination.equals("Destination") )
        {   td = top2;  }
        else if( destination.equals("Intermediate") )
        {   ti = top2;  }
    }

    public void display_towers()
    {
        int sv=-1,iv=-1,dv=-1;
        for( int i=nd ; i>=1 ; i-- )
        {
            sv = S[i];
            iv = I[i];
            dv = D[i];
            System.out.print("    ");
            if( sv==0 )
              System.out.print(" ");
            else
              System.out.print(sv);

            System.out.print("             ");
            if( iv==0 )
              System.out.print(" ");
            else
              System.out.print(iv);

            System.out.print("                ");
            if( dv==0 )
              System.out.print(" ");
            else
              System.out.print(dv);
            System.out.println();
        }
        System.out.println("  Source     Intermediate     Destination");
    }

    public void set_towers(RnD o)
    {
        nd = o.get_n();
        S = new int[(1+nd)];
        D = new int[(1+nd)];
        I = new int[(1+nd)];

        td = ti = 0;

        for( int i=1 ; i<=nd ; i++ )
          {
            S[i] = nd-i+1;
            D[i] = I[i] = 0;
          }
        ts = nd;
    }

    public void Move(int n,String s,String d,String i)
    {
       if( n==0 )
         return;
       Move((n-1),s,i,d); 
       System.out.println((++k)+") Move Disk no-"+n+" from "+s+" to "+d);
       Represent(s,d);
       display_towers();
       Move((n-1),i,d,s);
    }
}

public class Hanoi
{
    public static void main( String args[] )  
    {
        RnD o = new RnD();
        o.set_n();
        int n = o.get_n();
        if( n>=10 )
           { 
            System.out.println("Higher number of disks( i.e >=10) is harmful for PC performance !!\nExiting out of Program !!!"); 
            return;
           }
        Tower_of_Hanoi o1 = new Tower_of_Hanoi();
        o1.set_towers(o);
        o1.display_towers();
        o1.Move(n,"Source","Destination","Intermediate");
    }
}