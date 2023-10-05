package socket.udp.single;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class client {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket ds = null;
        DatagramPacket dp;
        byte []buffer;
        try{
            ds = new DatagramSocket(3333);
            while (true) {
                InetAddress ia = InetAddress.getByName("127.0.0.1");
                System.out.print(">");
                String message = in.readLine();
                if("quit".equalsIgnoreCase(message)) break;;
                buffer = message.getBytes();
                dp = new DatagramPacket(buffer, buffer.length, ia, 9999);
                ds.send(dp);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            ds.close();
        }
    }
}
