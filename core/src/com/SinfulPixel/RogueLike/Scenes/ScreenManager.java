package com.SinfulPixel.RogueLike.Scenes;

import com.badlogic.gdx.*;
import com.badlogic.gdx.utils.IntMap;

/**
 * Created by Min3 on 11/13/2014.
 */
public final class ScreenManager {
    private static ScreenManager instance;
    private Game game;
    private IntMap<com.badlogic.gdx.Screen> screens;
    private ScreenManager(){
        screens = new IntMap<com.badlogic.gdx.Screen>();
    }
    public static ScreenManager getInstance(){
        if(null==instance){
            instance = new ScreenManager();
        }
        return instance;
    }
    public void initialize(Game game){
        this.game = game;
    }
    public void show(Screen screen){
        if(null==game) return;
        if(!screens.containsKey(screen.ordinal())){
            screens.put(screen.ordinal(),screen.getScreenInstance());
        }
        game.setScreen(screens.get(screen.ordinal()));
    }
    public void dispose(Screen screen){
        if(!screens.containsKey(screen.ordinal())) return;
        screens.remove(screen.ordinal()).dispose();
    }
    public void dispose(){
        for(com.badlogic.gdx.Screen screen : screens.values()){
            screen.dispose();
        }
        screens.clear();
        instance = null;
    }
}
