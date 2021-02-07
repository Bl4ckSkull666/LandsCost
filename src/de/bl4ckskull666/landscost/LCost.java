package de.bl4ckskull666.landscost;

import de.bl4ckskull666.landscost.classes.ItemCost;
import de.bl4ckskull666.landscost.classes.LanguageManager;
import de.bl4ckskull666.landscost.events.Claim;
import de.bl4ckskull666.landscost.events.Create;
import me.angeschossen.lands.api.integration.LandsIntegration;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Bl4ckSkull666
 */
public class LCost extends JavaPlugin {
    @Override
    public void onEnable() {
        _plugin = this;
        if(!Bukkit.getPluginManager().isPluginEnabled("Lands")) {
            onDisable();
            return;
        }
        
        if(!getDataFolder().exists()) {
            getDataFolder().mkdir();
            getConfig().options().copyDefaults(true);
            saveConfig();
        }
        
        _landsIntegration = new LandsIntegration(this);
        _language = new LanguageManager();
        
        if(getConfig().isConfigurationSection("cost.create"))
            _costCreate = new ItemCost(getConfig().getConfigurationSection("cost.create"));
        
        if(getConfig().isConfigurationSection("cost.claim"))
            _costClaim = new ItemCost(getConfig().getConfigurationSection("cost.claim"));
        
        getCommand("languagemanager").setExecutor(new LanguageManager());
        
        getServer().getPluginManager().registerEvents(new Create(), this);
        getServer().getPluginManager().registerEvents(new Claim(), this);
    }
    
    private static LCost _plugin = null;
    private static LandsIntegration _landsIntegration;
    private static LanguageManager _language = null;
    private static ItemCost _costCreate = null;
    private static ItemCost _costClaim = null;
    
    public static LCost getPlugin() {
        return _plugin;
    }
    
    public static LandsIntegration getLandIntegration() {
        return _landsIntegration;
    }
    
    public static LanguageManager getLanguageManager() {
        return _language;
    }
    
    public static ItemCost getCostCreate() {
        return _costCreate;
    }
    
    public static ItemCost getCostClaim() {
        return _costClaim;
    }
}
