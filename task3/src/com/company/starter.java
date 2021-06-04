package com.company;

import java.util.Scanner;

public class starter
{
    public static void main (String []args )
    {
        Scanner scan = new Scanner(System.in);
        if(scan.next().equals("server"))
        {
            scan.close();
            //code for the server
             Server ss= new Server();
        }
        else
        {
            scan.close();
            // code for the client
            Client cc = new Client();
        }
    }
}
