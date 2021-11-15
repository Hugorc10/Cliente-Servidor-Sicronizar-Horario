package socket;

import controller.ServerController;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 */
public class SocketServidor extends Thread {
    ServerController serverController;
    ServerSocket serverSocket;
    
    public void run() {
        try {
            criarServerSocket(serverController.porta);
            System.out.println("Esperando conexao...");
            Socket socket = esperaConexao();
            trataConexao(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }//fim metodo catch
    } // fim do metodo run
    
    public void criarServerSocket(int porta) throws IOException {
        serverSocket = new ServerSocket(porta);
    }//fim metodo criarServerSocket
    
    public Socket esperaConexao() throws IOException {
        System.out.println("servidor iniciado!");
        return serverSocket.accept();
    } //fim do metodo esperaConexao
    
    public void trataConexao(Socket socket) {
        try {
            // stream de saida de dados em bytes sendo convertida para dados convencionais
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            // stream de entrada de dados em bytes sendo convertida para dados convencionais
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

//            String msg = input.readUTF();
            System.out.println("Mensagem recebida...");
            Calendar calendar = new GregorianCalendar();
            Date trialTime = new Date();
            calendar.setTime(trialTime);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            
            String horas = sdf.format(new Date());
            output.writeUTF(horas);
            output.flush();
            
            //fecha streams de entrada e saida
            input.close();
            output.close();
            serverController.btnLigarServidor.setVisible(true);
        } catch (IOException e) {
//            String erro = e.getMessage();
            System.out.println("Erro encontrado: " + e.getMessage());
            // trata excecao
        }//fim metodo catch
        finally {
            //final do tratamento do protocolo
            try {
                fechaSocket(socket);
            } catch (IOException e) {
                System.out.println("Problema no tratamento da conexao com o cliente" + socket.getInetAddress());
                System.out.println("Erro: " + e.getMessage());
            }//fim metodo catch
        }//fim metodo finally
    }//fim metodo trataConexao
    
    public void setControlador(ServerController control) {
        serverController = control;
    } //fim metodo setControlador
    
    public void fechaSocket(Socket s) throws IOException {
        //fecha o socket de comunicacao entre cliente-servidor
        s.close();
    }// fim metodo fechaSocket
    
}//fim classe Socket