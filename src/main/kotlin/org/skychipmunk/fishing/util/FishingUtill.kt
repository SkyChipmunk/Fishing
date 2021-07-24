package org.skychipmunk.fishing.util

import org.bukkit.inventory.ItemStack

fun ItemStack.lore(lore: List<String>) {
    itemMeta = itemMeta?.also {
        it.lore = lore
    }
}