/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vop.Ciphers;

import vop.Backbone.AbstractCipher;

/**
 *
 * @author erso
 */
public class CeasarCipher extends AbstractCipher {

    private int rotFactor;

    public CeasarCipher(int rotFactor) {
        if (rotFactor > 0 && rotFactor < ALPHABETH.length) {
            this.rotFactor = rotFactor;
        } else {
            System.out.println("Fejl i rotFactor!");
        }
    }

    @Override
    public String encrypt(String original) {
        String result = "";
        for (char c : original.toCharArray()) {
            int index = findCharIndex(c);
            if (index >= 0) {
                index = (index + rotFactor) % ALPHABETH.length;
                result += ALPHABETH[index];
            } else {
                result += c;
            }
        }
        return result;
    }

    @Override
    public String decrypt(String encrypted) {
        String result = "";
        for (char c : encrypted.toCharArray()) {
            int index = findCharIndex(c);
            if (index >= 0) {
                index = (index + ALPHABETH.length - rotFactor) % ALPHABETH.length;
                result += ALPHABETH[index];
            } else {
                result += c;
            }
        }
        return result;
    }
}
