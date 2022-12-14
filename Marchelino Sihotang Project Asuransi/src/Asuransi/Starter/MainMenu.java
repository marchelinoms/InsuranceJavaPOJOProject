package Asuransi.Starter;

import Asuransi.Class.*;
import Asuransi.Data.DataNasabah;
import Asuransi.Data.DataProduct;
import Asuransi.Data.DataProspect;
import Asuransi.Enum.JenisKelamin;
import Asuransi.Enum.JenisKendaraan;
import Asuransi.Enum.MetodeBayar;
import Asuransi.Enum.StatusKK;

import java.time.LocalDate;

import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;

public class MainMenu {
    Scanner scanner = new Scanner(System.in);

    private DataProspect dataProspect = new DataProspect();
    private DataNasabah dataNasabah = new DataNasabah();
    private DataProduct dataProduct = new DataProduct();

    public void initialization(){ dataProduct.setProductMap();}

    public void Utama(){

        System.out.println("Selamat Datang!");
        System.out.println("Pilih lah salah satu menu di bawah ini :");
        System.out.println("1. Menu Prospect");
        System.out.println("2. Menu Customer");
        System.out.println("3. Exit Application");
        System.out.println("Pilihan Anda : ");

        String input = scanner.nextLine().trim();

        boolean validasi = ValidasiInput.validateInput(input,3);
        if(!validasi){Utama();}

            switch (input){
                case "1" -> menuProspect();
                case "2" -> menuCustomer();
                case "3" ->
                {
                    System.out.println("Adios!");
                    System.exit(0);
                }
                default ->
                    {
                        System.out.println("Menu tidak tersedia !  \n silahkan pilih kembali sesuai dengan menu yang tersedia");
                        Utama();
                    }
            }
        }
    public void menuProspect(){
        System.out.println("Anda Berada di menu Prospect");

        if(dataProspect.getAllProspectempty().isEmpty()){
            System.out.println(" Belum ada Prospect yang terdaftar! , harap daftarkan Prospect dengan mengakses menu (Add Prospect) ");
        }
        else {
            dataProspect.showAllProspect();
        }

        System.out.println("Pilih lah salah satu menu di bawah ini :");
        System.out.println("1. Add Prospect");
        System.out.println("2. Prospect To Customer");
        System.out.println("3. Main Menu");
        System.out.println("4. Exit Application");
        System.out.println("Pilihan Anda : ");

        String input = scanner.nextLine().trim();
        boolean validasi = ValidasiInput.validateInput(input,4);
        if(!validasi){menuProspect();}
        switch (input){
                case "1" -> addProspectMenu();
                case "2" -> {
                    if(dataProspect.getAllProspectempty().isEmpty()){
                        System.out.println("Prospect belum terdaftar!");
                        menuProspect();
                    }
                    else {
                    prospectToCustomer();
                    }
                }
                case "3" -> Utama();
                case "4" -> {
                    System.out.println("Adios!");
                    System.exit(0);
                }
                default -> {
                    System.out.println("Menu tidak tersedia !\n silahkan pilih kembali sesuai dengan menu yang tersedia");
                    menuProspect();
                }
            }
        }
        public void menuCustomer(){
            System.out.println("Anda Berada di menu Customer");

            System.out.println(dataNasabah.getAllNasabahempty().get("10/2022/1"));

            Map<String,Nasabah> mapNasabah = dataNasabah.getAllNasabahempty();
            dataNasabah.showAllNasabah();

            System.out.println("Pilih Menu yang ingin dipilih : ");
            System.out.println("1. Buy Product");
            System.out.println("2. Detail Policy");
            System.out.println("3. Main Menu");
            System.out.println("4. Exit Application");
            System.out.println("Pilihan Anda : ");

            String input = scanner.nextLine().trim();
            boolean validasi = ValidasiInput.validateInput(input,4);
            if(!validasi){menuCustomer();}

                switch (input){
                    case "1" -> {
                        if (mapNasabah.values().isEmpty()){
                        System.out.println("Belum ada nasabah yang terdaftar, harap ubah prospect ke nasabah terlebih dahulu");
                        menuCustomer();
                    } else { buyProduct(); }
                    }
                    case "2" ->{
                        if (mapNasabah.values().isEmpty()){
                            System.out.println("Belum ada nasabah yang terdaftar, harap ubah prospect ke nasabah terlebih dahulu");
                            menuCustomer();
                        } else { detailPolicy(); }
                    }
                    case "3" -> Utama();
                    case "4" -> {
                        System.out.println("Adios!");
                        System.exit(0);
                    }
                    default -> {
                    System.out.println("Menu tidak tersedia !\n silahkan pilih kembali sesuai dengan menu yang tersedia");
                    menuCustomer();
                    }
                }
            }

