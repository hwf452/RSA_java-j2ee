package rsa;


import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec1.binary.Base64;

public class RSAUtils {

    public static final String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding";
    
    
    public static void main(String args[]) {
    	
        try {
        	//加密
        	String publicKeyStr = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArRB31uODVh8yGYdxoOZ0kUGUZavRTdPNPzmltGNb2DcI5HG0hvGfLOFZospR+VzNrhtEiQ+QFp9Gq0pkXxQBCC14dzmjetdqfHKVnZ0qYH8s9nwmhO/5cvtukzMzvRtwYc/glf6NGtLm6JrN087tM8PtzgJWTfUjzgm6fVh7V/Oqg/G1JiT98IAAxLZFGcreJpcobt7D39IqQj2MES6Ejb+aLPSy/aB/BBzlKLR7FmqNcbtstAJ8cFULUqpapH3urbWwa1fOuz4HvkPG6mZrW+cTvzH7/Y+UhBBpgaQVT/vlFGDK6H4O019bxsBD+t4JBCiBuojTKfcQKLQ0vbq1xwIDAQAB";
        	String info ="123ggf";        	
        	String strEncode= encryptByPublicKey(info,publicKeyStr); 
            System.out.println("加密内容："+strEncode);
            
            
        	//解密
            String privateKeyStr="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCtEHfW44NWHzIZh3Gg5nSRQZRlq9FN080/OaW0Y1vYNwjkcbSG8Z8s4VmiylH5XM2uG0SJD5AWn0arSmRfFAEILXh3OaN612p8cpWdnSpgfyz2fCaE7/ly+26TMzO9G3Bhz+CV/o0a0uboms3Tzu0zw+3OAlZN9SPOCbp9WHtX86qD8bUmJP3wgADEtkUZyt4mlyhu3sPf0ipCPYwRLoSNv5os9LL9oH8EHOUotHsWao1xu2y0AnxwVQtSqlqkfe6ttbBrV867Pge+Q8bqZmtb5xO/Mfv9j5SEEGmBpBVP++UUYMrofg7TX1vGwEP63gkEKIG6iNMp9xAotDS9urXHAgMBAAECggEAL+56smpqyqRzNLzdjKmnKT/XgN04Z+y8UMF/kllea6C6dsLDNAihhEWZlMuiLoU0df8ZWTiVOJ6+bNx6thaNPp2RWrv8+h3FYVg+9ds8jGNMqauy42ivVtgqRNyOfNanpn9zfTd2DzLQPyX40avi6E5gg4kELC0z0HHDU8n4x1/BVMwZt4qDGUbLcPCVHP9QLxqdzkTyKcCZh8b+VDC0o0sla/vYaHvlzEqmObAm/bbOFOgHA9kHKGDGLQBb+OHQGqNVKgXDMVDf5hBM49Xm8ZppB/jinv7rM6QjsMSgCXJGuxDAgYQ46WuJ+54KchVb291sWc8uwNE2DMMns3+rwQKBgQDfFdZzhbrglovG4WHuErAE+9Bgk7Of1w9bdnO8qTr3OWWMs3m/dwbu9Z19P2u6ln7nZkdDA98vFJFZoPAlQsdDLa4oCTHw7fy/VigeNNC2Rpu1NEL3MvqsajLDCZrajSGCOOasSX9UXnm1CXJ3nxnocIUru9XonDPWtXvYEHkYYQKBgQDGmUla0j2Ji6Ek3OI13H2vmNUDRwnn5kCGqdGYEueCf2n+evF9NBZy5rRJy29b3sWrb76+0xKaY2VGVqah9tnuDNKTS3hJXwSXOF0POouVeB2Qomdb5hOgoO8ialKWMh1HSyF/KJUcvNlOAnR8AbrDWMOsUld1ZIJZK44p5LxfJwKBgDtF7R3yqU2lEmx8U+3Sr0wTsDEI7ZAJrz3pAiVdfZpUeMPip/WUZZY2UmsF39TKydsn1MVckP9MYrZCyavMy27xAzYGA2v1f9NCzBQCinXz2slRon1V4T7QVL53ndp15zJXdgrO2HMNSx8r7GsWLecRhoCxPsu4PRnOTKKC9fnhAoGAAX2tG01wwNOXhhtSZ20cVHElSD0ESgVkfp5PwICD1Gr4dLyfi30UnhA1UkiAsYPeoAbau7wB677LR9fmsFiWEj9uZUSvxn08H5aAvFiIK7sXHbraY8o6Y35RzURXEmGV7q8VtUqss+aHCxrhnPy2VjkYXvbPSUZT5C97hbz93QkCgYEAmh7S/dd+GLKijE8Ak92jweRjnHJf17pdrLITM1e0J/JvKfjZ2u6xG/qyd6WpjEL1DkYUvNIJUtKRYQUuZkLdtp4E4gxgZJD9IXSrFpxGa6izavoVvFXKkudIUYQvgQP5nun5jpSk8OjDr+RTbP0YDbzhHT9ohcIKvfpFORZ6jog=";
            String decryptStr=decryptByPrivateKey(strEncode,privateKeyStr);
        	System.out.println("解密内容 :"+decryptStr);
        	
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    
    /**
     * 用公钥加密
     * @param data   加密数据
     * @param key    密钥
     * @return
     * @throws Exception
     */
    public static String encryptByPublicKey(String data,String publicKeyStr)throws Exception{
        //取公钥
        byte[] keyBytes =  Base64.decodeBase64(publicKeyStr);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        Key publicKey = keyFactory.generatePublic(x509EncodedKeySpec);

        //对数据解密
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] resultBytes=cipher.doFinal(data.getBytes());
        return Base64.encodeBase64String(resultBytes);
    }
	/** 
     * 用私钥解密 
     * @param data 加密数据 
     * @param key 密钥 
     * @return 
     * @throws Exception 
     */  
    public static String decryptByPrivateKey(String data, String privateKeyStr)  
            throws Exception {  
    	//取私钥
        byte[] keyBytes = Base64.decodeBase64(privateKeyStr);  
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");  
        Key privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);  
        // 对数据解密  
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");  
        cipher.init(Cipher.DECRYPT_MODE, privateKey);  
        byte[] dataBytes=Base64.decodeBase64(data); 
        byte[] resultBytes=cipher.doFinal(dataBytes);  
        return new String(resultBytes,"UTF-8");  
    }  
    
    
}
