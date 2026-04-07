# User Guide

## Introduction

InventoryDock helps store managers keep track of inventory by category, quantity, expiry date, and bin location.
This guide covers the commands needed to add items, list all stored items, and search by category, expiry date, bin, or quantity.

## Quick Start

1. Ensure that you have Java 17 or above installed.
2. Download the latest version of the application jar.
3. Open a terminal in the project folder.
4. Run `java -jar duke.jar`.
5. Type a command and press Enter.

## Command Format

Notes about command syntax:

* Command words are not case-sensitive. For example, `LIST` and `list` are treated the same.
* Category matching is case-insensitive. For example, `fruits` and `FRUITS` refer to the same category.
* Field names are case-sensitive. Type them exactly as shown, such as `category/`, `item/`, `qty/`, and `expiryDate/`.
* For `add`, fields must be entered in the correct order for the selected category.
* Boolean fields only accept `true` or `false`.
* Quantities must be positive integers.
* Dates must use `yyyy-M-d`, for example `2026-3-9` or `2026-12-31`.
* Bin searches accept `LETTER-NUMBER`, `LETTER`, or `NUMBER`, such as `A-10`, `A`, or `10`.
* Quantity searches return items whose quantity is less than or equal to the specified positive integer.
* `update` only supports changing common item fields. Category-specific fields cannot be updated.
* `sort` only supports sorting by name, expiry date and quantity.

## Data Storage

InventoryDock stores data in `data/inventory.txt`.

* Data is saved automatically after every successfully executed command.
* Data is also saved when you exit the app with `bye`.
* If the storage file contains corrupted lines, the app skips those lines and continues loading the rest of the inventory.

## Features

Notes about the command format:

* Words in `UPPER_CASE` are placeholders you should replace with your own values.
* Item and category values are matched case-insensitively by the app.
* For `add`, fields must appear in the correct order.

### Adding an item: `add`
Adds a new item to an existing category.

Format:

`add category/CATEGORY item/ITEM bin/BIN qty/QUANTITY expiryDate/DATE ...`

Common required fields:

* `category/` specifies the item category.
* `item/` specifies the item name.
* `bin/` specifies the bin location.
* `qty/` specifies the quantity as a positive integer.
* `expiryDate/` specifies the expiry date.

Supported categories and extra fields:

* Fruits
  `add category/fruits item/ITEM bin/BIN qty/QUANTITY expiryDate/DATE size/SIZE isRipe/BOOLEAN`
* Vegetables
  `add category/vegetables item/ITEM bin/BIN qty/QUANTITY expiryDate/DATE isLeafy/BOOLEAN`
* Toiletries
  `add category/toiletries item/ITEM bin/BIN qty/QUANTITY expiryDate/DATE brand/BRAND isLiquid/BOOLEAN`
* Snacks
  `add category/snacks item/ITEM bin/BIN qty/QUANTITY expiryDate/DATE brand/BRAND isCrunchy/BOOLEAN`
* Drinks
  `add category/drinks item/ITEM bin/BIN qty/QUANTITY expiryDate/DATE brand/BRAND flavour/FLAVOUR isCarbonated/BOOLEAN`
* Ice cream
  `add category/icecream item/ITEM bin/BIN qty/QUANTITY expiryDate/DATE flavour/FLAVOUR isDairyFree/BOOLEAN`
* Sweets
  `add category/sweets item/ITEM bin/BIN qty/QUANTITY expiryDate/DATE brand/BRAND sweetnessLevel/LEVEL isChewy/BOOLEAN`

