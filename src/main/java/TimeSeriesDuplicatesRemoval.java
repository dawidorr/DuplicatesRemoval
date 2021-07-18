import java.io.*;

public class TimeSeriesDuplicatesRemoval {
    public static void removeDuplicate(String input, String output) {
        BufferedReader sensorReader = null;
        BufferedWriter sensorWriter = null;
        try {
            String currentLine;
            int currentVoltage;
            int newVoltage;


            sensorReader = new BufferedReader(new FileReader(input));
            sensorWriter = new BufferedWriter(new FileWriter(output));
            PrintWriter sensorPrintWriter = new PrintWriter(sensorWriter);

            currentLine = sensorReader.readLine();
            sensorPrintWriter.println(currentLine);
            currentVoltage = GetVoltage.getVoltage(currentLine);

            while ((currentLine = sensorReader.readLine()) != null) {
                newVoltage = GetVoltage.getVoltage(currentLine);

                if(currentVoltage != newVoltage){
                    sensorPrintWriter.println(currentLine);
                    currentVoltage = newVoltage;
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

