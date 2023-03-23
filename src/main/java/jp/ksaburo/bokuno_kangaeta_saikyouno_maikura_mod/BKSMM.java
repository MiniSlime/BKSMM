package jp.ksaburo.bokuno_kangaeta_saikyouno_maikura_mod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BKSMM.MODID)
public class BKSMM {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "bokuno_kangaeta_saikyouno_maikura_mod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "bokuno_kangaeta_saikyouno_maikura_mod" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "bokuno_kangaeta_saikyouno_maikura_mod" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final RegistryObject<Item> TOKINIUM = ITEMS.register("tokinium", () -> new Item(new Item.Properties()
            .rarity(Rarity.RARE)
    ));

    public static final RegistryObject<Block> TOKINIUM_BLOCK = BLOCKS.register("tokinium_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
            .strength(0.25f, 12f)
            .requiresCorrectToolForDrops()
            .lightLevel(BlockState -> 5)
    ));

    public static final RegistryObject<Item> TOKINIUM_BLOCK_ITEM = ITEMS.register("tokinium_block", () -> new BlockItem(TOKINIUM_BLOCK.get(), new Item.Properties()
            .rarity(Rarity.EPIC)
    ));

    public static final RegistryObject<SwordItem> TOKINIUM_SWORD = ITEMS.register("tokinium_sword",
            () -> new TokiniumSword(Tiers.DIAMOND,15,-3.0f,new Item.Properties().rarity(Rarity.EPIC))
            );

    public static final RegistryObject<PickaxeItem> TOKINIUM_PICKAXE = ITEMS.register("tokinium_pickaxe",
            () -> new PickaxeItem(Tiers.DIAMOND, 5, -3.0f, new Item.Properties().rarity(Rarity.EPIC))
            );

    public static final RegistryObject<ShovelItem> TOKINIUM_SHOVEL = ITEMS.register("tokinium_shovel",
            () -> new ShovelItem(Tiers.DIAMOND, 4, -3.0f, new Item.Properties().rarity(Rarity.EPIC))
            );

    public static final RegistryObject<AxeItem> TOKINIUM_AXE = ITEMS.register("tokinium_axe",
            () -> new AxeItem(Tiers.DIAMOND,20,-3.5f,new Item.Properties().rarity(Rarity.EPIC))
            );

    public BKSMM() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so blocks get registered
        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(TOKINIUM_BLOCK_ITEM);
        }
        if(event.getTab() == CreativeModeTabs.INGREDIENTS){
            event.accept(TOKINIUM);
        }
        if(event.getTab() == CreativeModeTabs.COMBAT){
            event.accept(TOKINIUM_SWORD);
            event.accept(TOKINIUM_AXE);
        }
        if(event.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES){
            event.accept(TOKINIUM_PICKAXE);
            event.accept(TOKINIUM_SHOVEL);
            event.accept(TOKINIUM_AXE);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
