public class RoadTile extends Tile {

    @Override
    public char getCharacter() {
        return 'R';
    }

    @Override
    public String getDescription() {
        return "Road";
    }

    @Override
    public void action() {
        System.out.println("Walking along the paved road...");
    }
}
