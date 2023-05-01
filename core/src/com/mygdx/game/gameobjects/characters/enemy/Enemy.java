package com.mygdx.game.gameobjects.characters.enemy;

import com.mygdx.game.Drop;
import com.mygdx.game.components.collider.ColliderBaseDecorator;
import com.mygdx.game.components.movement.MovementAvoidCollisionDecorator;
import com.mygdx.game.components.renderer.RendererHealthBarDecorator;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.characters.Character;
import com.mygdx.game.gameobjects.characters.Player;
import com.mygdx.game.screens.CombatScreen;
import com.mygdx.game.screens.levels.LevelScreen;

public abstract class Enemy extends Character {
    private LevelScreen screen;

    public Enemy(final Drop game) {
        super(game);

        setCollider(new ColliderBaseDecorator(getCollider()) {
            @Override
            public void handleCollision(GameObject otherGameObject) {
                super.handleCollision(otherGameObject);

                if (otherGameObject instanceof Player) {
                    Character player = (Player) otherGameObject;

                    CombatScreen.Fight fight = new CombatScreen.Fight(
                            player.clone(),
                            ((Character) getGameObject()).clone()
                    );
                    screen.onFight(fight);
                }
            }
        });

        setMovement(new MovementAvoidCollisionDecorator(getMovement()));

        setRenderer(new RendererHealthBarDecorator(getRenderer()));
    }

    public void setScreen(LevelScreen screen) {
        this.screen = screen;
    }
}
