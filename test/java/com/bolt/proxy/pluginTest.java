import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

public class MyPluginTest {

    private static ProxyServer proxyServer;

    @BeforeAll
    public static void setUp() {
        proxyServer = ProxyServer.getInstance();
    }

    @Test
    public void testPluginLoad() {
        // Load plugin
        File pluginFile = new File("plugins", "ProxyPlugin.jar");
        Plugin plugin = proxyServer.getPluginManager().loadPlugin(pluginFile);

        // Assert that plugin is not null and enabled
        assertNotNull(plugin);
        assertTrue(plugin.isEnabled());
    }

    @Test
    public void testConfigLoad() {
        // Load config.yml
        Path configPath = new File("plugins/ProxyPlugin", "config.yml").toPath();

        // Assert that config file exists
        assertTrue(configPath.toFile().exists());
    }
    
}
