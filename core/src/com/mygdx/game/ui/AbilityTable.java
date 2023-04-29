package com.mygdx.game.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.components.abilities.Abilities;
import com.mygdx.game.components.abilities.ability.Ability;

public abstract class AbilityTable extends Table {
    private Abilities abilities;

    public AbilityTable(Abilities abilities) {
        super();
        this.abilities = abilities;

        setFillParent(true);

        // Set up the style
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        BitmapFont font = new BitmapFont();
        style.font = font;

        // Add abilities
        for (final Ability ability : abilities.getAbilityList()) {
            TextButton button = new TextButton(ability.getName(), style);
            button.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    onClickedAbility(ability);
                }
            });
            add(button).pad(10);
        }
    }

    protected abstract void onClickedAbility(Ability ability);
}
