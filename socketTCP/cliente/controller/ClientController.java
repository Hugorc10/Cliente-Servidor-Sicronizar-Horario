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

/**
* Classe: ClientController
* Funcao: controla todas as funcoes da tela
*/
public class ClientController implements Initializable {
  public int porta = 5554;
  
  @FXML
  public Button btnAtualizaHorario;
  @FXML
  public TextArea txtAreaHorario;
  @FXML
  public Label lblEsperandoConexao;
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    btnAtualizaHorario.setDefaultButton(true);
  
  } //fim do initialize
  
  public void atualizarHorario(ActionEvent event){
    btnAtualizaHorario.setVisible(false);
    porta +=1;
    
//    if (porta >= 5558) {
//      porta = 5554;
//    }
    
    SocketCliente socketCliente = new SocketCliente();
    socketCliente.setControlador(this);
    socketCliente.start();
  }

  public void atualizarHorario2(){
    //porta +=1;
    btnAtualizaHorario.setVisible(false);
    lblEsperandoConexao.setVisible(true);
    SocketCliente socketCliente = new SocketCliente();
    socketCliente.setControlador(this);
    socketCliente.start();
  }
  
} // fim da classe ClientController