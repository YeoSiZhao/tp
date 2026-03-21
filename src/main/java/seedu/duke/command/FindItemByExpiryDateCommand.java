package seedu.duke.command;

import seedu.duke.model.Category;
import seedu.duke.model.Inventory;
import seedu.duke.model.Item;
import seedu.duke.ui.UI;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FindItemCommand extends Command {
    private static Logger logger = Logger.getLogger(DeleteItemCommand.class.getName());

    private final String itemName;

    public FindItemCommand(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public void execute(Inventory inventory, UI ui) {
        assert inventory != null : "FindItemCommand received null inventory.";
        assert ui != null : "FindItemCommand received null UI.";
        assert itemName != null : "FindItemCommand received null item name.";
        logger.log(Level.INFO, "Attempting to find item: " + itemName);

        List<Category> categories = inventory.getCategories();

        for (Category category : categories) {
            Item item = category.findItemByName(itemName);
            if (item != null) {
                category.getItems().remove(item);
                logger.log(Level.INFO, "Deleted item " + itemName + " from category " + category.getName());
                ui.showItemDeleted(itemName,
                        category.getName());
                return;
            }
        }

        logger.log(Level.WARNING, "Item not found for deletion: " + itemName);
        ui.showItemNotFound(itemName);
    }
}
