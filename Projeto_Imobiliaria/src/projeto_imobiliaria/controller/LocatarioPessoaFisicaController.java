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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import projeto_imobiliaria.model.Locatario_Fisico;

/**
 * FXML Controller class
 *
 * @author thiag
 */
public class LocatarioPessoaFisicaController implements Initializable {

    @FXML
    private TextField txtNomeLocatario;
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
    private ComboBox<?> fiador_locatario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Máscaras dos campos
        MaskFieldUtil.cpfField(txtCPF);
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

    @FXML
    private void salvar(ActionEvent event) {

        if (txtNomeLocatario == null || txtNomeLocatario.getText().trim().equals("")
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
    
    public void limpar(){
        txtNomeLocatario.setText("");
//        Data
        txtNascidoEm.setText("");
        txtRG.setText("");
        txtCPF.setText("");
        txtProfissao.setText("");
        txtNomeMae.setText("");
//        EstadoCivil
//cbxEstadoCivil.setSelectionModel(SingleSelection<?>Selecione);
        txtNomeConjuge.setText("");
        txtLogradouro.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        txtUF.setText("");
        txtNumeroCasa.setText("");
        txtComplemento.setText("");
        txtTelefone.setText("");
        txtCelular.setText("");
        txtEmail.setText("");
        txtCEP.setText("");
        
        txtNomeLocatario.requestFocus();
    }

    public void gravar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("imobisoft");
        EntityManager em = emf.createEntityManager();

        Locatario_Fisico locatarioF = new Locatario_Fisico();

        locatarioF.setNome(txtNomeLocatario.getText());
//        datanascimento
        locatarioF.setSexo((String) cbxSexo.getSelectionModel().getSelectedItem());
        locatarioF.setLocalNascimento(txtNascidoEm.getText());
        locatarioF.setRG(txtRG.getText());
        locatarioF.setCPF(txtCPF.getText());
        locatarioF.setProfissao(txtProfissao.getText());
        locatarioF.setNomeMae(txtNomeMae.getText());
        locatarioF.setEstadoCivil((String) cbxEstadoCivil.getSelectionModel().getSelectedItem());
        locatarioF.setConjuge(txtNomeConjuge.getText());
        locatarioF.setLogradouro(txtLogradouro.getText());
        locatarioF.setNumeroCasa(txtNumeroCasa.getText());
        locatarioF.setBairro(txtBairro.getText());
        locatarioF.setCidade(txtCidade.getText());
        locatarioF.setUF(txtUF.getText());
        locatarioF.setCEP(txtCEP.getText());
        locatarioF.setComplemento(txtComplemento.getText());
        locatarioF.setTelefone(txtTelefone.getText());
        locatarioF.setCelular(txtCelular.getText());
        locatarioF.setEmail(txtEmail.getText());

        em.getTransaction().begin();
        em.persist(locatarioF);
        em.getTransaction().commit(); 
        limpar();
    }
}
