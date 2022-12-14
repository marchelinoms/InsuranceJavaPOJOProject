package Asuransi.Data;

import Asuransi.Class.Nasabah;
import Asuransi.Class.Prospect;
import Asuransi.Enum.MetodeBayar;
import Asuransi.Enum.StatusKK;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataNasabah {
 private HimpunanNasabah himpunanNasabah = new HimpunanNasabah();

    public void showAllNasabah(){
        Map<String, Nasabah> map1 = himpunanNasabah.getAllNasabah();
        for (Nasabah nasabah : map1.values()) {
            nasabah.printNasabah();
        }
    }

    public void addNasabah(Prospect prospect, String noKtp, StatusKK statusKeluarga, MetodeBayar paymentMethod){
        String nomor = prospect.formatTanggal1(LocalDate.now()) +"/"+Integer.valueOf(prospect.getNoProspect()).toString();
        Nasabah nasabah = new Nasabah(prospect, nomor, noKtp, statusKeluarga, paymentMethod);
        himpunanNasabah.addNasabah(nasabah);
    }
    public Map<String, Nasabah> getAllNasabahempty(){
        Map<String, Nasabah> map1 = himpunanNasabah.getAllNasabah();
        return map1;
    }

}
