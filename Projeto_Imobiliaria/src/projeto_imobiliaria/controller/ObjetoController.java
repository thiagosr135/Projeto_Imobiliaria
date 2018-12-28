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
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import projeto_imobiliaria.model.Objeto;

/**
 * FXML Controller class
 *
 * @author thiag
 */
public class ObjetoController implements Initializable {

    @FXML
    private TextField txtDescricao;
    @FXML
    private TextField txtLogradouro;
    @FXML
    private TextField txtNumero;
    @FXML
    private TextField txtBairro;
    @FXML
    private TextField txtCEP;
    @FXML
    private TextField txtCidade;
    @FXML
    private TextField txtUF;
    @FXML
    private TextField txtCodigoUnico;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        MaskFieldUtil.cepField(txtCEP);
        MaskFieldUtil.numericField(txtNumero);
        MaskFieldUtil.numericField(txtCodigoUnico);
    }    

    public void limpar(){
        txtDescricao.setText("");
        txtLogradouro.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        txtCEP.setText("");
        txtNumero.setText("");
        txtCodigoUnico.setText("");
        
        txtDescricao.requestFocus();
    }
    
    @FXML
    private void salvar(ActionEvent event) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("imobisoft");
        EntityManager em = emf.createEntityManager();
        Objeto objeto = new Objeto();
        
        objeto.setDescricao(txtDescricao.getText());
        objeto.setLogradouro(txtLogradouro.getText());
        objeto.setBairro(txtBairro.getText());
        objeto.setCidade(txtCidade.getText());
        objeto.setCEP(txtCEP.getText());
        objeto.setNumero(txtNumero.getText());
        objeto.setCodigoUnico(txtCodigoUnico.getText());
        
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        limpar();
        
    }

    @FXML
    private void editar(ActionEvent event) {
    }

    @FXML
    private void excluir(ActionEvent event) {
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
            alert.setHeaderText("Erro ao encontrar CEP!");
            alert.setContentText("Verifique os campos de CEP e tente novamente");
            alert.showAndWait();
        }
    }
    
}
