package net.eofitg.particleshider.hook.hit;

import net.eofitg.particleshider.ParticlesHider;
import net.minecraft.client.particle.EntityCrit2FX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class EntityCrit2FXHook4MagicCrit extends EntityCrit2FX {

    protected EntityCrit2FXHook4MagicCrit(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double p_i46284_8_, double p_i46284_10_, double p_i46284_12_) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, p_i46284_8_, p_i46284_10_, p_i46284_12_);
    }

    // hideSharpness
    @Override
    public void renderParticle(WorldRenderer worldRendererIn, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {
        if (ParticlesHider.config.enabled && ParticlesHider.config.hideSharpness) return;
        super.renderParticle(worldRendererIn, entityIn, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);

    }

    public static class MagicFactory implements IParticleFactory {
        public EntityFX getEntityFX(int particleID, World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn, int... p_178902_15_) {
            EntityFX entityfx = new EntityCrit2FXHook4MagicCrit(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);
            entityfx.setRBGColorF(entityfx.getRedColorF() * 0.3F, entityfx.getGreenColorF() * 0.8F, entityfx.getBlueColorF());
            entityfx.nextTextureIndexX();
            return entityfx;
        }
    }

}
