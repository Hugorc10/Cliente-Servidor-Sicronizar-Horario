package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import socket.SocketCliente;

import java.net.URL;
import java.util.ResourceBundle;

/*********************************************************************
 * Classe: Controlador
 * Funcao: controla todas as funcoes da tela
 ******************************************************************* */
public class ClientControllerUDP implements Initializable {
    @FXML
    public TextArea txtAreaHorario;
    @FXML
    Button btnMandaMsg;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }
    
    public void mandarMensagem() {
        SocketCliente socketCliente = new SocketCliente();
        socketCliente.setControlador(this);
        socketCliente.start();
    }
}//fim classe controlador