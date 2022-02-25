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
        PN pn = new PN(LocalDate.of(2022,2,23),LocalDate.of(2022,2,26),2);
        pn.givDosis(LocalDate.of(2022,2,24));
        pn.givDosis(LocalDate.of(2022,2,24));
        pn.givDosis(LocalDate.of(2022,2,24));
        //Act
        double acutalResult = pn.doegnDosis();
        //Assert
        assertEquals(6,acutalResult,0.0001);

        PN pn2 = new PN(LocalDate.of(2022,2,23),LocalDate.of(2022,2,26),2);
        pn2.givDosis(LocalDate.of(2022,2,24));
        pn2.givDosis(LocalDate.of(2022,2,24));
        pn2.givDosis(LocalDate.of(2022,2,25));
        //Act
        double actualResult2 = pn2.doegnDosis();
        //Assert
        assertEquals(3,actualResult2,0.0001);

        PN pn3 = new PN(LocalDate.of(2022,2,23),LocalDate.of(2022,2,26),2);
        pn3.givDosis(LocalDate.of(2022,2,24));
        pn3.givDosis(LocalDate.of(2022,2,26));
        //Act
        double actualResult3 = pn3.doegnDosis();
        //Assert
        assertEquals(1.3334,actualResult3,0.0001);

        //THIS IS HTE REAL ONe





    }
}