package ru.otus.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ClientHandler {
    private Socket socket;
    private Server server;
    private DataInputStream in;
    private DataOutputStream out;

    private String username;
    private static int userCount = 0;
    private Roles role;


    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());

        userCount++;
        username = "user" + userCount;
        role = Roles.USER;
        if(userCount == 1)
            role = Roles.ADMIN;

        new Thread(() -> {
            try {
                System.out.println("Клиент подключился " + socket.getPort());

                while (true) {
                    String message = in.readUTF();
                    if (message.startsWith("/")) {
                        if (message.equalsIgnoreCase("/exit")) {
                            sendMsg("/exitok");
                            break;
                        }
                        if(message.startsWith("/w")) {
                            int indexOfFirstSpace = message.indexOf(" ");
                            String nameAndMessage = message.substring(indexOfFirstSpace + 1);
                            int indexOfSecondSpace = nameAndMessage.indexOf(" ");
                            String user = nameAndMessage.substring(0, indexOfSecondSpace);
                            String messageForUser = nameAndMessage.substring(indexOfSecondSpace + 1);
                            server.broadcastPrivateMessage(user, "private message from " + username + " : " + messageForUser);
                        }
                        if(message.startsWith("/kick") && role == Roles.ADMIN) {
                            int indexOfSpace = message.indexOf(" ");
                            String userForKick = message.substring(indexOfSpace + 1);
                            server.kickUser(userForKick);
                        }
                    } else {
                        server.broadcastMessage(username + " : " + message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                disconnect();
            }
        }).start();
    }

    public void sendMsg(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void disconnect() {
        server.unsubscribe(this);
        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}
