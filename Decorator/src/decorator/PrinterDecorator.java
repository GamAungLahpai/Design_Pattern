package decorator;

public abstract class PrinterDecorator implements Printer {
    protected final Printer printer;

    protected PrinterDecorator(Printer printer) {
        this.printer = printer;
    }
}
