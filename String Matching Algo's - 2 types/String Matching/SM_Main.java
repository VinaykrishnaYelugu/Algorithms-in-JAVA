import java.util.*;

class read
{
    public String text,pattern;

    public read()
    {
        try( Scanner sc = new Scanner(System.in) )
        {
           System.out.print("Enter text :  ");
           text = sc.nextLine();
           System.out.print("Enter pattern :  ");
           pattern = sc.nextLine();
        }
    }
}

class String_Match_class
{
     public int string_matching(read o)
     {
        int tl=o.text.length(),pl=o.pattern.length();
        int i,j;
        for( i=0 ; i<(tl-pl+1) ; i++ )
        {
            for( j=0 ; j<pl ; j++ )
            {
                if( o.pattern.charAt(j)!=o.text.charAt(i+j) )
                   break;
            }
            if( j==pl )
                return i;
        }
        return -1;
     }
}

public class SM_Main
{
    public static void main( String[] args)
    {
       read o = new read();

       String_Match_class o1 = new String_Match_class();
       int position=o1.string_matching(o);
       if( position==-1 )
          System.out.println("pattern ''"+o.pattern+"'' Not found in ''"+o.text+"'' !!");
       else
          System.out.println("pattern ''"+o.pattern+"'' found in ''"+o.text+"'' !! position="+(1+position));
    }
}