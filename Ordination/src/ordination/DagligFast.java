package ordination;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligFast extends Ordination {
    private final Dosis[] dosis = new Dosis[4];

    public DagligFast(LocalDate startDen, LocalDate slutDen, double morgen, double middag, double aften, double nat) {
        super(startDen, slutDen);
        dosis[0] = new Dosis(LocalTime.of(8, 0), morgen);
        dosis[1] = new Dosis(LocalTime.of(12, 0), middag);
        dosis[2] = new Dosis(LocalTime.of(18, 0), aften);
        dosis[3] = new Dosis(LocalTime.of(23, 59), nat);

    }

    @Override
    /**
     *
     */
    public double samletDosis() {
        return doegnDosis() * antalDage();
    }

    @Override
    public double doegnDosis() {
        double døgndosis = 0;
        for (Dosis d : dosis) {
            døgndosis += d.getAntal();
        }
        return døgndosis;
    }

    @Override
    public String getType() {
        return "Daglig Fast";
    }

    public Dosis[] getDoser() {
        return dosis;
    }
}
