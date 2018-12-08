package problems;

import org.junit.Assert;
import org.junit.Test;

public class Problem92Test {

    @Test
    public void testSquareAndSumDigits_ExpectedNextNumberInTheChain() {
        Assert.assertEquals(32, Problem92.squareAndSumDigits(44));
        Assert.assertEquals(13, Problem92.squareAndSumDigits(32));
    }

}