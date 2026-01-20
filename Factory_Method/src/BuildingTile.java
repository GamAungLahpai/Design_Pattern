/**
 * Concrete implementation of Tile representing a building terrain.
 */
public class BuildingTile extends Tile {

    @Override
    public char getCharacter() {
        return 'B';
    }

    @Override
    public String getDescription() {
        return "Building";
    }

    @Override
    public void action() {
        System.out.println("Entering the building...");
    }
}
