/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vop;

import vop.Backbone.CipherInterface;
import vop.Ciphers.AtbashCipher;
import vop.Ciphers.CeasarCipher;

public class CipherDriver {

    public static void main(String[] args) {
        // TODO code application logic here
        CipherInterface cipher;
        
        String message = "Her har vi en Meddelelse, som er hemmelig!" ;
        System.out.println("Original: \n" + message);

        System.out.println("");

        cipher = new AtbashCipher();
        String enc = cipher.encrypt(message);
        System.out.println("Atbash: \n" + enc);
        System.out.println(cipher.decrypt(enc));

        System.out.println("");

        cipher = new CeasarCipher(13);
        enc = cipher.encrypt(message);
        System.out.println("Ceasar 13: \n" + enc);
        System.out.println(cipher.decrypt(enc));
    }
}
