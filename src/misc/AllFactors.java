package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllFactors {
    
    public AllFactors(){}
    
    public AllFactors(int n) {
        GetAllFactors(n);
    }
    
    public void GetAllFactors(int n) {
        GetAllFactorsInt(n, new ArrayList<Integer>(), n);
    }
    
    /*public void GetAllFactorsInt(int n, StringBuffer buffer, int parent) {
        if (n == 1) {
            if (buffer.length() == 0) {
                System.out.println("1");
            }else {
                for (int i = 0; i <=  buffer.length() -2 ; ++i) {
                    System.out.print(buffer.charAt(i) + " * ");
                }
                System.out.println(buffer.charAt(buffer.length() - 1));
                return;
            }
        }
        for (int i = 2; i <= Math.ceil(n/2.0) + 1 ; ++i) {
            if (n % i != 0) {
                continue;
            }
            
            if (i > parent) {
                continue;
            }
            
            buffer.append(i);
            GetAllFactorsInt(n / i, buffer, i);
            buffer.setLength(buffer.length() - 1);
            
        }
    }*/
    
    // Using list because stringbuffer will treat 10 as 1 and 0
    public void GetAllFactorsInt(int n, List<Integer> buffer, int parent) {
        if (n == 1) {
            if (buffer.size() == 0) {
                System.out.println("1");
            }else {
                for (int i = 0; i <=  buffer.size() -2 ; ++i) {
                    System.out.print(buffer.get(i) + " * ");
                }
                System.out.println(buffer.get(buffer.size() - 1));
                return;
            }
        }
        for (int i = 2; i <= Math.ceil(n/2.0) + 1 ; ++i) {
            if (n % i != 0) {
                continue;
            }
            
            // This line will stop generating redundant items..
            if (i > parent) {
                continue;
            }
            
            buffer.add(i);
            GetAllFactorsInt(n / i, buffer, i);
            buffer.remove(buffer.size() - 1);
            
        }
    }
    
    // Without repetition
    public void NchooseKInt(String str, StringBuffer buffer, int n, int k, int start) {
        if (buffer.length() == k) {
            System.out.println(buffer);
            return;
        }
        for (int i = start; i < str.length(); ++i) {
            // should be i > start
            if (i > 0 && str.charAt(i) == str.charAt(i - 1)) {
                continue;
            }
            buffer.append(str.charAt(i));
            NchooseKInt(str, buffer, str.length(), k,  i + 1);
            buffer.setLength(buffer.length() - 1);
        }
        
    }
    
    public void NchooseK(String str, int n, int k) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        str = new String(chars);
        NchooseKInt(str, new StringBuffer(), n, k, 0);
    }
    
    public static void main(String[] args) {
        //AllFactors af = new AllFactors(100);
        /* String str = "abbccaad";
        af.NchooseK(str, str.length(), 3); */
        AllFactors af = new AllFactors();
        String str = "142";
        af.NchooseK(str, str.length(), 3);
    }
}
