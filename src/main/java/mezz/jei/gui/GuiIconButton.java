package mezz.jei.gui;

import mezz.jei.api.gui.IDrawable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

/**
 * A gui button that has an {@link IDrawable} instead of a string label.
 */
public class GuiIconButton extends GuiButton {
	private final IDrawable icon;

	public GuiIconButton(int buttonId, IDrawable icon) {
		this(buttonId, 0, 0, 0, 0, icon);
	}

	public GuiIconButton(int buttonId, int x, int y, int widthIn, int heightIn, IDrawable icon) {
		super(buttonId, x, y, widthIn, heightIn, "");
		this.icon = icon;
	}

	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY) {
		super.drawButton(mc, mouseX, mouseY);
		if (this.visible) {
			int xOffset = xPosition + (height - this.icon.getWidth()) / 2;
			int yOffset = yPosition + (width - this.icon.getHeight()) / 2;
			this.icon.draw(mc, xOffset, yOffset);
		}
	}
}