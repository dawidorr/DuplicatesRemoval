import java.io.*;

public class TimeSeriesDuplicatesRemoval {
    public static void removeDuplicate() {
        BufferedReader sensorReader = null;
        BufferedWriter sensorWriter = null;
        try {
            String currentLine;
            int currentVoltage;
            int newVoltage;

            //From file
            sensorReader = new BufferedReader(new FileReader("input.txt"));
            //Write to file
            sensorWriter = new BufferedWriter(new FileWriter("output.txt"));
            //Read from console
//            InputStreamReader isr = new InputStreamReader(System.in);
            //Write to console
//            sensorWriter = new BufferedWriter(new OutputStreamWriter(System.out));

            PrintWriter sensorPrintWriter = new PrintWriter(sensorWriter);

            currentLine = sensorReader.readLine();
            sensorPrintWriter.println(currentLine);
            currentVoltage = GetVoltage.getVoltage(currentLine);
            sensorPrintWriter.flush();

            while ((currentLine = sensorReader.readLine()) != null ) {
                newVoltage = GetVoltage.getVoltage(currentLine);

                if(currentVoltage != newVoltage){
                    sensorPrintWriter.println(currentLine);
                    currentVoltage = newVoltage;
                    sensorPrintWriter.flush();
                }
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {
                if (sensorReader != null){
                    sensorReader.close();
                }
                if (sensorWriter != null){
                    sensorWriter.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

