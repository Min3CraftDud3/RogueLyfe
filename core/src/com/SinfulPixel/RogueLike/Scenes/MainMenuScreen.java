package com.SinfulPixel.RogueLike.Scenes;

import com.SinfulPixel.RogueLike.RogueLike;
import com.SinfulPixel.RogueLike.Timer.ScreenSwitchTask;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Timer;

/**
 * Created by Min3 on 11/13/2014.
 */
public class MainMenuScreen implements com.badlogic.gdx.Screen {
    private static final String SinglePlayer = "Single Player";
    private static final String Multiplayer = "Multiplayer";
    private static final String Options = "Options";
    private static final String Exit = "Exit";
    private static final String Website = "SinfulPixel.com";
    private static final String Title = "Rogue Lyfe";
    private static int scrHeight = RogueLike.height;
    private static int scrWidth = RogueLike.width;
    SpriteBatch batch;
    BitmapFont font;
    BitmapFont shadow;
    BitmapFont title;
    BitmapFont title1;
    Texture img;
    public MainMenuScreen(){
        batch = new SpriteBatch();
        FileHandle fontFile = Gdx.files.internal("alagard.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        font = generator.generateFont(50);
        shadow = generator.generateFont(50);
        title =  generator.generateFont(130);
        title1 =  generator.generateFont(130);
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
        title1.draw(batch,Title,((scrWidth - title.getBounds(Title).width) / 2)-9,((scrHeight - title.getBounds(Title).height) / 2)+240);
        //Options
        font.setColor(Color.YELLOW);
        font.draw(batch, SinglePlayer, ((scrWidth - font.getBounds(SinglePlayer).width) / 2),((scrHeight - font.getBounds(SinglePlayer).height) / 2));
        font.draw(batch, Multiplayer, ((scrWidth - font.getBounds(Multiplayer).width) / 2),((scrHeight - font.getBounds(Multiplayer).height) / 2)-45);
        font.draw(batch, Options,((scrWidth - font.getBounds(Options).width) / 2),((scrHeight - font.getBounds(Options).height) / 2)-85);
        font.draw(batch, Exit,((scrWidth - font.getBounds(Exit).width) / 2),((scrHeight - font.getBounds(Exit).height) / 2)-125);
        //TextShadow
        shadow.setColor(179,189,0,150);
        shadow.draw(batch, SinglePlayer, ((scrWidth - font.getBounds(SinglePlayer).width) / 2)-3,((scrHeight - font.getBounds(SinglePlayer).height) / 2)-3);
        shadow.draw(batch, Multiplayer, ((scrWidth - font.getBounds(Multiplayer).width) / 2)-3,((scrHeight - font.getBounds(Multiplayer).height) / 2)-48);
        shadow.draw(batch, Options,((scrWidth - font.getBounds(Options).width) / 2)-3,((scrHeight - font.getBounds(Options).height) / 2)-88);
        shadow.draw(batch, Exit,((scrWidth - font.getBounds(Exit).width) / 2)-3,((scrHeight - font.getBounds(Exit).height) / 2)-128);
        batch.end();
    }

    @Override
    public void resize(int i, int i2) {

    }

    @Override
    public void show() {
        Timer.schedule(new ScreenSwitchTask(Screen.OPTIONS), 1f);
    }

    @Override
    public void hide() {
        ScreenManager.getInstance().dispose(Screen.MAIN_MENU);
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
