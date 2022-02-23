package ordination;

import com.sun.webkit.LoadListenerClient;

import java.time.LocalDate;
import java.time.LocalTime;

public class DagligFast extends Ordination {
    private final Dosis[] dosis = new Dosis[4];

    public DagligFast(LocalDate startDen, LocalDate slutDen, double morgen, double middag, double aften, double nat) {
        super(startDen, slutDen);
        dosis[0] = new Dosis(LocalTime.of(8, 0), morgen);
        dosis[1] = new Dosis(LocalTime.of(12, 0), middag);
        dosis[2] = new Dosis(LocalTime.of(18, 0), aften);
        dosis[3] = new Dosis(LocalTime.of(0, 0), nat);

    }

    @Override
    public double samletDosis() {
        double samletdosis = 0;
        for (Dosis d : dosis) {
            samletdosis += d.getAntal();
        }
        return samletdosis;
    }

    @Override
    public double doegnDosis() {
        double samletdosis = 0;
        double døgndosis = 0;

        if(antalDage()<1){
            for (int i = 0; i <= antalDage(); i++) {
                samletdosis += samletDosis();
            }
            døgndosis = samletdosis/antalDage();
        }else{
            døgndosis = samletdosis;
        }

        return døgndosis;
    }

    @Override
    public String getType() {
        return "Daglig Fast";
    }

}
