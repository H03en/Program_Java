package clientchat;

import java.io.*;
import java.net.*;

public class Clientchat {
    public static void main(String[] args) throws Exception
    {
        Socket sock=new Socket("127.0.0.1", 3000);
        BufferedReader keyread=new BufferedReader(new InputStreamReader(System.in));//Give Input Az User
        OutputStream ostrem=sock.getOutputStream();//sent data
        PrintWriter pwrite=new PrintWriter(ostrem,true);// Show Msg Send
        InputStream instrem=sock.getInputStream();///Resive data
        BufferedReader resread=new BufferedReader(new InputStreamReader(instrem));// Show Msg Resev On Server
        System.out.println("Start The Chat Press Chat");
        String resmsg,senmsg;// 
        while(true)
        {
            senmsg=keyread.readLine();//Send Msg For Server
            pwrite.print(senmsg);// Print Msg send
            pwrite.flush();//
            if((resmsg=resread.readLine())!= null)
            {
                System.out.println(resmsg);
            }
        }
    }    
}
