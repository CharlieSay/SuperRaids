package uk.co.ocelot.mob;

import net.minecraft.server.v1_15_R1.ChatComponentText;
import net.minecraft.server.v1_15_R1.EntityLiving;
import net.minecraft.server.v1_15_R1.EntityTypes;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.bukkit.Location;

import java.util.Objects;

public abstract class CustomMob extends EntityLiving {

    private final Location spawnLocation;
    private boolean nameVisibility;

    public CustomMob(EntityTypes entityTypes, Location loc, String name, Integer health, boolean showName) {
        super(entityTypes, ((CraftWorld) Objects.requireNonNull(loc.getWorld())).getHandle());
        this.spawnLocation = loc;
        this.nameVisibility = showName;

        this.setPosition(loc.getX(),loc.getY(),loc.getZ());
        this.setCustomName(new ChatComponentText(name));
        this.setCustomNameVisible(nameVisibility);
        this.setCustomNameVisible(true);
        this.setHealth(health);
    }

    public Location getSpawnLocation() {
        return spawnLocation;
    }

    public boolean isNameVisibility() {
        return nameVisibility;
    }

    public void setLocation(Location loc) {
        this.setPosition(loc.getX(),loc.getY(),loc.getZ());
    }

    public void setNameVisibility(boolean nameVisibility) {
        this.nameVisibility = nameVisibility;
    }
}
