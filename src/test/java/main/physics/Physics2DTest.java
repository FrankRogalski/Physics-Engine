package main.physics;

import org.junit.Test;
import main.vectors.Vector2D;

import static org.junit.Assert.assertEquals;


public class Physics2DTest {
    @Test
    public void testBaseConstructor() {
        Physics2D physics2D = new Physics2D(1, 2, 3, 4);

        assertEquals(1, physics2D.getX(), 0.00001);
        assertEquals(2, physics2D.getY(), 0.00001);
        assertEquals(3, physics2D.getMaxSpeed(), 0.00001);
        assertEquals(4, physics2D.getMaxForce(), 0.00001);
    }

    @Test
    public void testBaseConstructorWithVector() {
        Vector2D vector2D = new Vector2D(1, 2);
        Physics2D physics2D = new Physics2D(vector2D, 3, 4);

        assertEquals(vector2D, physics2D.getLocation());
        assertEquals(3, physics2D.getMaxSpeed(), 0.00001);
        assertEquals(4, physics2D.getMaxForce(), 0.00001);
    }

    @Test
    public void testBaseConstructorWithVectorNull() {
        Vector2D vector2D = null;
        @SuppressWarnings("ConstantConditions") Physics2D physics2D = new Physics2D(vector2D, 3, 4);

        assertEquals(new Vector2D(), physics2D.getLocation());
        assertEquals(3, physics2D.getMaxSpeed(), 0.00001);
        assertEquals(4, physics2D.getMaxForce(), 0.00001);
    }

    @Test
    public void testBaseConstructorWithPhysics() {
        Physics2D physics2D1 = new Physics2D(1, 2, 5, 6);
        Physics2D physics2D2 = new Physics2D(physics2D1, 3, 4);

        assertEquals(physics2D1.getLocation(), physics2D2.getLocation());
        assertEquals(3, physics2D2.getMaxSpeed(), 0.00001);
        assertEquals(4, physics2D2.getMaxForce(), 0.00001);
    }

    @Test
    public void testBaseConstructorWithPhysicsNull() {
        Physics2D physics2D1 = null;
        @SuppressWarnings("ConstantConditions") Physics2D physics2D2 = new Physics2D(physics2D1, 3, 4);

        assertEquals(new Vector2D(), physics2D2.getLocation());
        assertEquals(3, physics2D2.getMaxSpeed(), 0.00001);
        assertEquals(4, physics2D2.getMaxForce(), 0.00001);
    }

    @Test
    public void testCopyConstructor() {
        Physics2D physics2D1 = new Physics2D(1, 2, 5, 6);
        physics2D1.seek(100, 100);
        physics2D1.updatePosition();
        physics2D1.seek(100, 100);
        Physics2D physics2D2 = new Physics2D(physics2D1);

        assertEquals(physics2D1.getLocation(), physics2D2.getLocation());
        assertEquals(physics2D1.getVelocity(), physics2D2.getVelocity());
        assertEquals(physics2D1.getAcceleration(), physics2D2.getAcceleration());
        assertEquals(physics2D1.getMaxSpeed(), physics2D2.getMaxSpeed(), 0.00001);
        assertEquals(physics2D1.getMaxForce(), physics2D2.getMaxForce(), 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCopyConstructorNull() {
        new Physics2D(null);
    }

    @Test
    public void testSeekXAndY() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.seek(10, 0);

        assertEquals(0.1, physics2D.getAcceleration().getX(), 0.00001);
        assertEquals(0, physics2D.getAcceleration().getY(), 0.00001);
    }

    @Test
    public void testSeekXAndYWithWeight() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.seek(10, 0, 2);

        assertEquals(0.2, physics2D.getAcceleration().getX(), 0.00001);
        assertEquals(0, physics2D.getAcceleration().getY(), 0.00001);
    }

    @Test
    public void testSeekVector() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.seek(new Vector2D(10, 0));

