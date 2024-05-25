package your.package;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Page1Controller {

    @FXML
    private void handleJsExercise1Action(ActionEvent event) throws IOException {
        // Charger la deuxième page
        Parent page2Parent = FXMLLoader.load(getClass().getResource("Page2.fxml"));
        Scene page2Scene = new Scene(page2Parent);

        // Obtenir la fenêtre (stage) actuelle
        Stage window = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();

        // Définir la nouvelle scène sur la fenêtre actuelle
        window.setScene(page2Scene);
        window.show();
    }
}
