package leetcodeoj;
import org.junit.Test;
import org.junit.Assert;

public class Problem8 { 
    public String getValidString(String str) {
        int positives = 0, neagtives = 0;
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == '+') {
                positives++;
            }else if (str.charAt(i) == '-') {
                neagtives++;
            } else {
                if ((str.charAt(i) < '0') || (str.charAt(i) > '9')) {
                    break;
                }
            }
            if (positives + neagtives > 1) {
                if (buffer.length() == 2) {
                    buffer.setLength(0);
                }
                break;
            }
            buffer.append(str.charAt(i));
        }
        return buffer.toString();
    }

    public int atoi(String str) {
        str = getValidString(str.trim());
        if (str.length() == 0) {
            return 0;
        }
        boolean negative = false;
        if (str.charAt(0) == '-') {
            negative = true;
            str = str.substring(1);
        } else if (str.charAt(0) == '+') {
            str = str.substring(1);
        }
        long p = 1;
        long sum = 0;
        for (int i = str.length() - 1; i >= 0; --i) {
            sum += ((int) (str.charAt(i) - '0')) * p;
            p *= 10;
            long tmp = sum;
            if (negative && ((-1) * sum) <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }else if (tmp >= Integer.MAX_VALUE && !negative) {
                return Integer.MAX_VALUE;
            }
        }
        
        if (negative) {
            sum = (-1) * sum;
        }
        
        return (int) sum;
    }
    
    @Test
    public void atoiTest() {
        Problem8 p8 = new Problem8();
        Assert.assertEquals(128, p8.atoi(" 128 "));
        Assert.assertEquals(0, p8.atoi("   "));
        Assert.assertEquals(Integer.MAX_VALUE, p8.atoi("9999999999"));
        Assert.assertEquals(-152, p8.atoi(" -152  "));
        Assert.assertEquals(1, p8.atoi(" +1  "));
        Assert.assertEquals(0, p8.atoi(" +-231  "));
        Assert.assertEquals(123456, p8.atoi(" 123456a  "));
        Assert.assertEquals(-12, p8.atoi("  -0012a42"));
        Assert.assertEquals(-12, p8.atoi("  -0012+-a42"));
        Assert.assertEquals(Integer.MIN_VALUE, p8.atoi("-2147483648"));
        Assert.assertEquals(Integer.MIN_VALUE, p8.atoi("-2147483649"));
        Assert.assertEquals(Integer.MAX_VALUE, p8.atoi("9223372036854775809"));
        Assert.assertEquals(Integer.MIN_VALUE, p8.atoi("-5569223372036854775809"));
        Assert.assertEquals(Integer.MIN_VALUE, p8.atoi(Integer.toString(Integer.MIN_VALUE)));
        Assert.assertEquals(Integer.MAX_VALUE, p8.atoi(Integer.toString(Integer.MAX_VALUE)));
        Assert.assertEquals(-2147483647, p8.atoi("-2147483647"));
    }
}
