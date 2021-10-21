package socket;

import controller.ServerControllerTCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SocketServidor extends Thread {
    ServerControllerTCP c;
    ServerSocket serverSocket;
    
    public void run() {
        /*while(true){*/
        //int novaP = 0;
        try {
            criarServerSocket(c.porta);
            System.out.println("Esperando conexao...");
            Socket socket = esperaConexao();
            trataConexao(socket);
        } catch (IOException e) {
            e.printStackTrace();
        /*novaP += porta + 1;
	      iniciarServer(novaP);
        System.out.println("nova porta: " + novaP);*/
        }//fim metodo catch
        /*}//fim while*/
    }//fim metodo iniciarServer
    
    public void criarServerSocket(int porta) throws IOException {
        serverSocket = new ServerSocket(porta);
    }//fim metodo criarServerSocket
    
    public Socket esperaConexao() throws IOException {
        System.out.println("servidor iniciado!");
        return serverSocket.accept();
    }//fim metodo esperaConexao
    
    public void trataConexao(Socket socket) {
        try {
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());//stream de saida de dados em bytes sendo convertida para dados convencionais
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());//stream de entrada de dados em bytes sendo convertida para dados convencionais
            
            /* Protocolo hdsp */
            String msg = input.readUTF();
            System.out.println("Mensagem recebida...");
            Calendar calendar = new GregorianCalendar();
            Date trialTime = new Date();
            calendar.setTime(trialTime);
      /*String hora = (calendar.get(Calendar.HOUR_OF_DAY) + "");
      String minuto = (calendar.get(Calendar.MINUTE) + "");
      String segundo = (calendar.get(Calendar.SECOND) + "");
      String horas = hora + ":" + minuto + ":" + segundo;*/
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            
            String horas = sdf.format(new Date());
            output.writeUTF(horas);
            output.flush();
            
            //fecha streams de entrada e saida
            input.close();
            output.close();
            c.btnLigarServidor.setVisible(true);
        } catch (IOException e) {
            //trata excecao
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
    
    public void setControlador(ServerControllerTCP control) {
        c = control;
    }//fim metodo setControlador
    
    public void fechaSocket(Socket s) throws IOException {
        s.close();//fecha o socket de comunicacao entre cliente-servidor
    }// fim metodo fechaSocket
    
}//fim classe Socket