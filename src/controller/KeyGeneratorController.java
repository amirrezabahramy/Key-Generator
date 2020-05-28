package controller;

import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import view.KeyGeneratorPage;
import model.KeyGenerator;

public class KeyGeneratorController {
    private KeyGeneratorPage keyGeneratorPage;

    public KeyGeneratorController() {
        keyGeneratorPage = new KeyGeneratorPage();
        generatorButton();
        copyButton();
    }

    public void generatorButton() {
        keyGeneratorPage.getGenerate().setOnAction(event -> {
            keyGeneratorPage.getTextField().setText(KeyGenerator.formatKey(KeyGenerator.generateKey()));
            keyGeneratorPage.getText().setText("Key generated!");
        });

    }

    public void copyButton() {
        keyGeneratorPage.getCopy().setOnAction(event -> {
            if (!(keyGeneratorPage.getTextField().getText().equals(""))) {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString(keyGeneratorPage.getTextField().getText());
                clipboard.setContent(content);
                keyGeneratorPage.getText().setText("Key copied!");
            } else {
                keyGeneratorPage.getText().setText("There is nothing to be copied.");
            }
        });
    }

    public KeyGeneratorPage getKeyGeneratorPage() {
        return keyGeneratorPage;
    }

}
