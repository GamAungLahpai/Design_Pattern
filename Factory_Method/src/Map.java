import java.util.Random;

public abstract class Map {
    protected int width;
    protected int height;
    protected Tile[][] tiles;
    protected Random random;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[height][width];
        this.random = new Random();
        generateMap();
    }

    public abstract Tile createTile();

    private void generateMap() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                tiles[i][j] = createTile();
            }
        }
    }

    public void display() {
        System.out.println("Map Layout:");
        System.out.println("===========");

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(tiles[i][j].getCharacter() + " ");
            }
            System.out.println();
        }

        System.out.println("\nLegend:");
        System.out.println("=======");
        printLegend();
    }

    private void printLegend() {
        boolean[] printed = new boolean[5]; // Track which types we've printed

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                char tileChar = tiles[i][j].getCharacter();
                int index = getCharIndex(tileChar);

                if (index != -1 && !printed[index]) {
                    System.out.println(tileChar + " = " + tiles[i][j].getDescription());
                    printed[index] = true;
                }
            }
        }
    }

    private int getCharIndex(char c) {
        switch (c) {
            case 'S': return 0; // Swamp
            case 'W': return 1; // Water
            case 'R': return 2; // Road
            case 'F': return 3; // Forest
            case 'B': return 4; // Building
            default: return -1;
        }
    }
}
