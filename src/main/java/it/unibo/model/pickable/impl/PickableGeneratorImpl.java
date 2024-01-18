package it.unibo.model.pickable.impl;

import java.awt.Point;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.unibo.model.pacman.api.PacMan;
import it.unibo.model.pickable.api.EffectChose;
import it.unibo.model.pickable.api.EffectPickable;
import it.unibo.model.pickable.api.Pickable;
import it.unibo.model.pickable.api.PickableGenerator;

/** Is a Map Generetor of Pickable. */
public class PickableGeneratorImpl implements PickableGenerator {
    private final Map<Point, Pickable> pickableMap = new HashMap<>();
    private static final int PERCENTAGE = 10;
    private static final int PERCENTAGE_NORMAL_PICKABLE = 8;
    private static final int NUMBER_OF_ALL_EFFECT = EffectChose.values().length;

    /**
     * Generate a Map of Pickable at 80% of probability of neutral pickable and 20%
     * of Bonus or Malus pickable.
     * 
     * @param pickableSpawnPoints is a list of Point where the pickable can spawn.
     */
    @Override
    public void generateMap(final List<Point> pickableSpawnPoints) {
        for (final Point point : pickableSpawnPoints) {
            final double doubleRandomNumberForTypeOfPickable = Math.random() * PERCENTAGE;
            // converti il double in numero intero
            final int randomNumberForTypeOfPickable = (int) doubleRandomNumberForTypeOfPickable;
            if (randomNumberForTypeOfPickable > PERCENTAGE_NORMAL_PICKABLE) {
                final double doubleRandomNumberForEffectChose = Math.random() * NUMBER_OF_ALL_EFFECT;
                // converti il double in numero intero e poi in EffectChose
                final EffectChose effect = EffectChose.values()[(int) doubleRandomNumberForEffectChose];
                switch (effect) {
                    case BONUS_LIFE:
                        pickableMap.put(point, new BonusLife());
                        break;
                    case BONUS_POINTS:
                        pickableMap.put(point, new BonusPoints());
                        break;
                    case BONUS_SPEED:
                        pickableMap.put(point, new BonusSpeed());
                        break;
                    case MALUS_LIFE:
                        pickableMap.put(point, new MalusLife());
                        break;
                    case MALUS_POINTS:
                        pickableMap.put(point, new MalusPoints());
                        break;
                    case MALUS_SPEED:
                        pickableMap.put(point, new MalusSpeed());
                        break;
                    default:
                        break;
                }
            } else {
                pickableMap.put(point, new PickableImpl());
            }
        }
    }

    /**
     * Is for get the Map of Pickable.
     * 
     * @return a Map of Pickable.
     */
    @Override
    public Map<Point, Pickable> getPickableMap() {
        return new HashMap<>(pickableMap);
    }

    /**
     * Is for take a Pickable.
     * 
     * @param point  is the Point where the Pickable is
     * @param pacman is the PacMan that take the Pickable.
     */
    @Override
    public void takePickable(final Point point, final PacMan pacman) {
        if (pickableMap.containsKey(point)) {
            pickableMap.get(point).addPointsPickable(pacman);
            if (pickableMap.get(point) instanceof EffectPickable) {
                ((EffectPickable) pickableMap.get(point)).doEffect(pacman);
            }
            pickableMap.remove(point);
        }
    }

}
