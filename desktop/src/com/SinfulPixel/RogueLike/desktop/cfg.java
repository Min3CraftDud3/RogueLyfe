package com.SinfulPixel.RogueLike.desktop;

/**
 * Created by Min3 on 10/26/2014.
 */
public class cfg {
    private int height = 720;
    private int width = 1280;
    private int fpsCap = 30;
    private int soundsVolume = 100;
    private int musicVolume = 100;

    public int getHeight(){return this.height;}
    public int getWidth(){return this.width;}
    public int getFpsCap(){return this.fpsCap;}
    public int getSoundsVolume(){return this.soundsVolume;}
    public int getMusicVolume(){return this.musicVolume;}
    public void setHeight(int h){this.height = h;}
    public void setWidth(int w){this.width = w;}
    public void setFpsCap(int fps){this.fpsCap = fps;}
    public void setSoundsVolume(int vol){this.soundsVolume = vol;}
    public void setMusicVolume(int vol){this.musicVolume = vol;}

}
