// A Java program for a Client
import java.net.*;
import java.io.*;

public class Client {
    // initialize socket and input output streams
    public Socket socket = null;
    public DataInputStream input = null;
    public  DataOutputStream out = null;
    String line = "";
    boolean keepgoing=true;
    // constructor to put ip address and port
    public Client(String address, int port) {

        // establish a connection
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            input = new DataInputStream(System.in);

            // sends output to the socket

            out = new DataOutputStream(socket.getOutputStream());
        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException i) {
            System.out.println(i);
        }

        // string to read message from input
        line = "";

        // keep reading until "Over" is input
        while (!line.equals("Over")) {
            try {
                line = input.readLine();
                out.writeUTF(line);
            } catch (IOException i) {
                System.out.println(i);
            }
        }

        // close the connection
        try {
            input.close();
            out.close();
            socket.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }


    public static void main(String args[])
    {

        Client client = new Client("127.0.0.1", 500);

    }
}



