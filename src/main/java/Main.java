import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String input = "input.txt";
        String output = "output.txt";
        //PLIK
        BufferedReader sensorReaderFromFile = new BufferedReader(new FileReader(input));
        BufferedWriter sensorWriterToFile = new BufferedWriter(new FileWriter(output));
        //KONSOLA
        BufferedReader sensorReaderFromConsole = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter sensorWriterToConsole = new BufferedWriter(new OutputStreamWriter(System.out));

        TimeSeriesDuplicatesRemoval.removeDuplicate(sensorReaderFromFile,sensorWriterToFile);
    }


}
