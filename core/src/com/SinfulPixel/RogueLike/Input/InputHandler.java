package com.SinfulPixel.RogueLike.Input;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Min3 on 11/9/2014.
 */
public class InputHandler implements ApplicationListener {
    private SpriteBatch batch;
    private Texture texture;
    private Sprite sprite;
    private Sprite sprite1;

    @Override
    public void create() {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        batch = new SpriteBatch();

        texture = new Texture(Gdx.files.internal("crosshair.png"));
        sprite = new Sprite(texture);
        sprite.setPosition(w/2 -sprite.getWidth()/2, h/2 - sprite.getHeight()/2);
        sprite1 = new Sprite(texture);
        sprite1.setPosition(w/2 -sprite1.getWidth()/2, h/2 - sprite1.getHeight()/2);
    }

    @Override
    public void resize(int i, int i2) {

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Mouse
        if(!Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
            sprite.setPosition(Gdx.input.getX() - sprite.getWidth()/2,
                    Gdx.graphics.getHeight() - Gdx.input.getY() - sprite.getHeight()/2);
        }else{
            //attack
            sprite.setPosition(Gdx.input.getX() - sprite.getWidth()/2,
                    Gdx.graphics.getHeight() - Gdx.input.getY() - sprite.getHeight()/2);
        }
        if(Gdx.input.isButtonPressed(Input.Buttons.RIGHT)){
            sprite.setPosition(Gdx.graphics.getWidth()/2 -sprite.getWidth()/2,
                    Gdx.graphics.getHeight()/2 - sprite.getHeight()/2);
        }
        //Keyboard
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
                sprite1.translateX(-1f);
            else
                sprite1.translateX(-10.0f);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
                sprite1.translateX(1f);
            else
                sprite1.translateX(10.0f);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
                sprite1.translateY(-1f);
            else
                sprite1.translateY(-10.0f);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
                sprite1.translateY(1f);
            else
                sprite1.translateY(10.0f);
        }
        batch.begin();
        sprite.draw(batch);
        batch.end();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
