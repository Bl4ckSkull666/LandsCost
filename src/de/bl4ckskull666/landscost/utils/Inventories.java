package de.bl4ckskull666.landscost.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Bl4ckSkull666
 */
public class Inventories {
    public static boolean canPay(Player p, Material mat, int a) {
        return p.getInventory().contains(mat, a);
    }
    
    public static boolean payIt(Player p, Material mat, int a) {
        if(!canPay(p, mat, a)) {
            return false;
        }
        
        return pay(p, mat, a);
    }
    
    private static boolean pay(Player p, Material mat, int a) {
        int cost = a;
        
        for(ItemStack item: p.getInventory().getContents()) {
            if(item != null && item.getType().equals(mat)) {
                if(item.getAmount() > a) {
                    item.setAmount(item.getAmount()-a);
                    a = 0;
                } else if(item.getAmount() == a || item.getAmount() <= a) {
                    a -= item.getAmount();
                    item.setAmount(0);
                }
            }
            
            if(a == 0) {
                p.updateInventory();
                return true;
            }
        }
        
        p.getInventory().addItem(new ItemStack(mat, (cost-a)));
        p.updateInventory();
        return false;
    }
}
