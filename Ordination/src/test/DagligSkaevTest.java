package Test;

import ordination.DagligSkaev;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class DagligSkaevTest {
    DagligSkaev dagligSkaev = new DagligSkaev(LocalDate.of(2022,02,23),LocalDate.of(2022,2,24));

    @Test
    public void samletDosis() {
        dagligSkaev.opretDosis(LocalTime.of(12,30),5);
        dagligSkaev.opretDosis(LocalTime.of(13,30),1);
        assertEquals(12, dagligSkaev.samletDosis());
    }

    @Test
    public void doegnDosis() {
        dagligSkaev.opretDosis(LocalTime.of(12,30),5);
        dagligSkaev.opretDosis(LocalTime.of(13,30),1);
        assertEquals(6,dagligSkaev.doegnDosis());
    }
}