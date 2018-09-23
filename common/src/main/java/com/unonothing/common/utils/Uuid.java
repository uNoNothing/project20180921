package com.unonothing.common.utils;

import com.unonothing.common.exceptions.ExceptionFactory;
import com.unonothing.common.exceptions.ExceptionType;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class Uuid {
    public static String generate() {

        MessageDigest salt = null;
        String uuid;

        try {
            salt = MessageDigest.getInstance("SHA-256");
            salt.update(UUID.randomUUID().toString().getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw ExceptionFactory.create(ExceptionType.INTERNAL_SERVER_ERROR, e.getCause(), e);
        }

        if (salt != null) {
            uuid = salt.digest().toString();
        } else {
            uuid = UUID.randomUUID().toString();
        }

        return uuid;
    }
}
