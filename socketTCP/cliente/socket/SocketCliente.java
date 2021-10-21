package socket;

import controller.ClientControllerTCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketCliente extends Thread{

  ClientControllerTCP c;

  public void run() {
    try {
      Socket socket = new Socket("localhost",c.porta);

      //Criacao dos streams de entrada e saida
      ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

      String msg = "HELLO";
      output.writeUTF(msg);
      output.flush();//libera buffer para envio
      msg = input.readUTF();
      System.out.println("Resposta do servidor: " + msg);
      c.horario.setText(msg);

      input.close();
      output.close();
      socket.close();
      c.lblEsperandoConexao.setVisible(false);
      c.btnMandaMsg.setVisible(true);

    }catch(IOException e){
      //System.out.println("Problema no tratamento da conexao com o cliente" + socket.getInetAddress());
      c.mandarMensagem2();
      //e.printStackTrace();
      /*novaP += porta + 1;
      criarClientSocket(novaP);
      System.out.println("nova porta: " + novaP);*/
    }//fim metodo catch

  }//fim metodo criarClientSocket

  public void setControlador(ClientControllerTCP control){
    c = control;
  }//fim metodo setControlador

}//fim classe Socket