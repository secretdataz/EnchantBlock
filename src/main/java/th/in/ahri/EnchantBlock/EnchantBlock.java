package th.in.ahri.EnchantBlock;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class EnchantBlock extends JavaPlugin implements Listener{

    Logger log = Bukkit.getLogger();
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        log.info("EnchantBlock by secretdataz enabled!");
    }

    @EventHandler
    public void onEnchant(EnchantItemEvent event){
        Player p = event.getEnchanter();
        if(!p.hasPermission("enchantblock.bypass")){
            return;
        }
        for(Enchantment enchantment : event.getEnchantsToAdd().keySet()){
            switch(enchantment.getId()){
                case 0:
                case 7:
                case 9:
                case 16:
                case 20:
                case 48:
                case 50:
                case 51:
                    p.sendMessage(ChatColor.DARK_RED +"คุณไม่ได้รับอนุญาตให้ใช้งาน enchantment " + enchantment.getName());
                    event.setCancelled(true);
                default:
                    continue;
            }
        }
    }
}
