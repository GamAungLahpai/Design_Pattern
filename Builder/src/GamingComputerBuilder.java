public class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        computer = new Computer();
    }

    public void buildProcessor() {
        computer.setProcessor("Intel i9");
    }

    public void buildRAM() {
        computer.setRAM(32);
    }

    public void buildHardDrive() {
        computer.setHardDrive("1TB SSD");
    }

    public void buildGraphicsCard() {
        computer.setGraphicsCard("NVIDIA RTX 4080");
    }

    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 11");
    }

    public Computer getComputer() {
        return computer;
    }
}