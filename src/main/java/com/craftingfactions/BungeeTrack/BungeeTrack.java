package com.craftingfactions.BungeeTrack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class BungeeTrack extends Plugin implements Listener {


    public void onEnable() {
	ProxyServer.getInstance().getPluginManager().registerListener(this, this);
    }

    @EventHandler
    public void onLoginEvent(LoginEvent ev) {
	try {
	    DateFormat df = new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss");
	    Date now = Calendar.getInstance().getTime();
	    String date = df.format(now);

	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("BungeeTrack.txt", true)));
	    out.println (
	    		"Username: "
	    		+ ev.getConnection().getName()
	    		+ "IP: "
	    		+ ev.getConnection().getAddress().getAddress().toString()
	    		+ "used "
	    		+ ev.getConnection().getVirtualHost().getHostString()
	    		+ "at "
	    		+ date);
	    out.close();    
	    } 
		catch (IOException exception) {
	    exception.printStackTrace();
		}
    }
}
