package BusinessLogic.Entities;

public class ceExoAsalto extends ceExobot {
    public ceExoAsalto() {
        super("ExoAsalto");
        this.ceArmaNombre = "Fusil/Revolver";
    }

    @Override
    public String ceRealizarAccion() {
        return "Disparar (Munición)";
    }
}
