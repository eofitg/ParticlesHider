package net.eofitg.particleshider.hook.explode;

import net.eofitg.particleshider.ParticlesHider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityLargeExplodeFX;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class EntityLargeExplodeFXHook extends EntityLargeExplodeFX {

    protected EntityLargeExplodeFXHook(TextureManager renderEngine, World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double p_i1213_9_, double p_i1213_11_, double p_i1213_13_) {
        super(renderEngine, worldIn, xCoordIn, yCoordIn, zCoordIn, p_i1213_9_, p_i1213_11_, p_i1213_13_);
    }

    // hideLargeExplode
    @Override
    public void renderParticle(WorldRenderer worldRendererIn, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {
        if (ParticlesHider.config.enabled && ParticlesHider.config.hideLargeExplode) return;
        super.renderParticle(worldRendererIn, entityIn, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
    }

    public static class Factory implements IParticleFactory {
        public EntityFX getEntityFX(int particleID, World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn, int... p_178902_15_) {
            return new EntityLargeExplodeFXHook(Minecraft.getMinecraft().getTextureManager(), worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);
        }
    }

}
