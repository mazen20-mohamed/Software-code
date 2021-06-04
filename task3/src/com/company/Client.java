package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client
{
    Client()
    {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println(ip);
            Socket other = new Socket(ip,22000);
            Scanner ss = new Scanner (System.in);
            DataOutputStream otherwrite = new DataOutputStream(other.getOutputStream());
            DataInputStream otherread = new DataInputStream(other.getInputStream());
            String str="";
            while(true)
            {
                str = otherread.readUTF();
                System.out.println(str);
                str = otherread.readUTF();
                System.out.println(str);

                str = ss.nextLine();
                otherwrite.writeUTF(str);
                if(str.equalsIgnoreCase("exit"))
                {
                    break;
                }
                str = otherread.readUTF();
                System.out.println(str);
            }
            otherread.close();
            otherwrite.close();
            other.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE,null,ex);
        }

    }
}
