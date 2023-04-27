package com.mygdx.game.components.abilities;

import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.attacks.Attack;
import com.mygdx.game.gameplay.Ability;

import java.util.LinkedList;
import java.util.List;

public class ThrowableAbilities extends BaseAbilities {
    private final List<Ability> abilityList;
    private int health;

    public ThrowableAbilities(Drop game) {
        super(game);
        this.abilityList = new LinkedList<>();
        this.health = 100;
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
    public void takeDamage(GameObject currentGameObject, int damage) {
        health -= damage;

        if (health <= 0) {
            health = 0;
            currentGameObject.markForDestruction();
        }
    }

    @Override
    public void performAttack(GameObject thisGameObject, Attack attack) {
        thisGameObject.addChild(attack);
        attack.getFight().endTurn();
    }

    @Override
    public Integer getHealth() {
        return health;
    }

    @Override
    public void destroy() {

    }
}
