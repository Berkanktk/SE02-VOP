/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vop.Backbone;

public abstract class AbstractCipher implements CipherInterface {

    protected int findCharIndex(char ch) {
        for (int i = 0; i < ALPHABETH.length; i++) {
            if (ch == ALPHABETH[i]) {
                return i;
            }
        }
        return -1;  //not found
    }
}