        assertEquals(0.1, physics2D.getAcceleration().getX(), 0.00001);
        assertEquals(0, physics2D.getAcceleration().getY(), 0.00001);
    }

    @Test
    public void testSeekVectorWithWeight() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.seek(new Vector2D(10, 0), 2);

        assertEquals(0.2, physics2D.getAcceleration().getX(), 0.00001);
        assertEquals(0, physics2D.getAcceleration().getY(), 0.00001);
    }

    @Test
    public void testSeekPhysics() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.seek(new Physics2D(10, 0, 0, 0));

        assertEquals(0.1, physics2D.getAcceleration().getX(), 0.00001);
        assertEquals(0, physics2D.getAcceleration().getY(), 0.00001);
    }

    @Test
    public void testSeekPhysicsWithWeight() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.seek(new Physics2D(10, 0, 0, 0), 2);

        assertEquals(0.2, physics2D.getAcceleration().getX(), 0.00001);
        assertEquals(0, physics2D.getAcceleration().getY(), 0.00001);
    }

    @Test
    public void testAvoidXAndY() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.avoid(10, 0);

        assertEquals(-0.1, physics2D.getAcceleration().getX(), 0.00001);
        assertEquals(0, physics2D.getAcceleration().getY(), 0.00001);
    }

    @Test
    public void testAvoidXAndYWithWeight() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.avoid(10, 0, 2);

        assertEquals(-0.2, physics2D.getAcceleration().getX(), 0.00001);
        assertEquals(0, physics2D.getAcceleration().getY(), 0.00001);
    }

    @Test
    public void testAvoidVector() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.avoid(new Vector2D(10, 0));

        assertEquals(-0.1, physics2D.getAcceleration().getX(), 0.00001);
        assertEquals(0, physics2D.getAcceleration().getY(), 0.00001);
    }

    @Test
    public void testAvoidVectorWithWeight() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.avoid(new Vector2D(10, 0), 2);

        assertEquals(-0.2, physics2D.getAcceleration().getX(), 0.00001);
        assertEquals(0, physics2D.getAcceleration().getY(), 0.00001);
    }

    @Test
    public void testAvoidPhysics() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.avoid(new Physics2D(10, 0, 0, 0));

        assertEquals(-0.1, physics2D.getAcceleration().getX(), 0.00001);
        assertEquals(0, physics2D.getAcceleration().getY(), 0.00001);
    }

    @Test
    public void testAvoidPhysicsWithWeight() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.avoid(new Physics2D(10, 0, 0, 0), 2);

        assertEquals(-0.2, physics2D.getAcceleration().getX(), 0.00001);
        assertEquals(0, physics2D.getAcceleration().getY(), 0.00001);
    }

    @Test
    public void testMoveXAndY() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.move(10, 0, 1, false);

        assertEquals(0.1, physics2D.getAcceleration().getX(), 0.00001);
        assertEquals(0, physics2D.getAcceleration().getY(), 0.00001);
    }

    @Test
    public void testMoveXAndYAvoid() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.move(10, 0, 1, true);

        assertEquals(-0.1, physics2D.getAcceleration().getX(), 0.00001);
        assertEquals(0, physics2D.getAcceleration().getY(), 0.00001);
    }

    @Test
    public void testMoveVector() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.move(new Vector2D(10, 0), 1, false);

        assertEquals(0.1, physics2D.getAcceleration().getX(), 0.00001);
        assertEquals(0, physics2D.getAcceleration().getY(), 0.00001);
    }

    @Test
    public void testMoveVectorAvoid() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.move(new Vector2D(10, 0), 1, true);

        assertEquals(-0.1, physics2D.getAcceleration().getX(), 0.00001);
        assertEquals(0, physics2D.getAcceleration().getY(), 0.00001);
    }

    @Test
    public void testMovePhysics() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.move(new Physics2D(10, 0, 0, 0), 1, false);

        assertEquals(0.1, physics2D.getAcceleration().getX(), 0.00001);
        assertEquals(0, physics2D.getAcceleration().getY(), 0.00001);
    }

    @Test
    public void testMovePhysicsAvoid() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.move(new Physics2D(10, 0, 0, 0), 1, true);

        assertEquals(-0.1, physics2D.getAcceleration().getX(), 0.00001);
        assertEquals(0, physics2D.getAcceleration().getY(), 0.00001);
    }

    @Test
    public void testUpdatePosition() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.setFriction(0.5);
        for (int i = 0; i < 2; i++) {
            physics2D.seek(10, 0);
            physics2D.updatePosition();
        }

        assertEquals(0.25, physics2D.getX(), 0.00001);
        assertEquals(0, physics2D.getY(), 0.00001);
        assertEquals(0.15, physics2D.getVelocity().getX(), 0.00001);
        assertEquals(0, physics2D.getVelocity().getY(), 0.00001);
        assertEquals(0, physics2D.getAcceleration().getX(), 0.00001);
        assertEquals(0, physics2D.getAcceleration().getY(), 0.00001);
    }

    @Test
    public void testSetLocationXAndY() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.setLocation(10, 20);

        assertEquals(10, physics2D.getX(), 0.00001);
        assertEquals(20, physics2D.getY(), 0.00001);
    }

    @Test
    public void testSetLocationVector() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        Vector2D vector2D = new Vector2D(10, 10);
        physics2D.setLocation(vector2D);

        assertEquals(vector2D, physics2D.getLocation());
    }

    @Test
    public void testSetLocationPhysics() {
        Physics2D physics2D1 = new Physics2D(0, 0, 5, 0.1);
        Physics2D physics2D2 = new Physics2D(10, 10, 0, 0);
        physics2D1.setLocation(physics2D2);

        assertEquals(physics2D2.getLocation(), physics2D1.getLocation());
    }

    @Test
    public void testGetLocation() {
        Physics2D physics2D = new Physics2D(10, 20, 5, 0.1);

        assertEquals(10, physics2D.getX(), 0.00001);
        assertEquals(20, physics2D.getY(), 0.00001);
    }

    @Test
    public void testSetX() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.setX(10);

        assertEquals(10, physics2D.getX(), 0.00001);
    }

    @Test
    public void testGetX() {
        Physics2D physics2D = new Physics2D(10, 0, 5, 0.1);

        assertEquals(10, physics2D.getX(), 0.00001);
    }

    @Test
    public void testSetY() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.setY(10);

        assertEquals(10, physics2D.getY(), 0.00001);
    }

    @Test
    public void testGetY() {
        Physics2D physics2D = new Physics2D(0, 10, 5, 0.1);

        assertEquals(10, physics2D.getY(), 0.00001);
    }

    @Test
    public void testDistanceXAndY() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);

        assertEquals(10, physics2D.distance(10, 0), 0.00001);
    }

    @Test
    public void testDistanceVector() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);

        assertEquals(10, physics2D.distance(new Vector2D(10, 0)), 0.00001);
    }

    @Test
    public void testDistancePhysics() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);

        assertEquals(10, physics2D.distance(new Physics2D(10, 0, 0, 0)), 0.00001);
    }

    @Test
    public void testGetVelocity() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.seek(10, 0);
        physics2D.updatePosition();

        assertEquals(0.1, physics2D.getVelocity().getX(), 0.00001);
        assertEquals(0, physics2D.getVelocity().getY(), 0.00001);
    }

    @Test
    public void testGetAcceleration() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.seek(10, 0);

        assertEquals(0.1, physics2D.getAcceleration().getX(), 0.00001);
        assertEquals(0, physics2D.getAcceleration().getY(), 0.00001);
    }

    @Test
    public void testSetMaxSpeed() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0);
        physics2D.setMaxSpeed(10);

        assertEquals(10, physics2D.getMaxSpeed(), 0.00001);
    }

    @Test
    public void testGetMaxSpeed() {
        Physics2D physics2D = new Physics2D(0, 0, 10, 0);

        assertEquals(10, physics2D.getMaxSpeed(), 0.00001);
    }

    @Test
    public void testSetMaxForce() {
        Physics2D physics2D = new Physics2D(0, 0, 0, 0.1);
        physics2D.setMaxForce(10);

        assertEquals(10, physics2D.getMaxForce(), 0.00001);
    }

    @Test
    public void testGetMaxForce() {
        Physics2D physics2D = new Physics2D(0, 0, 0, 10);

        assertEquals(10, physics2D.getMaxForce(), 0.00001);
    }

    @Test
    public void testSetFriction() {
        Physics2D physics2D = new Physics2D(0, 0, 0, 0);
        physics2D.setFriction(10);

        assertEquals(10, physics2D.getFriction(), 0.00001);
    }

    @Test
    public void testGetFriction() {
        Physics2D physics2D = new Physics2D(0, 0, 0, 0);
        physics2D.setFriction(10);

        assertEquals(10, physics2D.getFriction(), 0.00001);
    }
}
