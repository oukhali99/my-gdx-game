package com.mygdx.game.components;

import com.mygdx.game.Drop;
import com.mygdx.game.utils.Logger;

import java.util.LinkedList;
import java.util.List;

public class Abilities extends Component {
    private final List<Ability> abilityList;

    public Abilities(Drop game) {
        super(game);
        this.abilityList = new LinkedList<>();
    }

    public Abilities(Abilities abilityList) {
        super(abilityList);
        this.abilityList = new LinkedList<>(abilityList.abilityList);
    }

    public void addAbility(Ability ability) {
        abilityList.add(ability);
    }

    public List<Ability> getAbilityList() {
        return abilityList;
    }

    public static class Ability {
        private final String name;
        private final int damage;

        public Ability(String name, int damage) {
            this.name = name;
            this.damage = damage;
        }

        public String getName() {
            return name;
        }

        public void display() {
            Logger.log("Ability " + name + " for " + damage + " damage");
        }

        public int getDamage() {
            return damage;
        }
    }
}
