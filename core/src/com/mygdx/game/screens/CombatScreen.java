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

import java.util.Random;

public class CombatScreen extends BaseScreen {
    private Screen previousScreen;
    private Fight fight;
    private Stage stage;

    public CombatScreen(
            Drop game,
            Screen previousScreen,
            Fight fight
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

        // Add button table
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        // Set up the style
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        BitmapFont font = new BitmapFont();
        style.font = font;
        style.font.setColor(Color.RED);

        // Add stuff to the table
        TextButton exitButton = new TextButton("exit", style);
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                finalGame.setScreen(finalPreviousScreen);
                dispose();
            }
        });
        table.add(exitButton).pad(10);

        // Add abilities
        CombatActor playerWhoseTurnItIs = fight.whoseTurnItIs;
        Abilities abilities = playerWhoseTurnItIs.getAbilitiesComponent();
        for (final Abilities.Ability ability : abilities.getAbilityList()) {
            TextButton button = new TextButton(ability.getName(), style);
            button.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    ability.display();
                }
            });
            table.add(button).pad(10);
        }
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
