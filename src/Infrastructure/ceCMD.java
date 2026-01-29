package Infrastructure;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ceCMD {
    private static final String ceTRACER_FILE = ceAppConfig.cePATH_TRACER;

    // ANSI Color Codes
    private static final String ceANSI_RESET = "\u001B[0m";
    private static final String ceANSI_RED = "\u001B[31m";
    private static final String ceANSI_BLUE = "\u001B[34m";

    public static void ceImprimir(String ceMensaje) {
        if (ceMensaje.contains("GOOD")) {
            System.out.println(ceANSI_BLUE + ceMensaje + ceANSI_RESET);
        } else if (ceMensaje.contains("ERROR")) {
            System.out.println(ceANSI_RED + ceMensaje + ceANSI_RESET);
        } else {
            System.out.println(ceMensaje);
        }

        ceGuardarEnArchivo(ceMensaje);
    }

    private static void ceGuardarEnArchivo(String ceMensaje) {
        try (FileWriter ceFw = new FileWriter(ceTRACER_FILE, true);
                PrintWriter cePw = new PrintWriter(ceFw)) {

            cePw.println(ceMensaje);
        } catch (IOException e) {
            System.err.println("Error writing to ExoTracer.txt: " + e.getMessage());
        }
    }
}
