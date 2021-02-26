package vop.threadedtcp.requesthandlers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class FileOutRequestHandler extends AbstractRequestHandler{
private File outfile;

    public FileOutRequestHandler(Socket socket, String fileName) {
        super(socket);
        this.outfile = new File(fileName);
    }

    @Override
    public void run() {
        try (Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter writeToFile = new PrintWriter(new FileWriter(outfile, true), true);
            PrintWriter writeToClient = new PrintWriter(socket.getOutputStream(),true)) {
            writeToClient.println("Server ready. Type your message: ");

            while (scanner.hasNextLine()) {
                String gotString = scanner.nextLine();
                writeToFile.println(new Date() + "\t" + socket.getInetAddress()
                        + ":" + "\t" + socket.getPort() + "\t" + gotString);

                writeToClient.println(gotString + "\t" + " written to log!");
                }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Request handler closing");
    }

}
