package clientchat;

import java.io.*;
import java.net.*;

public class Chatserver 
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket sersock=new ServerSocket(3000);
        System.out.println("Server Is Ready For Chat");
        Socket sock=sersock.accept();
        BufferedReader keyread=new BufferedReader(new InputStreamReader(System.in));
        //Send To Client
        OutputStream ostrem=sock.getOutputStream();
        PrintWriter pwrit=new PrintWriter(ostrem,true);
        // Resive Az Client
        InputStream instrem=sock.getInputStream();
        BufferedReader resread=new BufferedReader(new InputStreamReader(instrem));
        String resmsg,senmsg;
        while(true)
        {
            if((resmsg=resread.readLine())!= null)
            {
                System.out.println(resmsg);
            }
            senmsg=keyread.readLine();
            pwrit.println(senmsg);
            pwrit.flush();
        }
    }
}
