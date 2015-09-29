public class Solution {
    public String addBinary(String a, String b) {
        if(a.length() == 0)   return b;
        if(b.length() == 0)   return a;
        int sum = 0;
        int carry = 0;
        
        StringBuilder stringbuilder = new StringBuilder();
        
        int ai = a.length()-1, bi = b.length()-1;
        while(ai >= 0 || bi >= 0) {
            int x = ai >= 0 ? a.charAt(ai)-'0' : 0;
            int y = bi >= 0 ? b.charAt(bi)-'0' : 0;
            sum = x^y^carry;
            carry = x + y + carry > 1 ? 1 : 0;
            stringbuilder.insert(0, sum);
            ai--;
            bi--;
        }
        if(carry == 1)
            stringbuilder.insert(0,1);
        return stringbuilder.toString();
    }
}
