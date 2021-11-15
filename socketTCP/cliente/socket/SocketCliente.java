package socket;

import controller.ClientController;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketCliente extends Thread {
    
    ClientController clientController;
    
    public void run() {
        try {
            Socket socket = new Socket("localhost", clientController.porta);
            
            // criacao dos streams de entrada e saida
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            
            String msg = "HELLO";
            output.writeUTF(msg);
            // libera o buffer para envio
            output.flush();
            msg = input.readUTF();
            System.out.println("Resposta do servidor: " + msg);
            clientController.txtAreaHorario.setText(msg);
            
            input.close();
            output.close();
            socket.close();
            clientController.lblEsperandoConexao.setVisible(false);
            clientController.btnAtualizaHorario.setVisible(true);
            
        } catch (IOException e) {
            clientController.atualizarHorario2();
        } //fim do metodo catch
        
    } //fim do metodo criarClientSocket
    
    public void setControlador(ClientController control) {
        clientController = control;
    } // fim do metodo setControlador
}//fim classe Socket