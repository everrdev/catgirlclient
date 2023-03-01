package fun.everr.cc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.minecraftforge.fml.common.Mod;

@Mod(CatgirlClient.MOD_ID)
public class CatgirlClient {
    public static final String MOD_ID = "cc";
    public static final Logger LOGGER = LoggerFactory.getLogger("CatgirlClient");
    public CatgirlClient() {
        LOGGER.atInfo().log("Hello world!");
    }
}
