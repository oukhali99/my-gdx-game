package com.mygdx.game.gameobjects.combat.characters.enemy;

import com.badlogic.gdx.Screen;
import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.attacks.Attack;
import com.mygdx.game.gameobjects.combat.characters.BaseCharacter;
import com.mygdx.game.gameobjects.combat.characters.Character;
import com.mygdx.game.gameobjects.combat.characters.Player;
import com.mygdx.game.gameobjects.combat.characters.combatmode.CombatModeDecoratorLeft;
import com.mygdx.game.gameobjects.combat.characters.combatmode.CombatModeDecoratorRight;
import com.mygdx.game.screens.CombatScreen;

import java.util.Random;

public abstract class BaseEnemy extends BaseCharacter implements Enemy {
    public BaseEnemy(Drop game) {
        super(game);
    }

    @Override
    public void onCollision(GameObject gameObject, GameObject otherGameObject) {
        super.onCollision(gameObject, otherGameObject);

        Character enemy = (Enemy) gameObject;

        if (otherGameObject instanceof Player) {
            Character player = (Player) otherGameObject;
            Screen combatScreen = new CombatScreen(
                    game,
                    game.getScreen(),
                    new CombatScreen.Fight(
                            new CombatModeDecoratorLeft(player),
                            new CombatModeDecoratorRight(enemy)
                    )
            );
            game.setScreen(combatScreen);
        }
        else if (!(otherGameObject instanceof Attack)) {
            Random random = new Random();
            boolean xPositive = random.nextFloat() < 0.5f;
            boolean yPositive = random.nextFloat() < 0.5f;
            transform.translate(xPositive ? 16 : -16, yPositive ? 16 : -16);
        }
    }
}
