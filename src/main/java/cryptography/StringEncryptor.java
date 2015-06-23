package cryptography;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class StringEncryptor {
	
        String key = "Bar12345Bar12345"; // 128 bit key
        Key aesKey = null;;
        Cipher cipher = null;
        
    	private static StringEncryptor stringEncryptor = null;

    	private StringEncryptor() {
    		aesKey = new SecretKeySpec(key.getBytes(), "AES");
            try {
				cipher = Cipher.getInstance("AES");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				e.printStackTrace();
			}	
    	}

    	public static StringEncryptor getInstance() {
    		if (stringEncryptor == null) {
    			stringEncryptor = new StringEncryptor();
    		}
    		return stringEncryptor;
    	}

        public String getEncryptedString(String source) throws IllegalBlockSizeException, BadPaddingException
        {	
        	byte[] encrypted = null;
	        try {
				cipher.init(Cipher.ENCRYPT_MODE, aesKey);
				encrypted = cipher.doFinal(source.getBytes());
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			}
            return Base64.encodeBase64String(encrypted);
        }
        
        String getDepryctedString(String source) throws IllegalBlockSizeException, BadPaddingException
        {
        	String decrypted = null;
            try {
				cipher.init(Cipher.DECRYPT_MODE, aesKey);
	            byte[] bytes = Base64.decodeBase64(source);
				decrypted = new String(cipher.doFinal(bytes));
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			}
            return decrypted.toString();
        }
}
