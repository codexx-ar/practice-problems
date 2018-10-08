import org.junit.Test;

public class CheckMonotonicSeries {

    @Test
    public void testMonotonicSeries() {
        assert isMonotonicSeries(new int[]{0,0,0,1,2,3,4});
        assert isMonotonicSeries(new int[]{9,8,7,5,4,4,4,-1,-3});
        assert(!isMonotonicSeries(new int[]{9,8,7,5,4,4,4,-1,2,3}));
    }

    private static boolean isMonotonicSeries(int[] series) {
        if(series.length < 1) return false;
        if(series.length < 2) return true;
        int prev = series[0];
        int pos = 0;
        boolean isIncr = false;
        boolean foundRythm = false;
        while(++pos < series.length && !foundRythm) {
            if(series[pos] == prev) continue;
            if(series[pos] > prev) isIncr = true;
            foundRythm = true;
            prev = series[pos];
        }
        boolean isSeries = true;
        for(int i = pos; i < series.length; i++) {
            if(isIncr && series[i] < prev)    {isSeries = false; break;}
            else if(!isIncr && series[i] > prev)   {isSeries = false; break;}
            prev = series[i];
        }
        return isSeries;
    }
}

