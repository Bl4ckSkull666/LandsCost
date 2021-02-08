package de.bl4ckskull666.landscost.events;

import de.bl4ckskull666.landscost.LCost;
import de.bl4ckskull666.landscost.classes.ItemCost;
import de.bl4ckskull666.landscost.classes.LanguageManager;
import de.bl4ckskull666.landscost.utils.Inventories;
import java.util.HashMap;
import me.angeschossen.lands.api.events.ChunkPreClaimEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

/**
 *
 * @author Bl4ckSkull666
 */
public class Claim implements Listener {
    @EventHandler(priority = EventPriority.LOWEST)
    public void doChunkPreClaim(ChunkPreClaimEvent e) {
        if(LCost.getPlugin().getConfig().getBoolean("debug", false))
            LCost.getPlugin().getLogger().severe("do claim by " + e.getLandPlayer().getPlayer().getDisplayName());
        
        ItemCost cost = LCost.getCostClaim();
        if(cost.getMaterial() == null)
            return;
        
        double multipli = 1.0d;
        if(e.getLandPlayer().getEditLand() != null && cost.getMultiplicator() > 0.0) {
            multipli = (1.0d+(cost.getMultiplicator()*e.getLandPlayer().getEditLand().getSize()));
        }
        
        int amount = (int)Math.ceil(cost.getAmount()*multipli);
        HashMap<String, String> sr = new HashMap<>();
        sr.put("%claim%", String.valueOf(e.getLandPlayer().getEditLand().getSize()+1));
        sr.put("%item%", cost.getMaterial().name());
        sr.put("%itemname%", LanguageManager.getTextMessage(e.getLandPlayer().getPlayer().getLocale(), "item." + cost.getMaterial().name().toLowerCase(), cost.getMaterial().name().toLowerCase().replaceAll("_", " "), null));
        sr.put("%amount%", String.valueOf(amount));
        
        if(!Inventories.canPay(e.getLandPlayer().getPlayer(), cost.getMaterial(), amount)) {
            LanguageManager.sendMessage(e.getLandPlayer().getPlayer(), "claim.no-item", "You need %item% x %amount% for the %claim%. claim.", sr);
            e.setCancelled(true);
            return;
        }
        
        Inventories.payIt(e.getLandPlayer().getPlayer(), cost.getMaterial(), amount);
        LanguageManager.sendMessage(e.getLandPlayer().getPlayer(), "claim.paid-item", "You paid %amount% of %item% for the %claim%. claim of new land.", sr);
    }
}
