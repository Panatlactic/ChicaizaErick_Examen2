import ConsoleApp.ceLogin;
import UserInterface.ceExoTrooperForm;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {

        ceLogin ceLoginService = new ceLogin();

        if  (ceLoginService.ceAutenticar()) {

            SwingUtilities.invokeLater(() -> {
                ceExoTrooperForm ceForm = new ceExoTrooperForm();
             ceForm.setVisible(true);
            });
        } else {
            System.exit(0);
        }
    }
}
