/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_imobiliaria.controller;

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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import projeto_imobiliaria.model.Fiador;
import projeto_imobiliaria.model.Locatario_Fisico;

/**
 * FXML Controller class
 *
 * @author thiag
 */
public class FiadorController implements Initializable {

    @FXML
    private TextField txtNomeFiador;
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
    @FXML
    private ComboBox<?> locatario_fiador;
    @FXML
    private TextField txtNomeLocador1;

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
    
    public void gravar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("imobisoft");
        EntityManager em = emf.createEntityManager();

        Fiador fiador = new Fiador();

        fiador.setNome(txtNomeFiador.getText());
//        datanascimento
        fiador.setSexo((String) cbxSexo.getSelectionModel().getSelectedItem());
        fiador.setLocalNascimento(txtNascidoEm.getText());
        fiador.setRG(txtRG.getText());
        fiador.setCPF(txtCPF.getText());
        fiador.setProfissao(txtProfissao.getText());
        fiador.setNomeMae(txtNomeMae.getText());
        fiador.setEstadoCivil((String) cbxEstadoCivil.getSelectionModel().getSelectedItem());
        fiador.setConjuge(txtNomeConjuge.getText());
        fiador.setLogradouro(txtLogradouro.getText());
        fiador.setNumeroCasa(txtNumeroCasa.getText());
        fiador.setBairro(txtBairro.getText());
        fiador.setCidade(txtCidade.getText());
        fiador.setUF(txtUF.getText());
        fiador.setCEP(txtCEP.getText());
        fiador.setComplemento(txtComplemento.getText());
        fiador.setTelefone(txtTelefone.getText());
        fiador.setCelular(txtCelular.getText());
        fiador.setEmail(txtEmail.getText());

    }

    @FXML
    private void buscarCEP(ActionEvent event) {
    }

    @FXML
    private void salvar(ActionEvent event) {
         if (txtNomeFiador == null || txtNomeFiador.getText().trim().equals("")
                || txtRG == null || txtRG.getText().trim().equals("")
                || txtCPF == null || txtCPF.getText().trim().equals("")
                || txtCelular == null || txtCelular.getText().trim().equals("")) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campos Incorretos!");
            alert.setHeaderText(null);
            alert.setContentText("Preencha todos os campos marcados com asteriscos corretamente");
            alert.showAndWait();

        } else {
            gravar();
        }

    }
}
