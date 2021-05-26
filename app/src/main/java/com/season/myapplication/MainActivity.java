package com.season.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.bitcoinj.core.ECKey;
import org.bouncycastle.util.encoders.Base64;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            String data = "688109";
            ECKey ecKey = new ECKey();
            ecKey.decompress();

            Log.i("TAG", "onCreate: 签名内容：" + data);
            Log.i("TAG", "onCreate: 私钥：" + ecKey.getPrivateKeyAsHex());
            Log.i("TAG", "onCreate: 公钥：" + ecKey.getPublicKeyAsHex());

            String sign_msg1 = ecKey.signMessage(data);
            Log.i("TAG", "onCreate: 签名：" + sign_msg1);

            Log.i("TAG", "onCreate: 签名Base64解码：" + toHex(Base64.decode(sign_msg1)));

    }


    public static String toHex(byte[] bytes) {
        if (bytes == null) {
            return "";
        }
        final char[] hexArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] hexChars = new char[bytes.length * 2];
        int v;
        for (int j = 0; j < bytes.length; j++) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}