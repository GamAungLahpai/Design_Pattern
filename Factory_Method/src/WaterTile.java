public class WaterTile extends Tile {

    @Override
    public char getCharacter() {
        return 'W';
    }

    @Override
    public String getDescription() {
        return "Water";
    }

    @Override
    public void action() {
        System.out.println("Swimming across the water...");
    }
}
