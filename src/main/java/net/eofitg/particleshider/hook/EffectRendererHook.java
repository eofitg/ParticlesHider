package net.eofitg.particleshider.hook;

import net.eofitg.particleshider.ParticlesHider;
import net.eofitg.particleshider.hook.cloud.EntityCloudFXHook;
import net.eofitg.particleshider.hook.explode.*;
import net.eofitg.particleshider.hook.hit.EntityCrit2FXHook4Crit;
import net.eofitg.particleshider.hook.hit.EntityCrit2FXHook4MagicCrit;
import net.eofitg.particleshider.hook.portal.EntityPortalFXHook;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class EffectRendererHook extends EffectRenderer {

    public EffectRendererHook(World worldIn, TextureManager rendererIn) {
        super(worldIn, rendererIn);
    }

    @Override
    public void registerParticle(int id, IParticleFactory particleFactory) {
        // Explode
        if (id == EnumParticleTypes.EXPLOSION_NORMAL.getParticleID()) {  // white smoke
            super.registerParticle(id, new EntityExplodeFXHook.Factory());
        } else if (id == EnumParticleTypes.EXPLOSION_HUGE.getParticleID()) {
            super.registerParticle(id, new EntityHugeExplodeFXHook.Factory());
        } else if (id == EnumParticleTypes.EXPLOSION_LARGE.getParticleID()) {
            super.registerParticle(id, new EntityLargeExplodeFXHook.Factory());
        } else if (id == EnumParticleTypes.SMOKE_NORMAL.getParticleID()) {  // black smoke
            super.registerParticle(id, new EntitySmokeFXHook.Factory());
        }

        // Cloud
        else if (id == EnumParticleTypes.CLOUD.getParticleID()) {
            super.registerParticle(id, new EntityCloudFXHook.Factory());
        }

        // Critical & Sharpness
        else if (id == EnumParticleTypes.CRIT.getParticleID()) {
            super.registerParticle(id, new EntityCrit2FXHook4Crit.Factory());
        } else if (id == EnumParticleTypes.CRIT_MAGIC.getParticleID()) {
            super.registerParticle(id, new EntityCrit2FXHook4MagicCrit.MagicFactory());
        }

        // Portal
        else if (id == EnumParticleTypes.PORTAL.getParticleID()) {
            super.registerParticle(id, new EntityPortalFXHook.Factory());
        }

        else {
            super.registerParticle(id, particleFactory);
        }
    }

    // hideBlockDestroy
    @Override
    public void addBlockDestroyEffects(BlockPos pos, IBlockState state) {
        if (ParticlesHider.config.enabled && ParticlesHider.config.hideBlockDestroy) {
            // hideBlockDestroyExcludeRedstone
            if (!ParticlesHider.config.hideBlockDestroyExcludeRedstone) return;
            if (state.getBlock() != Blocks.redstone_block) return;
        }
        super.addBlockDestroyEffects(pos, state);
    }

    // hideBlockHit
    @Override
    public void addBlockHitEffects(BlockPos pos, EnumFacing side) {
        if (ParticlesHider.config.enabled && ParticlesHider.config.hideBlockHit) {
            return;
        }
        super.addBlockHitEffects(pos, side);
    }

}
