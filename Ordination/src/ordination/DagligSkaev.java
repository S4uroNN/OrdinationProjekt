package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {
    private final ArrayList<Dosis> doser = new ArrayList<>();

    public DagligSkaev(LocalDate startDen,
                       LocalDate slutDen, Patient patient, Laegemiddel laegemiddel,
                       LocalTime[] klokkeSlet, double[] antalEnheder) {
        super(startDen, slutDen);
    }

    @Override
    public double samletDosis() {
        double tæller = 0;
        for (Dosis d : doser) {
            tæller += d.getAntal();
        }
        return tæller;
    }

    @Override
    public double doegnDosis() {
        double samletdosis = 0;
        for (int i = 0; i <= antalDage(); i++) {
            samletdosis += samletDosis();
        }
        return samletdosis / antalDage();
    }

    @Override
    public String getType() {
        return "Daglig Skæv";
    }

    public ArrayList<Dosis> getDoser() {
        return new ArrayList<>(doser);
    }

    public Dosis opretDosis(LocalTime tid, double antal) {
        Dosis dosis = new Dosis(tid, antal);
        doser.add(dosis);
        return dosis;
    }
}
