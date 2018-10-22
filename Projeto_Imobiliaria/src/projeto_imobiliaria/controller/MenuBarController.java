/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_imobiliaria.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author thiag
 */
public class MenuBarController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void abrirLocador(ActionEvent event) throws IOException {
        
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/projeto_imobiliaria/view/Locador.fxml"));
        //.getChildren().setAll(pane);
     
    }

    @FXML
    private void abrirLocatario(ActionEvent event) {
    }

    @FXML
    private void abrirObjeto(ActionEvent event) {
    }

    @FXML
    private void abrirFiador(ActionEvent event) {
    }

    @FXML
    private void abrirContrato(ActionEvent event) {
    }

    @FXML
    private void abrirRecibo(ActionEvent event) {
    }
    
}
