// CS108 HW1 -- String static methods
import java.util.*;
import java.lang.*;
public class StringCode {

    /**
     * Given a string, returns the length of the largest run.
     * A a run is a series of adajcent chars that are the same.
     * @param str
     * @return max run length
     */
    public static int maxRun(String str) {
        int cnt = 1;
        int max=1;
        for(int i=0;i<str.length();i++) {
            for(int j=i+1;j<str.length()-1;j++) {
                if(str.charAt(i)==str.charAt(j)) {
                    cnt++;
                }
                else{
                    max=Math.max(max,cnt);
                    cnt=1;
                }
            }
        }
        max = Math.max(max, cnt);
        return max;
    }


    /**
     * Given a string, for each digit in the original string,
     * replaces the digit with that many occurrences of the character
     * following. So the string "a3tx2z" yields "attttxzzz".
     * @param str
     * @return blown up string
     */
    public static String blowup(String str) {
        StringBuilder res = new StringBuilder();
        for(int i=0;i<str.length();i++) {
            char cur = str.charAt(i);
            if(Character.isDigit(cur)) {
                if(i+1 < str.length()) {
                    int n = Character.getNumericValue(str.charAt(i));
                    char next = str.charAt(i+1);
                    for(int j=0;j<n;j++)
                    {
                        res=res.append(next);
                    }
                }
            }
            else {
                res.append(cur);
            }
        }
        return res.toString();
    }

    /**
     * Given 2 strings, consider all the substrings within them
     * of length len. Returns true if there are any such substrings
     * which appear in both strings.
     * Compute this in linear time using a HashSet. Len will be 1 or more.
     */

    public static boolean compare (String a, String b) {
        if(a.length() != b.length()) { return false; }
        for(int i=0;i<a.length();i++) {
            if(a.charAt(i)!=b.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public static boolean stringIntersect(String a, String b, int len) {
        int lena= a.length();
        int lenb= b.length();
        if(lena<len || lenb<len) { return false; };
        int leng = Math.min(lena,lenb);
        for(int i=0;i <leng-len+1;i++) {
            if (compare(a.substring(i, i + len), b.substring(i, i + len))) {
                return true;
            }
        }
       return false;
    }
}
