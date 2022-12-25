package de.philipp.wirelesschest.command;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.HashSet;

import java.util.Set;

public class Command_LinkChest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if(args.length != 4) {
            player.sendMessage("§cwrong args");
            return false;
        }

        Block block = player.getTargetBlock((Set<Material>) null, 5); // get the block that the player is aiming at, up to a distance of 5 blocks
        if (block == null || block.getType() != Material.CHEST) {
            player.sendMessage("§cNot looking at chest");
            return false;
        }

        double x,y,z;
        String name;
        try {
            x = Double.parseDouble(args[0]);
            y = Double.parseDouble(args[1]);
            z = Double.parseDouble(args[2]);
            name = args[3];
        } catch (NumberFormatException e) {
            player.sendMessage("§cNumber Ex");
            return false;
        }

        Location loc = new Location(player.getWorld(), x,y,z);
        Block chestLinkTo = loc.getBlock();
        if(chestLinkTo.getType() != Material.CHEST) {
            player.sendMessage("§cLink to no Chest");
            return false;
        }

        Chest origin = (Chest) block.getState();
        Chest linkTo = (Chest) chestLinkTo.getState();

        if(origin.getInventory().getSize() != linkTo.getInventory().getSize()) {
            player.sendMessage("§cChest not same Size");
            return false;
        }

        

        player.sendMessage("§aLinked Chests");
        return false;
    }
}
