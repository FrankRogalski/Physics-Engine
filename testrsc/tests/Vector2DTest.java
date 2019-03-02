package tests;

import javafx.geometry.Point2D;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import vectors.Vector2D;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class Vector2DTest {
    @Test
    public void testEmptyConstructor() {
        final Vector2D vector2D = new Vector2D();

        Assertions.assertEquals(0, vector2D.getX());
        Assertions.assertEquals(0, vector2D.getY());
    }

    @Test
    public void testPresetConstructor() {
        final Vector2D vector2D = new Vector2D(10, 20);

        Assertions.assertEquals(10, vector2D.getX());
        Assertions.assertEquals(20, vector2D.getY());
    }

    @Test
    public void testCopyConstructor() {
        final Vector2D vector2D1 = new Vector2D(10, 20);
        final Vector2D vector2D2 = new Vector2D(vector2D1);

        Assertions.assertEquals(10, vector2D2.getX());
        Assertions.assertEquals(20, vector2D2.getY());
    }

    @Test
    public void testSetAllComponentsWithVector() {
        final Vector2D vector2D = new Vector2D();
        vector2D.setAllComponents(new Vector2D(10, 20));

        Assertions.assertEquals(10, vector2D.getX());
        Assertions.assertEquals(20, vector2D.getY());
    }

    @Test
    public void testSetAllComponentsWithValue() {
        final Vector2D vector2D = new Vector2D();
        vector2D.setAllComponents(1);

        Assertions.assertEquals(1, vector2D.getX());
        Assertions.assertEquals(1, vector2D.getY());
    }

    @Test
    public void testSetAllComponentsWithTwoValues() {
        final Vector2D vector2D = new Vector2D();
        vector2D.setAllComponents(10, 20);

        Assertions.assertEquals(10, vector2D.getX());
        Assertions.assertEquals(20, vector2D.getY());
    }

    @Test
    public void testCreateFromAngle() {
        final Vector2D vector2D = Vector2D.createFromAngle(Math.PI / 2);
        // Test only if the method is accurate to 5 decimal places
        Assertions.assertEquals(0, Math.round(vector2D.getX() * 100000) / 100000d);
        Assertions.assertEquals(1, Math.round(vector2D.getY() * 100000) / 100000d);
    }

    @Test
    public void testCreateFromAngleWithDistance() {
        final Vector2D vector2D = Vector2D.createFromAngle(Math.PI / 2, 5);
        // Test only if the method is accurate to 5 decimal places
        Assertions.assertEquals(0, Math.round(vector2D.getX() * 100000) / 100000d);
        Assertions.assertEquals(5, Math.round(vector2D.getY() * 100000) / 100000d);
    }

    @Test
    public void testCreateRandomVector2D() {
        final List<Double> directions = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            final Vector2D vector2D = Vector2D.createRandomVector2D();
            // Test only if the method is accurate to 5 decimal places
            Assertions.assertEquals(1, Math.round(vector2D.getMag() * 100000) / 100000d);
            final double direction = vector2D.getDirection();
            if (directions.contains(direction)) {
                Assertions.fail();
            }
            directions.add(direction);
        }
    }

    @Test
    public void testAddWithVector() {
        final Vector2D vector2D1 = new Vector2D(5, 10);
        final Vector2D vector2D2 = new Vector2D(20, 100);
        vector2D1.add(vector2D2);

        Assertions.assertEquals(25, vector2D1.getX());
        Assertions.assertEquals(110, vector2D1.getY());

        Assertions.assertEquals(20, vector2D2.getX());
        Assertions.assertEquals(100, vector2D2.getY());
    }

    @Test
    public void testAddWithValues() {
        final Vector2D vector2D = new Vector2D(5, 10);
        vector2D.add(20, 100);

        Assertions.assertEquals(25, vector2D.getX());
        Assertions.assertEquals(110, vector2D.getY());
    }

    @Test
    public void testStaticAddWithTwoVectors() {
        final Vector2D vector2D1 = new Vector2D(5, 10);
        final Vector2D vector2D2 = new Vector2D(20, 100);
        final Vector2D vector2D3 = Vector2D.add(vector2D1, vector2D2);

        Assertions.assertEquals(25, vector2D3.getX());
        Assertions.assertEquals(110, vector2D3.getY());

        Assertions.assertEquals(5, vector2D1.getX());
        Assertions.assertEquals(10, vector2D1.getY());

        Assertions.assertEquals(20, vector2D2.getX());
        Assertions.assertEquals(100, vector2D2.getY());
    }

    @Test
    public void testStaticAddWithVectorsAndValues() {
        final Vector2D vector2D1 = new Vector2D(5, 10);
        final Vector2D vector2D2 = Vector2D.add(vector2D1, 20, 100);

        Assertions.assertEquals(25, vector2D2.getX());
        Assertions.assertEquals(110, vector2D2.getY());

        Assertions.assertEquals(5, vector2D1.getX());
        Assertions.assertEquals(10, vector2D1.getY());
    }

    @Test
    public void testStaticAddWithValues() {
        final Vector2D vector2D = Vector2D.add(5, 10, 20, 100);

        Assertions.assertEquals(25, vector2D.getX());
        Assertions.assertEquals(110, vector2D.getY());
    }

    @Test
    public void testSubWithVector() {
        final Vector2D vector2D1 = new Vector2D(90, 50);
        final Vector2D vector2D2 = new Vector2D(40, 30);
        vector2D1.sub(vector2D2);

        Assertions.assertEquals(50, vector2D1.getX());
        Assertions.assertEquals(20, vector2D1.getY());

        Assertions.assertEquals(40, vector2D2.getX());
        Assertions.assertEquals(30, vector2D2.getY());
    }

    @Test
    public void testSubWithValues() {
        final Vector2D vector2D = new Vector2D(90, 50);
        vector2D.sub(40, 30);

        Assertions.assertEquals(50, vector2D.getX());
        Assertions.assertEquals(20, vector2D.getY());
    }

    @Test
    public void testStaticSubWithTwoVectors() {
        final Vector2D vector2D1 = new Vector2D(90, 50);
        final Vector2D vector2D2 = new Vector2D(40, 30);
        final Vector2D vector2D3 = Vector2D.sub(vector2D1, vector2D2);

        Assertions.assertEquals(50, vector2D3.getX());
        Assertions.assertEquals(20, vector2D3.getY());

        Assertions.assertEquals(90, vector2D1.getX());
        Assertions.assertEquals(50, vector2D1.getY());

        Assertions.assertEquals(40, vector2D2.getX());
        Assertions.assertEquals(30, vector2D2.getY());
    }

    @Test
    public void testStaticSubWithVectorsAndValues() {
        final Vector2D vector2D1 = new Vector2D(90, 50);
        final Vector2D vector2D2 = Vector2D.sub(vector2D1, 40, 30);

        Assertions.assertEquals(50, vector2D2.getX());
        Assertions.assertEquals(20, vector2D2.getY());

        Assertions.assertEquals(90, vector2D1.getX());
        Assertions.assertEquals(50, vector2D1.getY());
    }

    @Test
    public void testStaticSubWithVectorsAndValuesReversed() {
        final Vector2D vector2D1 = new Vector2D(90, 50);
        final Vector2D vector2D2 = Vector2D.sub(40, 30, vector2D1);

        Assertions.assertEquals(-50, vector2D2.getX());
        Assertions.assertEquals(-20, vector2D2.getY());

        Assertions.assertEquals(90, vector2D1.getX());
        Assertions.assertEquals(50, vector2D1.getY());
    }

    @Test
    public void testStaticSubWithValues() {
        final Vector2D vector2D = Vector2D.sub(90, 50, 40, 30);

        Assertions.assertEquals(50, vector2D.getX());
        Assertions.assertEquals(20, vector2D.getY());
    }

    @Test
    public void testMultiply() {
        final Vector2D vector2D = new Vector2D(5, 3);
        vector2D.multiply(6);

        Assertions.assertEquals(30, vector2D.getX());
        Assertions.assertEquals(18, vector2D.getY());
    }

    @Test
    public void testStaticMultiply() {
        final Vector2D vector2D1 = new Vector2D(5, 3);
        final Vector2D vector2D2 = Vector2D.multiply(vector2D1,6);

        Assertions.assertEquals(30, vector2D2.getX());
        Assertions.assertEquals(18, vector2D2.getY());

        Assertions.assertEquals(5, vector2D1.getX());
        Assertions.assertEquals(3, vector2D1.getY());
    }

    @Test
    public void testStaticMultiplyWithValues() {
        final Vector2D vector2D = Vector2D.multiply(5, 3,6);

        Assertions.assertEquals(30, vector2D.getX());
        Assertions.assertEquals(18, vector2D.getY());
    }

    @Test
    public void testDiv() {
        final Vector2D vector2D = new Vector2D(25, 10);
        vector2D.div(5);

        Assertions.assertEquals(5, vector2D.getX());
        Assertions.assertEquals(2, vector2D.getY());
    }

    @Test
    public void testStaticDiv() {
        final Vector2D vector2D1 = new Vector2D(25, 10);
        final Vector2D vector2D2 = Vector2D.div(vector2D1,5);

        Assertions.assertEquals(5, vector2D2.getX());
        Assertions.assertEquals(2, vector2D2.getY());

        Assertions.assertEquals(25, vector2D1.getX());
        Assertions.assertEquals(10, vector2D1.getY());
    }

    @Test
    public void testStaticDivWithValues() {
        final Vector2D vector2D = Vector2D.div(25, 10,5);

        Assertions.assertEquals(5, vector2D.getX());
        Assertions.assertEquals(2, vector2D.getY());
    }

    @Test
    public void testDistanceWithVector() {
        final Vector2D vector2D1 = new Vector2D(0, 10);
        final Vector2D vector2D2 = new Vector2D(0, -10);

        Assertions.assertEquals(20, vector2D1.distance(vector2D2));
    }

    @Test
    public void testDistanceWithValues() {
        final Vector2D vector2D1 = new Vector2D(0, 10);

        Assertions.assertEquals(20, vector2D1.distance(0, -10));
    }

    @Test
    public void testStaticDistanceWithVectors() {
        final Vector2D vector2D1 = new Vector2D(0, 10);
        final Vector2D vector2D2 = new Vector2D(0, -10);

        Assertions.assertEquals(20, Vector2D.distance(vector2D1, vector2D2));
    }

    @Test
    public void testStaticDistanceWithVectorsAndValues() {
        final Vector2D vector2D = new Vector2D(0, 10);

        Assertions.assertEquals(20, Vector2D.distance(vector2D, 0, -10));
    }

    @Test
    public void testStaticDistanceWithValues() {
        Assertions.assertEquals(20, Vector2D.distance(0, 10, 0, -10));
    }

    @Test
    public void testNormalize() {
        final Vector2D vector2D = new Vector2D(5, 3);
        vector2D.normalize();
        // Test only if the method is accurate to 5 decimal places
        Assertions.assertEquals(1, Math.round(vector2D.getMag() * 100000) / 100000d);
    }

    @Test
    public void testNormalizeSmallValues() {
        final Vector2D vector2D = new Vector2D(0.5, 0.5);
        vector2D.normalize();
        // Test only if the method is accurate to 5 decimal places
        Assertions.assertEquals(1, Math.round(vector2D.getMag() * 100000) / 100000d);
    }

    @Test
    public void testStaticNormalize() {
        final Vector2D vector2D1 = new Vector2D(5, 3);
        final Vector2D vector2D2 = Vector2D.normalize(vector2D1);
        // Test only if the method is accurate to 5 decimal places
        Assertions.assertEquals(1, Math.round(vector2D2.getMag() * 100000) / 100000d);

        Assertions.assertEquals(5, vector2D1.getX());
        Assertions.assertEquals(3, vector2D1.getY());
    }

    @Test
    public void testStaticNormalizeSmallValues() {
        final Vector2D vector2D1 = new Vector2D(0.5, 0.1);
        final Vector2D vector2D2 = Vector2D.normalize(vector2D1);
        // Test only if the method is accurate to 5 decimal places
        Assertions.assertEquals(1, Math.round(vector2D2.getMag() * 100000) / 100000d);

        Assertions.assertEquals(0.5, vector2D1.getX());
        Assertions.assertEquals(0.1, vector2D1.getY());
    }

    @Test
    public void testStaticNormalizeWithValues() {
        final Vector2D vector2D = Vector2D.normalize(5, 3);
        // Test only if the method is accurate to 5 decimal places
        Assertions.assertEquals(1, Math.round(vector2D.getMag() * 100000) / 100000d);
    }

    @Test
    public void testStaticNormalizeWithSmallValues() {
        final Vector2D vector2D = Vector2D.normalize(0.5, 0.3);
        // Test only if the method is accurate to 5 decimal places
        Assertions.assertEquals(1, Math.round(vector2D.getMag() * 100000) / 100000d);
    }

    @Test
    public void testGetMag() {
        final Vector2D vector2D = new Vector2D(0, 3);
        Assertions.assertEquals(3, vector2D.getMag());
    }

    @Test
    public void testStaticGetMag() {
        final Vector2D vector2D = new Vector2D(0, 3);
        Assertions.assertEquals(3, Vector2D.getMag(vector2D));
    }

    @Test
    public void testStaticGetMagWithValues() {
        Assertions.assertEquals(3, Vector2D.getMag(0, 3));
    }

    @Test
    public void testGetMagSquared() {
        final Vector2D vector2D = new Vector2D(0, 3);
        Assertions.assertEquals(9, vector2D.getMagSquared());
    }

    @Test
    public void testStaticGetMagSquared() {
        final Vector2D vector2D = new Vector2D(0, 3);
        Assertions.assertEquals(9, Vector2D.getMagSquared(vector2D));
    }

    @Test
    public void testStaticGetMagSquaredWithValues() {
        Assertions.assertEquals(9, Vector2D.getMagSquared(0, 3));
    }

    @Test
    public void testGetDirection() {
        Assertions.assertEquals(0, new Vector2D(1, 0).getDirection());
    }

    @Test
    public void testStaticGetDirection() {
        Assertions.assertEquals(0, Vector2D.getDirection(new Vector2D(1, 0)));
    }

    @Test
    public void testStaticGetDirectionWithValues() {
        Assertions.assertEquals(0, Vector2D.getDirection(1, 0));
    }

    @Test
    public void testLimit() {
        final Vector2D vector2D = new Vector2D(10, 10);
        vector2D.limit(5);
        // Test only if the method is accurate to 5 decimal places
        Assertions.assertEquals(5, Math.round(vector2D.getMag() * 100000) / 100000d);
    }

    @Test
    public void testLimitNotReached() {
        final Vector2D vector2D = new Vector2D(0, 3);
        vector2D.limit(5);
        // Test only if the method is accurate to 5 decimal places
        Assertions.assertEquals(3, Math.round(vector2D.getMag() * 100000) / 100000d);
    }

    @Test
    public void testStaticLimit() {
        final Vector2D vector2D1 = new Vector2D(10, 5);
        final Vector2D vector2D2 = Vector2D.limit(vector2D1, 5);
        // Test only if the method is accurate to 5 decimal places
        Assertions.assertEquals(5, Math.round(vector2D2.getMag() * 100000) / 100000d);

        Assertions.assertEquals(10, vector2D1.getX());
        Assertions.assertEquals(5, vector2D1.getY());
    }

    @Test
    public void testStaticLimitNotReached() {
        final Vector2D vector2D1 = new Vector2D(3, 0);
        final Vector2D vector2D2 = Vector2D.limit(vector2D1, 5);
        // Test only if the method is accurate to 5 decimal places
        Assertions.assertEquals(3, Math.round(vector2D2.getMag() * 100000) / 100000d);

        Assertions.assertEquals(3, vector2D1.getX());
        Assertions.assertEquals(0, vector2D1.getY());

        Assertions.assertEquals(3, vector2D2.getX());
        Assertions.assertEquals(0, vector2D2.getY());
    }

    @Test
    public void testStaticLimitWithValues() {
        final Vector2D vector2D = Vector2D.limit(10, 10, 5);
        // Test only if the method is accurate to 5 decimal places
        Assertions.assertEquals(5, Math.round(vector2D.getMag() * 100000) / 100000d);
    }

    @Test
    public void testStaticLimitNotReachedWithValues() {
        final Vector2D vector2D = Vector2D.limit(1, 0, 5);
        // Test only if the method is accurate to 5 decimal places
        Assertions.assertEquals(1, Math.round(vector2D.getMag() * 100000) / 100000d);
    }

    @Test
    public void testLerp() {
        final Vector2D vector2D1 = new Vector2D();
        final Vector2D vector2D2 = new Vector2D(10, 0);
        final Vector2D vector2D3 = vector2D1.lerp(vector2D2, 0.2);

        Assertions.assertEquals(2, vector2D3.getX());
        Assertions.assertEquals(0, vector2D3.getY());

        Assertions.assertEquals(0, vector2D1.getX());
        Assertions.assertEquals(0, vector2D1.getY());

        Assertions.assertEquals(10, vector2D2.getX());
        Assertions.assertEquals(0, vector2D2.getY());
    }

    @Test
    public void testLerpWithValues() {
        final Vector2D vector2D1 = new Vector2D();
        final Vector2D vector2D2 = vector2D1.lerp(10, 0, 0.2);

        Assertions.assertEquals(2, vector2D2.getX());
        Assertions.assertEquals(0, vector2D2.getY());

        Assertions.assertEquals(0, vector2D1.getX());
        Assertions.assertEquals(0, vector2D1.getY());
    }

    @Test
    public void testStaticLerp() {
        final Vector2D vector2D1 = new Vector2D();
        final Vector2D vector2D2 = new Vector2D(10, 0);
        final Vector2D vector2D3 = Vector2D.lerp(vector2D1, vector2D2, 0.2);

        Assertions.assertEquals(2, vector2D3.getX());
        Assertions.assertEquals(0, vector2D3.getY());

        Assertions.assertEquals(0, vector2D1.getX());
        Assertions.assertEquals(0, vector2D1.getY());

        Assertions.assertEquals(10, vector2D2.getX());
        Assertions.assertEquals(0, vector2D2.getY());
    }

    @Test
    public void testStaticLerpWithValuesAndVectors() {
        final Vector2D vector2D1 = new Vector2D(10, 0);
        final Vector2D vector2D2 = Vector2D.lerp(0, 0, vector2D1, 0.2);

        Assertions.assertEquals(2, vector2D2.getX());
        Assertions.assertEquals(0, vector2D2.getY());

        Assertions.assertEquals(10, vector2D1.getX());
        Assertions.assertEquals(0, vector2D1.getY());
    }

    @Test
    public void testStaticLerpWithValuesAndVectorsReversed() {
        final Vector2D vector2D1 = new Vector2D();
        final Vector2D vector2D2 = Vector2D.lerp(vector2D1, 10, 0, 0.2);

        Assertions.assertEquals(2, vector2D2.getX());
        Assertions.assertEquals(0, vector2D2.getY());

        Assertions.assertEquals(0, vector2D1.getX());
        Assertions.assertEquals(0, vector2D1.getY());
    }

    @Test
    public void testStaticLerpWithValues() {
        final Vector2D vector2D = Vector2D.lerp(0, 0, 10, 0, 0.2);

        Assertions.assertEquals(2, vector2D.getX());
        Assertions.assertEquals(0, vector2D.getY());
    }

    @Test
    public void testSetMag() {
        final Vector2D vector2D = new Vector2D(10, 10);
        vector2D.setMag(5);

        Assertions.assertEquals(5, Math.round(vector2D.getMag() * 100000) / 100000d);
    }

    @Test
    public void testStaticSetMag() {
        final Vector2D vector2D1 = new Vector2D(10, 10);
        final Vector2D vector2D2 = Vector2D.setMag(vector2D1, 5);

        Assertions.assertEquals(5, Math.round(vector2D2.getMag() * 100000) / 100000d);
    }

    @Test
    public void testStaticSetMagWithValues() {
        final Vector2D vector2D = Vector2D.setMag(10, 10, 5);

        Assertions.assertEquals(5, Math.round(vector2D.getMag() * 100000) / 100000d);
    }

    @Test
    public void testMidpoint() {
        final Vector2D vector2D1 = new Vector2D();
        final Vector2D vector2D2 = new Vector2D(0, 10);
        final Vector2D vector2D3 = vector2D1.midpoint(vector2D2);

        Assertions.assertEquals(0, vector2D3.getX());
        Assertions.assertEquals(5, vector2D3.getY());
    }

    @Test
    public void testMidpointWithValues() {
        final Vector2D vector2D1 = new Vector2D();
        final Vector2D vector2D2 = vector2D1.midpoint(0, 10);

        Assertions.assertEquals(0, vector2D2.getX());
        Assertions.assertEquals(5, vector2D2.getY());
    }

    @Test
    public void testStaticMidpoint() {
        final Vector2D vector2D1 = new Vector2D();
        final Vector2D vector2D2 = new Vector2D(0, 10);
        final Vector2D vector2D3 = Vector2D.midpoint(vector2D1, vector2D2);

        Assertions.assertEquals(0, vector2D3.getX());
        Assertions.assertEquals(5, vector2D3.getY());
    }

    @Test
    public void testStaticMidpointWithValuesAndVectors() {
        final Vector2D vector2D1 = new Vector2D();
        final Vector2D vector2D2 = Vector2D.midpoint(vector2D1, 0, 10);

        Assertions.assertEquals(0, vector2D2.getX());
        Assertions.assertEquals(5, vector2D2.getY());
    }

    @Test
    public void testStaticMidpointWithValues() {
        final Vector2D vector2D = Vector2D.midpoint(0, 0, 0, 10);

        Assertions.assertEquals(0, vector2D.getX());
        Assertions.assertEquals(5, vector2D.getY());
    }

    @Test
    public void testDotProduct() {
        final Vector2D vector2D1 = new Vector2D(20, 30);
        final Vector2D vector2D2 = new Vector2D(5, 10);

        Assertions.assertEquals(400, vector2D1.dotProduct(vector2D2));
    }

    @Test
    public void testDotProductWithValues() {
        final Vector2D vector2D = new Vector2D(20, 30);

        Assertions.assertEquals(400, vector2D.dotProduct(5, 10));
    }

    @Test
    public void testStaticDotProduct() {
        final Vector2D vector2D1 = new Vector2D(20, 30);
        final Vector2D vector2D2 = new Vector2D(5, 10);

        Assertions.assertEquals(400, Vector2D.dotProduct(vector2D1, vector2D2));
    }

    @Test
    public void testStaticDotProductWithValuesAndVectors() {
        final Vector2D vector2D = new Vector2D(20, 30);

        Assertions.assertEquals(400, Vector2D.dotProduct(vector2D, 5, 10));
    }

    @Test
    public void testStaticDotProductWithValues() {
        Assertions.assertEquals(400, Vector2D.dotProduct(20, 30, 5, 10));
    }

    @Test
    public void testGetAbsoluteAngle() {
        final Vector2D vector2D1 = new Vector2D(-1, 0);
        final Vector2D vector2D2 = new Vector2D(1, 0);

        Assertions.assertEquals(Math.PI, vector2D1.getAbsoluteAngle(vector2D2));
    }

    @Test
    public void testGetAbsoluteAngleWithValues() {
        final Vector2D vector2D = new Vector2D(-1, 0);

        Assertions.assertEquals(Math.PI, vector2D.getAbsoluteAngle(1, 0));
    }

    @Test
    public void testStaticGetAbsoluteAngle() {
        final Vector2D vector2D1 = new Vector2D(-1, 0);
        final Vector2D vector2D2 = new Vector2D(1, 0);

        Assertions.assertEquals(Math.PI, Vector2D.getAbsoluteAngle(vector2D1, vector2D2));
    }

    @Test
    public void testStaticGetAbsoluteAngleWithValuesAndVectors() {
        final Vector2D vector2D = new Vector2D(-1, 0);

        Assertions.assertEquals(Math.PI, Vector2D.getAbsoluteAngle( vector2D, 1, 0));
    }

    @Test
    public void testStaticGetAbsoluteAngleWithValues() {
        Assertions.assertEquals(Math.PI, Vector2D.getAbsoluteAngle( -1, 0, 1, 0));
    }

    @Test
    public void testRotate() {
        final Vector2D vector2D = new Vector2D(1, 0);
        vector2D.rotate(Math.PI / 2);

        Assertions.assertEquals(0, Math.round(vector2D.getX() * 100000) / 100000d);
        Assertions.assertEquals(1, Math.round(vector2D.getY() * 100000) / 100000d);
    }

    @Test
    public void testStaticRotate() {
        final Vector2D vector2D1 = new Vector2D(1, 0);
        final Vector2D vector2D2 = Vector2D.rotate(vector2D1, Math.PI / 2);

        Assertions.assertEquals(0, Math.round(vector2D2.getX() * 100000) / 100000d);
        Assertions.assertEquals(1, Math.round(vector2D2.getY() * 100000) / 100000d);
    }

    @Test
    public void testStaticRotateWithValues() {
        final Vector2D vector2D = Vector2D.rotate(1, 0, Math.PI / 2);

        Assertions.assertEquals(0, Math.round(vector2D.getX() * 100000) / 100000d);
        Assertions.assertEquals(1, Math.round(vector2D.getY() * 100000) / 100000d);
    }

    @Test
    public void testToPoint2D() {
        final Point2D point2D = new Vector2D(10, 20).toPoint2D();

        Assertions.assertEquals(10, point2D.getX());
        Assertions.assertEquals(20, point2D.getY());
    }

    @Test
    public void testStaticToPoint2D() {
        final Point2D point2D = Vector2D.toPoint2D(new Vector2D(10, 20));

        Assertions.assertEquals(10, point2D.getX());
        Assertions.assertEquals(20, point2D.getY());
    }

    @Test
    public void testStaticToPoint2DWithValues() {
        final Point2D point2D = Vector2D.toPoint2D(10, 20);

        Assertions.assertEquals(10, point2D.getX());
        Assertions.assertEquals(20, point2D.getY());
    }

    @Test
    public void testGetX() {
        final Vector2D vector2D = new Vector2D(10, 0);

        Assertions.assertEquals(10, vector2D.getX());
    }

    @Test
    public void testSetX() {
        final Vector2D vector2D = new Vector2D();
        vector2D.setX(10);

        Assertions.assertEquals(10, vector2D.getX());
        Assertions.assertEquals(0, vector2D.getY());
    }

    @Test
    public void testGetY() {
        final Vector2D vector2D = new Vector2D(0, 10);

        Assertions.assertEquals(10, vector2D.getY());
    }

    @Test
    public void testSetY() {
        final Vector2D vector2D = new Vector2D();
        vector2D.setY(10);

        Assertions.assertEquals(0, vector2D.getX());
        Assertions.assertEquals(10, vector2D.getY());
    }

    @SuppressWarnings("AssertEqualsBetweenInconvertibleTypes")
    @Test
    public void testEquals() {
        final Vector2D vector2D1 = new Vector2D(12, 10);
        final Vector2D vector2D2 = new Vector2D(12, 10);
        final Point2D point2D = vector2D1.toPoint2D();
        final Vector2D vector2D3 = new Vector2D(10, 10);

        Assertions.assertEquals(vector2D1, vector2D1);
        Assertions.assertEquals(vector2D1, vector2D2);
        Assertions.assertEquals(vector2D1, point2D);
        Assertions.assertNotEquals(vector2D1, vector2D3);
    }

    @Test
    public void testHashcode() {
        final Vector2D vector2D1 = new Vector2D(12, 10);
        final Vector2D vector2D2 = new Vector2D(12, 10);
        final Vector2D vector2D3 = new Vector2D(10, 10);

        Assertions.assertEquals(vector2D1.hashCode(), vector2D2.hashCode());
        Assertions.assertNotEquals(vector2D1.hashCode(), vector2D3.hashCode());
    }

    @Test
    public void testToString() {
        final Vector2D vector2D = new Vector2D(12, 10);

        Assertions.assertEquals("Vector2D [x = 12.0, y = 10.0]", vector2D.toString());
    }
}
