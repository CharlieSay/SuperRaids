package uk.co.ocelot.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import uk.co.ocelot.SuperRaidsBase;

import java.util.HashMap;

public class BaseCommandExecutor implements CommandExecutor {

    private final SuperRaidsBase superRaidsBase;
    private HashMap<BaseCommand, String> commandsHashMap;

    public BaseCommandExecutor(SuperRaidsBase superRaidsBase) {
        this.superRaidsBase = superRaidsBase;
        this.commandsHashMap = new HashMap<>();
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return false;
    }
}
