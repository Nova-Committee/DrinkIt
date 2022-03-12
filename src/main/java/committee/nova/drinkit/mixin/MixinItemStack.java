package committee.nova.drinkit.mixin;

import committee.nova.drinkit.DrinkIt;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.UseAction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({ItemStack.class})
public abstract class MixinItemStack {
    @Shadow
    public abstract Item getItem();

    @Inject(method = "getUseAction", at = @At("RETURN"), cancellable = true)
    public void onGetUseAction(CallbackInfoReturnable<UseAction> cir) {
        final Item i = this.getItem();
        if (DrinkIt.DRINKABLE.contains(i)) cir.setReturnValue(UseAction.DRINK);
    }
}
