package com.mods.combatzak.mojo;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Manages items for registration
 * 
 * @author CombatZAK
 *
 */
public class MojoItem extends Item {
	/**
	 * default stack size
	 */
	private static final int DEFAULT_STACK_SIZE = 64;
	
	/**
	 * default creative tab
	 */
	private static final CreativeTabs DEFAULT_CREATIVE_TAB = CreativeTabs.tabMisc;
	
	/**
	 * default unlocalized name
	 */
	private static final String DEFAULT_UNLOCALIZED_NAME = "mojo.unlocalized";
	
	/**
	 * default item id
	 */
	private static final String DEFAULT_ITEMID = "mojo.itemid";
	
	/**
	 * default item id used for registration
	 */
	private static final String DEFAULT_TEXTURE_NAME = "mojo:textureName";
	
	/**
	 * item ID used for registration
	 */
	protected String itemId;
	
	/**
	 * Item tooltip
	 */
	protected String tooltip;
	
	/**
	 * Gets the registration item id
	 * 
	 * @return ID used for item registration
	 */
	public String getItemId() {
		return this.itemId;
	}
	
	/**
	 * Sets the registration item id
	 * 
	 * @param value ID used for item registration
	 */
	public void setItemId(String value) {
		this.itemId = value;
	}
	
	/**
	 * Self-referentially sets the registration item id
	 * 
	 * @param value ID used for item registration
	 * @return self-reference
	 */
	public MojoItem withItemId(String value) {
		this.setItemId(value);
		return this;
	}
	
	/**
	 * Gets the item tooltip
	 * 
	 * @return item tooltip
	 */
	public String getTooltip() {
		return this.tooltip;
	}
	
	/**
	 * Sets the item tooltip
	 * 
	 * @param value item tooltip
	 */
	public void setTooltip(String value) {
		this.tooltip = value;
	}
	
	/**
	 * Self-referentially sets the item tooltip
	 * 
	 * @param value item tooltip
	 * @return self-reference
	 */
	public MojoItem withTooltip(String value) {
		this.setTooltip(value);
		return this;
	}
	
	/**
	 * Creates a new MojoItem instance
	 * 
	 * @param itemId registration id and unlocalized name
	 * @param creativeTab tab on which item appears
	 * @param stackSize max stack size for item
	 * @param tooltip tooltip for item
	 * @param textureName texture name
	 */
	public MojoItem(String itemId, CreativeTabs creativeTab, int stackSize, String tooltip, String textureName) {
		super();
		this.itemId = itemId;
		this.tooltip = tooltip;
		setUnlocalizedName(itemId);
		setCreativeTab(creativeTab);
		setMaxStackSize(stackSize);
		setTextureName(textureName);
	}
	
	/**
	 * Default constructor
	 */
	public MojoItem() {
		this(DEFAULT_ITEMID, DEFAULT_CREATIVE_TAB, DEFAULT_STACK_SIZE, null, DEFAULT_TEXTURE_NAME);
	}
	
	/**
	 * Sets the tooltip data
	 */
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean para4) {
		if (this.tooltip == null || this.tooltip.equals("")) return; //check for no tooltip
		String[] tokens = tooltip.split("\n"); //get the individual tooltip lines
		for (String token : tokens)
			list.add(token); //add each line sequentially
	}
}
