package vg.civcraft.mc.citadel.command.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import vg.civcraft.mc.citadel.PlayerState;
import vg.civcraft.mc.citadel.Utility;
import vg.civcraft.mc.civmodcore.command.PlayerCommand;

public class ToggleEasyMode extends PlayerCommand {

	public ToggleEasyMode(String name) {
		super(name);
		setIdentifier("cte");
		setDescription("Toggle easy mode");
		setUsage("/cte");
		setArguments(0, 0);
	}

	@Override
	public boolean execute(CommandSender sender, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Must be a player to perform that command.");
			return true;
		}
		Player p = (Player) sender;
		PlayerState state = PlayerState.get(p);
		if (state.toggleEasyMode()) {
			Utility.sendAndLog(p, ChatColor.GREEN, "Easy mode has been enabled.");
		} else {
			Utility.sendAndLog(p, ChatColor.GREEN, "Easy mode has been disabled.");
		}
		return true;
	}

	@Override
	public List<String> tabComplete(CommandSender sender, String[] args) {
		return new ArrayList<String>();
	}

}
