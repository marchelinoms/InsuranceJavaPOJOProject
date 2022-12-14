package Asuransi.Enum;

public enum StatusKK {
    KEPALAKELUARGA("Kepala Keluarga"),
    SUAMI("Suami"),
    ISTRI("Istri"),
    ANAK("Anak"),
    MENANTU("Menantu"),
    CUCU("Cucu"),
    ORANGTUA("Orang Tua"),
    MERTUA("Mertua"),
    FAMILI("Famili");

    private String label;
    public String getLabel() {
        return label;
    }
    StatusKK (String label){
        this.label = label;
    }
}
