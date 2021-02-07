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
        
        pay(p, mat, a);
        return true;
    }
    
    private static void pay(Player p, Material mat, int a) {
        int paid = 0;
        for(ItemStack item: p.getInventory().getContents()) {
            if(item.getType().equals(mat)) {
                if(item.getAmount() > (a-paid)) {
                    item.setAmount(item.getAmount()-(a-paid));
                    paid = a;
                } else if(item.getAmount() <= (a+paid)) {
                    paid += item.getAmount();
                    p.getInventory().remove(item);
                }
            }
            
            if(paid == a)
                break;
        }
        
        p.updateInventory();
    }
}
