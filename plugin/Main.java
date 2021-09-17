package pistoncooldown;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.block.Dispenser;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPistonEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Lever;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener {

	@Override
	   public void onEnable() {
        PluginManager manager = getServer().getPluginManager();
        manager.registerEvents(this, this);
	}
	
	
	@Override
	public void onDisable() {
		
	}
	
	public ArrayList<Block> lp = new ArrayList<Block>();
	public ArrayList<Block> dss = new ArrayList<Block>();
	public ArrayList<Block> redstone = new ArrayList<Block>();


     
	/*
	@EventHandler
    public void OnInventoryOpen(org.bukkit.event.inventory. e) {
		
			
		 
		
		
e.getPlayer().sendMessage("fuckdddddddd");

AnvilInventory inv = (AnvilInventory) Bukkit.createInventory(e.getPlayer(), InventoryType.ANVIL, "Anvil");

e.getPlayer().openInventory(inv);

inv.setItem(0, new ItemStack(Material.PAPER, -999));
				 
			
		
		
	}*/
	

	
	

	
	@EventHandler
	public void llpeaa(BlockPlaceEvent event) {
		if (event.getBlock().getType() == Material.DISPENSER) {
			dss.add(event.getBlock());
		}
	}
	
	@EventHandler
	public void llpaa(BlockPistonExtendEvent event) {
		
		if (lp.contains(event.getBlock())==false) {
		if (event.getBlock().getBlockPower() > 0) {
		lp.add(event.getBlock());
		}
		}
		int count = 0;
		//troebortnoe
		
		
		int fuck = lp.size();
		for (int d = 0; d < fuck; d++) {
		
			
			if (lp.get(d).getBlockPower() == 0) {
				
				lp.remove(d);
			}
			
			
		}
		
		
		
for (int k = 0; k < dss.size(); k++) {
		
			
				lp.get(k).getState().update();
			
			
			
		}
		
		
		
		int fuck1 = lp.size();
		for (int i = 0; i < fuck1; i++) {
			if (lp.get(i).getChunk() == event.getBlock().getChunk()) {
				count = count +1;
						if (i == fuck1 -1) {
							
							
							
							
							if (count > 5) {
								
								
								
								event.setCancelled(true);
								
								
							    
							}
						}
			}
		}
		
	}
	


}
		
		
		

	
	
		
	
		
		
	/*	for (int i = 0; i < nnn.size(); i++) {
			if (nnn.get(i).getClass() == ShulkerBox.class) {
				
				ArrayList<ItemStack> is = new ArrayList<ItemStack>();
				
				
				ShulkerBox sb = (ShulkerBox) nnn.get(i);
				
				
				
					if (sb.getInventory().getContents().length == 27) {
						
					}
				
			}
		}*/
	
	
	

