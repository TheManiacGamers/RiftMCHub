package me.yeroc.riftmchub.managers;

/**
 * Created by Corey on 10/12/2016.
 */
public class PermissionsManager {
    static PermissionsManager instance = new PermissionsManager();

    private PermissionsManager() {
    }

    public static PermissionsManager getInstance() {
        return instance;
    }

    public String commands_rs = ("riftmc.rs");

}
