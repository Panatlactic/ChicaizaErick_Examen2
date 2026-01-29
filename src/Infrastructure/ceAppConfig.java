package Infrastructure;

public class ceAppConfig {
    public static final String ceDB_URL;
    public static final String ceDRIVER;
    public static final String cePATH_MUNISION;
    public static final String cePATH_TRACER;

    static {
        java.util.Properties ceProps = new java.util.Properties();
        try (java.io.FileInputStream ceFis = new java.io.FileInputStream("app.properties")) {
            ceProps.load(ceFis);
        } catch (java.io.IOException e) {
            // System.err.println("Error loading app.properties: " + e.getMessage());
        }
        ceDB_URL = ceProps.getProperty("ceDB_URL", "jdbc:sqlite:database\\ce_ExoTrooper.sqlite");
        ceDRIVER = ceProps.getProperty("ceDRIVER", "org.sqlite.JDBC");

        String munPath = ceProps.getProperty("cePATH_MUNISION", "src/ceStorage/ceDataFiles/ExoMunision.txt");
        if (!new java.io.File(munPath).exists() && new java.io.File("ceStorage/ceDataFiles/ExoMunision.txt").exists()) {
            munPath = "ceStorage/ceDataFiles/ExoMunision.txt";
        }
        cePATH_MUNISION = munPath;

        String tracerPath = ceProps.getProperty("cePATH_TRACER", "src/ceStorage/ceDataFiles/ExoTracer.txt");
        if (!new java.io.File(tracerPath).exists() && new java.io.File("ceStorage/ceDataFiles/ExoTracer.txt").exists()) {
            tracerPath = "ceStorage/ceDataFiles/ExoTracer.txt";
        }
        cePATH_TRACER = tracerPath;
    }
}
