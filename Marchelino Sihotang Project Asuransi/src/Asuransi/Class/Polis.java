package Asuransi.Class;

import Asuransi.Enum.FrekuensiTagihan;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Polis {
    private Nasabah nasabahTertanggungPolis;
    private Kendaraan kendaraanTertanggung;
    private Product product;
    private LocalDate tanggalMulaiPolis;

    public Polis() {
    }
    public Polis(Nasabah nasabahTertanggungPolis,Product product,LocalDate tanggalMulaiPolis){
        this.nasabahTertanggungPolis = nasabahTertanggungPolis;
        this.product = product;
        this.tanggalMulaiPolis = LocalDate.now();
    }
    public Polis(Nasabah nasabahTertanggungPolis,Product product){
        this.nasabahTertanggungPolis = nasabahTertanggungPolis;
        this.product = product;
        this.tanggalMulaiPolis = LocalDate.now();
    }
    public Polis(Kendaraan kendaraanTertanggung, Product product){
        this.kendaraanTertanggung = kendaraanTertanggung;
        this.product = product;
        this.tanggalMulaiPolis = LocalDate.now();
    }

    public Polis(Nasabah nasabahTertanggungPolis, Kendaraan kendaraanTertanggung, Product product, LocalDate tanggalMulaiPolis) {
        this.nasabahTertanggungPolis = nasabahTertanggungPolis;
        this.kendaraanTertanggung = kendaraanTertanggung;
        this.product = product;
        this.tanggalMulaiPolis = LocalDate.now();
    }

    public void printPolis(){
        if (this.kendaraanTertanggung == null){
            System.out.println("========================POLICY INFO==================================");
            System.out.println("Tertanggung: "+getNasabahTertanggungPolis().getProspect().getFirstName()+" "+getNasabahTertanggungPolis().getProspect().getLastName());
            System.out.println("Product: "+getProduct().getNamaProduk());
            System.out.println("Tanggal Mulai Dijalankan: "+ formatTanggal(getTanggalMulaiPolis()));
            System.out.println("Manfaat: "+ getProduct().getManfaat());
            System.out.println("=====================================================================");
            System.out.println("========================== PAYMENT ==================================");
            System.out.println(formatTanggal(getTanggalMulaiPolis())+", "+ currencyIndo((int) getProduct().getIuran()));
            if (this.product.getFrekuensi().equals(FrekuensiTagihan.BULANAN)){
                System.out.println(formatTanggal(getTanggalMulaiPolis().plusMonths(1))+", "+ currencyIndo((int) getProduct().getIuran()));
                System.out.println(formatTanggal(getTanggalMulaiPolis().plusMonths(2))+", "+ currencyIndo((int) getProduct().getIuran()));
                System.out.println("=====================================================================");
                System.out.println("\n");
            } else {
                System.out.println(formatTanggal(getTanggalMulaiPolis().plusYears(1))+", "+ currencyIndo((int) getProduct().getIuran()));
                System.out.println(formatTanggal(getTanggalMulaiPolis().plusYears(2))+", "+ currencyIndo((int) getProduct().getIuran()));
                System.out.println("=====================================================================");
                System.out.println("\n");
            }
        } else {
            System.out.println("========================POLICY INFO==================================");
            System.out.println("Product: "+getProduct().getNamaProduk());
            System.out.println("Tanggal Mulai Dijalankan: "+ formatTanggal(getTanggalMulaiPolis()));
            System.out.println("Jenis Kendaraan: "+getKendaraanTertanggung().getJenisKendaraan());
            System.out.println("Nomor Polisi: "+getKendaraanTertanggung().getNomorPolisi());
            System.out.println("Nomor STNK: "+getKendaraanTertanggung().getNomorSTNK());
            System.out.println("Merk Kendaraan: "+getKendaraanTertanggung().getMerk());
            System.out.println("Model Kendaraan: "+getKendaraanTertanggung().getModel());
            System.out.println("Warna Kendaraan: "+getKendaraanTertanggung().getWarna());
            System.out.println("=====================================================================");
            System.out.println("========================== PAYMENT ==================================");
            System.out.println(formatTanggal(getTanggalMulaiPolis())+", "+ currencyIndo((int) getProduct().getIuran()));
            System.out.println(formatTanggal(getTanggalMulaiPolis().plusYears(1))+", "+ currencyIndo((int) getProduct().getIuran()));
            System.out.println(formatTanggal(getTanggalMulaiPolis().plusYears(2))+", "+ currencyIndo((int) getProduct().getIuran()));
            System.out.println("=====================================================================");
            System.out.println("\n");
        }
    }
    public String formatTanggal (LocalDate localDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy",new Locale("id","ID"));
        return localDate.format(formatter);
    }

    @Override
    public String toString() {
        return "Polis{" +
                "nasabahTertanggungPolis=" + nasabahTertanggungPolis.toString() +
                ", kendaraanTertanggung=" + kendaraanTertanggung +
                ", product=" + product +
                ", tanggalMulaiPolis=" + tanggalMulaiPolis +
                '}';
    }

    public static String currencyIndo(int value){
        String result = NumberFormat.getCurrencyInstance(new Locale("id","ID")).format(Integer.valueOf(value));
        return result;
    }
    public Nasabah getNasabahTertanggungPolis() {
        return nasabahTertanggungPolis;
    }

    public void setNasabahTertanggungPolis(Nasabah nasabahTertanggungPolis) {
        this.nasabahTertanggungPolis = nasabahTertanggungPolis;
    }

    public Kendaraan getKendaraanTertanggung() {
        return kendaraanTertanggung;
    }

    public void setKendaraanTertanggung(Kendaraan kendaraanTertanggung) {
        this.kendaraanTertanggung = kendaraanTertanggung;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDate getTanggalMulaiPolis() {
        return tanggalMulaiPolis;
    }

    public void setTanggalMulaiPolis(LocalDate tanggalMulaiPolis) {
        this.tanggalMulaiPolis = tanggalMulaiPolis;
    }
}
