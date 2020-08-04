import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SimpleHTTPServer {
    public static void main(String[] args) throws IOException {
        // Creating a network socket
        final ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080 ....");

        while(true) {
            // spin forever
            try(Socket socket = server.accept()){
                // Read HTTP Request (GET) from client
                InputStreamReader inputReader = new InputStreamReader(socket.getInputStream());
                // Using BufferedReader because will send multiple times
                BufferedReader reader = new BufferedReader(inputReader);
                String line = reader.readLine();
                while(!line.isEmpty()) {
                    System.out.println(line);
                    line = reader.readLine();
                    // Read upto Cookie
                    if(line.contains("Cookie:")) {
                        System.out.println(line);
                        break;
                    }
                }
                // Prepare and Send the HTTP response
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
                socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
            }
        }
    }
}
