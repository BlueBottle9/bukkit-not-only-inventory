package bluescreen9.minecraft.bukkit.notonlyinventory;

import org.bukkit.event.inventory.InventoryClickEvent;

/***
 * The action of buttons. - 按钮触发动作
 * */
public interface Clickable {
	/**
	 * The action will be called when click buttons. - 点击按钮时调用的操作
	 * @param event The event of click. - 点击事件
	 * */
				public void onClick(InventoryClickEvent event);
}
