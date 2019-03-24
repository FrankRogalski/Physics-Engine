package main.vectors;

import javafx.geometry.Point2D;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class Vector2DTest {
    private static final double DELTA = 0.00001;
    private static final int ZERO = 0;

    @Test
    public void testEmptyConstructor() {
        final Vector2D vector2D = new Vector2D();

        assertEquals(0, vector2D.getX(), DELTA);
        assertEquals(0, vector2D.getY(), DELTA);
    }

    @Test
    public void testPresetConstructor() {
        final Vector2D vector2D = new Vector2D(10, 20);
        assertEquals(10, vector2D.getX(), DELTA);
        assertEquals(20, vector2D.getY(), DELTA);
    }

    @Test
    public void testCopyConstructor() {
        final Vector2D vector2D1 = new Vector2D(10, 20);
        final Vector2D vector2D2 = new Vector2D(vector2D1);

        assertEquals(10, vector2D2.getX(), DELTA);
        assertEquals(20, vector2D2.getY(), DELTA);
    }

    @Test
    public void testSetAllComponentsWithVector() {
        final Vector2D vector2D = new Vector2D();
        vector2D.setAllComponents(new Vector2D(10, 20));

        assertEquals(10, vector2D.getX(), DELTA);
        assertEquals(20, vector2D.getY(), DELTA);
    }

    @Test
    public void testSetAllComponentsWithValue() {
        final Vector2D vector2D = new Vector2D();
        vector2D.setAllComponents(1);

        assertEquals(1, vector2D.getX(), DELTA);
        assertEquals(1, vector2D.getY(), DELTA);
    }

    @Test
    public void testSetAllComponentsWithTwoValues() {
        final Vector2D vector2D = new Vector2D();
        vector2D.setAllComponents(10, 20);

        assertEquals(10, vector2D.getX(), DELTA);
        assertEquals(20, vector2D.getY(), DELTA);
    }

    @Test
    public void testCreateFromAngle() {
        final Vector2D vector2D = Vector2D.createFromAngle(Math.PI / 2);
        
        assertEquals(0, vector2D.getX(), DELTA);
        assertEquals(1, vector2D.getY(), DELTA);
    }

    @Test
    public void testCreateFromAngleWithDistance() {
        final Vector2D vector2D = Vector2D.createFromAngle(Math.PI / 2, 5);
        
        assertEquals(0, vector2D.getX(), DELTA);
        assertEquals(5, vector2D.getY(), DELTA);
    }

    @Test
    public void testCreateRandomVector2D() {
        final List<Double> directions = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            final Vector2D vector2D = Vector2D.createRandomVector2D();
            
            assertEquals(1, vector2D.getMag(), DELTA);
            final double direction = vector2D.getDirection();
            if (directions.contains(direction)) {
                fail();
            }
            directions.add(direction);
        }
        assertEquals(-Math.PI, directions.stream().mapToDouble(Double::doubleValue).min().orElse(1), 0.1);
        assertEquals(Math.PI, directions.stream().mapToDouble(Double::doubleValue).max().orElse(1), 0.1);
    }

    @Test
    public void testAddWithVector() {
        final Vector2D vector2D1 = new Vector2D(5, 10);
        final Vector2D vector2D2 = new Vector2D(20, 100);
        vector2D1.add(vector2D2);

        assertEquals(25, vector2D1.getX(), DELTA);
        assertEquals(110, vector2D1.getY(), DELTA);

        assertEquals(20, vector2D2.getX(), DELTA);
        assertEquals(100, vector2D2.getY(), DELTA);
    }

    @Test
    public void testAddWithValues() {
        final Vector2D vector2D = new Vector2D(5, 10);
        vector2D.add(20, 100);

        assertEquals(25, vector2D.getX(), DELTA);
        assertEquals(110, vector2D.getY(), DELTA);
    }

    @Test
    public void testStaticAddWithTwoVectors() {
        final Vector2D vector2D1 = new Vector2D(5, 10);
        final Vector2D vector2D2 = new Vector2D(20, 100);
        final Vector2D vector2D3 = Vector2D.add(vector2D1, vector2D2);

        assertEquals(25, vector2D3.getX(), DELTA);
        assertEquals(110, vector2D3.getY(), DELTA);

        assertEquals(5, vector2D1.getX(), DELTA);
        assertEquals(10, vector2D1.getY(), DELTA);

        assertEquals(20, vector2D2.getX(), DELTA);
        assertEquals(100, vector2D2.getY(), DELTA);
    }

    @Test
    public void testStaticAddWithVectorsAndValues() {
        final Vector2D vector2D1 = new Vector2D(5, 10);
        final Vector2D vector2D2 = Vector2D.add(vector2D1, 20, 100);

        assertEquals(25, vector2D2.getX(), DELTA);
        assertEquals(110, vector2D2.getY(), DELTA);

        assertEquals(5, vector2D1.getX(), DELTA);
        assertEquals(10, vector2D1.getY(), DELTA);
    }

    @Test
    public void testStaticAddWithValues() {
        final Vector2D vector2D = Vector2D.add(5, 10, 20, 100);

        assertEquals(25, vector2D.getX(), DELTA);
        assertEquals(110, vector2D.getY(), DELTA);
    }

    @Test
    public void testSubWithVector() {
        final Vector2D vector2D1 = new Vector2D(90, 50);
        final Vector2D vector2D2 = new Vector2D(40, 30);
        vector2D1.sub(vector2D2);

        assertEquals(50, vector2D1.getX(), DELTA);
        assertEquals(20, vector2D1.getY(), DELTA);

        assertEquals(40, vector2D2.getX(), DELTA);
        assertEquals(30, vector2D2.getY(), DELTA);
    }

    @Test
    public void testSubWithValues() {
        final Vector2D vector2D = new Vector2D(90, 50);
        vector2D.sub(40, 30);

        assertEquals(50, vector2D.getX(), DELTA);
        assertEquals(20, vector2D.getY(), DELTA);
    }

    @Test
    public void testStaticSubWithTwoVectors() {
        final Vector2D vector2D1 = new Vector2D(90, 50);
        final Vector2D vector2D2 = new Vector2D(40, 30);
        final Vector2D vector2D3 = Vector2D.sub(vector2D1, vector2D2);

        assertEquals(50, vector2D3.getX(), DELTA);
        assertEquals(20, vector2D3.getY(), DELTA);

        assertEquals(90, vector2D1.getX(), DELTA);
        assertEquals(50, vector2D1.getY(), DELTA);

        assertEquals(40, vector2D2.getX(), DELTA);
        assertEquals(30, vector2D2.getY(), DELTA);
    }

    @Test
    public void testStaticSubWithVectorsAndValues() {
        final Vector2D vector2D1 = new Vector2D(90, 50);
        final Vector2D vector2D2 = Vector2D.sub(vector2D1, 40, 30);

        assertEquals(50, vector2D2.getX(), DELTA);
        assertEquals(20, vector2D2.getY(), DELTA);

        assertEquals(90, vector2D1.getX(), DELTA);
        assertEquals(50, vector2D1.getY(), DELTA);
    }

    @Test
    public void testStaticSubWithVectorsAndValuesReversed() {
        final Vector2D vector2D1 = new Vector2D(90, 50);
        final Vector2D vector2D2 = Vector2D.sub(40, 30, vector2D1);

        assertEquals(-50, vector2D2.getX(), DELTA);
        assertEquals(-20, vector2D2.getY(), DELTA);

        assertEquals(90, vector2D1.getX(), DELTA);
        assertEquals(50, vector2D1.getY(), DELTA);
    }

    @Test
    public void testStaticSubWithValues() {
        final Vector2D vector2D = Vector2D.sub(90, 50, 40, 30);

        assertEquals(50, vector2D.getX(), DELTA);
        assertEquals(20, vector2D.getY(), DELTA);
    }

    @Test
    public void testMultiply() {
        final Vector2D vector2D = new Vector2D(5, 3);
        vector2D.multiply(6);

        assertEquals(30, vector2D.getX(), DELTA);
        assertEquals(18, vector2D.getY(), DELTA);
    }

    @Test
    public void testStaticMultiply() {
        final Vector2D vector2D1 = new Vector2D(5, 3);
        final Vector2D vector2D2 = Vector2D.multiply(vector2D1,6);

        assertEquals(30, vector2D2.getX(), DELTA);
        assertEquals(18, vector2D2.getY(), DELTA);

        assertEquals(5, vector2D1.getX(), DELTA);
        assertEquals(3, vector2D1.getY(), DELTA);
    }

    @Test
    public void testStaticMultiplyWithValues() {
        final Vector2D vector2D = Vector2D.multiply(5, 3,6);

        assertEquals(30, vector2D.getX(), DELTA);
        assertEquals(18, vector2D.getY(), DELTA);
    }

    @Test
    public void testDiv() {
        final Vector2D vector2D = new Vector2D(25, 10);
        vector2D.div(5);

        assertEquals(5, vector2D.getX(), DELTA);
        assertEquals(2, vector2D.getY(), DELTA);
    }

    @Test
    public void testStaticDiv() {
        final Vector2D vector2D1 = new Vector2D(25, 10);
        final Vector2D vector2D2 = Vector2D.div(vector2D1,5);

        assertEquals(5, vector2D2.getX(), DELTA);
        assertEquals(2, vector2D2.getY(), DELTA);

        assertEquals(25, vector2D1.getX(), DELTA);
        assertEquals(10, vector2D1.getY(), DELTA);
    }

    @Test
    public void testStaticDivWithValues() {
        final Vector2D vector2D = Vector2D.div(25, 10,5);

        assertEquals(5, vector2D.getX(), DELTA);
        assertEquals(2, vector2D.getY(), DELTA);
    }

    @Test
    public void testDistanceWithVector() {
        final Vector2D vector2D1 = new Vector2D(10, 10);
        final Vector2D vector2D2 = new Vector2D(10, -10);

        assertEquals(20, vector2D1.distance(vector2D2), DELTA);
    }

    @Test
    public void testDistanceWithValues() {
        final Vector2D vector2D1 = new Vector2D(0, 10);

        assertEquals(20, vector2D1.distance(0, -10), DELTA);
    }

    @Test
    public void testStaticDistanceWithVectors() {
        final Vector2D vector2D1 = new Vector2D(0, 10);
        final Vector2D vector2D2 = new Vector2D(0, -10);

        assertEquals(20, Vector2D.distance(vector2D1, vector2D2), DELTA);
    }

    @Test
    public void testStaticDistanceWithVectorsAndValues() {
        final Vector2D vector2D = new Vector2D(0, 10);

        assertEquals(20, Vector2D.distance(vector2D, 0, -10), DELTA);
    }

    @Test
    public void testStaticDistanceWithValues() {
        assertEquals(20, Vector2D.distance(0, 10, 0, -10), DELTA);
    }

    @Test
    public void testNormalize() {
        final Vector2D vector2D = new Vector2D(5, 3);
        vector2D.normalize();

        assertEquals(1, vector2D.getMag(), DELTA);
    }

    @Test
    public void testNormalizeZero() {
        final Vector2D vector2D = new Vector2D(0, 0);
        vector2D.normalize();

        assertEquals(0, vector2D.getMag(), DELTA);
    }

    @Test
    public void testNormalizeSmallValues() {
        final Vector2D vector2D = new Vector2D(0.5, 0.5);
        vector2D.normalize();

        assertEquals(1, vector2D.getMag(), DELTA);
    }

    @Test
    public void testStaticNormalize() {
        final Vector2D vector2D1 = new Vector2D(5, 3);
        final Vector2D vector2D2 = Vector2D.normalize(vector2D1);
        
        assertEquals(1, vector2D2.getMag(), DELTA);

        assertEquals(5, vector2D1.getX(), DELTA);
        assertEquals(3, vector2D1.getY(), DELTA);
    }

    @Test
    public void testStaticNormalizeSmallValues() {
        final Vector2D vector2D1 = new Vector2D(0.5, 0.1);
        final Vector2D vector2D2 = Vector2D.normalize(vector2D1);
        
        assertEquals(1, vector2D2.getMag(), DELTA);

        assertEquals(0.5, vector2D1.getX(), DELTA);
        assertEquals(0.1, vector2D1.getY(), DELTA);
    }

    @Test
    public void testStaticNormalizeWithValues() {
        final Vector2D vector2D = Vector2D.normalize(5, 3);
        
        assertEquals(1, vector2D.getMag(), DELTA);
    }

    @Test
    public void testStaticNormalizeWithSmallValues() {
        final Vector2D vector2D = Vector2D.normalize(0.5, 0.3);
        
        assertEquals(1, vector2D.getMag(), DELTA);
    }

    @Test
    public void testGetMag() {
        final Vector2D vector2D = new Vector2D(0, 3);
        assertEquals(3, vector2D.getMag(), DELTA);
    }

    @Test
    public void testStaticGetMag() {
        final Vector2D vector2D = new Vector2D(0, 3);
        assertEquals(3, Vector2D.getMag(vector2D), DELTA);
    }

    @Test
    public void testStaticGetMagWithValues() {
        assertEquals(3, Vector2D.getMag(0, 3), DELTA);
    }

    @Test
    public void testGetMagSquared() {
        final Vector2D vector2D = new Vector2D(0, 3);
        assertEquals(9, vector2D.getMagSquared(), DELTA);
    }

    @Test
    public void testStaticGetMagSquared() {
        final Vector2D vector2D = new Vector2D(0, 3);
        assertEquals(9, Vector2D.getMagSquared(vector2D), DELTA);
    }

    @Test
    public void testStaticGetMagSquaredWithValues() {
        assertEquals(9, Vector2D.getMagSquared(0, 3), DELTA);
    }

    @Test
    public void testGetDirection() {
        assertEquals(0, new Vector2D(10, 0).getDirection(), DELTA);
        assertEquals(Math.PI, new Vector2D(-10, 0).getDirection(), DELTA);
        assertEquals(Math.PI * 0.75, new Vector2D(-10, 10).getDirection(), DELTA);
        assertEquals(-Math.PI * 0.75, new Vector2D(-10, -10).getDirection(), DELTA);
        assertEquals(-Math.PI / 2, new Vector2D(0, -10).getDirection(), DELTA);
        assertEquals(Math.PI / 2, new Vector2D(0, 10).getDirection(), DELTA);
        assertEquals(0, new Vector2D(0, 0).getDirection(), DELTA);
    }

    @Test
    public void testStaticGetDirection() {
        assertEquals(0, Vector2D.getDirection(new Vector2D(1, 0)), DELTA);
    }

    @Test
    public void testStaticGetDirectionWithValues() {
        assertEquals(0, Vector2D.getDirection(1, 0), DELTA);
    }

    @Test
    public void testLimit() {
        final Vector2D vector2D = new Vector2D(10, 10);
        vector2D.limit(5);
        assertEquals(5, vector2D.getMag(), DELTA);
    }

    @Test
    public void testLimitOnLimit() {
        final Vector2D vector2D = spy(Vector2D.class);
        vector2D.setX(5);
        vector2D.limit(5);
        verify(vector2D, times(ZERO)).setMag(anyDouble());
        assertEquals(5, vector2D.getMag(), DELTA);
    }

    @Test
    public void testLimitNotReached() {
        final Vector2D vector2D = new Vector2D(0, 3);
        vector2D.limit(5);
        assertEquals(3, vector2D.getMag(), DELTA);
    }

    @Test
    public void testStaticLimit() {
        final Vector2D vector2D1 = new Vector2D(10, 5);
        final Vector2D vector2D2 = Vector2D.limit(vector2D1, 5);
        
        assertEquals(5, vector2D2.getMag(), DELTA);

        assertEquals(10, vector2D1.getX(), DELTA);
        assertEquals(5, vector2D1.getY(), DELTA);
    }

    @Test
    public void testStaticLimitNotReached() {
        final Vector2D vector2D1 = new Vector2D(3, 0);
        final Vector2D vector2D2 = Vector2D.limit(vector2D1, 5);
        
        assertEquals(3, vector2D2.getMag(), DELTA);

        assertEquals(3, vector2D1.getX(), DELTA);
        assertEquals(0, vector2D1.getY(), DELTA);

        assertEquals(3, vector2D2.getX(), DELTA);
        assertEquals(0, vector2D2.getY(), DELTA);
    }

    @Test
    public void testStaticLimitWithValues() {
        final Vector2D vector2D = Vector2D.limit(10, 10, 5);
        
        assertEquals(5, vector2D.getMag(), DELTA);
    }

    @Test
    public void testStaticLimitNotReachedWithValues() {
        final Vector2D vector2D = Vector2D.limit(1, 0, 5);
        
        assertEquals(1, vector2D.getMag(), DELTA);
    }

    @Test
    public void testLerpX() {
        final Vector2D vector2D1 = new Vector2D(5, 0);
        final Vector2D vector2D2 = new Vector2D(10, 0);
        final Vector2D vector2D3 = vector2D1.lerp(vector2D2, 0.2);

        assertEquals(6, vector2D3.getX(), DELTA);
        assertEquals(0, vector2D3.getY(), DELTA);

        assertEquals(5, vector2D1.getX(), DELTA);
        assertEquals(0, vector2D1.getY(), DELTA);

        assertEquals(10, vector2D2.getX(), DELTA);
        assertEquals(0, vector2D2.getY(), DELTA);
    }

    @Test
    public void testLerpY() {
        final Vector2D vector2D1 = new Vector2D(0, 5);
        final Vector2D vector2D2 = new Vector2D(0, 10);
        final Vector2D vector2D3 = vector2D1.lerp(vector2D2, 0.2);

        assertEquals(0, vector2D3.getX(), DELTA);
        assertEquals(6, vector2D3.getY(), DELTA);

        assertEquals(0, vector2D1.getX(), DELTA);
        assertEquals(5, vector2D1.getY(), DELTA);

        assertEquals(0, vector2D2.getX(), DELTA);
        assertEquals(10, vector2D2.getY(), DELTA);
    }

    @Test
    public void testLerpWithValues() {
        final Vector2D vector2D1 = new Vector2D();
        final Vector2D vector2D2 = vector2D1.lerp(10, 0, 0.2);

        assertEquals(2, vector2D2.getX(), DELTA);
        assertEquals(0, vector2D2.getY(), DELTA);

        assertEquals(0, vector2D1.getX(), DELTA);
        assertEquals(0, vector2D1.getY(), DELTA);
    }

    @Test
    public void testStaticLerp() {
        final Vector2D vector2D1 = new Vector2D();
        final Vector2D vector2D2 = new Vector2D(10, 0);
        final Vector2D vector2D3 = Vector2D.lerp(vector2D1, vector2D2, 0.2);

        assertEquals(2, vector2D3.getX(), DELTA);
        assertEquals(0, vector2D3.getY(), DELTA);

        assertEquals(0, vector2D1.getX(), DELTA);
        assertEquals(0, vector2D1.getY(), DELTA);

        assertEquals(10, vector2D2.getX(), DELTA);
        assertEquals(0, vector2D2.getY(), DELTA);
    }

    @Test
    public void testStaticLerpWithValuesAndVectors() {
        final Vector2D vector2D1 = new Vector2D(10, 0);
        final Vector2D vector2D2 = Vector2D.lerp(0, 0, vector2D1, 0.2);

        assertEquals(2, vector2D2.getX(), DELTA);
        assertEquals(0, vector2D2.getY(), DELTA);

        assertEquals(10, vector2D1.getX(), DELTA);
        assertEquals(0, vector2D1.getY(), DELTA);
    }

    @Test
    public void testStaticLerpWithValuesAndVectorsReversed() {
        final Vector2D vector2D1 = new Vector2D();
        final Vector2D vector2D2 = Vector2D.lerp(vector2D1, 10, 0, 0.2);

        assertEquals(2, vector2D2.getX(), DELTA);
        assertEquals(0, vector2D2.getY(), DELTA);

        assertEquals(0, vector2D1.getX(), DELTA);
        assertEquals(0, vector2D1.getY(), DELTA);
    }

    @Test
    public void testStaticLerpWithValues() {
        final Vector2D vector2D = Vector2D.lerp(0, 0, 10, 0, 0.2);

        assertEquals(2, vector2D.getX(), DELTA);
        assertEquals(0, vector2D.getY(), DELTA);
    }

    @Test
    public void testSetMag() {
        final Vector2D vector2D = new Vector2D(10, 10);
        vector2D.setMag(5);

        assertEquals(5, vector2D.getMag(), DELTA);
    }

    @Test
    public void testStaticSetMag() {
        final Vector2D vector2D1 = new Vector2D(10, 10);
        final Vector2D vector2D2 = Vector2D.setMag(vector2D1, 5);

        assertEquals(5, vector2D2.getMag(), DELTA);
    }

    @Test
    public void testStaticSetMagWithValues() {
        final Vector2D vector2D = Vector2D.setMag(10, 10, 5);

        assertEquals(5, vector2D.getMag(), DELTA);
    }

    @Test
    public void testMidpointX() {
        final Vector2D vector2D1 = new Vector2D();
        final Vector2D vector2D2 = new Vector2D(10, 0);
        final Vector2D vector2D3 = vector2D1.midpoint(vector2D2);

        assertEquals(5, vector2D3.getX(), DELTA);
        assertEquals(0, vector2D3.getY(), DELTA);
    }

    @Test
    public void testMidpointY() {
        final Vector2D vector2D1 = new Vector2D();
        final Vector2D vector2D2 = new Vector2D(0, 10);
        final Vector2D vector2D3 = vector2D1.midpoint(vector2D2);

        assertEquals(0, vector2D3.getX(), DELTA);
        assertEquals(5, vector2D3.getY(), DELTA);
    }

    @Test
    public void testMidpointWithValues() {
        final Vector2D vector2D1 = new Vector2D();
        final Vector2D vector2D2 = vector2D1.midpoint(0, 10);

        assertEquals(0, vector2D2.getX(), DELTA);
        assertEquals(5, vector2D2.getY(), DELTA);
    }

    @Test
    public void testStaticMidpoint() {
        final Vector2D vector2D1 = new Vector2D();
        final Vector2D vector2D2 = new Vector2D(0, 10);
        final Vector2D vector2D3 = Vector2D.midpoint(vector2D1, vector2D2);

        assertEquals(0, vector2D3.getX(), DELTA);
        assertEquals(5, vector2D3.getY(), DELTA);
    }

    @Test
    public void testStaticMidpointWithValuesAndVectors() {
        final Vector2D vector2D1 = new Vector2D();
        final Vector2D vector2D2 = Vector2D.midpoint(vector2D1, 0, 10);

        assertEquals(0, vector2D2.getX(), DELTA);
        assertEquals(5, vector2D2.getY(), DELTA);
    }

    @Test
    public void testStaticMidpointWithValues() {
        final Vector2D vector2D = Vector2D.midpoint(0, 0, 0, 10);

        assertEquals(0, vector2D.getX(), DELTA);
        assertEquals(5, vector2D.getY(), DELTA);
    }

    @Test
    public void testDotProduct() {
        final Vector2D vector2D1 = new Vector2D(20, 30);
        final Vector2D vector2D2 = new Vector2D(5, 10);

        assertEquals(400, vector2D1.dotProduct(vector2D2), DELTA);
    }

    @Test
    public void testDotProductWithValues() {
        final Vector2D vector2D = new Vector2D(20, 30);

        assertEquals(400, vector2D.dotProduct(5, 10), DELTA);
    }

    @Test
    public void testStaticDotProduct() {
        final Vector2D vector2D1 = new Vector2D(20, 30);
        final Vector2D vector2D2 = new Vector2D(5, 10);

        assertEquals(400, Vector2D.dotProduct(vector2D1, vector2D2), DELTA);
    }

    @Test
    public void testStaticDotProductWithValuesAndVectors() {
        final Vector2D vector2D = new Vector2D(20, 30);

        assertEquals(400, Vector2D.dotProduct(vector2D, 5, 10), DELTA);
    }

    @Test
    public void testStaticDotProductWithValues() {
        assertEquals(400, Vector2D.dotProduct(20, 30, 5, 10), DELTA);
    }

    @Test
    public void testGetAbsoluteAngle() {
        assertEquals(Math.PI / 2, new Vector2D(-42, 69).getAbsoluteAngle(new Vector2D(69, 42)), DELTA);
        assertEquals(Math.PI / 4, new Vector2D(1, 1).getAbsoluteAngle(new Vector2D(0, 1)), DELTA);
        assertEquals(2, new Vector2D(5 * Math.cos(2), 5 * Math.sin(2)).getAbsoluteAngle(new Vector2D(1, 0)), DELTA);
        assertEquals(1.3, new Vector2D(5 * Math.cos(1.3), -5 * Math.sin(1.3)).getAbsoluteAngle(new Vector2D(9, 0)), DELTA);
    }

    @Test
    public void testGetAbsoluteAngleWithValues() {
        final Vector2D vector2D = new Vector2D(-1, 0);

        assertEquals(Math.PI, vector2D.getAbsoluteAngle(1, 0), DELTA);
    }

    @Test
    public void testStaticGetAbsoluteAngle() {
        final Vector2D vector2D1 = new Vector2D(-1, 0);
        final Vector2D vector2D2 = new Vector2D(1, 0);

        assertEquals(Math.PI, Vector2D.getAbsoluteAngle(vector2D1, vector2D2), DELTA);
    }

    @Test
    public void testStaticGetAbsoluteAngleWithValuesAndVectors() {
        final Vector2D vector2D = new Vector2D(-1, 0);

        assertEquals(Math.PI, Vector2D.getAbsoluteAngle( vector2D, 1, 0), DELTA);
    }

    @Test
    public void testStaticGetAbsoluteAngleWithValues() {
        assertEquals(Math.PI, Vector2D.getAbsoluteAngle( -1, 0, 1, 0), DELTA);
    }

    @Test
    public void testRotate() {
        final Vector2D vector2D = new Vector2D(10, 10);
        vector2D.rotate(Math.PI / 2);

        assertEquals(-10, vector2D.getX(), DELTA);
        assertEquals(10, vector2D.getY(), DELTA);
    }

    @Test
    public void testStaticRotate() {
        final Vector2D vector2D1 = new Vector2D(1, 0);
        final Vector2D vector2D2 = Vector2D.rotate(vector2D1, Math.PI / 2);

        assertEquals(0, vector2D2.getX(), DELTA);
        assertEquals(1, vector2D2.getY(), DELTA);
    }

    @Test
    public void testStaticRotateWithValues() {
        final Vector2D vector2D = Vector2D.rotate(1, 0, Math.PI / 2);

        assertEquals(0, vector2D.getX(), DELTA);
        assertEquals(1, vector2D.getY(), DELTA);
    }

    @Test
    public void testToPoint2D() {
        final Point2D point2D = new Vector2D(10, 20).toPoint2D();

        assertEquals(10, point2D.getX(), DELTA);
        assertEquals(20, point2D.getY(), DELTA);
    }

    @Test
    public void testStaticToPoint2D() {
        final Point2D point2D = Vector2D.toPoint2D(new Vector2D(10, 20));

        assertEquals(10, point2D.getX(), DELTA);
        assertEquals(20, point2D.getY(), DELTA);
    }

    @Test
    public void testStaticToPoint2DWithValues() {
        final Point2D point2D = Vector2D.toPoint2D(10, 20);

        assertEquals(10, point2D.getX(), DELTA);
        assertEquals(20, point2D.getY(), DELTA);
    }

    @Test
    public void testGetX() {
        final Vector2D vector2D = new Vector2D(10, 0);

        assertEquals(10, vector2D.getX(), DELTA);
    }

    @Test
    public void testSetX() {
        final Vector2D vector2D = new Vector2D();
        vector2D.setX(10);

        assertEquals(10, vector2D.getX(), DELTA);
        assertEquals(0, vector2D.getY(), DELTA);
    }

    @Test
    public void testGetY() {
        final Vector2D vector2D = new Vector2D(0, 10);

        assertEquals(10, vector2D.getY(), DELTA);
    }

    @Test
    public void testSetY() {
        final Vector2D vector2D = new Vector2D();
        vector2D.setY(10);

        assertEquals(0, vector2D.getX(), DELTA);
        assertEquals(10, vector2D.getY(), DELTA);
    }

    @SuppressWarnings("AssertEqualsBetweenInconvertibleTypes")
    @Test
    public void testEquals() {
        final Vector2D vector2D1 = new Vector2D(12, 10);
        final Vector2D vector2D2 = new Vector2D(12, 10);
        final Point2D point2D = vector2D1.toPoint2D();
        final Vector2D vector2D3 = new Vector2D(10, 10);

        assertEquals(vector2D1, vector2D1);
        assertEquals(vector2D1, vector2D2);
        assertEquals(vector2D1, point2D);
        assertNotEquals(vector2D1, vector2D3);
        assertNotEquals(vector2D1, new StringBuilder());
    }

    @Test
    public void testHashcode() {
        final Vector2D vector2D1 = new Vector2D(42, 1337);
        final Vector2D vector2D2 = new Vector2D(42, 1337);
        final Vector2D vector2D3 = new Vector2D(69, 1337);

        assertEquals(149945927, vector2D1.hashCode());
        assertEquals(vector2D1.hashCode(), vector2D2.hashCode());
        assertNotEquals(vector2D1.hashCode(), vector2D3.hashCode());
    }

    @Test
    public void testToString() {
        final Vector2D vector2D = new Vector2D(12, 10);

        assertEquals("Vector2D [x = 12.0, y = 10.0]", vector2D.toString());
    }
}
