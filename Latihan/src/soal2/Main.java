package soal2;

public class Main {

    public static void main(String[] args) {
        
        Mahasiswa mhs = new Mahasiswa();

        try {

            mhs.setSksMaksimal(30);

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }
    }
}