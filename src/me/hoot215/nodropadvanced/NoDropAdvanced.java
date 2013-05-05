/*
 * Prevent items from being dropped, based on permissions.
 * Copyright (C) 2013 Andrew Stevanus (Hoot215) <hoot893@gmail.com>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.hoot215.nodropadvanced;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class NoDropAdvanced extends JavaPlugin implements Listener
  {
    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerDeath (PlayerDeathEvent event)
      {
        if (event.getEntity().hasPermission("nodropadvanced.nodrop"))
          {
            event.getDrops().clear();
          }
      }
    
    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerDropItem (PlayerDropItemEvent event)
      {
        if (event.getPlayer().hasPermission("nodropadvanced.nodrop"))
          {
            event.setCancelled(true);
          }
      }
    
    @Override
    public void onDisable ()
      {
        this.getLogger().info("Is now disabled");
      }
    
    @Override
    public void onEnable ()
      {
        this.getServer().getPluginManager().registerEvents(this, this);
        
        this.getLogger().info("Is now enabled");
      }
  }
