package Asuransi.Enum;

public enum JenisKelamin {
    L("Laki-Laki"),
    P("Perempuan");
    private String label;

    public String getLabel() {
        return label;
    }
    JenisKelamin(String label) {
        this.label = label;
    }
}
