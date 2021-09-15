import org.junit.Assert;
import org.junit.Test;
import zadatak1.Zadatak1;
import zadatak1.exception.InvalidWordException;

public class TestZadatak1 {

    @Test(expected = InvalidWordException.class)
    public void testNull() throws InvalidWordException {
        Zadatak1.isItEven(null);
    }

    @Test
    public void testWord(){
        try {
            Assert.assertTrue(Zadatak1.isItEven("anan"));
        } catch (InvalidWordException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testWordFalse(){
        try {
            Assert.assertFalse(Zadatak1.isItEven("ana"));
        } catch (InvalidWordException e) {
            e.printStackTrace();
        }
    }

}
