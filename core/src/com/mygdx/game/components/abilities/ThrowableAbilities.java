package com.mygdx.game.components.abilities;

import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.Drop;
import com.mygdx.game.components.abilities.ability.Ability;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.attacks.Attack;

import java.util.LinkedList;
import java.util.List;

public class ThrowableAbilities extends BaseAbilities {
    private final List<Ability> abilityList;

    public ThrowableAbilities(Drop game, GameObject gameObject) {
        super(game, gameObject);
        this.abilityList = new LinkedList<>();
    }

    @Override
    public void addAbility(Ability ability) {
        abilityList.add(ability);
    }

    @Override
    public List<Ability> getAbilityList() {
        return abilityList;
    }

    @Override
    public Ability getRandomAbility() {
        int size = abilityList.size();
        if (size == 0) {
            return null;
        }
        int randomIndex = MathUtils.random(0, size - 1);
        return abilityList.get(randomIndex);
    }

    @Override
    public void performAttack(Attack attack) {
        attack.getFight().endTurn();
    }

    @Override
    public void destroy() {

    }
}
