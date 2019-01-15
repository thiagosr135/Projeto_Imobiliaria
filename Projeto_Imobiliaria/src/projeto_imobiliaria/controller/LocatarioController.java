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
import javafx.scene.control.Alert;
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
    private JFXRadioButton rbPessoaJuridica;
    @FXML
    private JFXRadioButton rbPessoaFisica;
    @FXML
    private TextField txtNomeLocador1;
    @FXML
    private AnchorPane tabelaPessoaFisica;
    @FXML
    private JFXRadioButton rbPessoaFisicaTB;
    @FXML
    private JFXRadioButton rbPessoaJuridicaTB;
    @FXML
    private AnchorPane ancTabelaPessoa;
    
    

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
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao carregar");
            alert.setHeaderText("Não foi possível abrir");
        } 
    }

    //Se o botão Pessoa Física for selecionado
    @FXML
    private void PessoaFisica(ActionEvent event) throws IOException {
        
        /** Verificar RadioButton e setar a tela de cadastro */
        if (rbPessoaFisica.isSelected()){
           rbPessoaJuridica.setSelected(false);
           AnchorPane pane = FXMLLoader.load(getClass().getResource("/projeto_imobiliaria/view/LocatarioPessoaFisica.fxml"));
           acpTipoPessoa.getChildren().setAll(pane);
        }else{
             Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setTitle("Erro ao carregar");
             alert.setHeaderText("Não foi possível abrir");
        }
        
        
    }

    private void carregar(){
        
    }

    @FXML
    private void carregarTabelaPessoaFisica(ActionEvent event) throws IOException {
        if (rbPessoaFisicaTB.isSelected()){
           rbPessoaJuridicaTB.setSelected(false);
           AnchorPane pane = FXMLLoader.load(getClass().getResource("/projeto_imobiliaria/view/TBPessoaFisica.fxml"));
           ancTabelaPessoa.getChildren().setAll(pane);
        }else{
             Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setTitle("Erro ao carregar");
             alert.setHeaderText("Não foi possível abrir");
        }
    }

    @FXML
    private void carregarTabelaPessoaJuridica(ActionEvent event) throws IOException {
        if(rbPessoaJuridicaTB.isSelected()){
           rbPessoaFisicaTB.setSelected(false);
           AnchorPane pane = FXMLLoader.load(getClass().getResource("/projeto_imobiliaria/view/TBPessoaJuridica.fxml"));
           ancTabelaPessoa.getChildren().setAll(pane);
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao carregar");
            alert.setHeaderText("Não foi possível abrir");
        } 
    }
    
   
    
}
