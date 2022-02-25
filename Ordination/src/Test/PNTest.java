package test;

import ordination.PN;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class PNTest {

    @Test
    public void givDosis() {
        PN pn = new PN(LocalDate.of(2022,2,23),LocalDate.of(2022,2,26),2);
        //Act
        boolean actualResult = pn.givDosis(LocalDate.of(2022,2,24));
        //Assert
        assertEquals(true,actualResult);

        //Act
        boolean actualResult2 = pn.givDosis(LocalDate.of(2022,2,27));
        //Assert
        assertEquals(false,actualResult2);




    }

    @Test
    public void doegnDosis() {
    }
}