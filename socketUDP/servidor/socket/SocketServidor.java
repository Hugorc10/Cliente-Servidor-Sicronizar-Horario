package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SocketServidor extends Thread {
//    public static boolean stop = false;
    
    public void run() {
        try {
            int porta = 9876;
            
            DatagramSocket serverSocket = new DatagramSocket(porta);
            
            byte[] receiveData = new byte[1024];
            byte[] sendData;
            
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                System.out.println("Esperando por datagrama UDP na porta " + porta);
                serverSocket.receive(receivePacket);
                
                System.out.println("Datagrama UDP recebido...");
    
                InetAddress IPAddress = receivePacket.getAddress();
                
                int port = receivePacket.getPort();
                
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
                
                String horas = sdf.format(new Date());
                
                sendData = horas.getBytes();
                
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                
                System.out.println("Enviando " + horas + "...");
                
                serverSocket.send(sendPacket);
                System.out.println("Final do while");
            } //fim while
        } catch (IOException e) {
            e.printStackTrace();
        } //fim metodo catch
    } //fim metodo run
} //fim classe SocketServidor