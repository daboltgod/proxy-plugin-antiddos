package com.bolt.proxy;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class EventListener implements Listener {

    private final ProxyServer proxyServer;
    private final String targetServerHost;
    private final int targetServerPort;

    public EventListener(ProxyServer proxyServer, String targetServerHost, int targetServerPort) {
        this.proxyServer = proxyServer;
        this.targetServerHost = targetServerHost;
        this.targetServerPort = targetServerPort;
    }

    @EventHandler
    public void onPostLogin(PostLoginEvent event) {
        ProxiedPlayer player = event.getPlayer();

        // Get the player's remote address
        SocketAddress remoteAddress = player.getSocketAddress();

        // Get the target server address
        InetSocketAddress targetAddress = new InetSocketAddress(targetServerHost, targetServerPort);

        // Forward the connection to the target server through the proxy
        proxyServer.createServerInfo("target", targetAddress);
        player.connect(proxyServer.getServerInfo("target"));
    }

}
