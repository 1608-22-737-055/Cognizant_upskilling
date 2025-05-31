// TCP Client-Server Chat Example
import java.io.*;
import java.net.*;

class ChatServer implements Runnable {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);
            System.out.println("Waiting for client...");
            clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            Thread serverThread = new Thread(this);
            serverThread.start();

            // Read server input and send to client
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));
            String serverMessage;
            while ((serverMessage = serverInput.readLine()) != null) {
                out.println("Server: " + serverMessage);
            }

        } catch (IOException e) {
            System.out.println("Server Exception: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException e) {
            System.out.println("Server Exception: " + e.getMessage());
        }
    }

    public void stop() {
        try {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Error closing server: " + e.getMessage());
        }
    }
}

class ChatClient implements Runnable {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            Thread clientThread = new Thread(this);
            clientThread.start();

            // Read client input and send to server
            BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));
            String clientMessage;
            while ((clientMessage = clientInput.readLine()) != null) {
                out.println("Client: " + clientMessage);
            }

        } catch (IOException e) {
            System.out.println("Client Exception: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException e) {
            System.out.println("Client Exception: " + e.getMessage());
        }
    }

    public void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Error closing client: " + e.getMessage());
        }
    }
}

public class Ex35 {
    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("server")) {
            ChatServer server = new ChatServer();
            server.start(5000);
        } else {
            ChatClient client = new ChatClient();
            client.startConnection("127.0.0.1", 5000);
        }
    }
}
