package Asuransi.Data;

import Asuransi.Class.Product;
import Asuransi.Enum.FrekuensiTagihan;
import Asuransi.Enum.JenisProduk;

import java.util.HashMap;
import java.util.Map;

public class DataProduct {
    private Map<String, Product> productMap = new HashMap<>();

    private void setAllProducts(){
        Product sehatBersama = new Product("Sehat Bersama", JenisProduk.KESEHATAN, FrekuensiTagihan.BULANAN, "Claim perawatan kelas 1");
        Product sehatExtra = new Product("Sehat Extra", JenisProduk.KESEHATAN, FrekuensiTagihan.BULANAN, "Claim perawatan kelas VIP");
        Product lifeKeluarga = new Product("Life Keluarga", JenisProduk.JIWA, FrekuensiTagihan.BULANAN, "Mendapatkan Rp500.000.000,00 apabila terjadi sesuatu pada tertanggung");
        Product lifeSpecial = new Product("Life Special", JenisProduk.JIWA, FrekuensiTagihan.TAHUNAN, "Mendapatkan Rp800.000.000,00 apabila terjadi sesuatu pada tertanggung");
        Product protection = new Product("Protection", JenisProduk.KENDARAAN, FrekuensiTagihan.TAHUNAN, 2000000,"Mendapat ganti rugi sampai Rp100.000.000,00 bila terjadi sesuatu");
        Product protectionPlus = new Product("Protection Plus", JenisProduk.KENDARAAN, FrekuensiTagihan.TAHUNAN, 2500000,"Mendapat ganti rugi total lost apa bila terjadi sesuatu.");

        productMap.put(sehatBersama.getNamaProduk(), sehatBersama);
        productMap.put(sehatExtra.getNamaProduk(), sehatExtra);
        productMap.put(lifeKeluarga.getNamaProduk(), lifeKeluarga);
        productMap.put(lifeSpecial.getNamaProduk(), lifeSpecial);
        productMap.put(protection.getNamaProduk(), protection);
        productMap.put(protectionPlus.getNamaProduk(), protectionPlus);
    }
    public Map<String, Product> getAllProducts() {
        return productMap;
    }
    public void setProductMap(){setAllProducts();}
    public Product getProduct (String key) {return  productMap.get(key);}
}
