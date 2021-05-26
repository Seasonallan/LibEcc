package com.season.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.season.ecc.EccTool;

import org.bitcoinj.core.ECKey;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String data = "688109";
        ECKey ecKey = EccTool.createKeypair();

        Log.i("TAG", "签名内容：" + data);
        Log.i("TAG", "私钥：" + ecKey.getPrivateKeyAsHex());
        Log.i("TAG", "公钥：" + ecKey.getPublicKeyAsHex());

        Log.i("TAG", "签名Base64解码：" + EccTool.sign(ecKey, data));

    }


}