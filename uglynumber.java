public class uglynumber {
    public int nthUglyNumber(int n) {
        int num2 = 0, num3 = 0, num5 = 0;
        int nextIndex = 1;
        int uglyNumber[] = new int[n];
        uglyNumber[0] = 1;
        while(nextIndex < n) {
            int min = (uglyNumber[num2]*2 < uglyNumber[num3]*3) ? uglyNumber[num2]*2 : uglyNumber[num3]*3;
            min = (min < uglyNumber[num5]*5) ? min : uglyNumber[num5]*5;
            uglyNumber[nextIndex] = min;
            while(uglyNumber[num2] * 2 <= min)
                num2 ++;
            while(uglyNumber[num3] * 3 <= min)
                num3 ++;
            while(uglyNumber[num5] * 5 <= min)
                num5 ++;
            nextIndex ++;
        }
        return uglyNumber[n-1];
    }
}
