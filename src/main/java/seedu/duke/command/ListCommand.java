package seedu.duke.command;

import seedu.duke.model.Inventory;
import seedu.duke.ui.UI;

public class ListCommand extends Command {
    @Override
    public void execute(Inventory inventory, UI ui) {
        ui.showInventory(inventory);
    }
}
