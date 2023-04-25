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
import com.mygdx.game.gameobjects.combat.Attack;
import com.mygdx.game.gameobjects.combat.CriticalAttack;
import com.mygdx.game.gameobjects.combat.MissedAttack;
import com.mygdx.game.gameobjects.combat.combatactors.CombatActor;
import com.mygdx.game.gameobjects.combat.combatmode.CombatModeEnemy;
import com.mygdx.game.gameobjects.combat.combatmode.CombatModeGameObject;
import com.mygdx.game.gameobjects.combat.combatmode.CombatModePlayer;
import com.mygdx.game.gameplay.Ability;
import com.mygdx.game.ui.AbilityTable;

import java.util.LinkedList;
import java.util.List;

public class CombatScreen extends BaseScreen {
    private Screen previousScreen;
    private Fight fight;
    private Stage stage;
    private Table table;
    final CombatModePlayer combatModePlayer;
    final CombatModeEnemy combatModeEnemy;

    public CombatScreen(
            final Drop game,
            Screen previousScreen,
            final Fight fight
    ) {
        super(game);
        this.previousScreen = previousScreen;
        this.fight = fight;

        fight.addObserver(this);

        combatModePlayer = new CombatModePlayer(game, fight.player);
        combatModeEnemy = new CombatModeEnemy(game, fight.enemy);
        gameObjects.add(combatModePlayer);
        gameObjects.add(combatModeEnemy);

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
        table = new AbilityTable(fight.player.getAbilitiesComponent()) {
            @Override
            protected void onClickedAbility(Ability ability) {
                Attack attack = new Attack(game, ability, combatModePlayer, combatModeEnemy, fight);
                combatModePlayer.performAttack(attack);
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
            Ability ability = fight.enemy.getAbilitiesComponent().getRandomAbility();
            Attack attack = new Attack(game, ability, combatModeEnemy, combatModePlayer, fight);
            combatModeEnemy.performAttack(attack);
        }
    }

    public void onFightEnded(CombatModeGameObject winner) {
        closeOutOfScreen();
    }

    private void closeOutOfScreen() {
        game.setScreen(previousScreen);
        dispose();
    }

    public static class Fight {
        private CombatActor player;
        private CombatActor enemy;
        private List<CombatScreen> observers;
        private CombatActor whoseTurnItIs;

        public Fight(CombatActor player, CombatActor enemy) {
            this.player = player;
            this.enemy = enemy;
            this.observers = new LinkedList<>();
            this.whoseTurnItIs = player;
        }

        public void addObserver(CombatScreen observer) {
            observers.add(observer);
        }

        public void endFight(CombatModeGameObject winner) {
            for (CombatScreen combatScreen : observers) {
                combatScreen.onFightEnded(winner);
            }
        }

        public void endTurn() {
            whoseTurnItIs = null;
        }

        public void applyDamage(CombatModeGameObject attacker, CombatModeGameObject target, int damage) {
            target.takeDamage(damage);

            if (target.getHealth() <= 0) {
                endFight(attacker);
            }

            whoseTurnItIs = target.getCombatActor();
        }

        public boolean isPlayersTurn(CombatActor player) {
            return whoseTurnItIs == player;
        }
    }
}
