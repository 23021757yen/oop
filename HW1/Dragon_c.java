import java.util.*;
import java.lang.*;

public class Dragon_c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(dragon(n));
    }

    public static String dragon(int n)
    {
        if(n==0) return "F";
        else return dragon(n-1) +"L"+ nguoc(dao(dragon(n-1)));
    }

    public static String nguoc ( String s)
    {
        char[] a= s.toCharArray();
        String res="";
        for(int i=a.length-1;i>=0;i--)
        {
            res=res + a[i];
        }
        return res;
    }

    public static String dao( String s)
    {
        char[] a= s.toCharArray();
        for(int i=0;i<a.length;i++)
        {
            if(a[i]=='L')
            {
                a[i]='R';
            }
            else if(a[i]=='R')
            {
                a[i]='L';
            }
        }
        return new String(a);
    }
}