package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import controller.ClientController;

/**
 * Classe: SocketCliente
 */
public class SocketCliente extends Thread {
    ClientController clientController;
    
    public void run() {
        try {
//      BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            DatagramSocket clientSocket = new DatagramSocket();
            
            String servidor = "localhost";
            int porta = 9876;
            
            InetAddress IPAddress = InetAddress.getByName(servidor);
            
            byte[] sendData;
            byte[] receiveData = new byte[1024];
            
            String sentence = "Solicitar horario";
            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, porta);
            
            System.out.println("Enviando pacote UDP para " + servidor + ":" + porta);
            clientSocket.send(sendPacket);
            
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            
            clientSocket.receive(receivePacket);
            System.out.println("Pacote UDP recebido...");
            
            String sentencaRecebida = new String(receivePacket.getData(), receivePacket.getOffset(), receivePacket.getLength());
            clientController.txtAreaHorario.setText(sentencaRecebida);
            
            System.out.println("Data recebida do servidor: " + sentencaRecebida);
            clientSocket.close();
            System.out.println("Socket cliente fechado.");
        } catch (IOException e) {
            e.printStackTrace();
        } // fim do catch
    } //fim do metodo run
    
    public void setControlador(ClientController control) {
        this.clientController = control;
    } // fim do metodo setControlador
} // fim da classe Socket