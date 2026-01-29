package BusinessLogic.Entities;

public class ceExoMedico extends ceExobot {
    public ceExoMedico() {
        super("ExoMedico");
        this.ceArmaNombre = "BioSensor/BioEscaner";
    }

    @Override
    public String ceRealizarAccion() {
        return "Asistir (Energía)";
    }
}
