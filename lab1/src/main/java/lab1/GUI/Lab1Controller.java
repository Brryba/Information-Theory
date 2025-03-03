package lab1.GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import lab1.services.ErrorViewer;
import lab1.services.FileSelector;

import java.io.*;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Lab1Controller implements Initializable {
    @FXML
    private TextField inputField;
    @FXML
    private TextField outputField;
    @FXML
    private TextField keyField;
    @FXML
    private ToggleGroup cipherSelector;

    
    Ciphers cipher = Ciphers.COLUMNS;

    private boolean checkKey(String key) {
        if (key.isEmpty()) {
            ErrorViewer.showError("Ваш ключ не содержит корректных символов!");
        }
        return key.isEmpty();
    }

    private void fileNotFound() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Ключ не содержит корректных символов!");
        alert.setContentText("Пожалуйста, введите ключ в нужном поле");
        alert.show();
    }

    @FXML
    public void encodeButtonAction() {
        String key = keyField.getText();
        if (checkKey(key)) {
            if (cipher == Ciphers.COLUMNS) {
            }
        }
    }

    @FXML
    public void setCipher() {
        switch (cipherSelector.getSelectedToggle().getUserData().toString()) {
            case "columns": {
                cipher = Ciphers.COLUMNS;
                break;
            }
            case "vigenere": {
                cipher = Ciphers.VIGENERE;
                break;
            }
        };
    }

    @FXML
    public void save() {
        File file = FileSelector.selectFile(false, (Stage) inputField.getScene().getWindow());
        if (file != null) {
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(outputField.getText());
            } catch (IOException e) {
                ErrorViewer.showError("Запись в файл невозможна!");
            }
        }
    }

    @FXML
    public void open() {
        File file = FileSelector.selectFile(true, (Stage) inputField.getScene().getWindow());
        String input = null;
        if (file != null) {
            try (Scanner scanner = new Scanner(file)) {
                input = scanner.nextLine();
            } catch (FileNotFoundException e) {
                ErrorViewer.showError("Файл с таким именем не найден");
                return;
            } catch (NoSuchElementException e) {
                ErrorViewer.showError("Файл пустой");
                return;
            }
        }
        inputField.setText(input);
    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}