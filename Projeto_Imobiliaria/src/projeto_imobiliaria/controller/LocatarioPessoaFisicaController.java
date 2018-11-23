/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_imobiliaria.controller;

import br.com.parg.viacep.ViaCEP;
import br.com.parg.viacep.ViaCEPException;
import br.eti.diegofonseca.MaskFieldUtil;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author thiag
 */
public class LocatarioPessoaFisicaController implements Initializable {

    @FXML
    private TextField txtNomeLocador;
    @FXML
    private DatePicker dtpDataNascimento;
    @FXML
    private TextField txtNascidoEm;
    @FXML
    private TextField txtRG;
    @FXML
    private TextField txtCPF;
    @FXML
    private TextField txtProfissao;
    @FXML
    private TextField txtNomeMae;
    @FXML
    private ComboBox<?> cbxEstadoCivil;
    @FXML
    private TextField txtNomeConjuge;
    @FXML
    private TextField txtLogradouro;
    @FXML
    private TextField txtBairro;
    @FXML
    private TextField txtCidade;
    @FXML
    private TextField txtUF;
    @FXML
    private TextField txtNumeroCasa;
    @FXML
    private TextField txtComplemento;
    @FXML
    private TextField txtTelefone;
    @FXML
    private TextField txtCelular;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtCEP;
    @FXML
    private ComboBox<?> cbxSexo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       //Máscaras dos campos
        MaskFieldUtil.cpfField(txtCPF);
        MaskFieldUtil.numericField(txtNumeroCasa);
        MaskFieldUtil.foneField(txtTelefone);
        MaskFieldUtil.foneField(txtCelular);
        MaskFieldUtil.cepField(txtCEP);
    }    

    @FXML
    private void buscarCEP(ActionEvent event) {
         ViaCEP viaCep = new ViaCEP();

        try {
            viaCep.buscar(txtCEP.getText());

            txtLogradouro.setText(viaCep.getLogradouro());
            txtBairro.setText(viaCep.getBairro());
            txtCidade.setText(viaCep.getLocalidade());
            txtUF.setText(viaCep.getUf());
            
        } catch (ViaCEPException ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERRO");
            alert.setHeaderText("Não foi possível encontrar o CEP digitado !");
            alert.setContentText("");
            alert.showAndWait();
        }
    }
    
}
