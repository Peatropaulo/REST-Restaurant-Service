import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public StringBuffer post() throws IOException {
        String inputLine="";
        StringBuffer content=new StringBuffer();
        int status = 415;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the url you are trying to connect to without any extensions");
        URL url = new URL(scanner.next());
        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestMethod("POST");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            System.out.println("Enter your name");
            String username = scanner.next();
            System.out.println("Enter your Street");
            String Street = scanner.next()+scanner.next()+scanner.next();
            scanner.nextLine();
            System.out.println("Enter your City");
            String City = scanner.nextLine();
            System.out.println("Enter your two character state");
            String State = scanner.next();
            OutputStream os = con.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
            osw.write("{\n" +
                    "\t\"id\":\""+username+"\",\n" +
                    "\t\"City\": \""+City+"\",\n" +
                    "\t\"State\": \""+State+"\",\n" +
                    "\t\"Street\":\""+Street+"\"\n" +
                    "\t\n" +
                    "\t\n" +
                    "}");
            osw.flush();
            osw.close();
            os.close();  //dosn't forget to close the OutputStream
            con.connect();

            con.disconnect();
            status = con.getResponseCode();

        }
        catch (IOException e) {
            System.out.println("Your response returned with and error " +e.getMessage());
            return new StringBuffer();
        }
        System.out.println("Your response returned with code "+status);
        return content;

    }

    public StringBuffer get() throws IOException {
        String inputLine="";
        StringBuffer content=new StringBuffer();
        int status = 415;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the url you are trying to connect to");
        URL url = new URL(scanner.next());



        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
            status = con.getResponseCode();
        }
        catch (IOException e) {
            System.out.println("Your response returned with and error code" +e.getMessage());
            return new StringBuffer();
        }
        System.out.println("Your response returned with code "+status);
        return content;
    }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        while (true){
            System.out.println("Would you like to get,post, or exit to our web api test. Please Type \"Get, Post, or Quit\"");
            String option = scanner.next();
            if(option.compareToIgnoreCase("Quit")==0)
                break;
            if(option.compareToIgnoreCase("Post")==0) {
                try {
                    System.out.println(main.post());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(option.compareToIgnoreCase("Get")==0) {
                try {
                    System.out.println(main.get());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
