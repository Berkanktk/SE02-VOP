package vop;

public class CaesarCipher extends AbstractCipher {
    private int rotFactor;

    public CaesarCipher(int rotFactor) {
        if (rotFactor > 0 && rotFactor < ALPHABETH.length) {
            this.rotFactor = rotFactor;
        } else {
            System.out.println("Fejl i rotFactor");
        }
    }

    @Override
    public String encrypt(String original) {
        String result = "";
        for (char currentChar : original.toCharArray()) {
            int currentCharIndex = findCharIndex(currentChar);
            if (currentCharIndex >= 0) {
                currentCharIndex = (currentCharIndex + rotFactor)% ALPHABETH.length;
                result += ALPHABETH[currentCharIndex];
            } else {
                result += currentChar;
            }
        }
        return result;
    }

    @Override
    public String decrypt(String encrypted) {
        String result = "";
        for (char currentChar : encrypted.toCharArray()) {
            int currentCharIndex = findCharIndex(currentChar);
            if (currentCharIndex >= 0) {
                currentCharIndex = (currentCharIndex + ALPHABETH.length - rotFactor) % ALPHABETH.length;
                result += ALPHABETH[currentCharIndex];
            } else
                result += currentChar;
        }
        return result;
    }
}