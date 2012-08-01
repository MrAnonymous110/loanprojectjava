/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Encrypt;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Administrator
 */
public class MD5 {
    public static String encrypt(String str)
    {
        try {
                 MessageDigest md5 = MessageDigest.getInstance("MD5");
                 md5.update(str.getBytes());
                 BigInteger dis = new BigInteger(1,md5.digest());
                
                 String text = dis.toString(20);
                 return text;
        } catch (NoSuchAlgorithmException ex) {
           return "";
        }
    }
}
