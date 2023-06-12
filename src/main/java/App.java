import java.util.Random;

public class App {
    PrizeToysDraw prizeToysDraw;
    String dataFile = "toysPool.csv";

    public App() {
        prizeToysDraw = new PrizeToysDraw();
    }

    public void prizeDraw(int count) {
        for (int i = 0; i < count; i++) {
            prizeToysDraw.dropPrizeToy();
            WorkWithFiles.writePrizeToy(prizeToysDraw.getPrizeToy(),
                    " | выпало " + prizeToysDraw.getDropRate());
            save("afterDraw" + dataFile);
        }
    }

    public void addRandomToys() {
        Random rnd = new Random();
        for (int i = 0; i < 5; i++) {
            prizeToysDraw.addToy(new Toy(getToyName(), rnd.nextInt(1, 5), rnd.nextInt(1, 101)));
        }
        save("beforeDraw" + dataFile);
    }

    private void save(String filename) {
        WorkWithFiles.write(prizeToysDraw.toStringCsv(), filename);
    }

    private static String getToyName() {
        return ToysNames.values()[new Random().nextInt(ToysNames.values().length)].toString();
    }
}
