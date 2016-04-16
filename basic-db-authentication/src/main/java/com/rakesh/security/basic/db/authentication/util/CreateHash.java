package com.rakesh.security.basic.db.authentication.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by rakeshcherukuri on 16/04/16.
 */
public class CreateHash {

  public static String createWildFlyPasswordHash(String userName, String password) {
    String output = null;
    try {
      String str = String.join("", userName, ":ApplicationRealm:", password);

      MessageDigest digest = MessageDigest.getInstance("MD5");

      output = String.format("%x", new BigInteger(1, digest.digest(str.getBytes())));

      System.out.println("Message hex(md5()) = " + output);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return output;
  }

}
