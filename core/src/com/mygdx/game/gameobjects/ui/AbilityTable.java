package com.mygdx.game.gameobjects.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.Drop;
import com.mygdx.game.components.abilities.ability.Ability;
import com.mygdx.game.gameobjects.attacks.Attack;
import com.mygdx.game.gameobjects.attacks.AttackFactory;
import com.mygdx.game.screens.CombatScreen;

public class AbilityTable extends UIGameObject {
    private final Table table;
    private final CombatScreen.Fight fight;

    public AbilityTable(final Drop game, Stage stage, final CombatScreen.Fight fight) {
        super(game, stage);
        this.fight = fight;

        table = new Table();
        table.setFillParent(true);

        // Set up the style
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        BitmapFont font = new BitmapFont();
        style.font = font;

        // Add abilities
        for (final Ability ability : fight.getPlayer().getAbilities().getAbilityList()) {
            TextButton button = new TextButton(ability.getName(), style);
            button.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    onClickedAbility(ability);
                }
            });
            table.add(button).pad(10);
        }

        stage.addActor(table);
    }

    @Override
    public void postRender(float delta) {
        super.postRender(delta);
        table.setVisible(fight.isPlayersTurn(fight.getPlayer()));
    }

    private void onClickedAbility(Ability ability) {
        Attack attack = AttackFactory.getInstance().createAttack(game, ability, fight.getPlayer(), fight.getEnemy(), fight);
        fight.getPlayer().addChild(attack);
        fight.getPlayer().getAbilities().performAttack(attack);
    }
}
