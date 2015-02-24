package leetcodeoj;
import org.junit.Test;
import org.junit.Assert;

public class Problem14 {
    // Is there any better solution than this?
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = "";
        for (int i = strs[0].length(); i >= 0; --i) {
            prefix = strs[0].substring(0, i);
            int k = 1;
            for (; k < strs.length; ++k) {
                if (!strs[k].startsWith(prefix)) {
                    break;
                }
            }
            if (k == strs.length) {
                break;
            }
        }
        return prefix;
    }
    
    @Test
    public void longestCommonPrefixTest() {
        Problem14 p14 = new Problem14();
        Assert.assertEquals("", p14.longestCommonPrefix(
                new String[] {"", "b" }));
        Assert.assertEquals("ami", p14.longestCommonPrefix(
                new String[] {"amit", "amit1", "ami" }));
        Assert.assertEquals("", p14.longestCommonPrefix(
                new String[] {"amit", "amit1", "x" }));
        Assert.assertEquals("a", p14.longestCommonPrefix(
                new String[] {"amit", "amit1", "a" }));
        Assert.assertEquals("", p14.longestCommonPrefix(
                new String[] {}));
        Assert.assertEquals("abcded", p14.longestCommonPrefix(
                new String[] {"abcded"}));
        Assert.assertEquals("", p14.longestCommonPrefix(
                new String[] {"a", "b", "c", "d"}));
    }
}
