package com.mygdx.game.gameobjects.attacks;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.Drop;
import com.mygdx.game.components.abilities.ability.Ability;
import com.mygdx.game.components.abilities.ability.AbilityDecorator;
import com.mygdx.game.components.renderer.RendererColorFlashDecorator;
import com.mygdx.game.gameobjects.characters.Character;
import com.mygdx.game.screens.CombatScreen;

import java.util.Random;

public class AttackFactory {
    private static final Random RANDOM = new Random();
    private static final int NUM_TYPES = 3;
    private static AttackFactory instance;

    public static AttackFactory getInstance() {
        if (instance == null) {
            instance = new AttackFactory();
        }

        return instance;
    }

    public Attack createAttack(Drop game, Ability ability, Character attacker, Character target, CombatScreen.Fight fight) {
        int randomInt = RANDOM.nextInt(NUM_TYPES);

        Attack baseAttack = new Attack(game, ability, attacker, target, fight);

        if (RANDOM.nextFloat() < 0.5f) {
            baseAttack.setAbility(new AbilityDecorator(baseAttack.getAbility()) {

                @Override
                public int getDamage() {
                    return super.getDamage() * 2;
                }
            });

            baseAttack.setRenderer(new RendererColorFlashDecorator(baseAttack.getRenderer(), Color.RED, 0.1f));
        }

        return baseAttack;
    }
}
