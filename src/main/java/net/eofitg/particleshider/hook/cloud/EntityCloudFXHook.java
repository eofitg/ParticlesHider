package net.eofitg.particleshider.hook.cloud;

import net.eofitg.particleshider.ParticlesHider;
import net.minecraft.client.particle.EntityCloudFX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class EntityCloudFXHook extends EntityCloudFX {

    protected EntityCloudFXHook(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double p_i1221_8_, double p_i1221_10_, double p_i1221_12_) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, p_i1221_8_, p_i1221_10_, p_i1221_12_);
    }

    // hideCloud
    @Override
    public void renderParticle(WorldRenderer worldRendererIn, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {
        if (ParticlesHider.config.enabled && ParticlesHider.config.hideCloud) return;
        super.renderParticle(worldRendererIn, entityIn, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
    }

    public static class Factory implements IParticleFactory {
        public EntityFX getEntityFX(int particleID, World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn, int... p_178902_15_) {
            return new EntityCloudFXHook(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);
        }
    }

}
