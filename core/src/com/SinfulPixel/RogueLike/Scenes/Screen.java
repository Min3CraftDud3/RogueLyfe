package com.SinfulPixel.RogueLike.Scenes;

/**
 * Created by Min3 on 11/13/2014.
 */
public enum Screen {
    INTRO{
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance(){
            return new IntroScreen();
        }
    },
    MAIN_MENU{
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance(){
            return new MainMenuScreen();
        }
    },
    GAME{
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance(){
            return new GameScreen();
        }
    },
    OPTIONS{
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance(){ return new OptionsScreen(); }
    },
    PAUSE{
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance(){ return new PauseScreen(); }
    },
    CREDITS{
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance(){
            return new CreditsScreen();
        }
    };
    protected abstract com.badlogic.gdx.Screen getScreenInstance();

}
