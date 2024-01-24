package it.unibo.model.map.impl;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import it.unibo.model.map.api.MapBuilder;
import it.unibo.model.map.api.MapTypes;

/**
 * class which, given a map, sets the coordinates of the various objects.
 */
public class MapBuilderImpl implements MapBuilder {
    // 0 pickable 1 no-pickable 2 spawn-pac-man 3-spawn-ghost 4-gate-ghost 5 wall
    private final List<Point> spawnGhosts;
    private final Point spawnPacMan;
    private final List<Point> spawnCollectibleItems;
    private final List<Point> spawnWalls;

    /**
     * constructor that given the map reads it and saves the coordinates in the
     * lists.
     * 
     * @param map the game map.
     */
    public MapBuilderImpl(final int[][] map) {
        this.spawnPacMan = new Point();
        this.spawnGhosts = new ArrayList<>();
        this.spawnCollectibleItems = new ArrayList<>();
        this.spawnWalls = new ArrayList<>();
        for (final var x : range(0, map.length)) {
            for (final var y : range(0, map[x].length)) {
                final int ris = map[x][y];
                final MapTypes maptype = MapTypes.values()[ris];
                switch (maptype) {
                    case PICKABLE:
                        this.spawnCollectibleItems.add(new Point(x, y));
                        break;
                    case SPAWN_PAC_MAN:
                        this.spawnPacMan.setLocation(new Point(x, y));
                        break;
                    case SPAWN_GHOST:
                        this.spawnGhosts.add(new Point(x, y));
                        break;
                    case WALL:
                        this.spawnWalls.add(new Point(x, y));
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * returns the list of coordinates (x,y) of the ghost spawn.
     * 
     * @return returns the list of coordinate (x,y).
     */
    @Override
    public List<Point> getSpawnGhost() {

        return new ArrayList<>(this.spawnGhosts);
    }

    /**
     * returns the (x,y) coordinate of pac-man.
     * 
     * @return returns a coordinate (x,y).
     */
    @Override
    public Point getPacManSpawn() {

        return this.spawnPacMan.getLocation();
    }

    /**
     * returns the list of coordinates (x,y) of the collectible item spawn.
     * 
     * @return returns the list of coordinate (x,y).
     */
    @Override
    public List<Point> getSpawnCollectibleItems() {

        return new ArrayList<>(this.spawnCollectibleItems);
    }

    /**
     * returns the list of coordinates (x,y) of the walls spawn.
     * 
     * @return returns the list of coordinate (x,y).
     */
    @Override
    public List<Point> getWallsPath() {

        return new ArrayList<>(this.spawnWalls);
    }

    private Iterable<Integer> range(final int x, final int y) {

        return x < y ? () -> IntStream.rangeClosed(x, y).iterator() : () -> IntStream.rangeClosed(y, x).iterator();
    }

}