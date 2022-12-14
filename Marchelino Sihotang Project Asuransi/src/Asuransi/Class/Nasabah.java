package Asuransi.Class;

import Asuransi.Enum.JenisKelamin;
import Asuransi.Enum.MetodeBayar;
import Asuransi.Enum.StatusKK;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Nasabah  {
    private String nomorNasabah;
    private String noKTP;
    private StatusKK statusKK;
    private MetodeBayar metodeBayar;
    private List<Nasabah> nasabahList;
    private List<Polis> polisList;
    private Prospect prospect;
    public Nasabah(Prospect prospect, String nomor, String noKTP, StatusKK statusKeluarga, MetodeBayar paymentMethod) {
        this.prospect = prospect;
        this.nomorNasabah = nomor;
        this.noKTP = noKTP;
        this.statusKK = statusKeluarga;
        this.metodeBayar = paymentMethod;
        this.polisList = new ArrayList<>();
    }

    public void printNasabah(){
        System.out.println("No: "+getNomorNasabah()+", "+prospect.getFirstName()+" "+prospect.getLastName()+
                ", "+prospect.getJenisKelamin().getLabel() +", "+ prospect.getTanggalLahir()+
                " ("+prospect.getTempatLahir()+")"+", "+ prospect.getPekerjaan());
        System.out.println("KTP: "+getNoKTP()+", Status di KK: "+getStatusKK().getLabel()+", Payment Method: "+getMetodeBayar().getLabel());
        System.out.println("=====================================================================");

    }
    public void tambahPolis(Polis polis){this.polisList.add(polis);}
    public String getNomorNasabah() {
        return nomorNasabah;
    }

    public void setNomorNasabah(String nomorNasabah) {
        this.nomorNasabah = nomorNasabah;
    }

    public String getNoKTP() {
        return noKTP;
    }

    public void setNoKTP(String noKTP) {
        this.noKTP = noKTP;
    }

    public StatusKK getStatusKK() {
        return statusKK;
    }

    public void setStatusKK(StatusKK statusKK) {
        this.statusKK = statusKK;
    }

    public MetodeBayar getMetodeBayar() {
        return metodeBayar;
    }

    public void setMetodeBayar(MetodeBayar metodeBayar) {
        this.metodeBayar = metodeBayar;
    }

    public List<Nasabah> getNasabahList() {
        return nasabahList;
    }

    public void setNasabahList(List<Nasabah> nasabahList) {
        this.nasabahList = nasabahList;
    }

    public List<Polis> getPolisList() {
        return polisList;
    }

    public void setPolisList(List<Polis> polisList) {
        this.polisList = polisList;
    }

    public Prospect getProspect() {
        return prospect;
    }

    public void setProspect(Prospect prospect) {
        this.prospect = prospect;
    }

    @Override
    public String toString() {
        return "Nasabah{" +
                "nomorNasabah='" + nomorNasabah + '\'' +
                ", noKTP='" + noKTP + '\'' +
                ", statusKK=" + statusKK +
                ", metodeBayar=" + metodeBayar +
//               g
//                ", polisList=" + polisList +
//                ", prospect=" + prospect +
                '}';
    }
}
