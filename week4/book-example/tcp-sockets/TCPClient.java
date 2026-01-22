import java.io.*;
import java.net.*;

public class TCPClient {

    private static String HOST = "localhost";
    private static int PORT = 8081;

    public static void main(String argv[]) throws Exception
    {
        String sentence;
        String modifiedSentence;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket(HOST, PORT); // Starter TCP-forbindelsen
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        sentence = inFromUser.readLine();
        outToServer.writeBytes(sentence + '\n'); // Sender data til server
        modifiedSentence = inFromServer.readLine(); // Mottar svar fra server
        System.out.println("FROM SERVER:" + modifiedSentence);
        clientSocket.close(); // lukker forbindelsen
    }
}
