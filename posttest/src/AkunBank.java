public class AkunBank {

    private String nomorRekening;
    private double saldo;
    private double totalTransferHarian;

    // limit transfer harian
    private final double LIMIT_TRANSFER = 10000000;

    public AkunBank(String nomorRekening, double saldo) {
        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
        this.totalTransferHarian = 0;
    }

    // method untuk tarik tunai
    public void tarikTunai(double nominal)
            throws SaldoTidakMencukupiException {

        // ngecek apakah saldo cukup
        if (nominal > saldo) {

            double kurang = nominal - saldo;

            throw new SaldoTidakMencukupiException(
                    "Saldo tidak mencukupi untuk penarikan.",
                    kurang);
        }

        saldo -= nominal;

        System.out.println("Tarik tunai berhasil.");
        System.out.println("Sisa saldo : Rp" + saldo);
    }

    // method transfer antar rekening
    public void transfer(AkunBank tujuan, double nominal)
            throws SaldoTidakMencukupiException,
                   BatasTransferHarianException {

        // ngecek saldo
        if (nominal > saldo) {

            double kurang = nominal - saldo;

            throw new SaldoTidakMencukupiException(
                    "Saldo tidak mencukupi untuk transfer.",
                    kurang);
        }

        // ngecek limit transfer harian
        if (totalTransferHarian + nominal > LIMIT_TRANSFER) {

            throw new BatasTransferHarianException(
                    "Transfer melebihi batas harian Rp10.000.000");
        }

        saldo -= nominal;
        tujuan.saldo += nominal;
        totalTransferHarian += nominal;

        System.out.println("Transfer berhasil.");
        System.out.println("Tujuan : " + tujuan.nomorRekening);
        System.out.println("Nominal : Rp" + nominal);
    }

    public double getSaldo() {
        return saldo;
    }
}