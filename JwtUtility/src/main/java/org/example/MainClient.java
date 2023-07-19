package org.example;

import org.apache.commons.codec.binary.Base64;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Arrays;

public class MainClient {
    public static void main(String[] args) {
        try{
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(2048);
            KeyPair kp = kpg.generateKeyPair();

            String publicKey = Base64.encodeBase64String(kp.getPublic().getEncoded());
            String privateKey = Base64.encodeBase64String(kp.getPrivate().getEncoded());
            JwtUtils jwtUtils = new JwtUtils();
            //System.out.println(Base64.encodeBase64String(kp.getPrivate().getEncoded()));
            //System.out.println(Base64.encodeBase64String(kp.getPublic().getEncoded()));
            String jwtToken = jwtUtils.generateAccessToken("Ajinkya", Arrays.asList("ADMIN"),privateKey);
            System.out.println();
            System.out.println(jwtUtils.validateJwtToken(jwtToken,publicKey));
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}