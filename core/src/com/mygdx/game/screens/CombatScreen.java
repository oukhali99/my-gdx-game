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

    public CombatScreen(
            Drop game,
            Screen previousScreen,
            final Fight fight
    ) {
        super(game);
        this.previousScreen = previousScreen;
        this.fight = fight;

        fight.addObserver(this);

        final CombatModePlayer combatModePlayer = new CombatModePlayer(game, fight.player);
        final CombatModeEnemy combatModeEnemy = new CombatModeEnemy(game, fight.enemy);
        gameObjects.add(combatModePlayer);
        gameObjects.add(combatModeEnemy);

        // Initialize the stage
        final Drop finalGame = game;
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
                Attack attack = new Attack(finalGame, ability, combatModePlayer, combatModeEnemy, fight);
                combatModePlayer.performAttack(attack);
                //fight.whoseTurnItIs = fight.enemy;
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

        table.setVisible(fight.whoseTurnItIs == fight.player);

        // Enemy's turn
        if (fight.whoseTurnItIs == fight.enemy) {

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
        private CombatActor whoseTurnItIs;
        private List<CombatScreen> observers;

        public Fight(CombatActor player, CombatActor enemy) {
            this.player = player;
            this.enemy = enemy;
            this.whoseTurnItIs = player;
            this.observers = new LinkedList<>();
        }

        public void addObserver(CombatScreen observer) {
            observers.add(observer);
        }

        public void endFight(CombatModeGameObject winner) {
            for (CombatScreen combatScreen : observers) {
                combatScreen.onFightEnded(winner);
            }
        }
    }
}
