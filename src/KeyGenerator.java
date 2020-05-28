/*

This file is part of Key-Generator.

    Key-Generator is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Key-Generator is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Key-Generator.  If not, see <https://www.gnu.org/licenses/>.

 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class KeyGenerator extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    // This function generates 12-digit keys.
    private static long generateKey() {

        final long KEY = 322787489; // This is the base key that we use to generate other keys.
        final int F = 310; // First valid 12-digit number is the 310th multiple of KEY.
        final int L = 3098; // Last valid 12-digit number is the 3098th multiple of KEY.
        int range = L - F + 1;
        Random random = new Random();
        int i = random.nextInt(range) + F; // Variable i is going to be a number between F & L.
        return KEY * i + 467; // 467 is used to make the key more complicated.

    }

    /* This function converts a key to a string so it can be shown inside a textfield. It also adds
    a '-' character between every 3 digits so the key becomes more readable */
    private static String formatKey(long key) {

        StringBuilder formattedKey = new StringBuilder();
        String[] split = String.valueOf(key).split("");

        for (int i = 0, j = 1; i < split.length; j++) {
            if (j % 4 != 0) {
                formattedKey.append(split[i]);
                i++;
            } else {
                formattedKey.append('-');
            }
        }
        return formattedKey.toString();

    }

    @Override
    public void start(Stage mainWindow) {

        /* (StackPane) Root Node Config */
        StackPane root = new StackPane();
        root.setPrefSize(380, 140);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));
        root.setStyle("-fx-background-color: #3C9B46");
        /* (StackPane) End Of Root Node Config */


        /* (VBox) Main Container Config */
        VBox mainContainer = new VBox(23);
        mainContainer.setPadding(new Insets(25, 9, 25, 9));
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.getStyleClass().add("main-container");
        /* (VBox) End Of Main Container Config */


        /* (Text) Text Config */
        Text text = new Text("Generate key for your application.");
        text.getStyleClass().add("fancy-font");
        /* (Text) End Of Text Config */


        /* (HBox) Textfield and Buttons Container Config */
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        /* (HBox) End Of Textfield and Buttons Container Config */


        /* (HBox) Text Container Config */
        HBox textContainer = new HBox();
        textContainer.setAlignment(Pos.CENTER_LEFT);
        textContainer.getChildren().add(text);
        /* (HBox) End Of Text Container Config */

        /* (TextField) Textfield Config */
        TextField textField = new TextField();
        textField.setEditable(false);
        textField.getStyleClass().add("text-field");
        textField.setPrefSize(165, 36);
        /* (TextField) End Of Textfield Config */


        /* (Button) Buttons Config */
        Button generate = new Button("Generate"), copy = new Button("Copy");

        // Generate Button
        generate.getStyleClass().add("generate-btn");
        generate.setPrefSize(91, 36);
        generate.setOnAction(event -> {
            textField.setText(formatKey(generateKey()));
            text.setText("Key generated!");
        });

        // Copy Button
        copy.getStyleClass().add("copy-btn");
        copy.setPrefSize(91, 36);
        copy.setOnAction(event -> {
            if (!(textField.getText().equals(""))) {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString(textField.getText());
                clipboard.setContent(content);
                text.setText("Key copied!");
            } else {
                text.setText("There is nothing to be copied.");
            }
        });
        /* (Button) End Of Buttons Config */


        /* (HBox) Buttons Container Config */
        HBox buttonsContainer = new HBox(5);
        buttonsContainer.getChildren().addAll(generate, copy);
        /* (HBox) End Of Buttons Container Config */


        /* (Scene) Creating Scene */
        Scene scene = new Scene(root);
        scene.getStylesheets().add(KeyGenerator.class.getResource("/Styles/CSS Styles/KeyGeneratorStyles.css").toExternalForm());
        hBox.getChildren().addAll(textField, buttonsContainer);
        mainContainer.getChildren().addAll(textContainer, hBox);
        root.getChildren().add(mainContainer);
        /* (Scene) End Of Creating Scene */


        /* (Stage) Configuring Main Window */
        mainWindow.setTitle("Key Generator");
        mainWindow.setMinWidth(400);
        mainWindow.setMinHeight(160);
        mainWindow.setResizable(false);
        mainWindow.getIcons().add(new Image(KeyGenerator.class.getResource("/Styles/Icon.png").toExternalForm()));
        mainWindow.setScene(scene);
        /* (Stage) End Of Configuring Main Window */

        // Run
        mainWindow.show();
    }

}