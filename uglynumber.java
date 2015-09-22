public class uglynumber {
    public int nthUglyNumber(int n) {
        int num2 = 0, num3 = 0, num5 = 0;
        int nextIndex = 1;
        int uglyNumber[] = new int[n];
        uglyNumber[0] = 1;
        while(nextIndex < n) {
            int min = (num2 < num3) ? num2 : num3;
            min = (min < num5) ? min : num5;
            uglyNumber[nextIndex] = min;
            while(uglyNumber[num2] * 2 <= min)
                num2 ++;
            while(uglyNumber[num3] * 3 <= min)
                num3 ++;
            while(uglyNumber[num5] * 5 <= min)
                num5 ++;
            nextIndex ++;
        }
    }
}
