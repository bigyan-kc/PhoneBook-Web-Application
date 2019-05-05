package edu.nsu.util;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHash {
    private static String salt = "NOHACKING";
    private static String hashText;
    public static String findHash(String password){

        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte []messageDigest = md.digest((password+salt).getBytes());

            //Convert an array into sign magnitude
            BigInteger no = new BigInteger(1, messageDigest);

            //Convert message digest into hex value
            hashText = no.toString(16);
            while(hashText.length() < 32){
                hashText = '0' + hashText;
            }
        }

        catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return hashText;
    }

}
