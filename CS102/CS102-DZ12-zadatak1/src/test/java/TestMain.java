import org.junit.Assert;
import org.junit.Test;

public class TestMain {

    @Test(expected = NullPointerException.class)
    public void testException(){
        Main.isItRefleksiv(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBadArgumentExcetion(){
        Integer niz[][]=new Integer[5][4];
        Main.isItRefleksiv(niz);
    }

    @Test
    public void testIfItWorks(){
        Integer niz[][]=new Integer[2][2];
        niz[0][0]=0;
        niz[0][1]=0;
        niz[1][0]=0;
        niz[1][1]=0;
        Assert.assertTrue(Main.isItRefleksiv(niz));

    }
}
