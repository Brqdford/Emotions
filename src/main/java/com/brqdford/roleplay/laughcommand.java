package com.brqdford.roleplay;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import java.time.Instant;

import static com.brqdford.roleplay.maincommand.cooldown;

public class laughcommand implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        Player p = (Player)src;
        if (cooldown.containsKey(p.getName()) && Instant.now().minusSeconds(((Instant)cooldown.get(p.getName())).getEpochSecond()).getEpochSecond() < 60L) {
            p.sendMessage((Text)Text.of("§cYou must wait " + (60L - Instant.now().minusSeconds(((Instant)cooldown.get(p.getName())).getEpochSecond()).getEpochSecond()) + " seconds to use this command."));
            return CommandResult.success();
        }else {

            Sponge.getServer().getBroadcastChannel().send(Text.of(TextColors.GOLD, src.getName(), " laughs hysterically."));
            cooldown.put(p.getName(), Instant.now());
            return CommandResult.success();
        }
    }
}
