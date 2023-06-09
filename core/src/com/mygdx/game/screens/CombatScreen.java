package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.CombatModeDecorator;
import com.mygdx.game.gameobjects.combat.attacks.Attack;
import com.mygdx.game.gameobjects.combat.AttackFactory;
import com.mygdx.game.gameplay.Ability;
import com.mygdx.game.ui.AbilityTable;

import java.util.LinkedList;
import java.util.List;

public class CombatScreen extends BaseScreen {
    private Screen previousScreen;
    private Fight fight;
    private Stage stage;
    private Table table;

    public CombatScreen(
            final Drop game,
            Screen previousScreen,
            final Fight fight
    ) {
        super(game);
        this.previousScreen = previousScreen;
        this.fight = fight;

        fight.addObserver(this);

        final GameObject player = new CombatModeDecorator(fight.player);
        final GameObject enemy = new CombatModeDecorator(fight.enemy);
        baseGameObjects.add(player);
        baseGameObjects.add(enemy);

        fight.player = player;
        fight.enemy = enemy;
        fight.whoseTurnItIs = player;

        // Initialize the stage
        stage = new Stage();

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
        table = new AbilityTable(fight.player.getAbilities()) {
            @Override
            protected void onClickedAbility(Ability ability) {
                Attack attack = AttackFactory.getInstance().createAttack(game, ability, player, enemy, fight);
                player.getAbilities().performAttack(player, attack);
            }
        };
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        game.batch.begin();
        game.batch.end();

        Gdx.input.setInputProcessor(stage);
        stage.act(delta);
        stage.draw();

        table.setVisible(fight.isPlayersTurn(fight.player));

        // Enemy's turn
        if (fight.isPlayersTurn(fight.enemy)) {
            Ability ability = fight.enemy.getAbilities().getRandomAbility();
            Attack attack = AttackFactory.getInstance().createAttack(game, ability, fight.enemy, fight.player, fight);
            fight.enemy.getAbilities().performAttack(fight.enemy, attack);
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
        private GameObject player;
        private GameObject enemy;
        private List<CombatScreen> observers;
        private GameObject whoseTurnItIs;

        public Fight(GameObject player, GameObject enemy) {
            this.player = player;
            this.enemy = enemy;
            this.observers = new LinkedList<>();
            this.whoseTurnItIs = player;
        }

        public void addObserver(CombatScreen observer) {
            observers.add(observer);
        }

        public void endFight(GameObject winner) {
            for (CombatScreen combatScreen : observers) {
                combatScreen.onFightEnded(winner);
            }
        }

        public void endTurn() {
            whoseTurnItIs = null;
        }

        public void applyDamage(GameObject attacker, GameObject target, int damage) {
            target.getAbilities().takeDamage(damage);

            if (target.getAbilities().getHealth() <= 0) {
                endFight(attacker);
            }

            whoseTurnItIs = target;
        }

        public boolean isPlayersTurn(GameObject player) {
            return player.equals(whoseTurnItIs);
        }
    }
}
