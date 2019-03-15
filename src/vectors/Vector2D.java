package vectors;

import javafx.geometry.Point2D;

import java.util.Random;

/**
 * A class that represents a vector on a 2D plain
 */
@SuppressWarnings("WeakerAccess")
public class Vector2D {
    private double x;
    private double y;
    private static Random random = new Random();
    private static final double HALF_PI = Math.PI / 2;

    /**
     * The standard constructor that initializes all components with 0
     */
    public Vector2D() {
        setAllComponents(0);
    }

    /**
     * A constructor where you can set the x and y value of your vector
     *
     * @param x The x component of your Vector
     * @param y The y component of your Vector
     */
    public Vector2D(final double x, final double y) {
        setAllComponents(x, y);
    }

    /**
     * A constructor that creates a copy of an already existing vector
     *
     * @param vector2D The vector that you want to copy
     */
    @SuppressWarnings("CopyConstructorMissesField")
    public Vector2D(final Vector2D vector2D) {
        setAllComponents(vector2D);
    }

    /**
     * Changes all components of the vector to be equal to another vector
     *
     * @param vector2D The vector which components will be replicated
     */
    public void setAllComponents(final Vector2D vector2D) {
        setAllComponents(vector2D.x, vector2D.y);
    }

    /**
     * Sets all components of the vector to one value
     *
     * @param val The value that all components will have
     */
    public void setAllComponents(final double val) {
        setAllComponents(val, val);
    }

