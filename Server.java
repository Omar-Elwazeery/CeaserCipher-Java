import java.net.*;
import java.io.*;

public class Server
{
    //initialize socket and input stream
    public Socket		 socket = null;
    public ServerSocket server = null;
    public DataInputStream in	 = null;
    String line = "";
    String[] arr = new String[26];
    // constructor with port
    public Server(int port)
    {

        // starts server and waits for a connection
        try {

            server = new ServerSocket(port);


            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            socket = server.accept();

            System.out.println("Client accepted");


            // takes input from the client socket
            in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));

            line = "";


            // reads message from client until "Over" is sent
            while (line.equals("Attack"))
            {
                System.out.println(methods.BurteForce(line));
            }
            while (!line.equals("Over"))
            {
                try
                {
                    line = in.readUTF();
                    line=line.replaceAll("\\s","");
                    System.out.println(methods.encrypt(line,3));
                    //  System.out.println(methods.decrypt(line,3));


                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }

            System.out.println("Closing connection");


            // close connection
            socket.close();
            in.close();

        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    public static void main(String args[])
    {
        Server server = new Server(500);
    }
}
