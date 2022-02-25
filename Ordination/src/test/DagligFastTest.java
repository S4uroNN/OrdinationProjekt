package test;

import ordination.DagligFast;
import ordination.Dosis;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;


class DagligFastTest {

    DagligFast d = new DagligFast(LocalDate.of(2022, 02, 23),
            LocalDate.of(2022, 02, 24), 1, 1, 1, 1);

    DagligFast d2 = new DagligFast(LocalDate.of(2022, 02, 23),
            LocalDate.of(2022, 02, 24), 1, 2, 1, 0);

    @Test
    void samletDosis() {
        //Assert
        assertEquals(8, d.samletDosis());
        assertEquals(8, d2.samletDosis());
    }

    @Test
    void doegnDosis() {
        assertEquals(4, d.doegnDosis());
        assertEquals(4, d2.doegnDosis());
    }
}