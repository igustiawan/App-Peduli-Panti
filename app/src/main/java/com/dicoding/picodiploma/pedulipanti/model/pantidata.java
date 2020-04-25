package com.dicoding.picodiploma.pedulipanti.model;

import com.dicoding.picodiploma.pedulipanti.R;

import java.util.ArrayList;
import java.util.Collection;

public class pantidata {
    private static String[] NamaPanti= {
            "Panti Asuhan Anak Cacat Teratai Jaya",
            "Yayasan Insan Madani",
            "Panti Asuhan Muhammadiyah Aisyiyah Kota Jambi",
            "Panti Asuhan Rifahiyatul Bilad",
            "Panti asuhan abul hasan",
            "Orphanage Darul Aitam",
            "Panti Asuhan Al-Mahri",
            "Rumah Asuhan Izzati Jannah",
            "Rumah Yatim Piatu Ummi Ikhlas",
            "Panti Asuhan Baiturrahman"
    };

    private static String[] AlamatPanti = {
            "Jl. Sersan Muslim, RT. 024/ RW. 06, The Hok, Kec. Jambi Sel., Kota Jambi, Jambi 36125",
            "Jl. Soekarno Hatta 42 PasirPutih, Jambi Selatan, Jambi Indonesia",
            "Jl. Kapt. A. Bakaruddin Lorong Nusa Indah II No.1 RT.32/RW.16 Simpang IV Sipin Telanaipura Kota Jambi Jambi 36124 Indonesia",
            "Jl. Guru Muchtar No.52, Jelutung, Kec. Jambi Sel., Kota Jambi, Jambi 36124",
            "JL. TP Sriwijaya, No. 38 RT. 15, kel, Rawasari, kec.alam barajo, telp: 074161066 kode pos: 36125 no hp:, Rw. Sari, Kec. Kota Baru, Kota Jambi, Jambi",
            "Jl. TP Sriwijaya No. 08 RT. 09. Kel. Beliung Kec. Kota Baru Beliung Kecamatan Kota Baru Kota Jambi Jambi 36129 Indonesia",
            "JL. Handil Jaya, Kec. Jelutung, Kota Jambi, Jambi 36125",
            "RT 44 Kompleks Komering Jaya, Kelurahan Mayang Mangurai, Kecataman Alambarajo, Kota Jambi",
            "Jl. Sk Syahbudin RT 04, Mayang Mangurai, Kota Baru, Kota Jambi, Jambi, Indonesia",
            "Jl. RS. Fatmawati Raya No.8, Rajawali, Kec. Jambi Tim., Kota Jambi, Jambi 36123"
    };

    private static int[] ImagePanti = {
            R.drawable.teratai_jaya,
            R.drawable.insan_madani,
            R.drawable.panti_aisyiyah,
            R.drawable.rifahiyatul_bilad,
            R.drawable.abdul_hasan,
            R.drawable.orphanage_darul,
            R.drawable.alhamri_jambi,
            R.drawable.izzati_jannah,
            R.drawable.ummi_ikhlas,
            R.drawable.panti_baiturahman
    };

    public static ArrayList<panti> GetListPanti(){
        ArrayList<panti>  list = new ArrayList<>();
        for(int position=0;position < NamaPanti.length;position++){
            panti Panti = new panti();
            Panti.setNamapanti(NamaPanti[position]);
            Panti.setAlamatpanti(AlamatPanti[position]);
            Panti.setPhoto(ImagePanti[position]);
            list.add(Panti);
        }
        return list;
    }


}
