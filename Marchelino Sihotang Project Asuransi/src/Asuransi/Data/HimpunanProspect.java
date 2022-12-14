package Asuransi.Data;

import Asuransi.Class.Nasabah;
import Asuransi.Class.Prospect;

import java.util.LinkedHashMap;
import java.util.Map;

public class HimpunanProspect {
    private Map<Integer, Prospect> prospectMap = new LinkedHashMap<>();

    public Map<Integer,Prospect> getAllProspect(){
        return prospectMap;
    }

    public void addProspect(Prospect prospect){
        prospectMap.put(prospect.getNoProspect(), prospect);
    }
}
