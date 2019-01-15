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
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import projeto_imobiliaria.model.Locatario_Juridico;

/**
 * FXML Controller class
 *
 * @author thiag
 */
public class LocatarioPessoaJuridicaController implements Initializable {

    @FXML
    private TextField txtLogradouro;
    @FXML
    private TextField txtBairro;
    @FXML
    private TextField txtCidade;
    @FXML
    private TextField txtUF;
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
    private TextField txtNome;
    @FXML
    private TextField txtInscricaoEstadual;
    @FXML
    private TextField txtCNPJ;
    @FXML
    private TextField txtNumeroSede;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       //Máscaras dos campos
        MaskFieldUtil.cnpjField(txtCNPJ);
        MaskFieldUtil.cepField(txtCEP);
        MaskFieldUtil.foneField(txtTelefone);
        MaskFieldUtil.foneField(txtCelular);
      
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

    private void limpar(){
        txtNome.setText("");
        txtInscricaoEstadual.setText("");
        txtCNPJ.setText("");
        txtLogradouro.setText("");
        txtNumeroSede.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        txtUF.setText("");
        txtCEP.setText("");
        txtComplemento.setText("");
        txtTelefone.setText("");
        txtCelular.setText("");
        txtEmail.setText("");
        
        txtNome.requestFocus();
    }
    
    @FXML
    private void salvar(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("imobisoft");
        EntityManager em = emf.createEntityManager();
        
        Locatario_Juridico locatarioJ = new Locatario_Juridico();
        
        locatarioJ.setNome(txtNome.getText());
        locatarioJ.setIncricaoEstadual(txtInscricaoEstadual.getText());
        locatarioJ.setCNPJ(txtCNPJ.getText());
        locatarioJ.setLogradouro(txtLogradouro.getText());
        locatarioJ.setNumero(txtNumeroSede.getText());
        locatarioJ.setBairro(txtBairro.getText());
        locatarioJ.setCidade(txtCidade.getText());
        locatarioJ.setUF(txtUF.getText());
        locatarioJ.setCEP(txtCEP.getText());
        locatarioJ.setComplemento(txtComplemento.getText());
        locatarioJ.setTelefone(txtTelefone.getText());
        locatarioJ.setCelular(txtCelular.getText());
        locatarioJ.setEmail(txtEmail.getText());
        
        em.getTransaction().begin();
        em.persist(locatarioJ);
        em.getTransaction().commit();
        limpar();
        
    }
    
}
