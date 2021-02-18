package vop;

/**
 *
 * @author erso
 *  Udleveret driver klasse til opgave 2, VOP eksamen 10 juni 2016
 */
public class CipherDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CipherInterface cipher;

        String message = "Her har vi en Meddelelse, som er hemmelig!";
        System.out.println("Original Meddelelse: \n" + message);
        System.out.println(" ");

        // Fjern ud-kommenteringen, når AtbashCipher skal testes
        //cipher = new AtbashCipher();
        //String enc = cipher.encrypt(message);
        //System.out.println("Krypteret med AtBash Cipher: \n" + enc+ "\n");
        //System.out.println("Dekrypteret med AtBash Cipher: \n" + (cipher.decrypt(enc)));

        // Fjern ud-kommenteringen, når CeasarCipher skal testes
        cipher = new CaesarCipher(13);
        String enc = cipher.encrypt(message);
        System.out.println("Ceasar 13: \n" + enc);
        System.out.println(cipher.decrypt(enc));

    }

}
