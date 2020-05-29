import java.util.Scanner;
class TicTacToe
{
    static char A[][]=new char[3][3];
    static Scanner sc=new Scanner(System.in);
    static String s1,s2;
    public static void main(String args[])
    {
        
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                A[i][j]='-';
            }
        }
        
        System.out.println("*****TIC TAC TOE*****");
        System.out.println("NOTE: Player1 enters 'X' and Player2 enters 'O'\n      Rows and Columns are numbered from 1 to 3\n");
        System.out.println("Player 1- Enter your name:");
        s1=sc.nextLine();
        System.out.println("Player 2- Enter your name:");
        s2=sc.nextLine();
        boolean result;
        display();
        for(int i=1;i<=9;i++)
        {
            if(i%2==0)
            {
                result=accept(s2);
                display();
                if(result==true)
                {
                    System.out.println("~~~ Congo... "+s2+" WINS!!! ~~~");
                    break;
                }
            }
                else
                {
                    result=accept(s1);
                    display();
                    if(result==true)
                    {
                        System.out.println("~~~ Congratulations... "+s1+" WINS!!! ~~~");
                        break;
                    }
                }
                if(i==9)System.out.println("~~~NO PLAYER WINS!~~~");
            }
    }    
    static boolean accept(String s)
        {
            int r,c;
            System.out.print(s+" - Enter your row and column number: ");
            r=sc.nextInt(); r--;
            c=sc.nextInt(); c--;
            while(Character.compare(A[r][c],'X') == 0 || Character.compare(A[r][c],'O') == 0)
            {
                System.out.println((r+1)+" "+(c+1)+" position is already taken!\n");
                System.out.print(s+" - Enter your row and column number: ");
                r=sc.nextInt(); r--;
                c=sc.nextInt(); c--;
            }
            if(s.equals(s1))
            {
                A[r][c]='X';
                return check(s1,r,c);
            }
            else
            {
                A[r][c]='O';
                return check(s2,r,c);
            }
        }
    static boolean check(String s, int a, int b)
        {
            boolean c1, c2, c3=false, c4=false;
            int ctr=0;
            //row-wise checking
            for(int i=0;i<3;i++)
            {
                if(s.equals(s1))
                {
                    if(A[a][i]=='X')ctr++;
                }
                else
                {
                    if(A[a][i]=='O')ctr++;
                }
            }
            if(ctr==3)
            c1=true;
            else
            c1=false;
           
            //column-wise
            ctr=0;
            for(int i=0;i<3;i++)
            {
                if(s.equals(s1))
                {
                    if(A[i][b]=='X')ctr++;
                }
                else
                {
                    if(A[i][b]=='O')ctr++;
                }
            }
            if(ctr==3)
            c2=true;
            else
            c2=false;
            
            //left diagonal
            ctr=0;
            if(a==b)
            {
                for(int i=0;i<3;i++)
                {
                    if(s.equals(s1))
                    {
                        if(A[i][i]=='X')ctr++;
                    }
                    else
                    {
                        if(A[i][i]=='O')ctr++;
                    }
                }
                if(ctr==3)
                c3=true;
                
            }
            //right diagonal
            ctr=0;
            if(a+b==2)
            {
                for(int i=0;i<3;i++)
                {
                    if(s.equals(s1))
                    {
                        if(A[i][2-i]=='X')ctr++;
                    }
                    else
                    {
                        if(A[i][2-i]=='O')ctr++;
                    }
                }
                if(ctr==3)
                c4=true;
               
            }
            //returning winner, if any
            if(c1==true||c2==true||c3==true||c4==true)
            return true;
            else
            return false;
        }
    static void display()
        {
            System.out.println();
            for(int i=0;i<3;i++)
            {
              for(int j=0;j<3;j++)
              {
                System.out.print(A[i][j]+" ");
              }
              System.out.println();
            }
            System.out.println();
        }
}
