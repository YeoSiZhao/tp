package seedu.duke;

import java.util.Scanner;

import seedu.duke.command.Command;
import seedu.duke.model.Category;
import seedu.duke.model.Inventory;
import seedu.duke.parser.Parser;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        Inventory inventory = new Inventory();
        addDefaultCategories(inventory);

        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! Welcome to InventoryDock!");
        System.out.println("What can I do for you?");

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            Command command = parser.parse(input);

            if (command == null) {
                continue;
            }

            command.execute(inventory);
        }

        scanner.close();
    }

    private static void addDefaultCategories(Inventory inventory) {
        Category fruitsCategory = new Category("fruits");
        Category vegetablesCategory = new Category("vegetables");
        Category toiletriesCategory = new Category("toiletries");
        Category snacksCategory = new Category("snacks");

        inventory.addCategories(fruitsCategory);
        inventory.addCategories(vegetablesCategory);
        inventory.addCategories(toiletriesCategory);
        inventory.addCategories(snacksCategory);
    }
}
