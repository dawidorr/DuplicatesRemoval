public class GetVoltage {
    public static int getVoltageFromString(String str){
        String[] splits = str.split(":");
        return Integer.parseInt(splits[1].trim());
    }
}
