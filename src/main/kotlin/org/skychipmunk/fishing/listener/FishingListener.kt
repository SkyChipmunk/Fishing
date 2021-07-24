package org.skychipmunk.fishing.listener

import org.bukkit.Bukkit
import org.bukkit.Sound
import org.bukkit.entity.Item
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerFishEvent
import org.skychipmunk.fishing.data.FishingDatas.fishingDatas
import org.skychipmunk.fishing.util.lore
import java.util.*

class FishingListener: Listener {

    private val random = Random()
    @EventHandler
    fun PlayerFishEvent.onPlayerFishEvent() {
        if (fishingDatas.isNotEmpty() && (random.nextInt(100) + 1) > 10 && state == PlayerFishEvent.State.CAUGHT_FISH){
            fishingDatas.add((fishingDatas.sortedDescending()[0] + 1).coerceAtMost(20))
            Bukkit.broadcastMessage("§a${player.name}님의 물고기 최고기록을 달성 하셨습니다 길이: ${fishingDatas.sortedDescending()[0]}")
            player.playSound(player.location, Sound.ENTITY_PLAYER_LEVELUP, 1f ,1f)
        }
        val length = if (fishingDatas.isEmpty()) 10 else fishingDatas.sortedDescending()[0]
        if (caught is Item) {
            (caught as Item).itemStack.lore(listOf("§aFishing Length: $length Cm"))
            fishingDatas.add(length)
        }
    }
}