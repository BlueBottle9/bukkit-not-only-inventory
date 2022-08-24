package bluescreen9.minecraft.bukkit.notonlyinventory;


import org.bukkit.inventory.ItemStack;

public class ItemButton {
			private ItemStack icon;
			protected Clickable click;
			protected InventoryGui gui;
			
			public ItemButton(ItemStack icon, Clickable click) {
				this.icon = icon;
				this.click = click;
			}
			
			public void setIcon(ItemStack icon) {
				this.icon = icon;
			}
			
			public ItemStack getIcon() {
				return this.icon;
			}
			
			public InventoryGui getGui() {
				return this.gui;
			}
			
			public void setClick(Clickable click) {
				this.click = click;
			}
			
			public Clickable getClick() {
				return this.click;
			}
			
}
