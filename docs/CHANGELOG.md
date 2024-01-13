# The Aether - Forge - 1.19.2-1.1.0

Additions

- Allow the Book of Lore to be placed in Chiseled Bookshelves.
- Add a beta resource pack texture for the Lootr variant of Mimics.
- Add Swet Balls to the Forge tag for Slimeballs.
- Update sk_sk.
- Update uk_ua.

Changes

- Disable fire tick within the Aether dimension.
- Change how Moa age is internally tracked to make aging able to be displayed by mods that show mob age info.
- Allow Skyroot Buckets to be used as Furnace fuel.
- Change the model of Aerclouds to make their interior appear hollow.
- Disallow worlds from being opened by the world preview system if they have never been opened with the Aether mod.

Fixes

- Fix performance overhead from biome checks for entities falling out of the Aether.
- Fix performance overhead from biome checks for converting block placements.
- Fix performance overhead from custom Tall Grass coloring.
- Fix inconsistent handling of damage modifiers with Holy Sword and Pig Slayer.
- Fix Aechor Plants being able to be leashed.
- Fix texture z-fighting on Phyg and Flying Cow wings at joints.
- Fix various mob and player layers not turning invisible when they should.
- Fix Parachutes not detecting block collision in all situations.
- Fix being able to jump on Blue Aerclouds before their effect is activated.
- Fix health refilling to full on respawn even when other mods modify the respawn health amount.
- Fix all items being able to be renamed to an easter egg in the Book of Lore.
- Fix null log spam about Moa Eggs from JER.
- Fix missing translation entry for blocks creative tab.

# The Aether - Forge - 1.19.2-1.0.0

View the full changelog here: https://gist.github.com/bconlon1/f2c8a57554bc8478ea7ade005df1b01d

# The Aether - Forge - 1.19.2-1.0.0-beta.2.2

Additions

- Update ms_my translation.
- Update uk_ua translation.

Changes

- Update Patreon logomark.

Fixes

- Fix server timeout from trying to access supporter data.
- Fix missing pixels on Stratus supporter skin texture.

# The Aether - Forge - 1.19.2-1.0.0-beta.2.1

Changes

- Made Tips compatibility more consistent and compatible with the trivia config.

Fixes

- Fix missing class crash with Apache Commons for servers on some machines.
- Fix crash from null Moa Skin selection when refreshing selection screen.
- Fix config for disabling gloves requirement for armor abilities not working.

# The Aether - Forge - 1.19.2-1.0.0-beta.2

Additions

- Implement the fully functional system for Patreon Moa Skins.
- Add a notification message over the player's hotbar when trying to use an item that doesn't work in the Aether.
- Add a config option `"Crystal Fruit Leaves consistency"` to allow Crystal Fruit Leaves to be right-clickable for harvesting.
- Add a config option `"Require gloves for set abilities"` to toggle whether Gloves are required with a set of armor for an armor set ability to work.
- Add a translation key for localizing the name of the Aether Loot rarity type for compatibility with other mods like Loot Beams.
- Update ru_ru translation.
- Update uk_ua translation.

Changes

- Rewrite Slider AI to use goals instead of brains to fix some issues with performance.
- Improved the check for what tools are considered pickaxes for the Slider fight for better compatibility with other mods' tools.
- Changed what Note Block instrument sounds can be made from certain Aether blocks.
- Make Sliders and Valkyrie Queens check a block's hardness to see if it is breakable before trying to break it.
- Included vanilla blocks to the Plunderer's Remorse advancement.
- Prevent colors given to item names with commands from displaying in the Book of Lore.

Fixes

- Fix a major performance issue resulting from the code for players falling out of the Aether.
- Fix the Slider trying to target killed players that have respawned outside the boss room.
- Fix silver hearts from Life Shards not shaking properly.
- Fix silver hearts from Life Shards rendering too far to the left in certain situations with other mods.
- Fix certain client statuses not being communicated to other clients, like total invisibility from the Invisibility Cloak.
- Fix the code for the Aether's boss health bars interfering with other mods' boss health bars.
- Fix the Lootr texture for Mimics showing up even when the Lootr config for using Vanilla textures is enabled.

# The Aether - Forge - 1.19.2-1.0.0-beta.1.3

Additions

- Add new Moa Skins (still work-in-progress).
- Add sounds for interacting using Swet Balls and Ambrosium Shards.
- Remove Pro Tips when the Tips mod is installed, and include all Pro Tips in Tips' selection instead.
- Update es_es translation.
- Update sk_sk translation.

Changes

- Split boss bar textures into separate files.

Fixes

- Fix crash with Optifine installed.
- Fix Moa Skins render incorrectly displaying.
- Fix JER error log from Moas.
- Fix extended reach breaking when interacting using the offhand.
- Fix Skyroot Boats and Skyroot Chest Boats not being dispensable.
- Fix an invisible multiplayer button still existing when the server button config is enabled.

# The Aether - Forge - 1.19.2-1.0.0-beta.1.2

Additions

- Add recipe for crafting the Grindstone with a Holystone Slab.

Changes

- Nerfed dart shooter damage and usage speed.
- Resized all body parts of the Moa's saddle model.
- Updated some lore entries to be more accurate to modern gameplay.

Fixes

- Fix crash with Creatures and Beasts and Mining Master
- Fix incorrect lighting with cold lightmap config.
- Fix missing Mimic sound warning.
- Fix missing chest loot with Turkish system language.

# The Aether - Forge - 1.19.2-1.0.0-beta.1.1

Changes

- Add a "Portal text y-coordinate in loading screens" config option to change the position of the "Ascending to the Aether" and "Descending from the Aether" text.

Fixes

- Fix custom GUIs from mods like Catalogue and Controlling not working with the Aether.
- Fix the Invisibility Cloak not appearing to apply visibility to players who have joined the game after the user equipped the accessory.
- Fix a rare overlap with the Aether's music when switching from creative mode to survival mode.
- Fix the Valkyrie Queen's dialogue screen showing up for all players in the vicinity.

# The Aether - Forge - 1.19.2-1.0.0-beta.1

**This beta is a full port of 1.19.4-1.0.0-beta.6.1 to 1.19.2!**