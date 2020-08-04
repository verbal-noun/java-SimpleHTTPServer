import java.net.ServerSocket;

public class SimpleHTTPServer {
    public static void main(String[] args) throws Exception {
        // Creating a network socket
        final ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080 ....");
        while(true) {
            // spin forever
        }
    }
}
