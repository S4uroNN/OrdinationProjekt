package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev extends Ordination{
    private final ArrayList<Dosis> doser = new ArrayList<>();

    public DagligSkaev(LocalDate startDen, LocalDate slutDen) {
        super(startDen, slutDen);
    }

    @Override
    public double samletDosis() {
        return 0;
    }

    @Override
    public double doegnDosis() {
        return 0;
    }

    @Override
    public String getType() {
        return null;
    }


    public void opretDosis(LocalTime tid, double antal) {
        // TODO
    }
}
