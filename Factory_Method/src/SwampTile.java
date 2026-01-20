public class SwampTile extends Tile {

    @Override
    public char getCharacter() {
        return 'S';
    }

    @Override
    public String getDescription() {
        return "Swamp";
    }

    @Override
    public void action() {
        System.out.println("Slogging through muddy swamp water...");
    }
}
