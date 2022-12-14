package Asuransi.Enum;

public enum MetodeBayar {
    CC("Credit Card"),
    AC("Auto Collection"),
    VP("Voucher Point");

    private String label;

    public String getLabel() {
        return label;
    }

    MetodeBayar(String label) {
        this.label = label;
    }
}
