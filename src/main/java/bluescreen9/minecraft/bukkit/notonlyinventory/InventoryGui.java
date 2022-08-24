package bluescreen9.minecraft.bukkit.notonlyinventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class InventoryGui {
			private Plugin plugin;
			private Inventory container;
			private HashMap<Integer, ItemButton> buttons = new HashMap<Integer, ItemButton>();
			private HashMap<ItemStack, ItemButton> icons = new HashMap<ItemStack, ItemButton>();
			
			public InventoryGui(Plugin plugin,Inventory container) {
				this.plugin = plugin;
				this.container = container;
				this.plugin.getServer().getPluginManager().registerEvents(new ClickListener(this), plugin);
			}
			
			public InventoryGui(Plugin plugin,int size) {
				this.plugin = plugin;
				this.container = Bukkit.createInventory(null, size);
				this.plugin.getServer().getPluginManager().registerEvents(new ClickListener(this), plugin);
			}
			
			public InventoryGui(Plugin plugin,int size,String title) {
				this.plugin = plugin;
				this.container = Bukkit.createInventory(null, size,title);
				this.plugin.getServer().getPluginManager().registerEvents(new ClickListener(this), plugin);
			}
			
			public void setButton(ItemButton button,int position) {
				buttons.put(position, button);
				icons.put(button.getIcon(), button);
				container.setItem(position, button.getIcon());
			}
			
			public void removeButton(int position) {
				buttons.remove(position);
				icons.remove(getButton(position).getIcon());
				container.setItem(position, null);
			}
			
			public ItemButton getButton(int position) {
				return buttons.get(position);
			}
			
			public ItemButton getButton(ItemStack icon) {
				return icons.get(icon);
			}
			
			public void setContainer(Inventory container) {
				this.container = container;
			}
			
			public Inventory getContainer() {
				return this.container;
			}
			
			public List<ItemButton> getButtons() {
				ArrayList<ItemButton> list = new ArrayList<ItemButton>();
				list.addAll(buttons.values());
				return list;
			}
			
			public List<ItemStack> getIcon() {
				ArrayList<ItemStack> list = new ArrayList<ItemStack>();
				for (ItemButton ib:getButtons()) {
					list.add(ib.getIcon());
				}
				return list;
			}
			
}
