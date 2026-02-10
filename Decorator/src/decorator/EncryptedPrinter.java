package decorator;

public class EncryptedPrinter extends PrinterDecorator {
    private static final int SHIFT = 3;

    public EncryptedPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        String encrypted = caesarEncrypt(message);
        printer.print(encrypted);
    }

    private String caesarEncrypt(String message) {
        StringBuilder result = new StringBuilder(message.length());
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result.append((char) ('a' + (ch - 'a' + SHIFT) % 26));
            } else if (ch >= 'A' && ch <= 'Z') {
                result.append((char) ('A' + (ch - 'A' + SHIFT) % 26));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
