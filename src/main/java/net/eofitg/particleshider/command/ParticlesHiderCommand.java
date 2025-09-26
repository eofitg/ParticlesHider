package net.eofitg.particleshider.command;

import net.eofitg.particleshider.ParticlesHider;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParticlesHiderCommand extends CommandBase {

    private static final List<String> SUBCOMMANDS = Arrays.asList(
            "toggle",
            "hideBlockDestroy", "hideBlockDestroyExcludeRedstone", "hideBlockHit",
            "hideExplodeWhiteSmoke", "hideExplodeBlackSmoke", "hideHugeExplode", "hideLargeExplode",
            "hideCloud",
            "hideCritical", "hideSharpness",
            "hidePortal",
            "reload"
    );


    @Override
    public String getCommandName() {
        return "particleshider";
    }

    @Override
    public List<String> getCommandAliases() {
        return Arrays.asList("ph", "phider");
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/particleshider toggle|<config_name>|reload";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (!(sender instanceof EntityPlayer)) return;

        if (args.length == 0) {
            sender.addChatMessage(new ChatComponentText(EnumChatFormatting.YELLOW + "Usage: " + getCommandUsage(sender)));
            return;
        }

        String sub = args[0].toLowerCase();

        switch (sub) {
            case "toggle": {
                ParticlesHider.config.enabled = !ParticlesHider.config.enabled;
                ParticlesHider.saveConfig();
                String status = ParticlesHider.config.enabled ? EnumChatFormatting.GREEN + "enabled" : EnumChatFormatting.RED + "disabled";
                sender.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "Particles Hider " + status + EnumChatFormatting.BLUE + "."));
                break;
            }
            case "reload": {
                ParticlesHider.loadConfig();
                sender.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "Particles Hider configuration file reloaded."));
                break;
            }
            case "hideblockdestroy": {
                ParticlesHider.config.hideBlockDestroy = !ParticlesHider.config.hideBlockDestroy;
                String status = ParticlesHider.config.hideBlockDestroy ? EnumChatFormatting.GREEN + "true" : EnumChatFormatting.RED + "false";
                sender.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "Status set to: " + status + EnumChatFormatting.BLUE + "."));
                break;
            }
            case "hideblockdestroyexcluderedstone": {
                ParticlesHider.config.hideBlockDestroyExcludeRedstone = !ParticlesHider.config.hideBlockDestroyExcludeRedstone;
                String status = ParticlesHider.config.hideBlockDestroyExcludeRedstone ? EnumChatFormatting.GREEN + "true" : EnumChatFormatting.RED + "false";
                sender.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "Status set to: " + status + EnumChatFormatting.BLUE + "."));
                break;
            }
            case "hideblockhit": {
                ParticlesHider.config.hideBlockHit = !ParticlesHider.config.hideBlockHit;
                String status = ParticlesHider.config.hideBlockHit ? EnumChatFormatting.GREEN + "true" : EnumChatFormatting.RED + "false";
                sender.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "Status set to: " + status + EnumChatFormatting.BLUE + "."));
                break;
            }
            case "hideexplodewhitesmoke": {
                ParticlesHider.config.hideExplodeWhiteSmoke = !ParticlesHider.config.hideExplodeWhiteSmoke;
                String status = ParticlesHider.config.hideExplodeWhiteSmoke ? EnumChatFormatting.GREEN + "true" : EnumChatFormatting.RED + "false";
                sender.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "Status set to: " + status + EnumChatFormatting.BLUE + "."));
                break;
            }
            case "hideexplodeblacksmoke": {
                ParticlesHider.config.hideExplodeBlackSmoke = !ParticlesHider.config.hideExplodeBlackSmoke;
                String status = ParticlesHider.config.hideExplodeBlackSmoke ? EnumChatFormatting.GREEN + "true" : EnumChatFormatting.RED + "false";
                sender.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "Status set to: " + status + EnumChatFormatting.BLUE + "."));
                break;
            }
            case "hidehugeexplode": {
                ParticlesHider.config.hideHugeExplode = !ParticlesHider.config.hideHugeExplode;
                String status = ParticlesHider.config.hideHugeExplode ? EnumChatFormatting.GREEN + "true" : EnumChatFormatting.RED + "false";
                sender.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "Status set to: " + status + EnumChatFormatting.BLUE + "."));
                break;
            }
            case "hidelargeexplode": {
                ParticlesHider.config.hideLargeExplode = !ParticlesHider.config.hideLargeExplode;
                String status = ParticlesHider.config.hideLargeExplode ? EnumChatFormatting.GREEN + "true" : EnumChatFormatting.RED + "false";
                sender.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "Status set to: " + status + EnumChatFormatting.BLUE + "."));
                break;
            }
            case "hidecloud": {
                ParticlesHider.config.hideCloud = !ParticlesHider.config.hideCloud;
                String status = ParticlesHider.config.hideCloud ? EnumChatFormatting.GREEN + "true" : EnumChatFormatting.RED + "false";
                sender.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "Status set to: " + status + EnumChatFormatting.BLUE + "."));
                break;
            }
            case "hidecritical": {
                ParticlesHider.config.hideCritical = !ParticlesHider.config.hideCritical;
                String status = ParticlesHider.config.hideCritical ? EnumChatFormatting.GREEN + "true" : EnumChatFormatting.RED + "false";
                sender.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "Status set to: " + status + EnumChatFormatting.BLUE + "."));
                break;
            }
            case "hidesharpness": {
                ParticlesHider.config.hideSharpness = !ParticlesHider.config.hideSharpness;
                String status = ParticlesHider.config.hideSharpness ? EnumChatFormatting.GREEN + "true" : EnumChatFormatting.RED + "false";
                sender.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "Status set to: " + status + EnumChatFormatting.BLUE + "."));
                break;
            }
            case "hideportal": {
                ParticlesHider.config.hidePortal = !ParticlesHider.config.hidePortal;
                String status = ParticlesHider.config.hidePortal ? EnumChatFormatting.GREEN + "true" : EnumChatFormatting.RED + "false";
                sender.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "Status set to:  " + status + EnumChatFormatting.BLUE + "."));
                break;
            }
            default: {
                sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Unknown argument: " + sub));
                sender.addChatMessage(new ChatComponentText(EnumChatFormatting.YELLOW + "Usage: " + getCommandUsage(sender)));
            }
        }
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            String prefix = args[0].toLowerCase();
            for (String cmd : SUBCOMMANDS) {
                if (cmd.toLowerCase().startsWith(prefix)) {
                    completions.add(cmd);
                }
            }
        }

        return completions.isEmpty() ? null : completions;
    }

}
