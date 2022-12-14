package Asuransi.Class;

import Asuransi.Enum.JenisKelamin;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Prospect {
    private int noProspect;
    private String firstName;
    private String lastName;
    private LocalDate tanggalLahir;
    private String tempatLahir;
    private JenisKelamin jenisKelamin;
    private String pekerjaan;
    private long umur;
    private boolean isNasabah;
    public Prospect() {
    }

    public Prospect(int noProspect, String firstName, String lastName, LocalDate tanggalLahir, String tempatLahir, JenisKelamin jenisKelamin, String pekerjaan) {
        this.noProspect = noProspect;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tanggalLahir = tanggalLahir;
        this.tempatLahir = tempatLahir;
        this.jenisKelamin = jenisKelamin;
        this.pekerjaan = pekerjaan;
    }

    public Prospect(int noProspect, String firstName, String lastName, LocalDate tanggalLahir, String tempatLahir, JenisKelamin jenisKelamin, String pekerjaan, long umur, boolean isNasabah) {
        this.noProspect = noProspect;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tanggalLahir = tanggalLahir;
        this.tempatLahir = tempatLahir;
        this.jenisKelamin = jenisKelamin;
        this.pekerjaan = pekerjaan;
        this.umur = hitungUmur();
        this.isNasabah = false;
    }

    public Prospect(String firstName, String lastName, LocalDate tanggalLahir, String tempatLahir, JenisKelamin jenisKelamin, String pekerjaan) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.tanggalLahir = tanggalLahir;
        this.tempatLahir = tempatLahir;
        this.jenisKelamin = jenisKelamin;
        this.pekerjaan = pekerjaan;
    }
    
    public String formatTanggal (LocalDate localDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("id","ID"));
        return localDate.format(formatter);
    }
    public String formatTanggal1 (LocalDate localDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy", new Locale("id","ID"));
        return localDate.format(formatter);
    }
    public void printProspect(){
        System.out.println("No: "+getNoProspect()+", "+getFirstName()+" "+
                getLastName()+ ", "+ getJenisKelamin().getLabel()+", "+
                formatTanggal(getTanggalLahir())+" ("+getTempatLahir()+"), "+
                getPekerjaan()+", "+ nasabah(isNasabah()));
    }
    public int hitungUmur (){
        int hitungUmur = Period.between(this.tanggalLahir,LocalDate.now()).getYears();
        return hitungUmur;
    }

    private String nasabah( boolean nasabah ){
        if(nasabah){
            return "Nasabah";
        } else{
            return "Prospect";
        }
    }
    public boolean isNasabah() {
        return isNasabah;
    }
    public void setNasabah(boolean nasabah) {
        isNasabah = nasabah;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(LocalDate tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public JenisKelamin getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(JenisKelamin jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public int getNoProspect() {
        return noProspect;
    }

    public void setNoProspect(int noProspect) {
        this.noProspect = noProspect;
    }

    public long getUmur() {
        return umur;
    }

    public void setUmur(long umur) {
        this.umur = umur;
    }
}
