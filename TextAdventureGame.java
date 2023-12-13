import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Room {
    String description;
    Map<String, Room> exits = new HashMap<>();
    Map<String, Item> items = new HashMap<>();

    Room(String description) {
        this.description = description;
    }
}

class Item {
    String name;
    String description;

    Item(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

public class TextAdventureGame {
    static Scanner scanner = new Scanner(System.in);
    static Room currentRoom;
    static Map<String, Item> inventory = new HashMap<>();

    public static void main(String[] args) {
        // Create rooms
        Room livingRoom = new Room("You are in the living room. There is a door to the north.");
        Room kitchen = new Room("You are in the kitchen. There is a key on the table.");
        Room bedroom = new Room("You are in the bedroom. There is a locked chest.");

        // Create items
        Item key = new Item("key", "A small rusty key");

        // Add items to rooms
        kitchen.items.put("key", key);

        // Connect rooms
        livingRoom.exits.put("north", kitchen);
        kitchen.exits.put("south", livingRoom);
        kitchen.exits.put("north", bedroom);
        bedroom.exits.put("south", kitchen);

        // Set starting room
        currentRoom = livingRoom;

        // Game loop
        while (true) {
            System.out.println(currentRoom.description);
            printInventory();

            String command = scanner.nextLine().toLowerCase();
            processCommand(command);
        }
    }

    static void processCommand(String command) {
        String[] parts = command.split(" ");
        String action = parts[0];

        switch (action) {
            case "go":
                go(parts);
                break;
            case "look":
                look();
                break;
            case "take":
                take(parts);
                break;
            case "inventory":
                printInventory();
                break;
            case "quit":
                System.out.println("Thanks for playing. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid command. Try again.");
        }
    }

    static void go(String[] parts) {
        if (parts.length < 2) {
            System.out.println("Go where? Please specify a direction.");
            return;
        }

        String direction = parts[1];
        Room nextRoom = currentRoom.exits.get(direction);

        if (nextRoom == null) {
            System.out.println("You can't go that way.");
        } else {
            currentRoom = nextRoom;
        }
    }

    static void look() {
        System.out.println("You look around. " + currentRoom.description);

        if (!currentRoom.items.isEmpty()) {
            System.out.print("You see the following items: ");
            for (Item item : currentRoom.items.values()) {
                System.out.print(item.name + " ");
            }
            System.out.println();
        }
    }

    static void take(String[] parts) {
        if (parts.length < 2) {
            System.out.println("Take what? Please specify an item.");
            return;
        }

        String itemName = parts[1];
        Item item = currentRoom.items.get(itemName);

        if (item == null) {
            System.out.println("That item is not here.");
        } else {
            currentRoom.items.remove(itemName);
            inventory.put(itemName, item);
            System.out.println("You take the " + item.name + ".");
        }
    }

    static void printInventory() {
        if (!inventory.isEmpty()) {
            System.out.print("Inventory: ");
            for (Item item : inventory.values()) {
                System.out.print(item.name + " ");
            }
            System.out.println();
        }
    }
}