    /**
     * Sets the individual components of the vector as you desire
     *
     * @param x The value your x components will change to
     * @param y The value your y components will change to
     */
    public void setAllComponents(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Creates a unit vector from the given angle
     *
     * @param angle The angle in radians that the vector will be at
     * @return The created vector
     */
    public static Vector2D createFromAngle(final double angle) {
        return createFromAngle(angle, 1);
    }

    /**
     * Creates a vector from the given angle with the given magnitude
     *
     * @param angle The angle in radians that the vector will be at
     * @param mag   The Magnitude of the vector that will be created
     * @return The created vector
     */
    public static Vector2D createFromAngle(final double angle, final double mag) {
        return new Vector2D(mag * Math.cos(angle), mag * Math.sin(angle));
    }

    /**
     * Creates a unit vector with a random angle
     *
     * @return The created vector
     */
    public static Vector2D createRandomVector2D() {
        return Vector2D.createFromAngle(random.nextDouble() * Math.PI * 2);
    }

    /**
     * Adds the given Vector to this one
     *
     * @param vector2D the Vector that will be added
     */
    public void add(final Vector2D vector2D) {
        add(vector2D.x, vector2D.y);
    }

    /**
     * Adds the given Values to the given components
     *
     * @param x The value that will be added to the x component
     * @param y The value that will be added to the y component
     */
    public void add(final double x, final double y) {
        this.x += x;
        this.y += y;
    }

    /**
     * Adds the second vector to the first and returns the result as a new vector
     * without changing either of the given vectors
     *
     * @param vector2D1 The fist vector that will be added
     * @param vector2D2 The second vector that will be added
     * @return The resulting vector from the addition
     */
    public static Vector2D add(final Vector2D vector2D1, final Vector2D vector2D2) {
        return Vector2D.add(vector2D1.x, vector2D1.y, vector2D2.x, vector2D2.y);
    }

    /**
     * Adds the x and y components to the vector and returns the result as a new vector
     * without changing the given vector
     *
     * @param vector2D The vector that will be added
     * @param x        The x component that will be added to the vector
     * @param y        The y component that will be added to the vector
     * @return The resulting vector from the addition
     */
    public static Vector2D add(final Vector2D vector2D, final double x, final double y) {
        return Vector2D.add(vector2D.x, vector2D.y, x, y);
    }

    /**
     * Adds the x and y components and creates a vector from the result
     *
     * @param x1 The first x component that will be added
     * @param y1 The first y component that will be added
     * @param x2 The second x component that will be added
     * @param y2 The second y component that will be added
     * @return The resulting vector from the addition
     */
    public static Vector2D add(final double x1, final double y1, final double x2, final double y2) {
        final Vector2D vector2D = new Vector2D(x1, y1);
        vector2D.add(x2, y2);
        return vector2D;
    }

    /**
     * Subtracts the given Vector from this one
     *
     * @param vector2D the Vector that will be subtracted
     */
    public void sub(final Vector2D vector2D) {
        sub(vector2D.x, vector2D.y);
    }

    /**
     * Subtracts the given Values from the given components
     *
     * @param x The value that will be subtracted from the x component
     * @param y The value that will be subtracted from the y component
     */
    public void sub(final double x, final double y) {
        this.x -= x;
        this.y -= y;
    }

    /**
     * Subtracts the second vector from the first and returns the result as a new vector
     * without changing either of the given vectors
     *
     * @param vector2D1 The fist vector that will be subtracted
     * @param vector2D2 The second vector that will be subtracted
     * @return The resulting vector from the subtraction
     */
    public static Vector2D sub(final Vector2D vector2D1, final Vector2D vector2D2) {
        return Vector2D.sub(vector2D1.x, vector2D1.y, vector2D2.x, vector2D2.y);
    }

    /**
     * Subtracts the x and y components from the vector and returns the result as a new vector
     * without changing the given vector
     *
     * @param vector2D The vector that will be subtracted
     * @param x        The x component that will be subtracted from the vector
     * @param y        The y component that will be subtracted from the vector
     * @return The resulting vector from the subtraction
     */
    public static Vector2D sub(final Vector2D vector2D, final double x, final double y) {
        return Vector2D.sub(vector2D.x, vector2D.y, x, y);
    }

    /**
     * Subtracts the x and y components from the vector and returns the result as a new vector
     * without changing the given vector
     *
     * @param x        The x component that will be subtracted from the vector
     * @param y        The y component that will be subtracted from the vector
     * @param vector2D The vector that will be subtracted
     * @return The resulting vector from the subtraction
     */
    public static Vector2D sub(final double x, final double y, final Vector2D vector2D) {
        return Vector2D.sub(x, y, vector2D.x, vector2D.y);
    }

    /**
     * Subtracts the x and y components and creates a vector from the result
     *
     * @param x1 The first x component that will be subtracted
     * @param y1 The first y component that will be subtracted
     * @param x2 The second x component that will be subtracted
     * @param y2 The second y component that will be subtracted
     * @return The resulting vector from the subtraction
     */
    public static Vector2D sub(final double x1, final double y1, final double x2, final double y2) {
        final Vector2D vector2D = new Vector2D(x1, y1);
        vector2D.sub(x2, y2);
        return vector2D;
    }

    /**
     * Multiplies the given factor with this vector
     *
     * @param factor The factor by which the vector will be multiplied
     */
    public void multiply(final double factor) {
        x *= factor;
        y *= factor;
    }

    /**
     * Multiplies the given factor with the given vector without changing it
     *
     * @param vector2D The vector that will be multiplied
     * @param factor   The factor by which the vector will be multiplied
     * @return The resulting vector from the multiplication
     */
    public static Vector2D multiply(final Vector2D vector2D, final double factor) {
        return Vector2D.multiply(vector2D.x, vector2D.y, factor);
    }

    /**
     * Multiplies the given factor with the given x and y components
     *
     * @param x      The x component that will be multiplied
     * @param y      The y component that will be multiplied
     * @param factor The factor by which the vector will be multiplied
     * @return The resulting vector from the multiplication
     */
    public static Vector2D multiply(final double x, final double y, final double factor) {
        final Vector2D vector2D = new Vector2D(x, y);
        vector2D.multiply(factor);
        return vector2D;
    }

    /**
     * Divides this vector by the given divisor
     *
     * @param divisor The divisor by which the vector will be divided
     */
    public void div(final double divisor) {
        if (divisor != 0) {
            x /= divisor;
            y /= divisor;
        }
    }

    /**
     * Divides the given vector by the given divisor without changing the vector
     *
     * @param vector2D The vector which will be divided
     * @param divisor  The divisor by which the vector will be divided
     * @return The resulting vector from the division
     */
    public static Vector2D div(final Vector2D vector2D, final double divisor) {
        return Vector2D.div(vector2D.x, vector2D.y, divisor);
    }

    /**
     * Divides the given x and y components by the given divisor
     *
     * @param x       The x component that will be divided
     * @param y       The y component that will be divided
     * @param divisor The divisor by which the x and y components will be divided
     * @return The resulting vector from the division
     */
    public static Vector2D div(final double x, final double y, final double divisor) {
        final Vector2D vector2D = new Vector2D(x, y);
        vector2D.div(divisor);
        return vector2D;
    }

    /**
     * Calculates the distance between this vector to the given vector
     *
     * @param vector2D the vector to which the distance will be calculated
     * @return The distance between the vectors
     */
    public double distance(final Vector2D vector2D) {
        return distance(vector2D.x, vector2D.y);
    }

    /**
     * Calculates the distance between this vector to the given x and y values
     *
     * @param x The x value to which the distance will be calculated
     * @param y The y value to which the distance will be calculated
     * @return The distance between this vector and the x and y values
     */
    public double distance(final double x, final double y) {
        return Vector2D.distance(this.x, this.y, x, y);
    }

    /**
     * Calculates the distance between the given vectors
     *
     * @param vector2D1 The vector from which the distance will be calculated
     * @param vector2D2 The vector to which the distance is calculated
     * @return The distance between the vectors
     */
    public static double distance(final Vector2D vector2D1, final Vector2D vector2D2) {
        return vector2D1.distance(vector2D2);
    }

    /**
     * Calculates the distance between the given vector to the given x and y values
     *
     * @param vector2D The vector from which the distance will be calculated
     * @param x        The x value to which the distance will be calculated
     * @param y        The y value to which the distance will be calculated
     * @return The distance between the vector and the x and y values
     */
    public static double distance(final Vector2D vector2D, final double x, final double y) {
        return vector2D.distance(x, y);
    }

    /**
     * Calculates the distance between the given x and y values
     *
     * @param x1 The x value from which the distance will be calculated
     * @param y1 The y value from which the distance will be calculated
     * @param x2 The x value to which the distance will be calculated
     * @param y2 The y value to which the distance will be calculated
     * @return The distance between the x and y values
     */
    public static double distance(final double x1, final double y1, final double x2, final double y2) {
        final double a = x1 - x2;
        final double b = y1 - y2;
        return Math.sqrt(a * a + b * b);
    }

    /**
     * Sets the magnitude of this vector to one
     */
    public void normalize() {
        final double mag = getMag();
        if (mag == 0) {
            return;
        }
        x /= mag;
        y /= mag;
    }

    /**
     * Creates a new vector based on the given one with magnitude one
     *
     * @param vector2D The vector which will be copied
     * @return The resulting new vector with a magnitude of one
     */
    public static Vector2D normalize(final Vector2D vector2D) {
        return Vector2D.normalize(vector2D.x, vector2D.y);
    }

    /**
     * Creates a new vector based on the given x and y components with magnitude one
     *
     * @param x The x component of the vector
     * @param y The y component of the vector
     * @return The resulting new vector with a magnitude of one
     */
    public static Vector2D normalize(final double x, final double y) {
        final Vector2D vector2D1 = new Vector2D(x, y);
        vector2D1.normalize();
        return vector2D1;
    }

    /**
     * Returns The magnitude of this vector
     *
     * @return The magnitude of this vector
     */
    public double getMag() {
        return Vector2D.getMag(x, y);
    }

    /**
     * Returns the magnitude of the given vector
     *
     * @param vector2D The vector which magnitude you want to find out
     * @return The magnitude of the given vector
     */
    public static double getMag(final Vector2D vector2D) {
        return vector2D.getMag();
    }

    /**
     * Returns the magnitude that a vector with these components would have
     *
     * @param x The x component of the vector
     * @param y The y component of the vector
     * @return The magnitude that the vector would have
     */
    public static double getMag(final double x, final double y) {
        return Math.sqrt(x * x + y * y);
    }

    /**
     * Returns the Squared magnitude of this vector, which is computationally faster than the real magnitude
     *
     * @return The Squared magnitude of this vector
     */
    public double getMagSquared() {
        return Vector2D.getMagSquared(x, y);
    }

    /**
     * Returns the Squared magnitude of the given vector, which is computationally faster than the real magnitude
     *
     * @param vector2D The vector which squared magnitude is calculated
     * @return The Squared magnitude of the vector
     */
    public static double getMagSquared(final Vector2D vector2D) {
        return vector2D.getMagSquared();
    }

    /**
     * Returns the Squared magnitude of the given x and y components, which is computationally faster than the real magnitude
     *
     * @param x The x component of the vector
     * @param y The y component of the vector
     * @return The Squared magnitude of the vector
     */
    public static double getMagSquared(final double x, final double y) {
        return x * x + y * y;
    }

    /**
     * Returns the rotation of this vector
     *
     * @return The rotation of this vector
     */
    public double getDirection() {
        return Vector2D.getDirection(x, y);
    }

    /**
     * Returns the rotation of the given vector
     *
     * @return The rotation of the given vector
     */
    public static double getDirection(final Vector2D vector2D) {
        return vector2D.getDirection();
    }

    /**
     * Returns the rotation of the vector represented by the given x and y component
     *
     * @param x The x component of the vector
     * @param y The y component of the vector
     * @return The rotation of the vector represented by the given x and y component
     */
    public static double getDirection(final double x, final double y) {
        return Math.atan2(x, y) - HALF_PI;
    }

    /**
     * Sets the magnitude of this vector to the maximum,
     * if it happens to be longer
     *
     * @param max The maximum magnitude of the vector
     */
    public void limit(final double max) {
        if (getMagSquared() > max * max) {
            setMag(max);
        }
    }

    /**
     * Sets the magnitude of the given vector without changing it to the maximum and returns it as a new vector,
     * if it happens to be longer
     *
     * @param vector2D The vector which magnitude might be to long
     * @param max      The maximum magnitude of the vector
     * @return The vector with the maximum magnitude that you specified
     */
    public static Vector2D limit(final Vector2D vector2D, final double max) {
        return limit(vector2D.x, vector2D.y, max);
    }

    /**
     * Sets the magnitude of the given x and y component, which represent a vector,
     * to the maximum and returns it as a new vector, if it happens to be longer
     *
     * @param x   The x component of the vector
     * @param y   The y component of the vector
     * @param max The maximum magnitude of the vector
     * @return The vector with the maximum magnitude that you specified
     */
    public static Vector2D limit(final double x, final double y, final double max) {
        final Vector2D vector2D = new Vector2D(x, y);
        vector2D.limit(max);
        return vector2D;
    }

    /**
     * Linearly interpolates this vector to the given vector
     *
     * @param vector2D   The vector to which will be lerped
     * @param percentage The amount of interpolation from 0 to 1
     * @return The resulting vector
     */
    public Vector2D lerp(final Vector2D vector2D, final double percentage) {
        return lerp(vector2D.x, vector2D.y, percentage);
    }

    /**
     * Linearly interpolates this vector to the given x and y component representing a vector
     *
     * @param x          The x component of the vector to which will be lerped
     * @param y          The y component of the vector to which will be lerped
     * @param percentage The amount of interpolation from 0 to 1
     * @return The resulting vector
     */
    public Vector2D lerp(final double x, final double y, final double percentage) {
        return Vector2D.lerp(this.x, this.y, x, y, percentage);
    }

    /**
     * Linearly interpolates between the given vectors
     *
     * @param vector2D1  The vector from which will be lerped
     * @param vector2D2  The vector to which will be lerped
     * @param percentage The amount of interpolation from 0 to 1
     * @return The resulting vector
     */
    public static Vector2D lerp(final Vector2D vector2D1, final Vector2D vector2D2, final double percentage) {
        return vector2D1.lerp(vector2D2, percentage);
    }

    /**
     * Linearly interpolates the given vector to the given x and y component representing a vector
     *
     * @param x          The x component of the vector from which will be lerped
     * @param y          The y component of the vector from which will be lerped
     * @param vector2D   The vector to which will be lerped
     * @param percentage The amount of interpolation from 0 to 1
     * @return The resulting vector
     */
    public static Vector2D lerp(final double x, final double y, final Vector2D vector2D, final double percentage) {
        return Vector2D.lerp(x, y, vector2D.x, vector2D.y, percentage);
    }

    /**
     * Linearly interpolates from the given vector to the given x and y component representing a vector
     *
     * @param vector2D   The vector from which will be lerped
     * @param x          The x component of the vector to which will be lerped
     * @param y          The y component of the vector to which will be lerped
     * @param percentage The amount of interpolation from 0 to 1
     * @return The resulting vector
     */
    public static Vector2D lerp(final Vector2D vector2D, final double x, final double y, final double percentage) {
        return vector2D.lerp(x, y, percentage);
    }

    /**
     * Linearly interpolates the given x and y components
     *
     * @param x1         The x component of the vector from which will be lerped
     * @param y1         The y component of the vector from which will be lerped
     * @param x2         The x component of the vector to which will be lerped
     * @param y2         The y component of the vector to which will be lerped
     * @param percentage The amount of interpolation from 0 to 1
     * @return The resulting vector
     */
    public static Vector2D lerp(final double x1, final double y1, final double x2, final double y2, final double percentage) {
        return new Vector2D(x1 + (x2 - x1) * percentage, y1 + (y2 - y1) * percentage);
    }

    /**
     * Sets the magnitude of this vector
     *
     * @param mag The magnitude the vector will be changed to
     */
    public void setMag(final double mag) {
        normalize();
        multiply(mag);
    }

    /**
     * Returns a new vector with the angle of the given one and the given magnitude
     *
     * @param vector2D The vector which angle will be copied
     * @param mag      The magnitude which the new vector will have
     * @return A new vector with the angle of the given one and the given magnitude
     */
    public static Vector2D setMag(final Vector2D vector2D, final double mag) {
        return Vector2D.setMag(vector2D.x, vector2D.y, mag);
    }

    /**
     * Returns a new vector with the angle that the x and y components would form and the given magnitude
     *
     * @param x   The x component of the vector which angle will be copied
     * @param y   The y component of the vector which angle will be copied
     * @param mag The magnitude which the new vector will have
     * @return A new vector with the angle that the x and y components would form and the given magnitude
     */
    public static Vector2D setMag(final double x, final double y, final double mag) {
        final Vector2D vector2D = new Vector2D(x, y);
        vector2D.setMag(mag);
        return vector2D;
    }

    /**
     * Returns the vector in the middle of this one and the given one
     *
     * @param vector2D One of the vectors between which the midpoint is located
     * @return The midpoint between the two vectors
     */
    public Vector2D midpoint(final Vector2D vector2D) {
        return midpoint(vector2D.x, vector2D.y);
    }

    /**
     * Returns the vector in the middle of this one and the given x and y coordinates
     *
     * @param x The x component of the vector
     * @param y The y component of the Vector
     * @return The midpoint between the two vectors
     */
    public Vector2D midpoint(final double x, final double y) {
        return Vector2D.midpoint(this.x, this.y, x, y);
    }

    /**
     * Returns the midpoint of the two given vectors
     *
     * @param vector2D1 One of the vectors between which the midpoint is located
     * @param vector2D2 One of the vectors between which the midpoint is located
     * @return The midpoint of the two given vectors
     */
    public static Vector2D midpoint(final Vector2D vector2D1, final Vector2D vector2D2) {
        return vector2D1.midpoint(vector2D2);
    }

    /**
     * Returns the midpoint between the given vector and the x and y components which represent a vector
     *
     * @param vector2D One of the vectors between which the midpoint is located
     * @param x        The x component of the other vector
     * @param y        The x component of the other vector
     * @return The midpoint between the given vector and the x and y components which represent a vector
     */
    public static Vector2D midpoint(final Vector2D vector2D, final double x, final double y) {
        return vector2D.midpoint(x, y);
    }

    /**
     * Returns the midpoint between the x and y components which are representing vectors
     *
     * @param x1 The x component representing the first vector
     * @param y1 The y component representing the first vector
     * @param x2 The x component representing the second vector
     * @param y2 The y component representing the second vector
     * @return The midpoint between the x and y components which are representing vectors
     */
    public static Vector2D midpoint(final double x1, final double y1, final double x2, final double y2) {
        return new Vector2D((x1 + x2) / 2, (y1 + y2) / 2);
    }

    /**
     * Calculates the dot product of this vector and another one
     *
     * @param vector2D The vector with which the dot product is calculated
     * @return The dot Product of the two vectors
     */
    public double dotProduct(final Vector2D vector2D) {
        return dotProduct(vector2D.x, vector2D.y);
    }

    /**
     * Calculates the dot product of this vector and the given x and y component representing a second vector
     *
     * @param x The x component of the second vector
     * @param y The y component of the second vector
     * @return The dot Product of the two vectors
     */
    public double dotProduct(final double x, final double y) {
        return Vector2D.dotProduct(this.x, this.y, x, y);
    }

    /**
     * Calculates the dot product of the given vectors
     *
     * @param vector2D1 The first vector
     * @param vector2D2 The second vector
     * @return The dot Product of the two vectors
     */
    public static double dotProduct(final Vector2D vector2D1, final Vector2D vector2D2) {
        return vector2D1.dotProduct(vector2D2);
    }

    /**
     * Calculates the dot product of the given vector and the given x and y component representing a second vector
     *
     * @param vector2D The first vector
     * @param x        The x component of the second vector
     * @param y        The y component of the second vector
     * @return The dot Product of the two vectors
     */
    public static double dotProduct(final Vector2D vector2D, final double x, final double y) {
        return vector2D.dotProduct(x, y);
    }

    /**
     * Calculates the dot product of the given x and y components
     *
     * @param x1 The x component of the first vector
     * @param y1 The y component of the first vector
     * @param x2 The x component of the second vector
     * @param y2 The y component of the second vector
     * @return The dot Product of the two vectors
     */
    public static double dotProduct(final double x1, final double y1, final double x2, final double y2) {
        return x1 * x2 + y1 * y2;
    }

    /**
     * Returns the absolute angle between this vector and the given one
     *
     * @param vector2D The vector to which the angle is calculated
     * @return The resulting angle in radians
     */
    public double getAbsoluteAngle(final Vector2D vector2D) {
        return getAbsoluteAngle(vector2D.x, vector2D.y);
    }

    /**
     * Returns the absolute angle between this vector and the given x and y component representing a vector
     *
     * @param x The x component of the vector
     * @param y The y component of the vector
     * @return The resulting angle in radians
     */
    public double getAbsoluteAngle(final double x, final double y) {
        return Vector2D.getAbsoluteAngle(this.x, this.y, x, y);
    }

    /**
     * Returns the absolute angle between the given vectors
     *
     * @param vector2D1 The vector from which the angle is calculated
     * @param vector2D2 The vector to which the angle is calculated
     * @return The resulting angle in radians
     */
    public static double getAbsoluteAngle(final Vector2D vector2D1, final Vector2D vector2D2) {
        return vector2D1.getAbsoluteAngle(vector2D2);
    }

    /**
     * Returns the absolute angle between the given vector and the given x and y component representing a vector
     *
     * @param vector2D The vector from which the angle is calculated
     * @param x        The x component of the second vector
     * @param y        The y component of the second vector
     * @return The resulting angle in radians
     */
    public static double getAbsoluteAngle(final Vector2D vector2D, final double x, final double y) {
        return vector2D.getAbsoluteAngle(x, y);
    }

    /**
     * Returns the absolute angle between the given x and y components
     *
     * @param x1 The x component of the first vector
     * @param y1 The y component of the first vector
     * @param x2 The x component of the second vector
     * @param y2 The y component of the second vector
     * @return The resulting angle in radians
     */
    public static double getAbsoluteAngle(final double x1, final double y1, final double x2, final double y2) {
        final double delta = (x1 * x2 + y1 * y2) / Math.sqrt((x1 * x1 + y1 * y1) * (x2 * x2 + y2 * y2));
        if (delta > 1) {
            return 0;
        }
        if (delta < -1) {
            return Math.PI;
        }
        return Math.acos(delta);
    }

    /**
     * Rotates this vector by the given angle
     *
     * @param radians The radians the vector will be turned
     */
    public void rotate(final double radians) {
        final double newAngle = getDirection() + radians;
        final double mag = getMag();
        x = Math.cos(newAngle) * mag;
        y = Math.sin(newAngle) * mag;
    }

    /**
     * Rotates the given vector by the given angle
     *
     * @param vector2D The vector which will be turned
     * @param radians  The radians the vector will be turned
     * @return The resulting vector
     */
    public static Vector2D rotate(final Vector2D vector2D, final double radians) {
        return Vector2D.rotate(vector2D.x, vector2D.y, radians);
    }

    /**
     * Rotates the given x and y components representing a vector by the given angle
     *
     * @param x       The x component of the vector
     * @param y       The y component of the vector
     * @param radians The radians the vector will be turned
     * @return The resulting vector
     */
    public static Vector2D rotate(final double x, final double y, final double radians) {
        final Vector2D vector2D = new Vector2D(x, y);
        vector2D.rotate(radians);
        return vector2D;
    }

    /**
     * Converts this vector to a JavaFx Point2D
     *
     * @return The new Point2D
     */
    public Point2D toPoint2D() {
        return Vector2D.toPoint2D(x, y);
    }

    /**
     * Converts the given vector to a JavaFx Point2D
     *
     * @param vector2D The vector that will be converted to a Point2D
     * @return The new Point2D
     */
    public static Point2D toPoint2D(final Vector2D vector2D) {
        return vector2D.toPoint2D();
    }

    /**
     * Converts the x and y components to a JavaFx Point2D
     *
     * @param x The x component of the point
     * @param y The y component of the point
     * @return The new Point2D
     */
    public static Point2D toPoint2D(final double x, final double y) {
        return new Point2D(x, y);
    }

    /**
     * Returns the x component of the Vector
     *
     * @return The x component of the Vector
     */
    public double getX() {
        return x;
    }

    /**
     * Sets the x component of the Vector
     *
     * @param x The x component the vector will be set to
     */
    public void setX(final double x) {
        this.x = x;
    }

    /**
     * Returns the y component of the Vector
     *
     * @return The y component of the Vector
     */
    public double getY() {
        return y;
    }

    /**
     * Sets the y component of the Vector
     *
     * @param y The y component the vector will be set to
     */
    public void setY(final double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Vector2D) {
            final Vector2D vector2D = (Vector2D) obj;
            return x == vector2D.x && y == vector2D.y;
        } else if (obj instanceof Point2D) {
            final Point2D point2D = (Point2D) obj;
            return x == point2D.getX() && y == point2D.getY();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        long bits = 7L;
        bits = 31L * bits + Double.doubleToLongBits(x);
        bits = 31L * bits + Double.doubleToLongBits(y);
        return (int) (bits ^ (bits >> 32));
    }

    @Override
    public String toString() {
        return "Vector2D [x = " + x + ", y = " + y + "]";
    }
}
