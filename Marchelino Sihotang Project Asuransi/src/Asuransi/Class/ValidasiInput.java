package Asuransi.Class;

public class ValidasiInput {
    public static boolean validateInput(String input, int maxMenu) {
    boolean validation = false;
    try {
        int numericInput = Integer.parseInt(input);
        if(numericInput <= maxMenu && numericInput >= 1) {
            validation = true;
        } else {
            System.out.printf("Tolong masukan antara 1 - %d\n", maxMenu);
        }
    }catch(Exception exception) {
        System.out.println("Format yang anda masukan salah, coba lagi.");
    }
    return validation;
}
    public static boolean validateInput(String input) {
        boolean validation = false;
        try {
            int numericInput = Integer.parseInt(input);
            if(numericInput >= 1) {
                validation = true;
            } else {
                System.out.println("Tolong masukan bilangan bulat");
            }
        }catch(Exception exception) {
            System.out.println("Format yang anda masukan salah, coba lagi.");
        }
        return validation;
    }
}
