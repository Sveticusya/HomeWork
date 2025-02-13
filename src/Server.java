import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {

    private static ServerSocket server;
    public static LinkedList<ServerThread> serverClients = new LinkedList<>();

    public static void main(String[] args) throws IOException {
                server = new ServerSocket(4004);
                System.out.println("Сервер запущен!");
                try {
                    while(true) {
                        serverClients.add(new ServerThread(server.accept()));
                    }
                }
                finally {
                    server.close();
                }
    }
}