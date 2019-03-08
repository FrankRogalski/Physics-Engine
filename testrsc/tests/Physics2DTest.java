package tests;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import physics.Physics2D;
import vectors.Vector2D;

@SuppressWarnings("WeakerAccess")
public class Physics2DTest {
    @Test
    public void testBaseConstructor() {
        Physics2D physics2D = new Physics2D(1, 2, 3, 4);

        Assertions.assertEquals(1, physics2D.getX());
        Assertions.assertEquals(2, physics2D.getY());
        Assertions.assertEquals(3, physics2D.getMaxSpeed());
        Assertions.assertEquals(4, physics2D.getMaxForce());
    }

    @Test
    public void testBaseConstructorWithVector() {
        Vector2D vector2D = new Vector2D(1, 2);
        Physics2D physics2D = new Physics2D(vector2D, 3, 4);

        Assertions.assertEquals(vector2D, physics2D.getLocation());
        Assertions.assertEquals(3, physics2D.getMaxSpeed());
        Assertions.assertEquals(4, physics2D.getMaxForce());
    }

    @Test
    public void testBaseConstructorWithVectorNull() {
        Vector2D vector2D = null;
        @SuppressWarnings("ConstantConditions") Physics2D physics2D = new Physics2D(vector2D, 3, 4);

        Assertions.assertEquals(new Vector2D(), physics2D.getLocation());
        Assertions.assertEquals(3, physics2D.getMaxSpeed());
        Assertions.assertEquals(4, physics2D.getMaxForce());
    }

    @Test
    public void testBaseConstructorWithPhysics() {
        Physics2D physics2D1 = new Physics2D(1, 2, 5, 6);
        Physics2D physics2D2 = new Physics2D(physics2D1, 3, 4);

        Assertions.assertEquals(physics2D1.getLocation(), physics2D2.getLocation());
        Assertions.assertEquals(3, physics2D2.getMaxSpeed());
        Assertions.assertEquals(4, physics2D2.getMaxForce());
    }

    @Test
    public void testBaseConstructorWithPhysicsNull() {
        Physics2D physics2D1 = null;
        @SuppressWarnings("ConstantConditions") Physics2D physics2D2 = new Physics2D(physics2D1, 3, 4);

        Assertions.assertEquals(new Vector2D(), physics2D2.getLocation());
        Assertions.assertEquals(3, physics2D2.getMaxSpeed());
        Assertions.assertEquals(4, physics2D2.getMaxForce());
    }

    @Test
    public void testCopyConstructor() {
        Physics2D physics2D1 = new Physics2D(1, 2, 5, 6);
        physics2D1.seek(100, 100);
        physics2D1.updatePosition();
        physics2D1.seek(100, 100);
        Physics2D physics2D2 = new Physics2D(physics2D1);

        Assertions.assertEquals(physics2D1.getLocation(), physics2D2.getLocation());
        Assertions.assertEquals(physics2D1.getVelocity(), physics2D2.getVelocity());
        Assertions.assertEquals(physics2D1.getAcceleration(), physics2D2.getAcceleration());
        Assertions.assertEquals(physics2D1.getMaxSpeed(), physics2D2.getMaxSpeed());
        Assertions.assertEquals(physics2D1.getMaxForce(), physics2D2.getMaxForce());
    }

    @Test
    public void testCopyConstructorNull() {
        try {
            new Physics2D(null);
            Assertions.fail();
        } catch (IllegalArgumentException ex) {
            // not needed
        }
    }

    @Test
    public void testSeekXAndY() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.seek(10, 0);

