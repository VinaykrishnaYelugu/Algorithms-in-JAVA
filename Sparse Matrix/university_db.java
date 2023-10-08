import java.util.Scanner;

class s_node
{
    String s_name;
    int sid;
    s_node s_next;
    c_node c;
}

class c_node
{
    String c_name;
    int cid;
    c_node c_next;
    s_node s;
}

class sparse_matrix
{
    s_node sf;

    Scanner sc = new Scanner(System.in);

    public void add_courses_to_student(s_node o)
    {
        
    }

    public void add_student(boolean flag)
    {
       s_node o = new s_node();
       System.out.print("Enter Student Id :  ");
       o.sid = sc.nextInt();
       System.out.print("Enter Student Name :  ");
       o.s_name = sc.nextLine();
       o.s_next = null;
       o.c = null;
       add_courses_to_student(o);
       if( flag==true )
       { sf = o; return;  }

       s_node temp=sf;
       while( temp.s_next != null )
       {    temp = temp.s_next;    }
       temp.s_next = o;

       return ;
    }

}

public class university_db
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        s_node sf=null;
        sparse_matrix o = new sparse_matrix();
        int choice;
        System.out.println("Entre choice : ");
        System.out.println("1. Add student\n2. Add course\n3. Display courses registered by student\n4. Display students registered in courses\n5. Exit");
        choice = sc.nextInt();
        boolean init_s=true;
        switch( choice )
        {
            case 1 : o.add_student(init_s); init_s=false; break;
            case 2 : break;
            case 3 : //display_student_data(sf); 
                     break;
            case 4 : break;
            case 5 : return;
        }

    }
}