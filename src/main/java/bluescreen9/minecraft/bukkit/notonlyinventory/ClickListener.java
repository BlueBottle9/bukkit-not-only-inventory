package bluescreen9.minecraft.bukkit.notonlyinventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Clicking listener. - 点击监听器
 * */
public class ClickListener implements Listener{
	private InventoryGui gui;
	
				@EventHandler
				public void onClick(InventoryClickEvent event) {
						if (event.getCurrentItem() == null) {
							return;
						}
						
						if (event.getInventory() == null) {
							return;
						}
						
						if (!gui.getContainer().equals(event.getClickedInventory())) {
							return;
						}
						
						if (!gui.getIcon().contains(event.getCurrentItem())) {
							return;
						}
						event.setCancelled(true);
						gui.getButton(event.getCurrentItem()).click.onClick(event);
				}
				
				/**
				 * @param gui The gui of the listener. 监听器所属的Gui
				 * */
				public ClickListener(InventoryGui gui) {
					this.gui = gui;
				}
}
