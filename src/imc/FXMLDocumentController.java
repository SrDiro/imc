package imc;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Label labelTitulo;
    @FXML
    private Label labelAltura;
    @FXML
    private Label labelPeso;
    @FXML
    private TextField textFieldAltura;
    @FXML
    private TextField textFieldPeso;
    @FXML
    private Label labelCm;
    @FXML
    private Label labelKilos;
    @FXML
    private Label labelResultado;
    @FXML
    private TextField textFieldResultado;
    @FXML
    private RadioButton RBObesidad;
    @FXML
    private ToggleGroup opciones;
    @FXML
    private RadioButton RBSobrepeso;
    @FXML
    private RadioButton RBNormal;
    @FXML
    private RadioButton RBExtremaDelgadez;
    @FXML
    private AnchorPane panel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        panel.setStyle("-fx-background-image: url(file:///C:/Users/daw/Documents/NetBeansProjects/IMC/gif/safe_image.gif); -fx-background-size: 705px 591px;");
    }

    @FXML
    private void calcularIMC(ActionEvent event) {

        double altura, peso, resultado;
        String resultadoFormateado;

        altura = Double.parseDouble(this.textFieldAltura.getText());
        peso = Double.parseDouble(this.textFieldPeso.getText());

        if (altura < 40 || altura > 220) {
            this.textFieldAltura.setStyle("-fx-background-color: rgb(255, 89, 89);");
        } else {
            this.textFieldAltura.setStyle("-fx-background-color: rgb(106, 249, 142);");
        }

        if (peso < 20 || peso > 180) {
            this.textFieldPeso.setStyle("-fx-background-color: rgb(255, 89, 89);");
        } else {
            this.textFieldPeso.setStyle("-fx-background-color: rgb(106, 249, 142);");
        }

        //CALCULO DEL IMC
        resultado = peso / ((altura / 100) * (altura / 100));

        DecimalFormat formateador = new DecimalFormat("00.00");
        resultadoFormateado = formateador.format(resultado);

        if (resultado < 18.4 || resultado > 30) {
            this.textFieldResultado.setStyle("-fx-background-color: rgb(236, 244, 83);");
        }

        this.textFieldResultado.setText(resultadoFormateado);

        if (resultado > 30) {
            RBObesidad.fire();
        } else if (resultado > 25 && resultado < 29.9) {
            RBSobrepeso.fire();
        } else if (resultado > 18.5 && resultado < 24.9) {
            RBNormal.fire();
        } else if (resultado < 18.5) {
            RBExtremaDelgadez.fire();
        }

    }

}
