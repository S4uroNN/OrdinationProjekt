package ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class PN extends Ordination {
    private double antalEnheder;
    private ArrayList<LocalDate> givetDosis = new ArrayList<>();

    public PN(LocalDate startDen, LocalDate slutDen, double antalEnheder){
        super(startDen, slutDen);
        this.antalEnheder = antalEnheder;
    }


    /**
     * Registrerer at der er givet en dosis paa dagen givesDen
     * Returnerer true hvis givesDen er inden for ordinationens gyldighedsperiode og datoen huskes
     * Retrurner false ellers og datoen givesDen ignoreres
     * @param givesDen
     * @return
     */
    public boolean givDosis(LocalDate givesDen) {
            if ((givesDen.isEqual(getStartDen()) || givesDen.isAfter(getStartDen())) &&
                    (givesDen.isEqual(getSlutDen()) || givesDen.isBefore(getSlutDen()))) {
                givetDosis.add(givesDen);
                return true;
            }
        return false;
    }

    public double doegnDosis() {
        double doegnDosis = 0;
        doegnDosis = samletDosis()/ (ChronoUnit.DAYS.between(givetDosis.get(0),givetDosis.get(givetDosis.size()-1))+1);
        return doegnDosis;
    }

    @Override
    public String getType() {
        return "PN";
    }


    public double samletDosis() {
        return givetDosis.size()*antalEnheder;
    }

    /**
     * Returnerer antal gange ordinationen er anvendt
     * @return
     */
    public int getAntalGangeGivet() {
        return givetDosis.size();
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

}
