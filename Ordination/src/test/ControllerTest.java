package test;

import com.sun.source.tree.AssertTree;
import controller.Controller;
import ordination.Laegemiddel;
import ordination.Patient;
import org.junit.Before;
import org.junit.Test;
import storage.Storage;

import javax.naming.CompositeName;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {
    Controller controller;

    @Before
    public void setUp() throws Exception {
        controller = Controller.getTestController();
    }

    @Test
    public void ordinationPNAnvendt() {


    }

    @Test
    public void anbefaletDosisPrDoegn() {
        Patient patient24 = new Patient("11007593","Alin", 24);
        Patient patient25 = new Patient("11007593","Alin", 25);
        Patient patient121 = new Patient("11007593","Alin", 121);

        Laegemiddel laegemiddel = new Laegemiddel("Mad",0.1,0.15,0.16,"stk");

        assertEquals(2.4,Controller.getTestController().anbefaletDosisPrDoegn(patient24,laegemiddel),0.1);
        //arrange
        assertEquals(3.75,Controller.getTestController().anbefaletDosisPrDoegn(patient25,laegemiddel),0.01);
        //arrange
        assertEquals(19.36,Controller.getTestController().anbefaletDosisPrDoegn(patient121,laegemiddel),0.01);
    }

    @Test
    public void antalOrdinationerPrVægtPrLægemiddel() {
        Patient patient1 = controller.opretPatient("121256-0512", "Jane Jensen", 63.4);
        Patient patient2 = controller.opretPatient("070985-1153", "Finn Madsen", 83.2);
        Patient patient3 = controller.opretPatient("050972-1233", "Hans Jørgensen", 89.4);
        Patient patient4 = controller.opretPatient("011064-1522", "Ulla Nielsen", 59.9);
        Patient patient5 = controller.opretPatient("090149-2529", "Ib Hansen", 87.7);

        Laegemiddel laegemiddel1  = controller.opretLaegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        Laegemiddel laegemiddel2  = controller.opretLaegemiddel("Paracetamol", 1, 1.5, 2, "Ml");
        Laegemiddel laegemiddel3  = controller.opretLaegemiddel("Fucidin", 0.025, 0.025, 0.025, "Styk");
        Laegemiddel laegemiddel4  = controller.opretLaegemiddel("Methotrexat", 0.01, 0.015, 0.02, "Styk");
        LocalTime[] kl = {LocalTime.of(12, 0), LocalTime.of(12, 40),
                LocalTime.of(16, 0), LocalTime.of(18, 45)};
        double[] an = {0.5, 1, 2.5, 3};
        controller.opretDagligSkaevOrdination(LocalDate.of(2022,02,23),LocalDate.of(2022,02,24),patient1,laegemiddel1,kl,an);

        assertEquals(1,controller.antalOrdinationerPrVægtPrLægemiddel(25,90,laegemiddel1),0.01);
        assertEquals(1,controller.antalOrdinationerPrVægtPrLægemiddel(0,65,laegemiddel1),0.01);
        assertEquals(0,controller.antalOrdinationerPrVægtPrLægemiddel(80,120,laegemiddel1),0.01);
    }
}