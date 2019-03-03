package physics;

import vectors.Vector2D;

/**
 * A class used to calculate the physics of an Agent in a 2D Environment
 */
public class Physics2D {
    private Vector2D location;
    private Vector2D velocity = new Vector2D();
    private Vector2D acceleration = new Vector2D();

    private double maxSpeed;
    private double maxForce;

    /**
     * The constructor of the class
     *
     * @param x        The starting x position of the agent
     * @param y        The starting y position of the agent
     * @param maxSpeed The maximum speed the agent can achieve
     * @param maxForce The maximum force with which the agent can change its velocity
     */
    public Physics2D(final double x, final double y, final double maxSpeed, final double maxForce) {
        location = new Vector2D(x, y);
        this.maxForce = maxForce;
        this.maxSpeed = maxSpeed;
    }

    /**
     * The constructor of the class
     *
     * @param location The starting location of the agent
     * @param maxSpeed The maximum speed the agent can achieve
     * @param maxForce The maximum force with which the agent can change its velocity
     */
    public Physics2D(final Vector2D location, final double maxSpeed, final double maxForce) {
        if (location != null) {
            this.location = new Vector2D(location);
        } else {
            this.location = new Vector2D();
        }
        this.maxForce = maxForce;
        this.maxSpeed = maxSpeed;
    }

    /**
     * The constructor of the class
     *
     * @param physics2D A Template Physics object from which the agent will copy the current location
     * @param maxSpeed  The maximum speed the agent can achieve
     * @param maxForce  The maximum force with which the agent can change its velocity
     */
    public Physics2D(final Physics2D physics2D, final double maxSpeed, final double maxForce) {
        if (physics2D != null) {
            location = new Vector2D(physics2D.location);
        } else {
            location = new Vector2D();
        }
        this.maxForce = maxForce;
        this.maxSpeed = maxSpeed;
    }

    /**
     * Copy constructor to replicate the state of an agent perfectly
     *
     * @param physics2D The physics object that will be cloned
     */
    public Physics2D(final Physics2D physics2D) {
        if (physics2D != null) {
            location = new Vector2D(physics2D.location);
            velocity = new Vector2D(physics2D.velocity);
            acceleration = new Vector2D(physics2D.acceleration);
            this.maxForce = physics2D.maxForce;
            this.maxSpeed = physics2D.maxSpeed;
        } else {
            throw new IllegalArgumentException("The physics Object cant be null");
        }
    }

    /**
     * Commands the agent to seek a specific point
     *
     * @param x The x component of the Point that will be chased
     * @param y The y component of the Point that will be chased
     */
    public void seek(final double x, final double y) {
        move(new Vector2D(x, y), 1, false);
    }

    /**
     * Commands the agent to seek a specific point
     *
     * @param x      The x component of the Point that will be chased
     * @param y      The y component of the Point that will be chased
     * @param weight The rating of the importance of the target
     */
    public void seek(final double x, final double y, final double weight) {
        move(new Vector2D(x, y), weight, false);
    }

    /**
     * Commands the agent to seek a specific point
     *
     * @param moveTo The point that will be chased
     */
    public void seek(final Vector2D moveTo) {
        move(moveTo, 1, false);
    }

    /**
     * Commands the agent to seek a specific point
     *
     * @param moveTo The point that will be chased
     * @param weight The rating of the importance of the target
     */
    public void seek(final Vector2D moveTo, final double weight) {
        move(moveTo, weight, false);
    }

    /**
     * Commands the agent to seek a specific point
     *
     * @param moveTo The physics object of the agent which will be chased
     */
    public void seek(final Physics2D moveTo) {
        move(moveTo.location, 1, false);
    }

    /**
     * Commands the agent to seek a specific point
     *
     * @param moveTo The physics object of the agent which will be chased
     * @param weight The rating of the importance of the target
     */
    public void seek(final Physics2D moveTo, final double weight) {
        move(moveTo.location, weight, false);
    }

    /**
     * Commands the agent to flee from a specific point
     *
     * @param x The x component of the Point that will be avoided
     * @param y The y component of the Point that will be avoided
     */
    public void avoid(final double x, final double y) {
        move(new Vector2D(x, y), 1, true);
    }

    /**
     * Commands the agent to flee from a specific point
     *
     * @param x      The x component of the Point that will be avoided
     * @param y      The y component of the Point that will be avoided
     * @param weight The rating of the importance of the target
     */
    public void avoid(final double x, final double y, final double weight) {
        move(new Vector2D(x, y), weight, true);
    }

    /**
     * Commands the agent to flee from a specific point
     *
     * @param fleeFrom The point that will be avoided
     */
    public void avoid(final Vector2D fleeFrom) {
        move(fleeFrom, 1, true);
    }

    /**
     * Commands the agent to flee from a specific point
     *
     * @param fleeFrom The point that will be avoided
     * @param weight   The rating of the importance of the target
     */
    public void avoid(final Vector2D fleeFrom, final double weight) {
        move(fleeFrom, weight, true);
    }

