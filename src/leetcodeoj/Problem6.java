package leetcodeoj;
import  org.junit.Assert;
import org.junit.Test;

public class Problem6 {
   public String convert(String s, int numRows) {
      StringBuffer result = new StringBuffer();
      StringBuffer[] buffers = new StringBuffer[numRows];
      for (int i = 0; i < buffers.length; ++i) {
         buffers[i] = new StringBuffer();
      }
      boolean shrink = false;
      int start = 0, end = numRows - 1;
      for (int i = 0; i < s.length(); ++i) {
         buffers[start].append(s.charAt(i));
         if (start == end) {
            if (shrink) {
               start = 0;
               end = numRows - 1;
               shrink = !shrink;
            } else {
               if (numRows > 2) {
                  start = numRows - 2;
                  end = 1;
                  shrink = !shrink;
               } else {
                  start = 0;
                  end = numRows - 1;
               }
            }
         } else {
            start = shrink ? start - 1 : start + 1;
         }
      }
      for (int i = 0; i < buffers.length; ++i) {
         result.append(buffers[i]);
      }
      return result.toString();
   }
    // Without using extra memory: http://tech-wonderland.net/blog/leetcode-zigzag-conversion.html
    public String convert1(String s, int nRows) {
        int i = 0;
        StringBuffer[] buffers = new StringBuffer[nRows];
        for (i = 0; i < nRows; ++i) {
            buffers[i] = new StringBuffer();
        }
        int j = 0;
        int steps = nRows - 2;
        for (i = 0; i < s.length(); ++i) {
            if (j < nRows) {
                buffers[j].append(s.charAt(i));
                ++j;
                if (j == nRows) {
                    steps = nRows - 2;
                    if(steps <= 0) {
                        j = 0;
                    }
                }
            }else if (steps > 0) {
                buffers[steps].append(s.charAt(i));
                --steps;
                if (steps == 0) {
                    j = 0;
                }
            }
        }
        
        StringBuffer result = new StringBuffer();
        for (i = 0; i < buffers.length; ++i) {
            result.append(buffers[i].toString());
        }
        
        return result.toString();
    }
    
    @Test
    public void convertTest() {
        Problem6 p6 = new Problem6();
        Assert.assertEquals("PAHNAPLSIIGYIR", p6.convert("PAYPALISHIRING", 3));
        Assert.assertEquals("PYAIHRNAPLSIIG", p6.convert("PAYPALISHIRING", 2));
        Assert.assertEquals("PINALSIGYAHRPI", p6.convert("PAYPALISHIRING", 4));
    }
}
