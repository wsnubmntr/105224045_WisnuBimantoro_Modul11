public class SaldoTidakMencukupiException extends Exception {

    // simpen nominal kekurangan saldo
    private double kekuranganSaldo;

    public SaldoTidakMencukupiException(String pesan,
                                        double kekuranganSaldo) {
        super(pesan);
        this.kekuranganSaldo = kekuranganSaldo;
    }

    // balikin jumlah saldo yang kurang
    public double getKekuranganSaldo() {
        return kekuranganSaldo;
    }
}