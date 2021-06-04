package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server
{
    Server()
    {
        try
        {
            ServerSocket ser = new ServerSocket(22000);
            while(true)
            {
                Socket client = ser.accept();
                DataInputStream clientread = new DataInputStream (client.getInputStream());
                DataOutputStream clientwrite = new DataOutputStream(client.getOutputStream());
                while(true)
                {
                    clientwrite.writeUTF("You are connected but not for long");
                    clientwrite.writeUTF("You can ask me once");
                    String st = clientread.readUTF();
                    System.out.println("Client said: "+ st);
                    if(st.equalsIgnoreCase("exit"))
                    {
                        break;
                    }
                    clientwrite.writeUTF("We do not have any services right now , GOOD BYE :)");
                }
                clientread.close();
                clientwrite.close();
                client.close();
            }
        }
        catch (IOException ex)
        {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
