package physics;

import vectors.Vector2D;

public class Physics2D {
    private Vector2D location;
    private Vector2D velocity = new Vector2D();
    private Vector2D acceleration = new Vector2D();

    private double maxSpeed;
    private double maxForce;

    public Physics2D(final double x, final double y, final double maxSpeed, final double maxForce) {
        location = new Vector2D(x, y);
        this.maxForce = maxForce;
        this.maxSpeed = maxSpeed;
    }

    public Physics2D(final Vector2D location, final double maxSpeed, final double maxForce) {
        if (location != null) {
            this.location = new Vector2D(location);
        } else {
            this.location = new Vector2D();
        }
        this.maxForce = maxForce;
        this.maxSpeed = maxSpeed;
    }

    public Physics2D(final Physics2D physics2D, final double maxSpeed, final double maxForce) {
        if (physics2D != null) {
            location = new Vector2D(physics2D.location);
        } else {
            location = new Vector2D();
        }
        this.maxForce = maxForce;
        this.maxSpeed = maxSpeed;
    }

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

    public void seek(final double x, final double y) {
        move(new Vector2D(x, y), 1, false);
    }

    public void seek(final double x, final double y, final double weight) {
        move(new Vector2D(x, y), weight, false);
    }

    public void seek(final Vector2D moveTo) {
        move(moveTo, 1, false);
    }

    public void seek(final Vector2D moveTo, final double weight) {
        move(moveTo, weight, false);
    }

    public void seek(final Physics2D moveTo) {
        move(moveTo.location, 1, false);
    }

    public void seek(final Physics2D moveTo, final double weight) {
        move(moveTo.location, weight, false);
    }

    public void avoid(final double x, final double y) {
        move(new Vector2D(x, y), 1, true);
    }

    public void avoid(final double x, final double y, final double weight) {
        move(new Vector2D(x, y), weight, true);
    }

    public void avoid(final Vector2D moveTo) {
        move(moveTo, 1, true);
    }

    public void avoid(final Vector2D moveTo, final double weight) {
        move(moveTo, weight, true);
    }

    public void avoid(final Physics2D moveTo) {
        move(moveTo.location, 1, true);
    }

    public void avoid(final Physics2D moveTo, final double weight) {
        move(moveTo.location, weight, true);
    }

    public void move(final Physics2D moveTo, final double weight, final boolean avoid) {
        move(moveTo.location, weight, avoid);
    }

    public void move(final double x, final double y, final double weight, final boolean avoid) {
        move(new Vector2D(x, y), weight, avoid);
    }

    public void move(final Vector2D moveTo, final double weight, final boolean avoid) {
        final Vector2D move = new Vector2D(moveTo);
        //desired
        move.sub(location);
        move.limit(maxSpeed);
        //steer
        move.sub(velocity);
        move.limit(maxForce);
        move.multiply(weight);

        // reverse direction when avoiding something
        if (avoid) {
            move.multiply(-1);
        }
        //apply the force
        acceleration.add(move);
    }

    public void updatePosition() {
        velocity.add(acceleration);
        velocity.limit(maxSpeed);
        location.add(velocity);
        acceleration.setAllComponents(0);
    }

    public void setLocation(final double x, final double y) {
        location.setAllComponents(x, y);
    }

    public void setLocation(final Vector2D vector2D) {
        location = new Vector2D(vector2D);
    }

    public void setLocation(final Physics2D physics2D) {
        location = new Vector2D(physics2D.location);
    }

    public Vector2D getLocation() {
        return new Vector2D(location);
    }

    public void setX(final double x) {
        location.setX(x);
    }

    public double getX() {
        return location.getX();
    }

    public void setY(final double y) {
        location.setY(y);
    }

    public double getY() {
        return location.getY();
    }

    public double distance(final double x, final double y) {
        return location.distance(x, y);
    }

    public double distance(final Vector2D point) {
        return location.distance(point);
    }

    public double distance(final Physics2D physics2D) {
        return location.distance(physics2D.location);
    }

    public Vector2D getVelocity() {
        return new Vector2D(velocity);
    }

    public void setMaxSpeed(final double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxForce(final double maxForce) {
        this.maxForce = maxForce;
    }

    public double getMaxForce() {
        return maxForce;
    }
}
