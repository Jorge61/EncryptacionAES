package cifrado;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class pruebaP {

    public static void main(String[] args) throws Exception {

        // Generamos una clave de 128 bits adecuada para AES
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        Key key = keyGenerator.generateKey();

        // Alternativamente, una clave que queramos que tenga al menos 16 bytes
        // y nos quedamos con los bytes 0 a 15
        key = new SecretKeySpec("la clave de bytes".getBytes(), 0, 16, "AES");

        String textnro = "123456";

        // Se obtiene un cifrador AES
        Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");

        // Se inicializa para encriptacion y se< encripta el texto,
        // que debemos pasar como bytes.
        aes.init(Cipher.ENCRYPT_MODE, key);
        byte[] encriptado = aes.doFinal(textnro.getBytes());

        // Se escribe byte a byte en hexadecimal el texto
        // encriptado para ver su pinta.
        for (byte b : encriptado) {
            System.out.print(Integer.toHexString(0xA & b ));
        }
        System.out.println();

         // Se iniciliza el cifrador para desencriptar, con la
        // misma clave y se desencripta
//        aes.init(Cipher.DECRYPT_MODE, key);             
//        byte[] desencriptado = aes.doFinal(encriptado); 

        // Texto obtenido, igual al original.
//        System.out.println(new String(desencriptado));
    }

}
