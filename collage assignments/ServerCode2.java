import java.io.*;
import java.net.*;

public class ServerCode2 {
ServerSocket ss;
Socket socket;
BufferedReader sock_in,kdb_in;
PrintWriter sock_out;
String str;
    public ServerCode2()
    {
    try{
        ss=new ServerSocket(8765);
        System.out.println("Server is listening port 8765");
        socket=ss.accept();
        System.out.println("Connection established...");
        kdb_in=new BufferedReader(new InputStreamReader(System.in));
        sock_in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        sock_out=new PrintWriter(socket.getOutputStream());
        while(true)
        {
        System.out.println("Msg from client");
        str=sock_in.readLine();
        int k=str.length();
        System.out.println(str);
        int left=0,right=k-1;
        int flag=1;
        while(left<=right)
        {
            if(str.charAt(left)!=(str.charAt(right)))
            {
                flag=0;
                break;
            }
            else
            {
                left++;right--;
            }
        }
        if(flag==1)
            str="....Palindrome....";
        else
            str="....Not Palindrome....";
        sock_out.println(str);
        sock_out.flush();
        if(str.equals("bye"))
            break;
        }
    }catch (Exception e) { }
    }
public static void main(String arg[])
{
    new ServerCode2();
}}