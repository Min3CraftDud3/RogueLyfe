package com.SinfulPixel.RogueLike.Scenes;

import com.SinfulPixel.RogueLike.RogueLike;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by Min3 on 11/24/2014.
 */
public class PauseScreen implements com.badlogic.gdx.Screen {
    String Title = "PAUSED";
    String resume = "Resume";
    String save = "Save";
    String options = "Options";
    String exit = "Exit";
    private static int scrHeight = RogueLike.height;
    private static int scrWidth = RogueLike.width;
    SpriteBatch batch;
    BitmapFont font;
    BitmapFont shadow;
    BitmapFont title;
    BitmapFont title1;
    Texture img;
    public PauseScreen(){
        batch = new SpriteBatch();
        FileHandle fontFile = Gdx.files.internal("alagard.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        font = generator.generateFont(50);
        shadow = generator.generateFont(50);
        title =  generator.generateFont(90);
        title1 =  generator.generateFont(90);
        img = new Texture("bgtile_128.png");
        img.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
    }
    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0,0,0,scrWidth,scrHeight);
        //Draw Title
        title.setColor(Color.YELLOW);
        title.draw(batch, Title,((scrWidth - title.getBounds(Title).width) / 2),((scrHeight - title.getBounds(Title).height) / 2)+250);
        title1.setColor(179,189,0,150);
        title1.draw(batch,Title,((scrWidth - title.getBounds(Title).width) / 2)-7,((scrHeight - title.getBounds(Title).height) / 2)+242);
        //Options
        font.setColor(Color.YELLOW);
        font.draw(batch, resume, ((scrWidth - font.getBounds(resume).width) / 2),((scrHeight - font.getBounds(resume).height) / 2));
        font.draw(batch, save, ((scrWidth - font.getBounds(save).width) / 2),((scrHeight - font.getBounds(save).height) / 2)+30);
        font.draw(batch, options,((scrWidth - font.getBounds(options).width) / 2),((scrHeight - font.getBounds(options).height) / 2)-35);
        font.draw(batch, exit,((scrWidth - font.getBounds(exit).width) / 2),((scrHeight - font.getBounds(exit).height) / 2)-77);
        //TextShadow
        shadow.setColor(179,189,0,150);
        shadow.draw(batch, resume, ((scrWidth - font.getBounds(resume).width) / 2)-3,((scrHeight - font.getBounds(resume).height) / 2)-3);
        shadow.draw(batch, save, ((scrWidth - font.getBounds(save).width) / 2)-3,((scrHeight - font.getBounds(save).height) / 2)+27);
        shadow.draw(batch, options,((scrWidth - font.getBounds(options).width) / 2)-3,((scrHeight - font.getBounds(options).height) / 2)-38);
        shadow.draw(batch, exit,((scrWidth - font.getBounds(exit).width) / 2)-3,((scrHeight - font.getBounds(exit).height) / 2)-80);
        batch.end();
    }

    @Override
    public void resize(int i, int i2) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

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
