import java.io.*;

public class TimeSeriesDuplicatesRemoval {
    public static void removeDuplicate(BufferedReader sensorReader, BufferedWriter sensorWriter) {

        try {
            String currentLine;
            int currentVoltage;
            int newVoltage;

            PrintWriter sensorPrintWriter = new PrintWriter(sensorWriter);

            currentLine = sensorReader.readLine();
            sensorPrintWriter.println(currentLine);
            currentVoltage = GetVoltage.getVoltageFromString(currentLine);
            sensorPrintWriter.flush();

            while ((currentLine = sensorReader.readLine()) != null ) {
                newVoltage = GetVoltage.getVoltageFromString(currentLine);

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

