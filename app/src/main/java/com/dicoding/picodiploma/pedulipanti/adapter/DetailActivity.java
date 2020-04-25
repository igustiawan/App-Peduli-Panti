package com.dicoding.picodiploma.pedulipanti.adapter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.dicoding.picodiploma.pedulipanti.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    TextView NamaPanti,AlamatPanti;
    ImageView GambarPanti;
    Button btn_sms;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GambarPanti = (ImageView) findViewById(R.id.gambar_panti);
        NamaPanti = (TextView) findViewById(R.id.nama_panti);
        AlamatPanti = (TextView) findViewById(R.id.alamat_panti);
        btn_sms = (Button) findViewById(R.id.btn_sms);

        String GetNama = getIntent().getExtras().getString("namapanti");
        int GetGambar =getIntent().getIntExtra("gambarpanti",0);
        String GetAlamat = getIntent().getExtras().getString("alamatpanti");

        GambarPanti.setImageResource(GetGambar);
        NamaPanti.setText(GetNama);
        AlamatPanti.setText(GetAlamat);

        getSupportActionBar().setTitle("Detail Panti Asuhan");
    }

    public void telepon(View view) {
        String nomor = "082241999933" ;
        Intent panggil = new Intent(Intent. ACTION_DIAL);
        panggil.setData(Uri. fromParts("tel",nomor,null));
        startActivity(panggil);
    }

    public void sendsms(View view){
        Uri uriSms = Uri.parse("smsto:082241999933");
        Intent intentSMS = new Intent(Intent.ACTION_SENDTO, uriSms);
        intentSMS.putExtra("sms_body", "Assalamualaikum..\n");
        startActivity(intentSMS);
    }

    public void sendwa(View view){
        String nomortelepon = "+6282241999933";
        String pesan = "Assalamualaikum";

        startActivity(
                new Intent(Intent.ACTION_VIEW,
                        Uri.parse(
                                String.format("https://api.whatsapp.com/send?phone=%s&text=%s", nomortelepon, pesan)
                        )
                )
        );
    }
}
