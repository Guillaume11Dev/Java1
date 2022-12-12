package com.guillaume.mc1;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;

public class MonPluginListeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();
        player.getInventory().clear();
        player.getInventory().addItem(new ItemStack(Material.COMPASS, 1));


        ItemStack customsword = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta customM = customsword.getItemMeta();
        customM.setDisplayName("Ma super épée  custom");
        customM.setLore(Arrays.asList("premiere ligne", "deuxieme ligne", "tr..."));
        customM.addEnchant(Enchantment.DAMAGE_ALL, 200,true);
        customM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        customsword.setItemMeta(customM);

        player.getInventory().setItemInOffHand(customsword);

        ItemStack customwool = new ItemStack(Material.WHITE_WOOL , 8);

        player.getInventory().setHelmet(customwool);
        player.getInventory().setItem(8, customsword);

        player.updateInventory();


    }

    @EventHandler
    public  void onInteract(PlayerInteractEvent event){

        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack it = event.getItem();

        if (it == null) return;

        if (it.getType() == Material.DIAMOND_HOE){
            if (action == Action.RIGHT_CLICK_AIR){
                player.sendMessage("Vous venez de faire un click");
            }
        }
        if (it.getType() == Material.COMPASS && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("Ma super épée  custom")){
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 4, 3,true,false,true));

            Inventory inv = Bukkit.createInventory(null, 27, "§8Mon menu");


            inv.setItem(11, getItem(Material.APPLE, "§aPassage en GameMode"));
            inv.setItem(14, getItem(Material.ANVIL,"§cGive de Tnt"));


            player.openInventory(inv);
        }
    }

   /* @EventHandler
    public void onClick(InventoryClickEvent event){

        Inventory inv = event.getInventory();
        Player player = (Player) event.getWhoClicked();
        ItemStack current = event.getCurrentItem();

    }*/


    public ItemStack getItem(Material material, String customName){
        ItemStack it = new ItemStack(material, 1);
        ItemMeta itM = it.getItemMeta();
        if (customName != null) itM.setDisplayName(customName);
        it.setItemMeta(itM);
        return  it;
    }
}





