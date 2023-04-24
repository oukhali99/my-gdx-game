package com.mygdx.game.gameobjects.combat;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.combat.combatmode.CombatModeGameObject;
import com.mygdx.game.gameplay.Ability;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.combatactors.CombatActor;
import com.mygdx.game.utils.Logger;

public class Attack extends GameObject {
    private Ability ability;
    private CombatModeGameObject attacker;
    private CombatModeGameObject target;

    public Attack(Drop game, Ability ability, CombatModeGameObject attacker, CombatModeGameObject target) {
        super(game);
        this.ability = ability;
        this.target = target;
        this.attacker = attacker;

        setPosition(attacker.getPosition());
    }

    public void start() {
        Logger.log("Attacked " + target + " with " + ability.getName() + " for " + ability.getDamage() + " damage");
        target.takeDamage(ability.getDamage());
    }

    float stateTime = 0;

    @Override
    public void render(float delta) {
        super.render(delta);

        float speed = 200;

        // Update the position of the fireball based on the elapsed time and speed
        float deltaX = speed * delta;
        Vector2 position = getPosition();
        position.add(deltaX, 0);

        // Get the current frame of the animation based on the elapsed time
        TextureRegion currentFrame = (TextureRegion) ability.getAnimation().getKeyFrame(stateTime, true);

        // Draw the current frame at the current position of the fireball
        game.batch.draw(currentFrame, position.x, position.y);

        // Update the elapsed time
        stateTime += delta;
    }
}
