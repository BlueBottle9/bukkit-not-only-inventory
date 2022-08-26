package bluescreen9.minecraft.bukkit.notonlyinventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

/**
 * An "inventory gui"
 * */
public class InventoryGui {
			private Plugin plugin;
			private Inventory container;
			private HashMap<Integer, ItemButton> buttons = new HashMap<Integer, ItemButton>();
			private HashMap<ItemStack, ItemButton> icons = new HashMap<ItemStack, ItemButton>();
			
			/**
			 * @param plugin The plugin to register the event listener. - 注册监听器的插件
			 * @param container The inventory of gui. - Gui的物品栏
			 * */
			public InventoryGui(Plugin plugin,Inventory container) {
				this.plugin = plugin;
				this.container = container;
				this.plugin.getServer().getPluginManager().registerEvents(new ClickListener(this), plugin);
			}
			
			/**
			 * @param plugin The plugin to register the event listener. - 注册监听器的插件
			 * @param size The size of gui's Inventory. - Gui物品栏的大小
			 * */
			public InventoryGui(Plugin plugin,int size) {
				this.plugin = plugin;
				this.container = Bukkit.createInventory(null, size);
				this.plugin.getServer().getPluginManager().registerEvents(new ClickListener(this), plugin);
			}
			
			/**
			 * @param plugin The plugin to register the event listener. - 注册监听器的插件
			 * @param size The size of gui's Inventory. - Gui物品栏的大小
			 * @param title The title of the gui. - Gui 的标题
			 * */
			public InventoryGui(Plugin plugin,int size,String title) {
				this.plugin = plugin;
				this.container = Bukkit.createInventory(null, size,title);
				this.plugin.getServer().getPluginManager().registerEvents(new ClickListener(this), plugin);
			}
			
			/**
			 * Set a button to a position of gui. - 设置Gui中的按钮
			 * @param button The button set to the gui. - 设置到gui中的按钮
			 * @param position The position the button sets. - 按钮设置的位置 
			 * */
			public void setButton(ItemButton button,int position) {
				buttons.put(position, button);
				icons.put(button.getIcon(), button);
				container.setItem(position, button.getIcon());
				button.gui = this;
			}
			
			/**
			 * Remove a button from the gui. - 从Gui中移除一个按钮
			 * @param position The posion of the button. - 按钮的位置
			 * */
			public void removeButton(int position) {
				buttons.remove(position);
				icons.remove(getButton(position).getIcon());
				container.setItem(position, null);
			}
			
			/**
			 * Get a button in the gui. - 从Gui中得到按钮
			 * @param position The position of the button. - 按钮的位置
			 * @return The button in the position. - 这个位置上的按钮 
			 * */
			public ItemButton getButton(int position) {
				return buttons.get(position);
			}
			
			/**
			 * Get a button in the gui. - 从Gui中得到按钮
			 * @param icon The icon of the button. - 按钮的"图标"
			 * @return The button with this icon. - 这个图标对应的按钮 
			 * */
			public ItemButton getButton(ItemStack icon) {
				return icons.get(icon);
			}
			
			/**
			 * Set the inventory of the gui. - 设置Gui的物品栏
			 * @param container The inventory sets to the gui. - 设置的物品栏
			 * */
			public void setContainer(Inventory container) {
				this.container = container;
			}
			
			/**
			 * Get the inventory of gui. - 得到Gui的物品栏
			 * @return The inventory of this gui. - 这个Gui的物品栏
			 * */
			public Inventory getContainer() {
				return this.container;
			}
			
			/**
			 * Get all buttons of the gui. - 得到这个Gui中的全部按钮
			 * @return The list of buttons. - 按钮列表
			 * */
			public List<ItemButton> getButtons() {
				ArrayList<ItemButton> list = new ArrayList<ItemButton>();
				list.addAll(buttons.values());
				return list;
			}
			
			protected List<ItemStack> getIcon() {
				ArrayList<ItemStack> list = new ArrayList<ItemStack>();
				for (ItemButton ib:getButtons()) {
					list.add(ib.getIcon());
				}
				return list;
			}
			
}
