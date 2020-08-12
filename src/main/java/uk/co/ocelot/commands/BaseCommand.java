package uk.co.ocelot.commands;

import org.bukkit.command.Command;

import java.util.List;

public abstract class BaseCommand extends Command {

    private static final String COMMAND_LOG = "SuperRaidsCommmands";
    private static final String COMMAND_PREFIX = "SRC";

    public BaseCommand(String name, String description, String usageMessage, List<String> aliases) {
        super(name, description, usageMessage, aliases);
    }
}
