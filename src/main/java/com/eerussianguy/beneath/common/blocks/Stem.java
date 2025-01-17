package com.eerussianguy.beneath.common.blocks;

import java.util.Locale;
import java.util.function.Supplier;
import com.eerussianguy.beneath.Beneath;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;

import net.dries007.tfc.common.blocks.wood.Wood;
import net.dries007.tfc.util.Helpers;
import net.dries007.tfc.util.registry.RegistryWood;
import net.dries007.tfc.world.feature.tree.TFCTreeGrower;

import static net.dries007.tfc.common.blocks.wood.Wood.BlockType.*;

public enum Stem implements RegistryWood
{
    CRIMSON(true, MapColor.TERRACOTTA_RED, MapColor.COLOR_RED, 8),
    WARPED(true, MapColor.TERRACOTTA_BLUE, MapColor.COLOR_BLUE, 8);

    public static final Stem[] VALUES = values();

    private final String serializedName;
    private final boolean conifer;
    private final MapColor woodColor;
    private final MapColor barkColor;
    private final TFCTreeGrower tree;
    private final int daysToGrow;
    private final BlockSetType blockSet;
    private final WoodType woodType;

    Stem(boolean conifer, MapColor woodColor, MapColor barkColor, int daysToGrow)
    {
        this.serializedName = name().toLowerCase(Locale.ROOT);
        this.conifer = conifer;
        this.woodColor = woodColor;
        this.barkColor = barkColor;
        this.tree = new TFCTreeGrower(Beneath.identifier("tree/" + serializedName), Beneath.identifier("tree/" + serializedName + "_large"));
        this.blockSet = new BlockSetType(serializedName);
        this.woodType = new WoodType(Beneath.identifier(this.serializedName).toString(), this.blockSet);
        this.daysToGrow = daysToGrow;
    }

    @Override
    public String getSerializedName()
    {
        return serializedName;
    }

    public boolean isConifer()
    {
        return conifer;
    }

    @Override
    public MapColor woodColor()
    {
        return woodColor;
    }

    @Override
    public MapColor barkColor()
    {
        return barkColor;
    }

    @Override
    public TFCTreeGrower tree()
    {
        return tree;
    }

    @Override
    public int daysToGrow()
    {
        return defaultDaysToGrow();
    }

    @Override
    public int autumnIndex()
    {
        return 0;
    }

    public int defaultDaysToGrow()
    {
        return daysToGrow;
    }

    @Override
    public Supplier<Block> getBlock(Wood.BlockType type)
    {
        return BeneathBlocks.WOODS.get(this).get(type);
    }

    @SuppressWarnings("unchecked")
    public <B extends Block> Supplier<? extends B> getBlockCasted(Wood.BlockType type)
    {
        return (Supplier<? extends B>) this.getBlock(type);
    }

    @Override
    public BlockSetType getBlockSet()
    {
        return blockSet;
    }

    @Override
    public WoodType getVanillaWoodType()
    {
        return woodType;
    }

    public Wood.BlockType twig() { return TWIG; }
    public Wood.BlockType fallenLeaves() { return FALLEN_LEAVES; }
    public Wood.BlockType leaves() { return LEAVES; }
    public Wood.BlockType axle() { return AXLE; }
    public Wood.BlockType windmill() { return WINDMILL; }
}
