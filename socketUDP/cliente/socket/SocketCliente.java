package socket;

import java.io.IOException;

import controller.ClientControllerUDP;

import java.net.*;

public class SocketCliente extends Thread {
    ClientControllerUDP controllerUDP;
    
    public void run() {
        try {
//      BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            DatagramSocket clientSocket = new DatagramSocket();
            
            String servidor = "localhost";
            int porta = 9876;
            
            InetAddress IPAddress = InetAddress.getByName(servidor);
            
            byte[] sendData;
            byte[] receiveData = new byte[1024];
            
            /*System.out.println("Digite o texto a ser enviado ao servidor: ");*/
            String sentence = "Solicitar horario";
            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, porta);
            
            System.out.println("Enviando pacote UDP para " + servidor + " : " + porta);
            clientSocket.send(sendPacket);
            
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            
            clientSocket.receive(receivePacket);
            System.out.println("Pacote UDP recebido...");
            
            String sentencaRecebida = new String(receivePacket.getData());
            controllerUDP.txtAreaHorario.setText(sentencaRecebida);
            
            System.out.println("Data recebido do servidor: " + sentencaRecebida);
            clientSocket.close();
            System.out.println("Socket cliente fechado!");
        } catch (IOException e) {
            e.printStackTrace();
        }//fim metodo catch
    }//fim metodo criarClientSocket
    
    public void setControlador(ClientControllerUDP control) {
        this.controllerUDP = control;
    }//fim metodo setControlador
    
}//fim classe Socket