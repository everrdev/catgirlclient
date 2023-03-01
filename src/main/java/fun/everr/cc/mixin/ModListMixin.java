package fun.everr.cc.mixin;

import fun.everr.cc.CatgirlClient;
import net.minecraftforge.fml.ModList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import net.minecraftforge.forgespi.language.IModInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(ModList.class)
public abstract class ModListMixin {
    @Shadow @Final private List<IModInfo> sortedList;

    @Inject(at = @At("HEAD"), method = "getMods", cancellable = true, remap=false)
    private void onGetModList(CallbackInfoReturnable<List<IModInfo>> cir) {
        //TODO add is module "Hidden" enabled check
        cir.setReturnValue(this.sortedList.stream().filter(mod ->
                !mod.getModId().equalsIgnoreCase(CatgirlClient.MOD_ID)).toList());
    }
}
