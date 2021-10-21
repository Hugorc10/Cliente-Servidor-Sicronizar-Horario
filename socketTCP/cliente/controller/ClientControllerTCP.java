package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import socket.SocketCliente;

import java.net.URL;
import java.util.ResourceBundle;

/*********************************************************************
* Classe: Controlador
* Funcao: controla todas as funcoes da tela
******************************************************************* */
public class ClientControllerTCP implements Initializable {
  
  @FXML public Button btnMandaMsg;
  @FXML public TextArea horario;
  @FXML public Label lblEsperandoConexao;
  public int porta = 5554;
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
  
  } //fim do initialize
  
  public void mandarMensagem(ActionEvent event){
    btnMandaMsg.setVisible(false);
    porta +=1;
    SocketCliente socketCliente = new SocketCliente();
    socketCliente.setControlador(this);
    socketCliente.start();
  }

  public void mandarMensagem2(){
    //porta +=1;
    btnMandaMsg.setVisible(false);
    lblEsperandoConexao.setVisible(true);
    SocketCliente socketCliente = new SocketCliente();
    socketCliente.setControlador(this);
    socketCliente.start();
  }
  
}//fim classe controlador