package committee.nova.drinkit.mixin;

import committee.nova.drinkit.DrinkIt;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
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
    public void onGetUseAnimation(CallbackInfoReturnable<UseAnim> cir) {
        final Item i = this.getItem();
        if (DrinkIt.DRINKABLE.contains(i)) cir.setReturnValue(UseAnim.DRINK);
    }

    @Inject(method = "getDrinkingSound", at = @At("RETURN"), cancellable = true)
    public void onGetDrinkingSound(CallbackInfoReturnable<SoundEvent> cir) {
        final Item i = this.getItem();
        if (DrinkIt.THICK.contains(i)) cir.setReturnValue(SoundEvents.HONEY_DRINK);
    }
}
