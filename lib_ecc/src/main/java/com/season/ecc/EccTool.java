package com.season.ecc;

import org.bitcoinj.core.ECKey;
import org.spongycastle.util.encoders.Base64;

public class EccTool {

    /**
     * 创建密钥对
     * @return
     */
    public static ECKey createKeypair() {
        ECKey ecKey = new ECKey();
        ecKey.decompress();
        return ecKey;
    }

    /**
     * 使用密钥对签名信息
     * @param ecKey
     * @param content
     * @return
     */
    public static String sign(ECKey ecKey, String content) {
        String sign_msg1 = ecKey.signMessage(content);
        return toHex(Base64.decode(sign_msg1));
    }

    private static String toHex(byte[] bytes) {
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
