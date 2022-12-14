package Asuransi.Enum;

public enum JenisProduk {
    KESEHATAN("Kesehatan"),
    KENDARAAN("Kendaraan"),
    JIWA ("Jiwa");

    private String label;


    public String getLabel() {
        return label;
    }
    JenisProduk(String label) {
        this.label = label;
    }
}
