import controller.KeyGeneratorController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import view.KeyGeneratorPage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage mainWindow) {
        KeyGeneratorController keyGeneratorController=new KeyGeneratorController();
        Scene scene= new Scene(keyGeneratorController.getKeyGeneratorPage());
        scene.getStylesheets().add(KeyGeneratorPage.class.getResource("../Styles/CSS Styles/KeyGeneratorStyles.css").toExternalForm());
        /* (Stage) Configuring Main Window */
        mainWindow.setTitle("Key Generator");
        mainWindow.setMinWidth(400);
        mainWindow.setMinHeight(160);
        mainWindow.setResizable(false);
        mainWindow.setScene(scene);
        mainWindow.getIcons().add(new Image(Main.class.getResource("/Styles/Icon.png").toExternalForm()));
        /* (Stage) End Of Configuring Main Window */

        // Run
        mainWindow.show();
    }
}
