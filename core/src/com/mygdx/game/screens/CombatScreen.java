package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.Drop;
import com.mygdx.game.components.abilities.ability.Ability;
import com.mygdx.game.components.movement.MovementMuteDecorator;
import com.mygdx.game.components.renderer.MyTexture;
import com.mygdx.game.components.transform.combatmode.CombatModeTransformLeft;
import com.mygdx.game.components.transform.combatmode.CombatModeTransformRight;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.attacks.Attack;
import com.mygdx.game.gameobjects.attacks.AttackFactory;
import com.mygdx.game.gameobjects.characters.Character;
import com.mygdx.game.gameobjects.ui.AbilityTable;
import com.mygdx.game.utils.mytiledmap.MyTiledMap;
import com.mygdx.game.utils.mytiledmap.mapcell.MapCell;

import java.util.LinkedList;
import java.util.List;

public class CombatScreen extends BaseScreen {
    private final Screen previousScreen;
    private final Fight fight;
    private final MyTiledMap myTiledMap;

    public CombatScreen(
            final Drop game,
            Screen previousScreen,
            final Fight fight,
            MyTiledMap myTiledMap
    ) {
        super(game);
        this.previousScreen = previousScreen;
        this.fight = fight;
        this.myTiledMap = myTiledMap;

        fight.addObserver(this);

        // Get the tile the enemy is standing on for the background
        MapCell enemyTile = myTiledMap.getTileAt(fight.enemy.getPosition());
        String backgroundImagePath = enemyTile.getCombatTexturePath();

        // Add background
        GameObject background = new GameObject(game) {};
        background.setRenderer(new MyTexture(game, background, backgroundImagePath));
        background.setScale(camera.viewportWidth, camera.viewportHeight);
        background.setPosition(0, 0);
        addGameObject(background);

        // Change the behavior of the objects
        fight.player.setTransform(new CombatModeTransformLeft(fight.player.getTransform(), enemyTile));
        fight.player.setMovement(new MovementMuteDecorator(fight.player.getMovement()));

        fight.enemy.setTransform(new CombatModeTransformRight(fight.enemy.getTransform(), enemyTile));
        fight.enemy.setMovement(new MovementMuteDecorator(fight.enemy.getMovement()));

        addGameObject(fight.player);
        addGameObject(fight.enemy);

        // Initialize the style
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        BitmapFont font = new BitmapFont();
        style.font = font;

        // Add exit button
        TextButton exitButton = new TextButton("exit", style);
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                closeOutOfScreen();
            }
        });
        stage.addActor(exitButton);

        // Add ability table
        addGameObject(new AbilityTable(game, stage, fight));
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        game.batch.begin();
        game.batch.end();

        Gdx.input.setInputProcessor(stage);
        stage.act(delta);
        stage.draw();

        // Enemy's turn
        if (fight.isPlayersTurn(fight.enemy)) {
            Ability ability = fight.enemy.getAbilities().getRandomAbility();
            Attack attack = AttackFactory.getInstance().createAttack(game, ability, fight.enemy, fight.player, fight);
            fight.enemy.addChild(attack);
            fight.enemy.getAbilities().performAttack(attack);
        }
    }

    public void onFightEnded(GameObject winner) {
        closeOutOfScreen();
    }

    private void closeOutOfScreen() {
        game.setScreen(previousScreen);
        dispose();
    }

    public static class Fight {
        private final Character player;
        private final Character enemy;
        private final List<CombatScreen> observers;
        private Character whoseTurnItIs;

        public Fight(Character player, Character enemy) {
            this.player = player;
            this.enemy = enemy;
            this.observers = new LinkedList<>();
            this.whoseTurnItIs = player;
        }

        public void addObserver(CombatScreen observer) {
            observers.add(observer);
        }

        public void endFight(Character winner) {
            for (CombatScreen combatScreen : observers) {
                combatScreen.onFightEnded(winner);
            }
        }

        public void endTurn() {
            whoseTurnItIs = null;
        }

        public void applyDamage(Character attacker, Character target, int damage) {
            target.takeDamage(damage);

            if (target.getHealth() <= 0) {
                endFight(attacker);
            }

            whoseTurnItIs = target;
        }

        public boolean isPlayersTurn(Character player) {
            return whoseTurnItIs == player;
        }

        public Character getPlayer() {
            return player;
        }

        public Character getEnemy() {
            return enemy;
        }
    }
}
