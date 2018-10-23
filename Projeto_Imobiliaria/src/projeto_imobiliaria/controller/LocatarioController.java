/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_imobiliaria.controller;

import com.jfoenix.controls.JFXRadioButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author thiag
 */
public class LocatarioController implements Initializable {

    @FXML
    private AnchorPane acpTipoPessoa;
    @FXML
    private TextField txtNomeLocador1;
    @FXML
    private JFXRadioButton rbPessoaJuridica;
    @FXML
    private JFXRadioButton rbPessoaFisica;
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
    }    

    //Se o botão Pessoa Jurídica for selecionado
    @FXML
    private void PessoaJurica(ActionEvent event) throws IOException {
    
        /** Verificar RadioButton e setar a tela de cadastro */
        if(rbPessoaJuridica.isSelected()){
           rbPessoaFisica.setSelected(false);
           AnchorPane pane = FXMLLoader.load(getClass().getResource("/projeto_imobiliaria/view/LocatarioPessoaJuridica.fxml"));
           acpTipoPessoa.getChildren().setAll(pane);
        }else{} 
    }

    //Se o botão Pessoa Física for selecionado
    @FXML
    private void PessoaFisica(ActionEvent event) throws IOException {
        /** Verificar RadioButton e setar a tela de cadastro */
        if (rbPessoaFisica.isSelected()){
           rbPessoaJuridica.setSelected(false);
           AnchorPane pane = FXMLLoader.load(getClass().getResource("/projeto_imobiliaria/view/LocatarioPessoaFisica.fxml"));
           acpTipoPessoa.getChildren().setAll(pane);
        }else{};
    }
    
}
