package committee.nova.drinkit.mixin;

import committee.nova.drinkit.DrinkIt;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({ItemStack.class})
public abstract class MixinItemStack {
    @Shadow
    public abstract Item getItem();

    @Inject(method = "getUseAnimation", at = @At("RETURN"), cancellable = true)
    public void onGetUseAnimation(CallbackInfoReturnable<UseAction> cir) {
        if (DrinkIt.isDrinkable(this.getItem())) cir.setReturnValue(UseAction.DRINK);
    }

    @Inject(method = "getDrinkingSound", at = @At("RETURN"), cancellable = true)
    public void onGetDrinkingSound(CallbackInfoReturnable<SoundEvent> cir) {
        if (DrinkIt.isThick(this.getItem())) cir.setReturnValue(SoundEvents.HONEY_DRINK);
    }
}