    /**
     * Commands the agent to flee from a specific point
     *
     * @param fleeFrom The physics object of the agent which will be avoided
     */
    public void avoid(final Physics2D fleeFrom) {
        move(fleeFrom.location, 1, true);
    }

    /**
     * Commands the agent to flee from a specific point
     *
     * @param fleeFrom The physics object of the agent which will be avoided
     * @param weight   The rating of the importance of the target
     */
    public void avoid(final Physics2D fleeFrom, final double weight) {
        move(fleeFrom.location, weight, true);
    }

    /**
     * Commands the agent to seek a specific point
     *
     * @param moveTo The physics object of the agent which will be chased
     * @param weight The rating of the importance of the target
     * @param avoid  Commands if the target will be chased or avoided
     */
    public void move(final Physics2D moveTo, final double weight, final boolean avoid) {
        move(moveTo.location, weight, avoid);
    }

    /**
     * Commands the agent to seek a specific point
     *
     * @param moveTo The point that will be chased
     * @param weight The rating of the importance of the target
     * @param avoid  Commands if the target will be chased or avoided
     */
    public void move(final Vector2D moveTo, final double weight, final boolean avoid) {
        move(moveTo.getX(), moveTo.getY(), weight, avoid);
    }

    /**
     * Commands the agent to seek a specific point
     *
     * @param x      The x component of the Point that will be chased
     * @param y      The y component of the Point that will be chased
     * @param weight The rating of the importance of the target
     * @param avoid  Commands if the target will be chased or avoided
     */
    public void move(final double x, final double y, final double weight, final boolean avoid) {
        final Vector2D moveTo = new Vector2D(x, y);
        //desired
        moveTo.sub(location);
        moveTo.limit(maxSpeed);
        //steer
        moveTo.sub(velocity);
        moveTo.setMag(maxForce);
        moveTo.multiply(weight);

        // reverse direction when avoiding something
        if (avoid) {
            moveTo.multiply(-1);
        }
        //apply the force
        acceleration.add(moveTo);
    }

    /**
     * Updates the position of the agent after all targets have been taken into consideration
     */
    public void updatePosition() {
        acceleration.limit(maxForce);
        velocity.add(acceleration);
        velocity.limit(maxSpeed);
        location.add(velocity);
        acceleration.setAllComponents(0);
    }

    /**
     * Sets the location of the agent
     *
     * @param x The x component of the new location
     * @param y The y component of the new location
     */
    public void setLocation(final double x, final double y) {
        location.setAllComponents(x, y);
    }

    /**
     * Sets the location of the agent
     *
     * @param vector2D The new location of the agent
     */
    public void setLocation(final Vector2D vector2D) {
        location = new Vector2D(vector2D);
    }

    /**
     * Sets the location of the agent
     *
     * @param physics2D The agent to which this agent will move
     */
    public void setLocation(final Physics2D physics2D) {
        location = new Vector2D(physics2D.location);
    }

    /**
     * Returns the location of the agent
     *
     * @return The location of the agent
     */
    public Vector2D getLocation() {
        return new Vector2D(location);
    }

    /**
     * Sets the x component of the location
     *
     * @param x The new x component of the location
     */
    public void setX(final double x) {
        location.setX(x);
    }

    /**
     * Returns the x component of the location
     *
     * @return The x component of the location
     */
    public double getX() {
        return location.getX();
    }

    /**
     * Sets the y component of the location
     *
     * @param y The new y component of the location
     */
    public void setY(final double y) {
        location.setY(y);
    }

    /**
     * Returns the y component of the location
     *
     * @return The y component of the location
     */
    public double getY() {
        return location.getY();
    }

    /**
     * Calculates the distance of the agent to another point
     *
     * @param x The x component of the point to which the distance is calculated
     * @param y The y component of the point to which the distance is calculated
     * @return The distance of the agent to another point
     */
    public double distance(final double x, final double y) {
        return location.distance(x, y);
    }

    /**
     * Calculates the distance of the agent to another point
     * @param point The point to which the distance is calculated
     * @return The distance of the agent to another point
     */
    public double distance(final Vector2D point) {
        return location.distance(point);
    }

    /**
     * Calculates the distance of the agent to another agent
     * @param physics2D The physics of another agent to which the distance is calculated
     * @return The distance of the agent to another agent
     */
    public double distance(final Physics2D physics2D) {
        return location.distance(physics2D.location);
    }

    /**
     * Returns the velocity of the agent
     * @return The velocity of the agent
     */
    public Vector2D getVelocity() {
        return new Vector2D(velocity);
    }

    /**
     * Sets the maximum speed that the agent can travel at
     * @param maxSpeed The new maximum speed that the agent can travel at
     */
    public void setMaxSpeed(final double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    /**
     * Returns the maximum speed that the agent can travel at
     * @return The maximum speed that the agent can travel at
     */
    public double getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Sets the maximum force with which an agent can turn
     * @param maxForce The new maximum force with which an agent can turn
     */
    public void setMaxForce(final double maxForce) {
        this.maxForce = maxForce;
    }

    /**
     * Returns the maximum force with which an agent can turn
     * @return The maximum force with which an agent can turn
     */
    public double getMaxForce() {
        return maxForce;
    }
}