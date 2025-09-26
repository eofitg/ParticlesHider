package net.eofitg.particleshider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.eofitg.particleshider.command.ParticlesHiderCommand;
import net.eofitg.particleshider.config.ParticlesHiderConfig;
import net.eofitg.particleshider.hook.EffectRendererHook;
import net.eofitg.particleshider.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.commons.io.FileUtils;

import java.io.File;

@Mod(
        modid = Reference.MOD_ID,
        name = Reference.MOD_NAME,
        version = Reference.MOD_VERSION,
        acceptedMinecraftVersions = "[1.8.9]",
        clientSideOnly = true
)
public class ParticlesHider {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static File configFile = null;
    public static ParticlesHiderConfig config;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        configFile = new File(e.getModConfigurationDirectory(), "particles-hider.json");
        loadConfig();
        Runtime.getRuntime().addShutdownHook(new Thread(net.eofitg.particleshider.ParticlesHider::saveConfig));
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        Minecraft mc = Minecraft.getMinecraft();
        mc.effectRenderer = new EffectRendererHook(mc.theWorld, mc.renderEngine);
        ClientCommandHandler.instance.registerCommand(new ParticlesHiderCommand());
    }

    public static void loadConfig() {
        if (configFile == null) return;
        if (configFile.exists()) {
            try {
                String json = FileUtils.readFileToString(configFile);
                config = gson.fromJson(json,ParticlesHiderConfig.class);
            } catch (Exception ignored) {}
        } else {
            config = new ParticlesHiderConfig();
            saveConfig();
        }
    }

    public static void saveConfig() {
        if (configFile == null) return;
        try {
            String json = gson.toJson(config);
            FileUtils.write(configFile, json);
        } catch (Exception ignored) {}
    }

}
