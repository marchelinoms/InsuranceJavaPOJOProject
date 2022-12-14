package Asuransi.Class;

import Asuransi.Enum.FrekuensiTagihan;
import Asuransi.Enum.JenisProduk;

public class Product {
    private String namaProduk;
    private JenisProduk jenisProduk;
    private FrekuensiTagihan frekuensi;
    private double iuran;
    private String manfaat;

    public Product(){}

    public Product(String namaProduk, JenisProduk jenisProduk, FrekuensiTagihan frekuensi, String manfaat) {
        this.namaProduk = namaProduk;
        this.jenisProduk = jenisProduk;
        this.frekuensi = frekuensi;
        this.manfaat = manfaat;
    }

    public Product(String namaProduk, JenisProduk jenisProduk, FrekuensiTagihan frekuensi, double iuran, String manfaat) {
        this.namaProduk = namaProduk;
        this.jenisProduk = jenisProduk;
        this.frekuensi = frekuensi;
        this.iuran = iuran;
        this.manfaat = manfaat;
    }

    @Override
    public String toString() {
        return "Product{" +
                "namaProduk='" + namaProduk + '\'' +
                ", jenisProduk=" + jenisProduk +
                ", frekuensi=" + frekuensi +
                ", manfaat='" + manfaat + '\'' +
                '}';
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public JenisProduk getJenisProduk() {
        return jenisProduk;
    }

    public void setJenisProduk(JenisProduk jenisProduk) {
        this.jenisProduk = jenisProduk;
    }

    public FrekuensiTagihan getFrekuensi() {
        return frekuensi;
    }

    public void setFrekuensi(FrekuensiTagihan frekuensi) {
        this.frekuensi = frekuensi;
    }

    public String getManfaat() {
        return manfaat;
    }

    public void setManfaat(String manfaat) {
        this.manfaat = manfaat;
    }

    public double getIuran() {
        return iuran;
    }

    public void setIuran(double iuran) {
        this.iuran = iuran;
    }
}
