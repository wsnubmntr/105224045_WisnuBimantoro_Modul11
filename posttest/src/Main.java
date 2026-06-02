public class Main {

    public static void main(String[] args) {

        // buat dua objek rekening
        AkunBank rekeningA =
                new AkunBank("092831728", 5000000);

        AkunBank rekeningB =
                new AkunBank("088818129", 2000000);

        try {

            System.out.println("=== TRANSAKSI 1 ===");

            // menghabisin saldo rekening A
            rekeningA.tarikTunai(5000000);

            System.out.println();

            System.out.println("=== TRANSAKSI 2 ===");

            // nyoba transfer melebihi saldo
            rekeningA.transfer(rekeningB, 12000000);

        }

        // menanganin error saldo tidak cukup
        catch (SaldoTidakMencukupiException e) {

            System.out.println("ERROR SALDO");
            System.out.println(e.getMessage());

            System.out.println(
                    "Kekurangan saldo : Rp"
                    + e.getKekuranganSaldo());

        }

        // menanganin error limit transfer
        catch (BatasTransferHarianException e) {

            System.out.println("ERROR LIMIT TRANSFER");
            System.out.println(e.getMessage());

        }

        // selalu dijalankan
        finally {

            System.out.println();

            System.out.println(
                    "Sesi transaksi ATM Anda telah diakhiri. "
                    + "Kartu dikeluarkan otomatis.");
        }
    }
}