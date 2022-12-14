package Asuransi.Class;

import Asuransi.Enum.JenisKendaraan;

public class Kendaraan {
    private JenisKendaraan jenisKendaraan;
    private String nomorPolisi;
    private String nomorSTNK;
    private String merk;
    private String model;
    private String warna;

    public Kendaraan(){}

    public Kendaraan(JenisKendaraan jenisKendaraan, String nomorPolisi, String nomorSTNK, String merk, String model, String warna) {
        this.jenisKendaraan = jenisKendaraan;
        this.nomorPolisi = nomorPolisi;
        this.nomorSTNK = nomorSTNK;
        this.merk = merk;
        this.model = model;
        this.warna = warna;
    }

    public JenisKendaraan getJenisKendaraan() {
        return jenisKendaraan;
    }

    public void setJenisKendaraan(JenisKendaraan jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    public String getNomorPolisi() {
        return nomorPolisi;
    }

    public void setNomorPolisi(String nomorPolisi) {
        this.nomorPolisi = nomorPolisi;
    }

    public String getNomorSTNK() {
        return nomorSTNK;
    }

    public void setNomorSTNK(String nomorSTNK) {
        this.nomorSTNK = nomorSTNK;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }
}
