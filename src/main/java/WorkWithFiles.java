import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WorkWithFiles {
    public static void writePrizeToy(Object object, String text) {
        if (object != null)
            try (
                    FileWriter writer = new FileWriter("prizeToys.txt", true)) {
                writer.write(object + text + "\n");
                writer.flush();
            } catch (
                    IOException ex) {
                System.out.println(ex.getMessage());
            }
    }

    public ArrayList<String> readLinesToArrayList(){
        ArrayList<String> data = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("toysPool.csv")))
        {
            String s;
            while((s=br.readLine())!=null){
                data.add(s);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return data;
    }

    public static void write(String text, String filename) {
        if (text != null)
            try (
                    FileWriter writer = new FileWriter(filename, false)) {
                writer.write(text + "\n");
                writer.flush();
            } catch (
                    IOException ex) {
                System.out.println(ex.getMessage());
            }
    }

}
