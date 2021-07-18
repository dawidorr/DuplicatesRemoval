import org.junit.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Test {
    @org.junit.Test
    public void checkGetVoltage(){
        String test = "1615560000: 1";

        int expectedVoltage = 1;

        int currentVoltage = GetVoltage.getVoltage(test);

        Assert.assertEquals(expectedVoltage,currentVoltage);

    }

    @org.junit.Test
    //Test with input from file and output to file
    public void checkOutputSample() throws IOException {

        TimeSeriesDuplicatesRemoval.removeDuplicate();


        List<String> file1 = Files.readAllLines(Paths.get("output.txt"));
        List<String> file2 = Files.readAllLines(Paths.get("outputExpected.txt"));

        Assert.assertEquals(file1.size(), file2.size());

        for(int i = 0; i < file1.size(); i++) {
            Assert.assertEquals(file1.get(i), file2.get(i));
        }
    }
}
