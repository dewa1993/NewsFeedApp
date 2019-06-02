package com.upadhyay.newsfeedapplication.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

import android.util.Base64;

import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import static android.util.Base64.DEFAULT;

public class PasswordUtils {

    private static final Random RANDOM = new SecureRandom();


    public static String getSalt(int length) {
        StringBuilder returnValue = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            returnValue.append(AppConstants.ALPHABET.charAt(RANDOM.nextInt(AppConstants.ALPHABET.length())));
        }
        return new String(returnValue);
    }

    private static byte[] hash(char[] password, byte[] salt) {
        PBEKeySpec spec = new PBEKeySpec(password, salt, AppConstants.ITERATIONS, AppConstants.KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance(AppConstants.ALGORITHM);
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        } finally {
            spec.clearPassword();
        }
    }

    public static String generateSecurePassword(String password, String salt) {
        String returnValue = null;
        byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
        returnValue = Base64.encodeToString(securePassword, DEFAULT);

        return returnValue;
    }

    public static boolean verifyUserPassword(String providedPassword,
                                             String securedPassword, String salt) {
        boolean returnValue = false;

        // Generate New secure password with the same salt
        String newSecurePassword = generateSecurePassword(providedPassword, salt);

        // Check if two passwords are equal
        returnValue = newSecurePassword.equalsIgnoreCase(securedPassword);

        return returnValue;
    }
}
