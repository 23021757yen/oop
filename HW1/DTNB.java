import java.util.*;
import java.lang.*;
public class DTNB{
    public static void main(String [] args)
    {
        Scanner scan= new Scanner(System.in);
        int N = scan.nextInt();//so buoc
        int total= scan.nextInt();// so lan thu nghiem
        double M_average= 0.0;// tong cac lan thu nghiem
        for(int i=1;i<=total;i++)
        {
            M_average += Ran_distance(N);
        }
        double average= M_average / total;
        System.out.println(average);
    }

    public static double Ran_distance(int n)
    {
        double x=0.0;
        double y=0.0;

        Random rand = new Random();
        for(int i=1;i<=n;i++)
        {
            int direction= rand.nextInt(4);
            switch (direction)
            {
                case 0://dong
                    x+=1.0;
                    break;
                case 1://tay
                    x-=1.0;
                    break;
                case 2://nam
                    y-=1.0;
                    break;
                case 3:
                    y+=1.0;
                    break;
            }
        }
        return Math.sqrt(x*x + y*y);
    }
}