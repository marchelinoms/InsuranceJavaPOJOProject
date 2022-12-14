package Asuransi.Data;

import Asuransi.Class.Nasabah;

import java.util.LinkedHashMap;
import java.util.Map;

public class HimpunanNasabah {
    private Map<String,Nasabah> nasabahMap = new LinkedHashMap<>();

    public Map<String,Nasabah> getAllNasabah(){
        return nasabahMap;
    }

    public void addNasabah(Nasabah nasabah){
        nasabahMap.put(nasabah.getNomorNasabah(), nasabah);
    }

}