            // Prospect Menu -> addProspect Menu
        public void addProspectMenu(){
            Prospect prospect = new Prospect();

            System.out.println("Nama Depan :");
                String firstName = scanner.nextLine();
            System.out.println("Nama Belakang :");
                String lastName = scanner.nextLine();
            System.out.println("Tanggal Lahir (dd/MM/yyyy) :");
                String tanggalLahir = scanner.nextLine();
            DateTimeFormatter indoformat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate tanggalLahir1 = LocalDate.parse(tanggalLahir,indoformat);
            System.out.println("Tempat Lahir : ");
                String tempatLahir = scanner.nextLine();

            System.out.println("Jenis Kelamin (P/L) : ");
                JenisKelamin jenisKelamin1 = jenisKelamin();
            System.out.println("Pekerjaan : ");
                String pekerjaan = scanner.nextLine();
                dataProspect.addProspect(firstName,lastName,tanggalLahir1,tempatLahir,jenisKelamin1,pekerjaan);

            System.out.println("... Menambahkan Prospect Baru");
            System.out.println("(Kembali ke Menu Utama)");
            Utama();
        }
            // Prospect Menu -> ProspectToCustomer Menu
        public void prospectToCustomer(){
            Map<Integer, Prospect> model = dataProspect.getAllProspectempty();
            if (model.values().isEmpty()){
                System.out.println("Daftar Prospect masih kosong");
            } else {
                dataProspect.showAllProspect();
            }
            System.out.println("Ketik Nomor Prospect yang ingin dijadikan nasabah : ");
            String input = scanner.nextLine().trim();
            //Validasi bahwa inputan bilangan bulat dan nomor prospect EXIST!
            boolean validasi = ValidasiInput.validateInput(input);
            if(!validasi){prospectToCustomer();}
            Integer nomorProspectInt = Integer.valueOf(input);
            if(!model.containsKey(nomorProspectInt)){
                System.out.println("Nomor Prospect tidak ada");
                prospectToCustomer();
            }
            if (model.get(nomorProspectInt).isNasabah()){
                System.out.println("Prospect sudah menjadi nasabah");
                menuProspect();
            }

            //validasi bahwa ini harus diisi!
            System.out.println("Nomor KTP : ");
            String noKtp = validasiKosong("nomor","Ktp");

            //validasi bahwa yang diisi tersedia di enum StatusKK
            System.out.println("Status KK : ");
            StatusKK statusKk = statusKK();

            //validasi bahwa yang diisi tersedia di enum MetodePembayaran
            System.out.println("Payment Method : ");
            MetodeBayar paymentMethod = paymentMethod();

            //Menambahkan Nasabah baru dari Prospect yang ada
            model.get(nomorProspectInt).setNasabah(true);
            dataNasabah.addNasabah(model.get(nomorProspectInt),noKtp, statusKk, paymentMethod);
            System.out.println("... Menambahkan Nasabah Baru");
            System.out.println("(Kembali ke Menu Prospect)");
            menuProspect();
    }
            // Customer Menu -> Buy Product Menu
        public void buyProduct() {
            Map<String, Nasabah> model = dataNasabah.getAllNasabahempty();

            System.out.println("Pilih Nomor Customer :");
            //Validasi nomor customer tersedia
            String input = scanner.nextLine();
            if (!model.containsKey(input)) {
                System.out.println("Nomor nasabah tidak ada, coba lagi");
                buyProduct();
            }
            System.out.println("Pilih Nama Product :");
            //Validasi product sesuai tersedia
            String namaProduct = productValidation();
            //Jika Produk nya Kendaraan
            if (namaProduct.equals("Protection") || namaProduct.equals("Protection Plus")) {
                System.out.println("Masukkan Jenis Kendaraan (Motor/Mobil)");
                JenisKendaraan jenisKendaraan = validasiKendaraan();
                System.out.println("Nomor Polisi : ");
                String nomorPolisi = validasiKosong("Nomor", "polisi");
                System.out.println("Nomor STNK : ");
                String nomorStnk = validasiKosong("Nomor", "STNK");
                System.out.println("Merk : ");
                String merkKendaraan = validasiKosong("Merk", "kendaraan");
                System.out.println("Model : ");
                String modelKendaraan = validasiKosong("Model", "kendaraan");
                System.out.println("Warna : ");
                String warnaKendaraan = validasiKosong("Warna", "kendaraan");
                Kendaraan kendaraan = new Kendaraan(jenisKendaraan, nomorPolisi, nomorStnk, merkKendaraan, modelKendaraan, warnaKendaraan);
                Polis polis = new Polis(kendaraan, dataProduct.getProduct(namaProduct));
                model.get(input).tambahPolis(polis);
            } else if (namaProduct.equals("Sehat Bersama") || namaProduct.equals("Life Keluarga")) {
                //validasi nomor Nasabah tertanggung
                String nomorNasabahTertanggung = validasiNasabah();
                if (namaProduct.equals("Sehat Bersama")) {
                    if (hitungUmur(model.get(input).getProspect().getTanggalLahir()) <= 20) {
                        dataProduct.getProduct(namaProduct).setIuran(200000);
                    } else {
                        dataProduct.getProduct(namaProduct).setIuran(400000);
                    }

                } else {
                    if (hitungUmur(model.get(input).getProspect().getTanggalLahir()) <= 20) {
                        dataProduct.getProduct(namaProduct).setIuran(250000);
                    } else {
                        dataProduct.getProduct(namaProduct).setIuran(450000);
                    }
                }
                Polis polis = new Polis(model.get(nomorNasabahTertanggung), dataProduct.getProduct(namaProduct));
                model.get(input).tambahPolis(polis);
            } else {
                if (namaProduct.equals("Sehat Extra")) {
                    if (hitungUmur(model.get(input).getProspect().getTanggalLahir()) <= 20) {
                        dataProduct.getProduct(namaProduct).setIuran(300000);
                    } else {
                        dataProduct.getProduct(namaProduct).setIuran(500000);
                    }
                } else {
                    if (hitungUmur(model.get(input).getProspect().getTanggalLahir())<= 20) {
                        dataProduct.getProduct(namaProduct).setIuran(3600000);
                    } else {
                        dataProduct.getProduct(namaProduct).setIuran(4800000);
                    }
                }
                Polis polis = new Polis(model.get(input), dataProduct.getProduct(namaProduct));
                model.get(input).tambahPolis(polis);
            }

            System.out.println("Berhasil membeli produk");
            System.out.println("(Kembali ke Menu Customer)");
            menuCustomer();
        }
            //Customer Menu -> Detail Policy
        public void detailPolicy() {
            dataNasabah.showAllNasabah();
            Map<String, Nasabah> model = dataNasabah.getAllNasabahempty();
            System.out.println("Pilih Nomor Customer : ");
            String nomorNasabah = scanner.nextLine();
            if (!model.containsKey(nomorNasabah)) {
                System.out.println("Nomor Customer tidak ada");
                detailPolicy();
            }
            System.out.println("=======================CUSTOMER INFO=================================");
            model.get(nomorNasabah).printNasabah();
            if (model.get(nomorNasabah).getPolisList().isEmpty()) {
                System.out.println("=====================================================================");
                System.out.println("----------------------Nasabah belum membeli produk-------------------");
                System.out.println("=====================================================================");
                System.out.println("\n");
                menuCustomer();
            } else {
                for (Polis polis : model.get(nomorNasabah).getPolisList()) {
                    polis.printPolis();
                }
                menuCustomer();
            }
        }
    private String productValidation(){
        String namaProduct = scanner.nextLine();
        if (!dataProduct.getAllProducts().containsKey(namaProduct)){
            System.out.println("produk tidak tersedia, coba lagi");
            return productValidation();
        }
        return namaProduct;
    }
    private JenisKendaraan validasiKendaraan(){
        System.out.println("Input Data Kendaraan:");
        String jenisKendaraan=  scanner.nextLine();
        if (!jenisKendaraan.equalsIgnoreCase(JenisKendaraan.MOBIL.toString()) && !jenisKendaraan.equalsIgnoreCase(JenisKendaraan.MOTOR.toString())){
            System.out.println("Jenis kendaraan tidak tersedia (hanya mobil dan motor), silanhkan coba lagi");
            return validasiKendaraan();
        }
        JenisKendaraan kendaraan = JenisKendaraan.MOBIL;
        if (jenisKendaraan.equalsIgnoreCase(JenisKendaraan.MOTOR.toString())){
            kendaraan = JenisKendaraan.MOTOR;
        }
        return kendaraan;
    }
    private String validasiKosong(String value, String identitas){
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("")){
            System.out.println(value+" "+identitas+" tidak boleh kosong");
            return validasiKosong(value, identitas);
        }
        return input;
    }
    private StatusKK statusKK(){
        String statuskk1 = scanner.nextLine().trim();
        if(!statuskk1.equals(StatusKK.KEPALAKELUARGA.getLabel()) && !statuskk1.equals(StatusKK.SUAMI.getLabel())&&
                !statuskk1.equals(StatusKK.ISTRI.getLabel())  && !statuskk1.equals(StatusKK.ANAK.getLabel())&&
                !statuskk1.equals(StatusKK.CUCU.getLabel())   && !statuskk1.equals(StatusKK.MENANTU.getLabel())&&
                !statuskk1.equals(StatusKK.MERTUA.getLabel()) && !statuskk1.equals(StatusKK.ORANGTUA.getLabel()) &&
                !statuskk1.equals(StatusKK.FAMILI.getLabel()) && statuskk1.equalsIgnoreCase("")){
            System.out.println("Masukkan Status Hubungan Keluarga sesuai ketentuan yang berlaku !");
            System.out.println("""
                                1. Kepala Keluarga
                                2. Suami
                                3. Istri
                                4. Anak
                                5. Cucu
                                6. Menantu
                                7. Mertua
                                8. Orangtua
                                9. Famili""");
            System.out.println(" Status : ");
            return statusKK();
        }

        StatusKK kk;
        if(statuskk1.equalsIgnoreCase(StatusKK.KEPALAKELUARGA.getLabel())) {
            kk = StatusKK.KEPALAKELUARGA;
        }
        else if (statuskk1.equalsIgnoreCase(StatusKK.ANAK.getLabel())) {
            kk = StatusKK.ANAK;
        }
        else if (statuskk1.equalsIgnoreCase(StatusKK.SUAMI.getLabel())) {
            kk = StatusKK.SUAMI;
        }
        else if (statuskk1.equalsIgnoreCase(StatusKK.ISTRI.getLabel())) {
            kk = StatusKK.ISTRI;
        }
        else if (statuskk1.equalsIgnoreCase(StatusKK.CUCU.getLabel())) {
            kk = StatusKK.CUCU;
        }
        else if (statuskk1.equalsIgnoreCase(StatusKK.MENANTU.getLabel())) {
            kk = StatusKK.MENANTU;
        }
        else if (statuskk1.equalsIgnoreCase(StatusKK.MERTUA.getLabel())) {
            kk = StatusKK.MERTUA;
        }
        else if (statuskk1.equalsIgnoreCase(StatusKK.ORANGTUA.getLabel())) {
            kk = StatusKK.ORANGTUA;
        }
        else if (statuskk1.equalsIgnoreCase(StatusKK.FAMILI.getLabel())){
            kk = StatusKK.FAMILI;
        } else {
            return statusKK();
        }
        return kk;
    }
    private MetodeBayar paymentMethod(){
        String payment = scanner.nextLine().toUpperCase().trim();
        //Cek input apakah berada diluar enum Metode Bayar
        if(!payment.equalsIgnoreCase(MetodeBayar.AC.getLabel()) && !payment.equalsIgnoreCase(MetodeBayar.CC.getLabel()) && !payment.equalsIgnoreCase(MetodeBayar.VP.getLabel()) && payment.equalsIgnoreCase("")){
            System.out.println("Metode Pembayaran tidak tersedia!, harap masukkan salah satu metode dibawah ini");
            System.out.println("""
                                  1. CC (Credit Card)
                                  2. AC (Auto Collection)
                                  3. VP (Voucher Point)""");
            return paymentMethod();
        }

        MetodeBayar payment1;
        if(payment.equalsIgnoreCase(MetodeBayar.CC.getLabel())){
            payment1 = MetodeBayar.CC;
        } else if (payment.equalsIgnoreCase(MetodeBayar.AC.getLabel())) {
            payment1 = MetodeBayar.AC;
        } else {
            payment1 = MetodeBayar.VP;
        }
        return payment1;
    }
    private String validasiNasabah(){
        Map<String, Nasabah> model = dataNasabah.getAllNasabahempty();
        String nomorTertanggung = scanner.nextLine();
        if (!model.containsKey(nomorTertanggung)){
            System.out.println("Nomor nasabah tidak ada, coba lagi");
            return validasiNasabah();
        }
        return nomorTertanggung;
    }
    private JenisKelamin jenisKelamin(){
        String input = scanner.nextLine().trim().toUpperCase();
        if(!input.equals(JenisKelamin.L.toString())&& !input.equals(JenisKelamin.P.toString())){
            System.out.println("Masukkan Jenis Kelamin yang benar!");
        }
        JenisKelamin jenisKelamin = JenisKelamin.L;
        if(input.equals(JenisKelamin.P.getLabel())){
            jenisKelamin = JenisKelamin.P;
        }
        return jenisKelamin;
    }
    public int hitungUmur (LocalDate localDate){
        Period hitungUmur = Period.between(localDate,LocalDate.now());

        return hitungUmur.getYears();
    }
    }

