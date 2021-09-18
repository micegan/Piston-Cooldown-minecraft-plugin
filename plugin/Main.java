package pistoncooldown;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.block.Dispenser;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
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
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;


public class Main extends JavaPlugin implements Listener {

	
	  public FileConfiguration mobnammx;
	   public File mobnamfx = new File(this.getDataFolder(), "count.yml");

	    public void setups1x(Plugin p) {
	        if (!p.getDataFolder().exists()) {
	            p.getDataFolder().mkdir();
	        }

	        mobnamfx = new File(p.getDataFolder(), "count.yml");

	        if (!mobnamfx.exists()) {
	            try {
	            	mobnamfx.createNewFile();
	            } catch (IOException e) {
	                Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create count.yml!");
	            }
	        }

	       YamlConfiguration data = YamlConfiguration.loadConfiguration(mobnamfx);
	    }

	    public FileConfiguration getDatas1x() {
	        return mobnammx;
	    }

	    public void saveDatas1x() {
	        try {
	        	mobnammx.save(mobnamfx);
	        } catch (IOException e) {
	            Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save count.yml");
	        }
	    }

	    public void reloadDatas1x() {
	    	mobnammx = YamlConfiguration.loadConfiguration(mobnamfx);
	    } 
	
	@Override
	   public void onEnable() {
        PluginManager manager = getServer().getPluginManager();
        manager.registerEvents(this, this);
        
        
        setups1x(this);
        reloadDatas1x();
        
        if (mobnammx.get("data.pistoncount") == null) {

        mobnammx.set("data.pistoncount", 5);
        saveDatas1x();
        }
        else {
        	countx = mobnammx.getInt("data.pistoncount");
        }
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
	public int countx = 5;

	@Override
    public boolean onCommand(CommandSender sender,
                             Command command,
                             String label,
                             String[] args) {
		
        if ( command.getName().equalsIgnoreCase("pcd")) {
        	boolean got = false;
        	int d =0;
        	try {
        		d =  Integer.parseInt(args[0]);
        		got = true;
        	}
        	catch (Exception ex) {
        		got = false;
        	}
        	if (got == true) {
        	    mobnammx.set("data.pistoncount", d);
                saveDatas1x();
                countx = d;
                sender.sendMessage(ChatColor.RED + "[PistonCooldownPlugin]:" + ChatColor.YELLOW + " done, yeye!");
                
        	}
        	else {
        		sender.sendMessage(ChatColor.RED + "[PistonCooldownPlugin]:" + ChatColor.YELLOW + " can't use such a number!");
        	}
        }
        return true;
	}
	

	
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
							
							
							
							
							if (count > countx) {
								
								
								
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
	
	
	

