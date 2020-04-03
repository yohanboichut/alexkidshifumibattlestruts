package modele.dataencryption;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import interfaces.exceptions.TicketInvalideException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import static javax.crypto.Cipher.*;

public class DataChiffrement {

    private Cipher cipher; // Chiffrement utilisé
    private SecretKeySpec secretKey; // Clé secrète
    private ObjectMapper objectMapper; // Permet de transformer un objet en chaîne de caractère JSON et réciproquement

    public DataChiffrement(String secret) {
        byte[] key;
        try {
            cipher = getInstance("AES/ECB/PKCS5Padding");
            key = secret.getBytes("UTF-8");
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key,"AES");
            objectMapper = new ObjectMapper();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    /**
     * Chiffrement d'une donnée en string
     * @param invitation : invitation à chiffrer
     * @return : token correspondant au ciffrement de l'invitation en paramètre
     */

    public String chiffrement(Invitation invitation) {

        try {
            cipher.init(ENCRYPT_MODE,
                    secretKey);
            String strToEncrypt = this.objectMapper.writeValueAsString(invitation);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (InvalidKeyException | JsonProcessingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Encryption problem!");

    }

    /**
     * Permet de déchiffrer un token
     * @param token
     * @return l'invitation extraite du token
     * @throws TicketInvalideException : Le token n'est pas déchiffrable
     */

    public Invitation dechiffrement(String token) throws TicketInvalideException {
        try {
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            String jsonString = new String(cipher.doFinal(Base64.getDecoder().decode(token)));
            return objectMapper.readerFor(Invitation.class).readValue(jsonString);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new TicketInvalideException();
    }



}
