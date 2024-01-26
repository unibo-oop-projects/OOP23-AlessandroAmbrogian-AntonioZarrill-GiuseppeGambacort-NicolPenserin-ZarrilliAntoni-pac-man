package it.unibo.model.map.api;

import java.awt.Point;
import java.util.List;

import it.unibo.model.api.GameObject;

/**
 * this interface, given a map, sets the initial game conditions.
 */
public interface MapBuilder {

    /**
     * method that returns the list of wall objects.
     * @return returns a list with the object of the type  walls on the game map.
     */
    List<GameObject> getWallsPath();

    /**
     * method to obtain the ghost spawn.
     * @return returns a list of Points that represent the ghost spawn.
     */
    List<Point> getSpawnGhost();

    /**
     * Method to get Pac-Man's location at the start of the game.
     * @return returns a Point that represents Pacman's initial position on the game map.
     */
    Point getPacManSpawn();

    /**
     * method to obtain the boxes on the map where the collectible objects are located.
     * @return returns a Point-type list representing all the boxes on the map where objects can be collected.
     */
    List<Point> getSpawnCollectibleItems();
}
