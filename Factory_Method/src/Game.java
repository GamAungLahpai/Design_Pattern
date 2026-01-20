import java.util.Scanner;

public class Game {

    public Map createMap(String mapType, int width, int height) {
        mapType = mapType.toLowerCase();

        switch (mapType) {
            case "city":
                return new CityMap(width, height);
            case "wilderness":
                return new WildernessMap(width, height);
            default:
                System.out.println("Unknown map type. Creating wilderness map by default.");
                return new WildernessMap(width, height);
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("   RPG Map Generator");
        System.out.println("   Factory Method Pattern Demo");
        System.out.println("=================================");
        System.out.println();

        // Get user input for map type
        System.out.print("Enter map type (city/wilderness): ");
        String mapType = scanner.nextLine().trim();

        // Get user input for map dimensions
        System.out.print("Enter map width: ");
        int width = scanner.nextInt();

        System.out.print("Enter map height: ");
        int height = scanner.nextInt();

        System.out.println();

        // Create and display the map
        Map map = game.createMap(mapType, width, height);
        map.display();

        System.out.println();
        System.out.println("Map generation complete!");

        scanner.close();
    }
}
