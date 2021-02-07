package de.bl4ckskull666.landscost.classes;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Bl4ckSkull666
 */
public class ItemCost {
    private final Material _mat;
    private final int _amount;
    private final double _multiplicator;
    
    public ItemCost(ConfigurationSection cs) {
        if(cs.isString("material") && Material.valueOf(cs.getString("material").toUpperCase()) != null) {
            _mat = Material.valueOf(cs.getString("material").toUpperCase());
            _amount = cs.getInt("amount", 1);
            _multiplicator = cs.getDouble("multipli", 0.0d);
        } else {
            _mat = null;
            _amount = 0;
            _multiplicator = 0.0d;
        }
    }
    
    public Material getMaterial() {
        return _mat;
    }
    
    public int getAmount() {
        return _amount;
    }
    
    public double getMultiplicator() {
        return _multiplicator;
    }
    
    public ItemStack getItemStack() {
        if(_mat == null)
            return null;
        
        return new ItemStack(_mat, _amount);
    }
}
