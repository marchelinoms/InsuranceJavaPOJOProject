package Asuransi.Enum;

public enum JenisKendaraan {
    MOBIL("Mobil"),
    MOTOR("Motor");

    private String label;

    public String getLabel() {
        return label;
    }
    JenisKendaraan (String label) {
        this.label = label;
    }
}
