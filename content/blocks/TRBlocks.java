package mindustry.content;

import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.DrawPart.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.legacy.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;

public class TRBlocks{

  
    public static Block
    tagger,

    pressureDuct, pressureJunction, pressureOverflow, pressureRouter, pressureUnderflow,

    currentDrill,

    wallLimestone, oreAluminium, oreLimestone, oreSalt,

    intakeValve, kelpFarm, kelpCompressor, desalinator, pyratiteCompressor, aggregateMixer, 

    coreSubmerged,

    column, dartle, 

    aluminiumWall, largeAluminiumWall,

    outtakeValve,
  ;
private static void load() {
    wallLimestone = new StaticWall("wall-limestone"){{
        variants = 3;
    }};
    oreAluminium = new OreBlock("ore-aluminium"){{
        itemDrop = TRitems.aluminium;
    }};
          oreLimestone = new OreBlock("ore-limestone"){{
        itemDrop = TRitems.limestone;
    }};
            oreSalt = new OreBlock("ore-salt"){{
        itemDrop = TRitems.salt;
    }};
  dartle = new ItemTurret("dartle"){{
      requirements(Category.turret, with(TRItems.aluminium, 25, TRtems.limestone, 10));
      ammo(
          TRitems.aluminium, new BasicBulletType(4f, 16){{
              shootEffect = new ParticleEffect(){{
                particles = 6;
                line = true;
                colorFrom = b6b6b6;
                colorTo = b6b6b6;
                lenFrom = 4;
                lenTo = 0;
                length = 24;
                  }};
              sprite = "mine-bullet";
              width = 7f;
              height = 9f;
              lifetime = 24;
              ammoMultiplier = 2;
                }}
        );

        recoil = 0.5;
        shootY = 3;
        reload = 45;
        range = 96;
        rotateSpeed = 10;
        researchCostMultiplier = 0.05;

        limitRange();
  }}; 
    column = new ItemTurret("column"){{
      requirements(Category.turret, with(TRItems.aluminium, 25, TRtems.limestone, 10));
      ammo(
          TRitems.aluminium, new PointBulletType(4f, 0){{
              trailEffect = shootEffect = new ParticleEffect(){{
                particles = 6;
                sprite = "tantrosmod-bubble";
                cone = 0;
                length = 24;
                  }};
              width = 7f;
              height = 9f;
              lifetime = 24;
              ammoMultiplier = 2;
                }}
        );
        drawer = new DrawTurret(){{
          parts.addAll(
            new regionPart("-barrel"){{
            progress = PartProgress.recoil;
            under = false;
            moveY = -2
          }},
            new regionPart("-side"){{
              progress = PartProgress.recoil;
              under = false;
              moveRot = -15;
            }});
        }};
        recoil = 0;
        shootY = 3;
        reload = 45;
        range = 200;
        rotateSpeed = 10;
        researchCostMultiplier = 0.05;
        shootSound = Sounds.railgun;

        limitRange();
  }}; 
  pressure
