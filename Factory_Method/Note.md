# RPG Map Generator - Factory Method Pattern

This project demonstrates the Factory Method design pattern through an RPG map generation system.

## Overview

The application generates random maps for role-playing games using the Factory Method pattern. Maps can be either city environments or wilderness environments, each containing different types of terrain tiles.

## Design Pattern Implementation

### Factory Method Pattern Components:

1. **Abstract Product**: `Tile` - Defines the interface for map tiles
2. **Concrete Products**: `SwampTile`, `WaterTile`, `RoadTile`, `ForestTile`, `BuildingTile` - Specific tile implementations
3. **Abstract Creator**: `Map` - Defines the factory method `createTile()`
4. **Concrete Creators**: `CityMap`, `WildernessMap` - Implement the factory method for specific environments

## Map Types

### City Map
Contains randomly generated tiles of:
- **R** - Road tiles
- **F** - Forest tiles  
- **B** - Building tiles

### Wilderness Map
Contains randomly generated tiles of:
- **S** - Swamp tiles
- **W** - Water tiles
- **F** - Forest tiles

## Class Structure

```
Game
├── createMap() - Factory method to create map instances
└── main() - Entry point

Map (Abstract)
├── createTile() - Abstract factory method
├── display() - Displays the map matrix
└── generateMap() - Fills map with random tiles

CityMap extends Map
└── createTile() - Creates city-appropriate tiles

WildernessMap extends Map
└── createTile() - Creates wilderness-appropriate tiles

Tile (Abstract)
├── getCharacter() - Returns tile's character representation
├── getDescription() - Returns tile type description
└── action() - Tile-specific action (placeholder)

SwampTile, WaterTile, RoadTile, ForestTile, BuildingTile extend Tile
└── Implement all abstract methods
```

## How to Run

1. Compile the Java files:
   ```bash
   javac *.java
   ```

2. Run the application:
   ```bash
   java Game
   ```

3. Follow the prompts:
   - Enter map type: `city` or `wilderness`
   - Enter map width (number of columns)
   - Enter map height (number of rows)

## Example Output

### City Map (8x6):
```
Map Layout:
===========
B B B F B B R B 
R F F B R R B F 
R F B F R F R R 
F R R B F B B R 
F B B B F R R R 
B F R F F B F R 

Legend:
=======
B = Building
F = Forest
R = Road
```

### Wilderness Map (10x5):
```
Map Layout:
===========
W W F S W W W F W S 
F W W F W W S F W W 
S S S F F F W W W S 
W W W F W S W F W S 
W F W S F S W W S S 

Legend:
=======
W = Water
F = Forest
S = Swamp
```

## Key Features

- **Polymorphism**: The `Map.display()` method works with any tile type without knowing concrete implementations
- **Extensibility**: New tile types can be added by extending `Tile`
- **Factory Method**: Map types determine which tiles can be created through their `createTile()` implementation
- **Encapsulation**: Each class has well-defined responsibilities
- **Random Generation**: Maps are generated with random tile placement within type constraints

## Design Benefits

1. **Separation of Concerns**: Map creation logic is separated from tile creation logic
2. **Flexibility**: Easy to add new map types or tile types
3. **Maintainability**: Changes to specific tile types don't affect other components
4. **Consistency**: Each map type ensures only appropriate tiles are created
