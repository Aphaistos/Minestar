package fr.aphaistos.minestar.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import fr.aphaistos.minestar.MinestarMod;
import fr.aphaistos.minestar.blocks.entity.NasaWorkbenchBlockEntity;
import fr.aphaistos.minestar.container.NasaWorkbenchContainer;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class NasaWorkbenchScreen extends AbstractContainerScreen<NasaWorkbenchContainer> {
	public static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(MinestarMod.MODID, "textures/gui/nasa_workbench.png");
	
	public NasaWorkbenchScreen(NasaWorkbenchContainer container, Inventory playerInventory, Component title) {
		super(container, playerInventory, NasaWorkbenchBlockEntity.TITLE);
		this.leftPos = 0;
		this.topPos = 0;
		this.imageWidth = 176;
		this.imageHeight = 224;
	}

	@Override
	protected void renderBg(PoseStack stack, float partialTicks, int mouseX, int mouseY) {
		this.renderBackground(stack);
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
		RenderSystem.setShaderTexture(0, TEXTURE_LOCATION);
		blit(stack, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
		int energy = this.menu.getEnergy();
		int height = energy * 50 / this.menu.getMaxEnergy();
		blit(stack, this.leftPos + 155, this.topPos + 7, 176, 0, 14, height);
		
		if(mouseX >= (this.leftPos + 155) && mouseX <= (this.leftPos + 168) &&
				mouseY >= (this.topPos + 7) && mouseY <= (this.topPos + 56)) {
			renderTooltip(stack, new TextComponent(this.menu.getEnergy() + " RF"), mouseX, mouseY);
		}
	}
	
	@Override
	public void render(PoseStack stack, int mouseX, int mouseY, float partialTicks) {
		super.render(stack, mouseX, mouseY, partialTicks);
 		this.font.draw(stack, title, this.leftPos + 8, this.topPos + 6, 4210752);
		this.font.draw(stack, this.playerInventoryTitle, this.leftPos + 8, this.imageHeight - 85, 4210752);
		
		this.renderTooltip(stack, mouseX, mouseY);
	}
	
	@Override
	protected void renderLabels(PoseStack stack, int mouseX, int mouseY) {
	}
	
	@Override
	protected void init() {
		super.init();
		
	}

}