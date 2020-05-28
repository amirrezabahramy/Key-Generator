package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class KeyGeneratorPage extends StackPane{
    private TextField textField;
    private Button generate;
    private Button copy;

    private Text text;

    public KeyGeneratorPage() {
        /* (StackPane) Root Node Config */
        this.setPrefSize(380, 140);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10));
        this.setStyle("-fx-background-color: #3C9B46");
        /* (StackPane) End Of Root Node Config */


        /* (VBox) Main Container Config */
        VBox mainContainer=new VBox(23);
        mainContainer.setPadding(new Insets(25, 9, 25, 9));
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.getStyleClass().add("main-container");
        /* (VBox) End Of Main Container Config */


        /* (Text) Text Config */
        text = new Text("Generate key for your application.");
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
        textField = new TextField();
        textField.setEditable(false);
        textField.getStyleClass().add("text-field");
        textField.setPrefSize(165, 36);
        /* (TextField) End Of Textfield Config */


        /* (Button) Buttons Config */
        generate = new Button("Generate");
        copy = new Button("Copy");

        // Generate Button
        generate.getStyleClass().add("generate-btn");
        generate.setPrefSize(91, 36);

        // Copy Button
        copy.getStyleClass().add("copy-btn");
        copy.setPrefSize(91, 36);
        /* (Button) End Of Buttons Config */


        /* (HBox) Buttons Container Config */
        HBox buttonsContainer = new HBox(5);
        buttonsContainer.getChildren().addAll(generate, copy);
        /* (HBox) End Of Buttons Container Config */


        /* (Scene) Creating Scene */

        hBox.getChildren().addAll(textField, buttonsContainer);
        mainContainer.getChildren().addAll(textContainer, hBox);
        this.getChildren().add(mainContainer);
        /* (Scene) End Of Creating Scene */

    }

    public TextField getTextField() {
        return textField;
    }

    public void setTextField(TextField textField) {
        this.textField = textField;
    }

    public Button getGenerate() {
        return generate;
    }

    public void setGenerate(Button generate) {
        this.generate = generate;
    }

    public Button getCopy() {
        return copy;
    }

    public void setCopy(Button copy) {
        this.copy = copy;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

}
