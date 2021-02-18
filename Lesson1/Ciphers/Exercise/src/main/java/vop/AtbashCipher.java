package vop;


public class AtbashCipher extends AbstractCipher {

    @Override
    public String encrypt(String message) {
        StringBuilder sb = new StringBuilder();

        for(char currentChar: message.toCharArray()){
            int currentCharIndex = findCharIndex(currentChar);
            if (currentCharIndex > -1) {
                sb.append(ALPHABETH[ALPHABETH.length - 1 - currentCharIndex]);
            }

            else {
                sb.append(currentChar);
            }
        }
        return sb.toString();

    }

    @Override
    public String decrypt(String encrypted) {
        return encrypt(encrypted);
    }
}
