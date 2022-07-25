package com.tcct.decypty;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

public class DecryptTCCT {
	

	public static String decrypt(String b64Ecriptado, String privateKey) {
	    try {
	    	PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));
	    	KeyFactory kf = KeyFactory.getInstance("RSA");
	    	PrivateKey pk = kf.generatePrivate(spec);
	    	
	    	
	        Cipher rsa;
	        rsa = Cipher.getInstance("RSA");
	        byte[] buffer = Base64.getDecoder().decode(b64Ecriptado);
	        rsa.init(Cipher.DECRYPT_MODE, pk);
	        byte[] utf8 = rsa.doFinal(buffer);
	        return new String(utf8, "UTF8");
	    } catch (Exception e) {
	        System.out.println("ERROR DecryptTCCT: " + e.getMessage());
	    }
	    return null;
	}
}
