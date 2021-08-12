package parallelRun;

import java.sql.*;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.lang.reflect.*;

public class OracleConnection {
    private static final String USER = "system";
    private static final String PASSWORD = "midori";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DB = "C##DBADISUAT";

    public static List<DistributionLine> getDistributionLines(){
        List<DistributionLine> distributionList = new ArrayList<>();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
            Statement statement = con.createStatement();
            ResultSet queryResults = statement.executeQuery("select * from "+DB+".PARALLEL_RUN_DATA fetch first 200 rows only;");

            List<Field> fields = Arrays.asList(DistributionLine.class.getDeclaredFields());
            for(Field field: fields) {
                field.setAccessible(true);
            }
            while(queryResults.next()) {
                DistributionLine aDistributionLine = DistributionLine.class.getConstructor().newInstance();
                for(Field field: fields) {
                    String name = field.getName();
                    try{
                        String value = queryResults.getString(name);
                        field.set(aDistributionLine, field.getType().getConstructor(String.class).newInstance(value));
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                distributionList.add(aDistributionLine);
            }
            con.close();
        } catch(Exception e){
            System.out.println(e);
        }
        return distributionList;
    }

    public static void displayRunData(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
            Statement statement = con.createStatement();
            ResultSet queryResults = statement.executeQuery("select * from "+DB+".PARALLEL_RUN_DATA fetch first 200 rows only");
            while(queryResults.next())
                System.out.println(queryResults.getInt(1)+"  "+queryResults.getString(2)+"  "+queryResults.getString(3));
            con.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public static void displayRunDataOlm(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
            Statement statement = con.createStatement();
            ResultSet queryResults = statement.executeQuery("select * from "+DB+".PARALLEL_RUN_DATA_OLM fetch first 200 rows only");
            while(queryResults.next())
                System.out.println(queryResults.getInt(1)+"  "+queryResults.getString(2)+"  "+queryResults.getString(3));
            con.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public static void displayParallelRunExtraction(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
            Statement statement = con.createStatement();
            ResultSet queryResults = statement.executeQuery("select * from "+DB+".PARALLEL_RUN_EXTRACTION fetch first 200 rows only;");
            while(queryResults.next())
                System.out.println(queryResults.getInt(1)+"  "+queryResults.getString(2)+"  "+queryResults.getString(3));
            con.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public static void displayRunFileCmp(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","midori");
            Statement statement = con.createStatement();
            ResultSet queryResults = statement.executeQuery("select * from "+DB+".PARALLEL_RUN_FILE_CMP fetch first 200 rows only");
            while(queryResults.next())
                System.out.println(queryResults.getInt(1)+"  "+queryResults.getString(2)+"  "+queryResults.getString(3));
            con.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public static void displayRunFileStats(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","midori");
            Statement statement = con.createStatement();
            ResultSet queryResults = statement.executeQuery("select * from "+DB+".PARALLEL_RUN_FILE_STATS fetch first 200 rows only");
            while(queryResults.next())
                System.out.println(queryResults.getInt(1)+"  "+queryResults.getString(2)+"  "+queryResults.getString(3));
            con.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
