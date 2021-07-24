package org.skychipmunk.fishing

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import org.skychipmunk.fishing.listener.FishingListener

class Fishing : JavaPlugin(){

    companion object {
        lateinit var inst: JavaPlugin
    }

    override fun onEnable() {
        inst = this
        Bukkit.getPluginManager().registerEvents(FishingListener(), this)
    }
}