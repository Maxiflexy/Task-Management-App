package com.squad22podA.task_mgt.config;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.util.Base64;
import java.util.Properties;

@Component
public class JwtSecretGenerator {

    private static final String PROPERTIES_FILE_PATH = "src/main/resources/application.properties";
    private static final String JWT_SECRET_KEY = "jwt.secret";

    @PostConstruct
    public void generateAndWriteSecret() throws Exception {

        // Load existing properties
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(PROPERTIES_FILE_PATH)) {
            properties.load(input);
        }

        // Check if the JWT secret already exists
        if (properties.containsKey(JWT_SECRET_KEY)) {
            System.out.println("JWT Secret already exists: " + properties.getProperty(JWT_SECRET_KEY));
            return;
        }


        // Generate the secret key
        KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA512");
        keyGen.init(512);
        SecretKey secretKey = keyGen.generateKey();
        String base64Secret = Base64.getEncoder().encodeToString(secretKey.getEncoded());

        // Set the new secret key
        properties.setProperty(JWT_SECRET_KEY, base64Secret);

        // Save the properties back to the file
        try (OutputStream output = new FileOutputStream(PROPERTIES_FILE_PATH)) {
            properties.store(output, null);
        }

        System.out.println("Generated and saved JWT Secret: " + base64Secret);


    }


    /*

    Generating the Secret Key:

    We use the KeyGenerator class to generate a new HMAC SHA-512 key.
    This key is then encoded in base64 format.
    Reading and Modifying the Properties File:

    We load the existing properties from the application.properties file.
    We set the jwt.secret property to the newly generated base64-encoded secret key.
    Writing Back to the Properties File:

    We save the modified properties back to the application.properties file.

    checks if the jwt.secret property already exists and skips the generation if it does,
    ensuring that the same secret is used across application restarts.
     */
}
