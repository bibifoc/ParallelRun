package parallelRun;

import java.lang.reflect.Field;
import java.util.List;

public class ParallelRunMain {

    public static void main(String[] args) {
        System.out.println("Start...");
        //OracleConnection.displayParallelRunExtraction();
        OracleConnection.displayRunData();
        //OracleConnection.displayRunDataOlm();

        //List<DistributionLine> distributionList = OracleConnection.getDistributionLines();
        //for(DistributionLine distributionline: distributionList) {
        //    distributionline.testDisplay();
        //}
    }
}
