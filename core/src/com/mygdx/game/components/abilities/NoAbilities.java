package com.mygdx.game.components.abilities;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.attacks.Attack;
import com.mygdx.game.gameplay.Ability;

import java.util.List;

public class NoAbilities extends BaseAbilities {
    public NoAbilities(Drop game) {
        super(game);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void addAbility(Ability ability) {

    }

    @Override
    public List<Ability> getAbilityList() {
        return null;
    }

    @Override
    public Ability getRandomAbility() {
        return null;
    }

    @Override
    public void takeDamage(GameObject currentGameObject, int damage) {
    }

    @Override
    public void performAttack(GameObject thisGameObject , Attack attack) {

    }

    @Override
    public Integer getHealth() {
        return null;
    }
}
