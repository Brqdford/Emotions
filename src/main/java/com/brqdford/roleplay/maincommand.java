package com.brqdford.roleplay;


import com.google.inject.Inject;
import com.typesafe.config.ConfigException;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.source.ConsoleSource;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.mutable.DisplayNameData;
import org.spongepowered.api.entity.living.player.CooldownTracker;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.living.humanoid.player.CooldownEvent;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.network.Message;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.scoreboard.Scoreboard;
import org.spongepowered.api.scoreboard.Team;
import org.spongepowered.api.scoreboard.TeamMember;
import org.spongepowered.api.scoreboard.critieria.Criteria;
import org.spongepowered.api.scoreboard.displayslot.DisplaySlots;
import org.spongepowered.api.scoreboard.objective.Objective;
import org.spongepowered.api.service.permission.SubjectData;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.serializer.TextSerializers;
import org.spongepowered.api.util.Tristate;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Plugin(
        id = "roleplay",
        name = "RolePlay",
        version = "1.0",
        authors = {
                "Brqdford"
        }
)

public class maincommand {

    @Inject
    private Logger logger;

    @Inject
    private PluginContainer container;

    private static maincommand instance;


    @Listener
    public void onPreInit(GameInitializationEvent event) {
        instance = this;

    }
    public static HashMap<String, Instant> cooldown = new HashMap<>();
    Scoreboard scoreboard;
    @Listener
    public void onGameInit(GameInitializationEvent event) {
        logger.info(container.getName() +
                " running (version "
                + container.getVersion().orElse("UNSTABLE")
                + ")");


        CommandSpec commandman = CommandSpec.builder()
                .arguments(
                        GenericArguments.onlyOne(GenericArguments.player(Text.of("player")))
                )
                .executor((CommandSource src, CommandContext args) -> {
                    Player player = args.<Player>getOne("player").get();
                    Player p = (Player)src;
                    if (cooldown.containsKey(p.getName()) && Instant.now().minusSeconds(((Instant)cooldown.get(p.getName())).getEpochSecond()).getEpochSecond() < 60L) {
                        p.sendMessage((Text)Text.of("§cYou must wait " + (60L - Instant.now().minusSeconds(((Instant)cooldown.get(p.getName())).getEpochSecond()).getEpochSecond()) + " seconds to use this command."));
                        return CommandResult.success();
                    }else {
                        cooldown.put(p.getName(), Instant.now());
                        player.sendMessage(Text.of(TextColors.YELLOW, src.getName(), " hugs you."));
                        return CommandResult.success();
                    }
                })
                .build();
        Sponge.getCommandManager().register(container, commandman, "hug");

        CommandSpec commandman4 = CommandSpec.builder()
                .arguments(
                        GenericArguments.onlyOne(GenericArguments.player(Text.of("player")))
                )
                .executor((CommandSource src, CommandContext args) -> {
                    Player player = args.<Player>getOne("player").get();
                    Player p = (Player)src;
                    if (cooldown.containsKey(p.getName()) && Instant.now().minusSeconds(((Instant)cooldown.get(p.getName())).getEpochSecond()).getEpochSecond() < 60L) {
                        p.sendMessage((Text)Text.of("§cYou must wait " + (60L - Instant.now().minusSeconds(((Instant)cooldown.get(p.getName())).getEpochSecond()).getEpochSecond()) + " seconds to use this command."));
                        return CommandResult.success();
                    }else {
                        cooldown.put(p.getName(), Instant.now());
                        player.sendMessage(Text.of(TextColors.DARK_PURPLE, src.getName(), " gives you a fat smooch."));
                        return CommandResult.success();
                    }
                })
                .build();
        Sponge.getCommandManager().register(container, commandman4, "kiss");

        CommandSpec commandman5 = CommandSpec.builder()
                .arguments(
                        GenericArguments.onlyOne(GenericArguments.player(Text.of("player")))
                )
                .executor((CommandSource src, CommandContext args) -> {

                    Player player = args.<Player>getOne("player").get();
                    Player p = (Player)src;
                    if (cooldown.containsKey(p.getName()) && Instant.now().minusSeconds(((Instant)cooldown.get(p.getName())).getEpochSecond()).getEpochSecond() < 60L) {
                        p.sendMessage((Text)Text.of("§cYou must wait " + (60L - Instant.now().minusSeconds(((Instant)cooldown.get(p.getName())).getEpochSecond()).getEpochSecond()) + " seconds to use this command."));
                        return CommandResult.success();
                    }else {
                        cooldown.put(p.getName(), Instant.now());
                        player.sendMessage(Text.of(TextColors.RED, src.getName(), " slaps you across the face."));
                        return CommandResult.success();
                    }
                })
                .build();
        Sponge.getCommandManager().register(container, commandman5, "slap");
        CommandSpec commandman6 = CommandSpec.builder()
                .arguments(
                        GenericArguments.onlyOne(GenericArguments.player(Text.of("player")))
                )
                .executor((CommandSource src, CommandContext args) -> {
                    Player player = args.<Player>getOne("player").get();
                    Player p = (Player)src;
                    if (cooldown.containsKey(p.getName()) && Instant.now().minusSeconds(((Instant)cooldown.get(p.getName())).getEpochSecond()).getEpochSecond() < 60L) {
                        p.sendMessage((Text)Text.of("§cYou must wait " + (60L - Instant.now().minusSeconds(((Instant)cooldown.get(p.getName())).getEpochSecond()).getEpochSecond()) + " seconds to use this command."));
                        return CommandResult.success();
                    }else {
                        cooldown.put(p.getName(), Instant.now());
                        player.sendMessage(Text.of(TextColors.GRAY, src.getName(), " pokes you annoyingly."));
                        return CommandResult.success();
                    }
                })
                .build();
        Sponge.getCommandManager().register(container, commandman6, "poke");


        CommandSpec commandman2 = CommandSpec.builder()
                .executor(new crycommand())
                .build();
        Sponge.getCommandManager().register(container, commandman2, "cry");
        CommandSpec commandman3 = CommandSpec.builder()
                .executor(new laughcommand())
                .build();
        Sponge.getCommandManager().register(container, commandman3, "laugh");


        CommandSpec commandman7 = CommandSpec.builder()
                .arguments(
                        GenericArguments.onlyOne(GenericArguments.player(Text.of("player")))
                )
                .executor((CommandSource src, CommandContext args) -> {
                    Player player = args.<Player>getOne("player").get();
                    String getPlayerName = player.getName();
                    CommandSource console = Sponge.getServer().getConsole();
                    if (src.hasPermission("addplot.use")) {
                        if (player.hasPermission(SubjectData.GLOBAL_CONTEXT, "plots.plot.12")){
                            player.sendMessage(Text.of(TextColors.RED, "You already have the max amount of plots. (12)"));
                        }else if (player.hasPermission(SubjectData.GLOBAL_CONTEXT, "plots.plot.11")){
                            player.getSubjectData().setPermission(SubjectData.GLOBAL_CONTEXT, "plots.plot.12", Tristate.TRUE);
                            player.sendMessage(Text.of(TextColors.AQUA, "You can now have 12 total plots."));
                        }else if (player.hasPermission(SubjectData.GLOBAL_CONTEXT, "plots.plot.10")){
                            player.getSubjectData().setPermission(SubjectData.GLOBAL_CONTEXT, "plots.plot.11", Tristate.TRUE);
                            player.sendMessage(Text.of(TextColors.AQUA, "You can now have 11 total plots."));
                        }else if (player.hasPermission(SubjectData.GLOBAL_CONTEXT, "plots.plot.9")){
                            player.getSubjectData().setPermission(SubjectData.GLOBAL_CONTEXT, "plots.plot.10", Tristate.TRUE);
                            player.sendMessage(Text.of(TextColors.AQUA, "You can now have 10 total plots."));
                        }else if (player.hasPermission(SubjectData.GLOBAL_CONTEXT, "plots.plot.8")){
                            player.getSubjectData().setPermission(SubjectData.GLOBAL_CONTEXT, "plots.plot.9", Tristate.TRUE);
                            player.sendMessage(Text.of(TextColors.AQUA, "You can now have 9 total plots."));
                        }else if (player.hasPermission(SubjectData.GLOBAL_CONTEXT, "plots.plot.7")){
                            player.getSubjectData().setPermission(SubjectData.GLOBAL_CONTEXT, "plots.plot.8", Tristate.TRUE);
                            player.sendMessage(Text.of(TextColors.AQUA, "You can now have 8 total plots."));
                        }else if (player.hasPermission(SubjectData.GLOBAL_CONTEXT, "plots.plot.6")){
                            player.getSubjectData().setPermission(SubjectData.GLOBAL_CONTEXT, "plots.plot.7", Tristate.TRUE);
                            player.sendMessage(Text.of(TextColors.AQUA, "You can now have 7 total plots."));
                        }else if (player.hasPermission(SubjectData.GLOBAL_CONTEXT, "plots.plot.5")){
                            player.getSubjectData().setPermission(SubjectData.GLOBAL_CONTEXT, "plots.plot.6", Tristate.TRUE);
                            player.sendMessage(Text.of(TextColors.AQUA, "You can now have 6 total plots."));
                        }else if (player.hasPermission(SubjectData.GLOBAL_CONTEXT, "plots.plot.4")){
                            player.getSubjectData().setPermission(SubjectData.GLOBAL_CONTEXT, "plots.plot.5", Tristate.TRUE);
                            player.sendMessage(Text.of(TextColors.AQUA, "You can now have 5 total plots."));
                        }else if (player.hasPermission(SubjectData.GLOBAL_CONTEXT, "plots.plot.3")){
                            player.getSubjectData().setPermission(SubjectData.GLOBAL_CONTEXT, "plots.plot.4", Tristate.TRUE);
                            player.sendMessage(Text.of(TextColors.AQUA, "You can now have 4 total plots."));
                        }else if(player.hasPermission(SubjectData.GLOBAL_CONTEXT, "plots.plot.2")){
                            player.getSubjectData().setPermission(SubjectData.GLOBAL_CONTEXT, "plots.plot.3", Tristate.TRUE);
                            player.sendMessage(Text.of(TextColors.AQUA, "You can now have 3 total plots."));
                        }else if(player.hasPermission("plots.plot.6")){
                            player.getSubjectData().setPermission(SubjectData.GLOBAL_CONTEXT, "plots.plot.7", Tristate.TRUE);
                            player.sendMessage(Text.of(TextColors.AQUA, "You can now have 7 total plots."));
                        }else if(player.hasPermission("plots.plot.5")){
                            player.getSubjectData().setPermission(SubjectData.GLOBAL_CONTEXT, "plots.plot.6", Tristate.TRUE);
                            player.sendMessage(Text.of(TextColors.AQUA, "You can now have 6 total plots."));
                        }else if (player.hasPermission("plots.plot.4")){
                            player.getSubjectData().setPermission(SubjectData.GLOBAL_CONTEXT, "plots.plot.5", Tristate.TRUE);
                            player.sendMessage(Text.of(TextColors.AQUA, "You can now have 5 total plots."));
                        }else if (player.hasPermission("plots.plot.3")){
                            player.getSubjectData().setPermission(SubjectData.GLOBAL_CONTEXT, "plots.plot.4", Tristate.TRUE);
                            player.sendMessage(Text.of(TextColors.AQUA, "You can now have 4 total plots."));
                        }else if(player.hasPermission("plots.plot.2")){
                            player.getSubjectData().setPermission(SubjectData.GLOBAL_CONTEXT, "plots.plot.3", Tristate.TRUE);
                            player.sendMessage(Text.of(TextColors.AQUA, "You can now have 3 total plots."));
                        }else if(player.hasPermission("plots.plot.1")){
                            player.getSubjectData().setPermission(SubjectData.GLOBAL_CONTEXT, "plots.plot.2", Tristate.TRUE);
                            player.sendMessage(Text.of(TextColors.AQUA, "You can now have 2 total plots."));
                        }
                    }else {
                        src.sendMessage(Text.of(TextColors.RED, "You do not have permission."));
                    }
                    return CommandResult.success();
                })
                .build();
        Sponge.getCommandManager().register(container, commandman7, "addplot");

    }
}
