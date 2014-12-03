package com.SinfulPixel.RogueLike.Entity;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by Min3 on 11/15/2014.
 */
public class Player extends InputAdapter{
    private Body player;
    private float acc = 2000;
    public Player(World world,float x,float y,float width,float height){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x,y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width/2,height/2);
        FixtureDef fixDef = new FixtureDef();
        fixDef.shape=shape;
        fixDef.density = (float)Math.pow(width,height);
        fixDef.restitution = .1f;
        fixDef.friction = .5f;
        player = world.createBody(bodyDef);
        player.createFixture(fixDef);
    }
    public boolean keyDown(int keyCode){
        return true;
    }
    public boolean keyUp(int keyCode){
        return true;
    }
}
