package com.SinfulPixel.RogueLike.Scenes;

import com.SinfulPixel.RogueLike.RogueLike;
import com.SinfulPixel.RogueLike.Timer.ScreenSwitchTask;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.Timer;


/**
 * Created by Min3 on 11/13/2014.
 * Testing Git Setup
 */
public class IntroScreen implements com.badlogic.gdx.Screen {
    private int scrWidth = RogueLike.width;
    private int scrHeight = RogueLike.height;
    Texture img;
    OrthographicCamera camera;
    SpriteBatch batch;
    private Rectangle viewport;
    public IntroScreen(){
        camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        camera.position.set(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2,0);
        camera.update();
        //Res
        Vector2 newVirtualRes = new Vector2(0f,0f);
        Vector2 crop = new Vector2(scrWidth,scrHeight);
        newVirtualRes.set(Scaling.fit.apply((float) scrWidth, (float) scrHeight, (float) scrWidth, (float) scrHeight));
        crop.sub(newVirtualRes);
        viewport = new Rectangle(crop.x,crop.y,newVirtualRes.x,newVirtualRes.y);

        //
        batch = new SpriteBatch();
        img = new Texture("SinfulPixelLogo.png");
        //img.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
    }
    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(184/255f, 228/255f, 248/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img,camera.position.x - (img.getWidth()/2),camera.position.y - (img.getHeight()/2));
        batch.end();
    }

    @Override
    public void resize(int i, int i2) {
    }

    @Override
    public void show() {
        Timer.schedule(new ScreenSwitchTask(Screen.MAIN_MENU), 2f);
    }

    @Override
    public void hide() {
        ScreenManager.getInstance().dispose(Screen.INTRO);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        img.dispose();
        batch.dispose();
    }
}
