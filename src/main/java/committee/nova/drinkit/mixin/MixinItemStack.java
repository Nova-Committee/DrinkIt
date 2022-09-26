package committee.nova.drinkit.mixin;

import committee.nova.drinkit.DrinkIt$;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class MixinItemStack {
    @Shadow
    public abstract Item getItem();

    @Inject(method = "getItemUseAction", at = @At("HEAD"), cancellable = true)
    public void onGetItemUseAction(CallbackInfoReturnable<EnumAction> cir) {
        if (DrinkIt$.MODULE$.isDrinkable(getItem())) cir.setReturnValue(EnumAction.drink);
    }
}
