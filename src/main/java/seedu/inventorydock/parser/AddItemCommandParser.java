package seedu.inventorydock.parser;

import java.util.logging.Level;
import java.util.logging.Logger;

import seedu.inventorydock.command.AddItemCommand;
import seedu.inventorydock.command.Command;
import seedu.inventorydock.exception.InventoryDockException;
import seedu.inventorydock.model.Item;
import seedu.inventorydock.model.items.Accessories;
import seedu.inventorydock.model.items.Drinks;
import seedu.inventorydock.model.items.Fruit;
import seedu.inventorydock.model.items.Meat;
import seedu.inventorydock.model.items.Snack;
import seedu.inventorydock.model.items.Toiletries;
import seedu.inventorydock.model.items.Vegetable;
import seedu.inventorydock.parser.category.BooleanFieldParser;
import seedu.inventorydock.parser.category.CommonFieldParser;
import seedu.inventorydock.parser.category.InputValidator;

/**
 * Converts validated add-item arguments into category-specific {@link Item}
 * instances wrapped in {@link AddItemCommand} objects.
 */
public class AddItemCommandParser {
    private static final Logger logger = Logger.getLogger(AddItemCommandParser.class.getName());

    public Command handleFruit(String input) throws InventoryDockException {
        assert input != null : "AddItemCommandParser received null fruit input.";
        InputValidator.validate(input, "category/", "item/", "bin/", "qty/",
                "expiryDate/", "isRipe/");

        CommonFieldParser commonFields = CommonFieldParser.parse(input, "isRipe/");
        boolean isRipe = BooleanFieldParser.parse(input, "isRipe/");
        Item item = new Fruit(commonFields.itemName, commonFields.quantity, commonFields.bin,
                commonFields.expiryDate, isRipe);

        return new AddItemCommand(commonFields.categoryName, item);
    }

    public Command handleSnack(String input) throws InventoryDockException {
        assert input != null : "AddItemCommandParser received null snack input.";
        InputValidator.validate(input, "category/", "item/", "bin/", "qty/",
                "expiryDate/", "isCrunchy/");

        CommonFieldParser commonFields = CommonFieldParser.parse(input, "isCrunchy/");
        boolean isCrunchy = BooleanFieldParser.parse(input, "isCrunchy/");
        Item item = new Snack(commonFields.itemName, commonFields.quantity, commonFields.bin,
                commonFields.expiryDate, isCrunchy);

        return new AddItemCommand(commonFields.categoryName, item);
    }

    public Command handleToiletries(String input) throws InventoryDockException {
        assert input != null : "AddItemCommandParser received null toiletries input.";
        InputValidator.validate(input, "category/", "item/", "bin/", "qty/",
                "expiryDate/", "isLiquid/");

        CommonFieldParser commonFields = CommonFieldParser.parse(input, "isLiquid/");
        boolean isLiquid = BooleanFieldParser.parse(input, "isLiquid/");
        Item item = new Toiletries(commonFields.itemName, commonFields.quantity, commonFields.bin,
                commonFields.expiryDate, isLiquid);

        return new AddItemCommand(commonFields.categoryName, item);
    }

    public Command handleVegetables(String input) throws InventoryDockException {
        assert input != null : "AddItemCommandParser received null vegetable input.";
        InputValidator.validate(input, "category/", "item/", "bin/", "qty/",
                "expiryDate/", "isLeafy/");

        CommonFieldParser commonFields = CommonFieldParser.parse(input, "isLeafy/");
        boolean isLeafy = BooleanFieldParser.parse(input, "isLeafy/");
        Item item = new Vegetable(commonFields.itemName, commonFields.quantity, commonFields.bin,
                commonFields.expiryDate, isLeafy);

        return new AddItemCommand(commonFields.categoryName, item);
    }

    public Command handleDrinks(String input) throws InventoryDockException {
        assert input != null : "AddItemCommandParser received null drinks input.";
        logger.log(Level.INFO, "Parsing add-item command for drinks.");
        InputValidator.validate(input, "category/", "item/", "bin/", "qty/",
                "expiryDate/", "isCarbonated/");

        CommonFieldParser commonFields = CommonFieldParser.parse(input, "isCarbonated/");
        boolean isCarbonated = BooleanFieldParser.parse(input, "isCarbonated/");
        Item item = new Drinks(commonFields.itemName, commonFields.quantity, commonFields.bin,
                commonFields.expiryDate, isCarbonated);

        logger.log(Level.INFO, "Created drinks item command for category: " + commonFields.categoryName);
        return new AddItemCommand(commonFields.categoryName, item);
    }

    public Command handleMeat(String input) throws InventoryDockException {
        assert input != null : "AddItemCommandParser received null meat input.";
        logger.log(Level.INFO, "Parsing add-item command for meat.");
        InputValidator.validate(input, "category/", "item/", "bin/", "qty/",
                "expiryDate/", "isFrozen/");

        CommonFieldParser commonFields = CommonFieldParser.parse(input, "isFrozen/");
        boolean isFrozen = BooleanFieldParser.parse(input, "isFrozen/");
        Item item = new Meat(commonFields.itemName, commonFields.quantity, commonFields.bin,
                commonFields.expiryDate, isFrozen);

        logger.log(Level.INFO, "Created meat item command for category: " + commonFields.categoryName);
        return new AddItemCommand(commonFields.categoryName, item);
    }

    public Command handleAccessories(String input) throws InventoryDockException {
        assert input != null : "AddItemCommandParser received null accessories input.";
        logger.log(Level.INFO, "Parsing add-item command for accessories.");
        InputValidator.validate(input, "category/", "item/", "bin/", "qty/",
                "expiryDate/", "isFragile/");

        CommonFieldParser commonFields = CommonFieldParser.parse(input, "isFragile/");
        boolean isFragile = BooleanFieldParser.parse(input, "isFragile/");
        Item item = new Accessories(commonFields.itemName, commonFields.quantity, commonFields.bin,
                commonFields.expiryDate, isFragile);

        logger.log(Level.INFO, "Created accessories item command for category: " + commonFields.categoryName);
        return new AddItemCommand(commonFields.categoryName, item);
    }
}
