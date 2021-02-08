package de.bl4ckskull666.landscost.events;

import de.bl4ckskull666.landscost.LCost;
import de.bl4ckskull666.landscost.classes.ItemCost;
import de.bl4ckskull666.landscost.classes.LanguageManager;
import de.bl4ckskull666.landscost.utils.Inventories;
import java.util.HashMap;
import me.angeschossen.lands.api.events.LandCreateEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

/**
 *
 * @author Bl4ckSkull666
 */
public class Create implements Listener {
    @EventHandler(priority = EventPriority.LOWEST)
    public void doLandCreate(LandCreateEvent e) {
        if(LCost.getPlugin().getConfig().getBoolean("debug", false))
            LCost.getPlugin().getLogger().severe("do create by " + e.getLandPlayer().getPlayer().getDisplayName());
        
        ItemCost cost = LCost.getCostCreate();
        if(cost.getMaterial() == null)
            return;
        
        double multipli = 1.0d;
        if(e.getLandPlayer().getLands().size() > 1 && cost.getMultiplicator() > 0.0) {
            multipli = (1.0d+(cost.getMultiplicator()*e.getLandPlayer().getLands().size()));
        }
        
        int amount = (int)Math.ceil(cost.getAmount()*multipli);
        HashMap<String, String> sr = new HashMap<>();
        sr.put("%land%", String.valueOf(e.getLandPlayer().getLands().size()+1));
        sr.put("%item%", cost.getMaterial().name());
        sr.put("%itemname%", LanguageManager.getTextMessage(e.getLandPlayer().getPlayer().getLocale(), "item." + cost.getMaterial().name().toLowerCase(), cost.getMaterial().name().toLowerCase().replaceAll("_", " "), null));
        sr.put("%amount%", String.valueOf(amount));
        
        if(!Inventories.canPay(e.getLandPlayer().getPlayer(), cost.getMaterial(), amount)) {
            LanguageManager.sendMessage(e.getLandPlayer().getPlayer(), "create.no-item", "You need %item% x %amount% for the creation of Land number %land%.", sr);
            e.setCancelled(true);
            return;
        }
        
        Inventories.payIt(e.getLandPlayer().getPlayer(), cost.getMaterial(), amount);
        LanguageManager.sendMessage(e.getLandPlayer().getPlayer(), "create.paid-item", "You paid %amount% of %item% for the %land%. Land creation.", sr);
    }
}
