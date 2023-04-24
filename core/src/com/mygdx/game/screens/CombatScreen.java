package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Abilities;
import com.mygdx.game.gameobjects.combat.combatactors.CombatActor;
import com.mygdx.game.gameobjects.combat.combatmode.CombatModeEnemy;
import com.mygdx.game.gameobjects.combat.combatmode.CombatModePlayer;
import com.mygdx.game.ui.AbilityTable;

import java.util.Random;

public class CombatScreen extends BaseScreen {
    private Screen previousScreen;
    private Fight fight;
    private Stage stage;

    public CombatScreen(
            Drop game,
            Screen previousScreen,
            final Fight fight
    ) {
        super(game);
        this.previousScreen = previousScreen;
        this.fight = fight;

        gameObjects.add(new CombatModePlayer(game, fight.player));
        gameObjects.add(new CombatModeEnemy(game, fight.enemy));

        // Initialize the stage
        final Drop finalGame = game;
        final Screen finalPreviousScreen = previousScreen;
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
                finalGame.setScreen(finalPreviousScreen);
                dispose();
            }
        });
        stage.addActor(exitButton);

        // Add ability table
        Table table = new AbilityTable(fight.player.getAbilitiesComponent()) {
            @Override
            protected void onClickedAbility(Abilities.Ability ability) {
                fight.enemy.takeDamage(ability.getDamage());
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
    }

    public static class Fight {
        private CombatActor player;
        private CombatActor enemy;
        private CombatActor whoseTurnItIs;

        public Fight(CombatActor player, CombatActor enemy) {
            this.player = player;
            this.enemy = enemy;
            this.whoseTurnItIs = player;
        }
    }
}
