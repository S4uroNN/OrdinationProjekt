package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {
    private final ArrayList<Dosis> doser = new ArrayList<>();

    public DagligSkaev(LocalDate startDen,
                       LocalDate slutDen) {
        super(startDen, slutDen);



    }

    @Override
    public double samletDosis() {
       return doegnDosis()*antalDage();
    }

    @Override
    public double doegnDosis() {
        double døgndosis = 0;
        for(Dosis d : doser){
            døgndosis += d.getAntal();

        }
        return døgndosis;
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
