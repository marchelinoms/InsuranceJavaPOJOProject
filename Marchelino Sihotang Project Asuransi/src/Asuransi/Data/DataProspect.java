package Asuransi.Data;

import Asuransi.Class.Nasabah;
import Asuransi.Class.Prospect;
import Asuransi.Enum.JenisKelamin;
import Asuransi.Enum.MetodeBayar;
import Asuransi.Enum.StatusKK;

import java.time.LocalDate;
import java.util.Map;

public class DataProspect {
    private HimpunanProspect himpunanProspect = new HimpunanProspect();

    public void showAllProspect(){
        Map<Integer, Prospect> map1 = himpunanProspect.getAllProspect();
        for (Prospect prospect : map1.values()) {
            prospect.printProspect();
        }
    }

    public void addProspect(String firstName, String lastName, LocalDate tanggalLahir, String tempatLahir, JenisKelamin jenisKelamin, String pekerjaan){
        Map<Integer, Prospect> model = himpunanProspect.getAllProspect();
        int nomor = model.size()+ 1;
        Prospect prospect = new Prospect(nomor,firstName, lastName, tanggalLahir, tempatLahir, jenisKelamin, pekerjaan);
        himpunanProspect.addProspect(prospect);
    }

    public Map<Integer, Prospect> getAllProspectempty(){
        Map<Integer, Prospect> map1 = himpunanProspect.getAllProspect();
        return map1;
    }


}
