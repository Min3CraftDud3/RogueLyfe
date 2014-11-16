package com.SinfulPixel.RogueLike.Entity;

/**
 * Created by Min3 on 11/15/2014.
 */
public class Player {
    public enum state{STANDBY,WALKING,ATTACK,DEATH}
    public enum direction {NORTH,EAST,SOUTH,WEST}
    direction d = direction.SOUTH;
}
