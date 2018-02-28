/**
 * Sample Skeleton for 'DniGui.fxml' Controller Class
 */

package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class DniController {
	DNI dni = new DNI();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="resultado"
    private Label resultado; // Value injected by FXMLLoader

    @FXML // fx:id="entrada"
    private TextField entrada; // Value injected by FXMLLoader

    @FXML // fx:id="calcular"
    private Button calcular; // Value injected by FXMLLoader

    @FXML // fx:id="calcular"
    private Button verificar; // Value injected by FXMLLoader

    @FXML // fx:id="calcular"
    private Label resulVerificar; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert resultado != null : "fx:id=\"resultado\" was not injected: check your FXML file 'DniGui.fxml'.";
        assert entrada != null : "fx:id=\"entrada\" was not injected: check your FXML file 'DniGui.fxml'.";
        assert calcular != null : "fx:id=\"calcular\" was not injected: check your FXML file 'DniGui.fxml'.";
    }

    @FXML
    private void BotonCalculo(ActionEvent event) {
        // Button was clicked, do something...
    	resultado.setText("");
        resultado.setText(dni.calculoNIF(entrada.getText()));
        resulVerificar.setText("");
    }

    @FXML
    private void BotonVerificar(ActionEvent event) {
        // Button was clicked, do something...
    	resultado.setText("");
		if (dni.compruebaDNI(entrada.getText())) {
			resulVerificar.setText("Válido");
			resulVerificar.setTextFill(Color.GREEN);
		} else {
			resulVerificar.setText("Erróneo");
			resulVerificar.setTextFill(Color.RED);
		}
	}
}