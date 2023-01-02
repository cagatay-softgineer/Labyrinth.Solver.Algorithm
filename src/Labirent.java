import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Labirent {
    private static final int DUVAR = 0;
    private static final int YOL = 1;
    private static final int BASLANGIC = 2;
    private static final int BITIS = 3;
    private static final int COZUMYOLU = 4;
    public static int bitx,bity,basx,basy;
    public static String resultPart;
    public static int[][] labirent;
    private boolean[][] gecildi;
    private Kordinat baslangic;
    private Kordinat bitis;

    //labirent.txt Dosyasını String Değerinde Yazma
    public Labirent(File labirent) throws FileNotFoundException {
        String fileText1 = "";
        try (Scanner input = new Scanner(labirent)) {
            while (input.hasNextLine()) {
                fileText1 += input.nextLine() + "\n";
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Labirent dosyası Bulunamadı!");
            System.exit(0);
        }
        //Labirentin Başlangıcı Belirleme
        String fileText = fileText1.replaceFirst("1", "2");

        initializeMaze(fileText);
    }

    //Labirenti İşleme, Hata Varsa Bulma
    private void initializeMaze(String text) {
        if (text == null || (text = text.trim()).length() == 0) {
            throw new IllegalArgumentException("boş satır var");
        }

        String[] lines = text.split("[\r]?\n");
        labirent = new int[lines.length][lines[0].length()];
        gecildi = new boolean[lines.length][lines[0].length()];


        for (int row = 0; row < getHeight(); row++) {
            if (lines[row].length() != getWidth()) {
                throw new IllegalArgumentException((row + 1) + ". satırın uzunluğu geçersiz(" + lines[row].length() + ") satırın uzunluğu " + getWidth() + " olabilir");
            }

            for (int col = 0; col < getWidth(); col++) {
                if (lines[row].charAt(col) == '0')
                    labirent[row][col] = DUVAR;
                else if (lines[row].charAt(col) == '2') {
                    labirent[row][col] = BASLANGIC;
                    baslangic = new Kordinat(row, col);
                    basx=row;
                    basy=col;
                } else if (lines[row].charAt(col) == '9') {
                    labirent[row][col] = BITIS;
                    bitis = new Kordinat(row, col);
                    bitx=row;
                    bity=col;
                } else
                    labirent[row][col] = YOL;
            }
        }
    }

    public int getHeight() {
        return labirent.length;
    }

    public int getWidth() {
        return labirent[0].length;
    }

    public Kordinat getEntry() {
        return baslangic;
    }

    public Kordinat getExit() {
        return bitis;
    }

    //Çıkışı Kontrol Etme
    public boolean isExit(int x, int y) {
        return x == bitis.getX() && y == bitis.getY();
    }

    //Başlangıcı Kontrol Etme
    public boolean isStart(int x, int y) {
        return x == baslangic.getX() && y == baslangic.getY();
    }

    //Yoldan Geçip Geçmediğimizi Kontrol Etme
    public boolean isExplored(int row, int col) {
        return gecildi[row][col];
    }

    //Duvar İşaretleme
    public boolean isWall(int row, int col) {
        return labirent[row][col] == DUVAR;
    }

    //Geçtiğimiz Yolları İşaretleme
    public void setVisited(int row, int col, boolean value) {
        gecildi[row][col] = value;
    }

    //Kontrol Ettiğimiz İndeks Var Mı, Yok Mu Kontrolü
    public boolean isValidLocation(int row, int col) {
        if (row < 0 || row >= getHeight() || col < 0 || col >= getWidth()) {
            return false;
        }
        return true;
    }

    //Labirent çözümünü yazma
    public void printPath(List<Kordinat> path) {
        int[][] tempMaze = Arrays.stream(labirent)
                .map(int[]::clone)
                .toArray(int[][]::new);
        for (Kordinat kordinat : path) {
            if (isStart(kordinat.getX(), kordinat.getY()) || isExit(kordinat.getX(), kordinat.getY())) {
                continue;
            }
            tempMaze[kordinat.getX()][kordinat.getY()] = COZUMYOLU;
        }
        System.out.println(toString(tempMaze));
    }

    //Labirentin çözümünü labirent şeklinde yazdırma işlemi
    public String toString(int[][] labirent) {
        StringBuilder result = new StringBuilder(getWidth() * (getHeight() + 1));
        for (int row = 0; row < getHeight(); row++) {
            for (int col = 0; col < getWidth(); col++) {
                if (labirent[row][col] == YOL) {
                    result.append(' ');
                } else if (labirent[row][col] == DUVAR) {
                    result.append(' ');
                } else if (labirent[row][col] == BASLANGIC) {
                    result.append('1');
                } else if (labirent[row][col] == BITIS) {
                    result.append('9');
                } else if (labirent[row][col] == COZUMYOLU) {
                    result.append('1');
                } else {
                    result.append(' ');
                }
            }
            result.append('\n');
        }
        resultPart = String.valueOf(result);
        return result.toString();

    }

    //Labirenti Sıfırlama
    public void reset() {
        for (int i = 0; i < gecildi.length; i++)
            Arrays.fill(gecildi[i], false);
    }

    public static void main(String[] args) throws Exception {

        File labirent1 = new File("src/labirent.txt");


        try {
            calistir(labirent1);
            String[] values = resultPart.split("\n");
            if(values[(basx+bitx)/2].contains("1")){
                System.out.println("Labirent Çözüldü!");
            }
            else{
                System.out.println("Labirent Çözülemedi!");
            }
        } catch (NullPointerException e) {
            System.out.println("Labirent Çözülemedi!");
        }
    }

    private static void calistir(File file) throws Exception {
        Labirent labirent1 = new Labirent(file);
        coz(labirent1);
    }

    private static void coz(Labirent labirent) {
        CozumAlgoritmasi coz = new CozumAlgoritmasi();
        List<Kordinat> path = coz.solve(labirent);
        labirent.printPath(path);
        labirent.reset();
    }

}
