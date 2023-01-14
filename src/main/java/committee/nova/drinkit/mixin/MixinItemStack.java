package committee.nova.drinkit.mixin;

import committee.nova.drinkit.DrinkIt;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class MixinItemStack {
    @Inject(method = "getUseAnimation", at = @At("RETURN"), cancellable = true)
    public void inject$getUseAnimation(CallbackInfoReturnable<UseAnim> cir) {
        if (DrinkIt.isDrinkable((ItemStack) (Object) this)) cir.setReturnValue(UseAnim.DRINK);
    }

    @Inject(method = "getDrinkingSound", at = @At("RETURN"), cancellable = true)
    public void inject$getDrinkingSound(CallbackInfoReturnable<SoundEvent> cir) {
        if (DrinkIt.isThick((ItemStack) (Object) this)) cir.setReturnValue(SoundEvents.HONEY_DRINK);
    }
}