        Assertions.assertEquals(0.1, physics2D.getAcceleration().getX());
        Assertions.assertEquals(0, physics2D.getAcceleration().getY());
    }

    @Test
    public void testSeekXAndYWithWeight() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.seek(10, 0, 2);

        Assertions.assertEquals(0.2, physics2D.getAcceleration().getX());
        Assertions.assertEquals(0, physics2D.getAcceleration().getY());
    }

    @Test
    public void testSeekVector() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.seek(new Vector2D(10, 0));

        Assertions.assertEquals(0.1, physics2D.getAcceleration().getX());
        Assertions.assertEquals(0, physics2D.getAcceleration().getY());
    }

    @Test
    public void testSeekVectorWithWeight() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.seek(new Vector2D(10, 0), 2);

        Assertions.assertEquals(0.2, physics2D.getAcceleration().getX());
        Assertions.assertEquals(0, physics2D.getAcceleration().getY());
    }

    @Test
    public void testSeekPhysics() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.seek(new Physics2D(10, 0, 0, 0));

        Assertions.assertEquals(0.1, physics2D.getAcceleration().getX());
        Assertions.assertEquals(0, physics2D.getAcceleration().getY());
    }

    @Test
    public void testSeekPhysicsWithWeight() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.seek(new Physics2D(10, 0, 0, 0), 2);

        Assertions.assertEquals(0.2, physics2D.getAcceleration().getX());
        Assertions.assertEquals(0, physics2D.getAcceleration().getY());
    }

    @Test
    public void testAvoidXAndY() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.avoid(10, 0);

        Assertions.assertEquals(-0.1, physics2D.getAcceleration().getX());
        Assertions.assertEquals(0, physics2D.getAcceleration().getY());
    }

    @Test
    public void testAvoidXAndYWithWeight() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.avoid(10, 0, 2);

        Assertions.assertEquals(-0.2, physics2D.getAcceleration().getX());
        Assertions.assertEquals(0, physics2D.getAcceleration().getY());
    }

    @Test
    public void testAvoidVector() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.avoid(new Vector2D(10, 0));

        Assertions.assertEquals(-0.1, physics2D.getAcceleration().getX());
        Assertions.assertEquals(0, physics2D.getAcceleration().getY());
    }

    @Test
    public void testAvoidVectorWithWeight() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.avoid(new Vector2D(10, 0), 2);

        Assertions.assertEquals(-0.2, physics2D.getAcceleration().getX());
        Assertions.assertEquals(0, physics2D.getAcceleration().getY());
    }

    @Test
    public void testAvoidPhysics() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.avoid(new Physics2D(10, 0, 0, 0));

        Assertions.assertEquals(-0.1, physics2D.getAcceleration().getX());
        Assertions.assertEquals(0, physics2D.getAcceleration().getY());
    }

    @Test
    public void testAvoidPhysicsWithWeight() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.avoid(new Physics2D(10, 0, 0, 0), 2);

        Assertions.assertEquals(-0.2, physics2D.getAcceleration().getX());
        Assertions.assertEquals(0, physics2D.getAcceleration().getY());
    }

    @Test
    public void testMoveXAndY() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.move(10, 0, 1, false);

        Assertions.assertEquals(0.1, physics2D.getAcceleration().getX());
        Assertions.assertEquals(0, physics2D.getAcceleration().getY());
    }

    @Test
    public void testMoveXAndYAvoid() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.move(10, 0, 1, true);

        Assertions.assertEquals(-0.1, physics2D.getAcceleration().getX());
        Assertions.assertEquals(0, physics2D.getAcceleration().getY());
    }

    @Test
    public void testMoveVector() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.move(new Vector2D(10, 0), 1, false);

        Assertions.assertEquals(0.1, physics2D.getAcceleration().getX());
        Assertions.assertEquals(0, physics2D.getAcceleration().getY());
    }

    @Test
    public void testMoveVectorAvoid() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.move(new Vector2D(10, 0), 1, true);

        Assertions.assertEquals(-0.1, physics2D.getAcceleration().getX());
        Assertions.assertEquals(0, physics2D.getAcceleration().getY());
    }

    @Test
    public void testMovePhysics() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.move(new Physics2D(10, 0, 0, 0), 1, false);

        Assertions.assertEquals(0.1, physics2D.getAcceleration().getX());
        Assertions.assertEquals(0, physics2D.getAcceleration().getY());
    }

    @Test
    public void testMovePhysicsAvoid() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.move(new Physics2D(10, 0, 0, 0), 1, true);

        Assertions.assertEquals(-0.1, physics2D.getAcceleration().getX());
        Assertions.assertEquals(0, physics2D.getAcceleration().getY());
    }

    @Test
    public void testUpdatePosition() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.setFriction(0.5);
        physics2D.seek(10, 0);
        physics2D.updatePosition();

        Assertions.assertEquals(0.05, physics2D.getX());
        Assertions.assertEquals(0, physics2D.getY());
        Assertions.assertEquals(0.05, physics2D.getVelocity().getX());
        Assertions.assertEquals(0, physics2D.getVelocity().getY());
        Assertions.assertEquals(0, physics2D.getAcceleration().getX());
        Assertions.assertEquals(0, physics2D.getAcceleration().getY());
    }

    @Test
    public void testSetLocationXAndY() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.setLocation(10, 20);

        Assertions.assertEquals(10, physics2D.getX());
        Assertions.assertEquals(20, physics2D.getY());
    }

    @Test
    public void testSetLocationVector() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        Vector2D vector2D = new Vector2D(10, 10);
        physics2D.setLocation(vector2D);

        Assertions.assertEquals(vector2D, physics2D.getLocation());
    }

    @Test
    public void testSetLocationPhysics() {
        Physics2D physics2D1 = new Physics2D(0, 0, 5, 0.1);
        Physics2D physics2D2 = new Physics2D(10, 10, 0, 0);
        physics2D1.setLocation(physics2D2);

        Assertions.assertEquals(physics2D2.getLocation(), physics2D1.getLocation());
    }

    @Test
    public void testGetLocation() {
        Physics2D physics2D = new Physics2D(10, 20, 5, 0.1);

        Assertions.assertEquals(10, physics2D.getX());
        Assertions.assertEquals(20, physics2D.getY());
    }

    @Test
    public void testSetX() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.setX(10);

        Assertions.assertEquals(10, physics2D.getX());
    }

    @Test
    public void testGetX() {
        Physics2D physics2D = new Physics2D(10, 0, 5, 0.1);

        Assertions.assertEquals(10, physics2D.getX());
    }

    @Test
    public void testSetY() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.setY(10);

        Assertions.assertEquals(10, physics2D.getY());
    }

    @Test
    public void testGetY() {
        Physics2D physics2D = new Physics2D(0, 10, 5, 0.1);

        Assertions.assertEquals(10, physics2D.getY());
    }

    @Test
    public void testDistanceXAndY() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);

        Assertions.assertEquals(10, physics2D.distance(10, 0));
    }

    @Test
    public void testDistanceVector() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);

        Assertions.assertEquals(10, physics2D.distance(new Vector2D(10, 0)));
    }

    @Test
    public void testDistancePhysics() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);

        Assertions.assertEquals(10, physics2D.distance(new Physics2D(10, 0, 0, 0)));
    }

    @Test
    public void testGetVelocity() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.seek(10, 0);
        physics2D.updatePosition();

        Assertions.assertEquals(0.1, physics2D.getVelocity().getX());
        Assertions.assertEquals(0, physics2D.getVelocity().getY());
    }

    @Test
    public void testGetAcceleration() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0.1);
        physics2D.seek(10, 0);

        Assertions.assertEquals(0.1, physics2D.getAcceleration().getX());
        Assertions.assertEquals(0, physics2D.getAcceleration().getY());
    }

    @Test
    public void testSetMaxSpeed() {
        Physics2D physics2D = new Physics2D(0, 0, 5, 0);
        physics2D.setMaxSpeed(10);

        Assertions.assertEquals(10, physics2D.getMaxSpeed());
    }

    @Test
    public void testGetMaxSpeed() {
        Physics2D physics2D = new Physics2D(0, 0, 10, 0);

        Assertions.assertEquals(10, physics2D.getMaxSpeed());
    }

    @Test
    public void testSetMaxForce() {
        Physics2D physics2D = new Physics2D(0, 0, 0, 0.1);
        physics2D.setMaxForce(10);

        Assertions.assertEquals(10, physics2D.getMaxForce());
    }

    @Test
    public void testGetMaxForce() {
        Physics2D physics2D = new Physics2D(0, 0, 0, 10);

        Assertions.assertEquals(10, physics2D.getMaxForce());
    }

    @Test
    public void testSetFriction() {
        Physics2D physics2D = new Physics2D(0, 0, 0, 0);
        physics2D.setFriction(10);

        Assertions.assertEquals(10, physics2D.getFriction());
    }

    @Test
    public void testGetFriction() {
        Physics2D physics2D = new Physics2D(0, 0, 0, 0);
        physics2D.setFriction(10);

        Assertions.assertEquals(10, physics2D.getFriction());
    }
}
