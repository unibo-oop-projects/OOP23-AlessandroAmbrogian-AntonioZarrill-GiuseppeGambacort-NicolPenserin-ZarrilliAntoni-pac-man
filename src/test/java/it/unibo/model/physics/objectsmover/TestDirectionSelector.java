package it.unibo.model.physics.objectsmover;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.awt.Dimension;
import java.awt.Point;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Test;


import it.unibo.model.api.GameObjectFactory;
import it.unibo.model.ghost.impl.GhostImpl;
import it.unibo.model.impl.GameObjectFactoryImpl;
import it.unibo.model.physics.objectsmover.api.DirectionSelector;
import it.unibo.model.physics.objectsmover.impl.DirectionSelectorImpl;
import it.unibo.model.api.Character;
import it.unibo.model.api.Direction;
import it.unibo.model.api.GameObject;



public class TestDirectionSelector {
    
    private static final int GAME_OBJ_SIZE = 10;
    private static final int TARGET_INIT_POSITION = 10;

    private final Dimension dim = new Dimension(GAME_OBJ_SIZE, GAME_OBJ_SIZE);
    private final DirectionSelector selector = new DirectionSelectorImpl();
    private final GameObjectFactory factory  = new GameObjectFactoryImpl();

    @Test
    void upDirection(){
        Character ghost = new GhostImpl(new Point(TARGET_INIT_POSITION,TARGET_INIT_POSITION), dim, 1);
        GameObject target = factory.createGameObjectWithEmptyGraphics(new Point(TARGET_INIT_POSITION,TARGET_INIT_POSITION + 1), dim);
        selector.setDirection(ghost, target);
        assertEquals(Direction.UP ,ghost.getDirection().get());
    }


    @Test
    void DownDirection(){
        Character ghost = new GhostImpl(new Point(TARGET_INIT_POSITION,TARGET_INIT_POSITION), dim, 1);
        GameObject target = factory.createGameObjectWithEmptyGraphics(new Point(TARGET_INIT_POSITION,TARGET_INIT_POSITION - 1), dim);
        selector.setDirection(ghost, target);
        assertEquals(Direction.DOWN ,ghost.getDirection().get());
    }

    @Test
    void LeftDirection(){
        Character ghost = new GhostImpl(new Point(TARGET_INIT_POSITION,TARGET_INIT_POSITION), dim, 1);
        GameObject target = factory.createGameObjectWithEmptyGraphics(new Point(TARGET_INIT_POSITION-1,TARGET_INIT_POSITION), dim);
        selector.setDirection(ghost, target);
        assertEquals(Direction.LEFT ,ghost.getDirection().get());
    }

    
    @Test
    void RightDirection(){
        Character ghost = new GhostImpl(new Point(TARGET_INIT_POSITION,TARGET_INIT_POSITION), dim, 1);
        GameObject target = factory.createGameObjectWithEmptyGraphics(new Point(TARGET_INIT_POSITION+1,TARGET_INIT_POSITION), dim);
        selector.setDirection(ghost, target);
        assertEquals(Direction.RIGHT ,ghost.getDirection().get());
    }

    @Test
    void TwoDirections(){
        Character ghost = new GhostImpl(new Point(TARGET_INIT_POSITION,TARGET_INIT_POSITION), dim, 1);
        GameObject target = factory.createGameObjectWithEmptyGraphics(new Point(TARGET_INIT_POSITION+1,TARGET_INIT_POSITION+1), dim);
        selector.setDirection(ghost, target);
        assertEquals(Direction.RIGHT ,ghost.getDirection().get());

        target = factory.createGameObjectWithEmptyGraphics(new Point(TARGET_INIT_POSITION+2,TARGET_INIT_POSITION+1), dim);
        selector.setDirection(ghost, target);
        assertEquals(Direction.RIGHT ,ghost.getDirection().get());

        target = factory.createGameObjectWithEmptyGraphics(new Point(TARGET_INIT_POSITION+1,TARGET_INIT_POSITION+2), dim);
        selector.setDirection(ghost, target);
        assertEquals(Direction.UP ,ghost.getDirection().get());
    }

    @Test
    void noDirection(){
        Character ghost = new GhostImpl(new Point(TARGET_INIT_POSITION,TARGET_INIT_POSITION), dim, 1);
        GameObject target = factory.createGameObjectWithEmptyGraphics(new Point(TARGET_INIT_POSITION,TARGET_INIT_POSITION), dim);
        selector.setDirection(ghost, target);
        assertFalse(ghost.getDirection().isPresent());

        GameObject target2 = factory.createGameObjectWithEmptyGraphics(new Point(TARGET_INIT_POSITION+1,TARGET_INIT_POSITION), dim);
        selector.setDirection(ghost, target2);
        assertFalse(ghost.getDirection().isPresent());
    }
}
