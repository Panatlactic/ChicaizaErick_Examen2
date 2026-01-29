package BusinessLogic.Entities;

public class ceExoExplorador extends ceExobot {
    public ceExoExplorador() {
        super("ExoExplorador");
        this.ceArmaNombre = "GPS/Giroscopio";
    }

    @Override
    public String ceRealizarAccion() {
        return "Detectar (Energía)";
    }
}
