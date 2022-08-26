package bluescreen9.minecraft.bukkit.notonlyinventory;


import org.bukkit.inventory.ItemStack;
/**
 * An "item" button. - 一个物品“按钮”
 * */
public class ItemButton {
			private ItemStack icon;
			protected Clickable click;
			protected InventoryGui gui;
			
			/**
			 * @param icon The item that shows to players. - 展示给玩家的物品
			 * @param click The action called when players click the button. - 当按钮被玩家点击时执行的动作
			 * */
			public ItemButton(ItemStack icon, Clickable click) {
				this.icon = icon;
				this.click = click;
			}
			
			/**
			 * Set the item that shows to players. - 设置给玩家展示的物品
			 * @param icon The item that shows to players. - 展示给玩家的物品
			 * */
			public void setIcon(ItemStack icon) {
				this.icon = icon;
			}
			
			/**
			 * Get the item that shows to players. - 获取给玩家展示的物品
			 * @return icon The item that shows to players. - 展示给玩家的物品
			 * */
			public ItemStack getIcon() {
				return this.icon;
			}
			
			/**
			 * Get the gui that the button is in. - 得到这个按钮所在Gui
			 * @return The gui that the button is in. - 这个按钮所在的Gui
			 * */
			public InventoryGui getGui() {
				return this.gui;
			}
			
			/**
			 * Set the action of the button. - 设置按钮触发动作
			 * @param click The action. - 动作
			 * */
			public void setClick(Clickable click) {
				this.click = click;
			}
			
			/**
			 * Get the action of the button. - 获取按钮触发动作
			 * @return The action of the button. - 按钮的触发动作
			 * */
			public Clickable getClick() {
				return this.click;
			}
			
}
