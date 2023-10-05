package socket.udp.single;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class server {
    public static int udpServerPort = 9999;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        byte []buffer = new byte[256];
        DatagramSocket ds = null;
        try{
            ds = new DatagramSocket(udpServerPort);
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
            System.out.println("> echo-server is activated");
            while(true){
                ds.receive(dp);
                String input = new String(dp.getData(),0,dp.getLength());
                if("quit".equalsIgnoreCase(input)) break;
                System.out.println("> client IP address" + dp.getAddress() + " with Port number"
                        + dp.getPort()+": "+input);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            ds.close();
        }
    }
}
