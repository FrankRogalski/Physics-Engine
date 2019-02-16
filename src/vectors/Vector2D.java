package vectors;

import javafx.geometry.Point2D;

public class Vector2D {
    private double x;
    private double y;

    public Vector2D() {
        setAll(0);
    }

    public Vector2D(final double x, final double y) {
        setAll(x, y);
    }

    public Vector2D(final Vector2D vector2D) {
        setAll(vector2D);
    }

    public void setAll(final Vector2D vector2D) {
        setAll(vector2D.x, vector2D.y);
    }

    public void setAll(final double val) {
        setAll(val, val);
    }

    public void setAll(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public void add(final Vector2D vector2D) {
        add(vector2D.x, vector2D.y);
    }

    public void add(final double x, final double y) {
        this.x += x;
        this.y += y;
    }

    public static Vector2D add(final Vector2D vector2D1, final Vector2D vector2D2) {
        return Vector2D.add(vector2D1.x, vector2D1.y, vector2D2.x, vector2D2.y);
    }

    public static Vector2D add(final Vector2D vector2D, final double x, final double y) {
        return Vector2D.add(vector2D.x, vector2D.y, x, y);
    }

    public static Vector2D add(final double x1, final double y1, final double x2, final double y2) {
        final Vector2D vector2D = new Vector2D(x1, y1);
        vector2D.add(x2, y2);
        return vector2D;
    }

    public void sub(final Vector2D vector2D) {
        sub(vector2D.x, vector2D.y);
    }

    public void sub(final double x, final double y) {
        this.x -= x;
        this.y -= y;
    }

    public static Vector2D sub(final Vector2D vector2D1, final Vector2D vector2D2) {
        return Vector2D.sub(vector2D1.x, vector2D1.y, vector2D2.x, vector2D2.y);
    }

    public static Vector2D sub(final Vector2D vector2D, final double x, final double y) {
        return Vector2D.sub(vector2D.x, vector2D.y, x, y);
    }

    public static Vector2D sub(final double x, final double y, final Vector2D vector2D) {
        return Vector2D.sub(x, y, vector2D.x, vector2D.y);
    }

    public static Vector2D sub(final double x1, final double y1, final double x2, final double y2) {
        final Vector2D vector2D = new Vector2D(x1, y1);
        vector2D.sub(x2, y2);
        return vector2D;
    }

    public void mult(final double factor) {
        x *= factor;
        y *= factor;
    }

    public static Vector2D mult(final Vector2D vector2D, final double factor) {
        return Vector2D.mult(vector2D.x, vector2D.y, factor);
    }

    public static Vector2D mult(final double x, final double y, final double factor) {
        final Vector2D vector2D = new Vector2D(x, y);
        vector2D.mult(factor);
        return vector2D;
    }

    public void div(final double divisor) {
        if (divisor != 0) {
            x /= divisor;
            y /= divisor;
        }
    }

    public static Vector2D div(final Vector2D vector2D, final double divisor) {
        return Vector2D.div(vector2D.x, vector2D.y, divisor);
    }

    public static Vector2D div(final double x, final double y, final double divisor) {
        final Vector2D vector2D = new Vector2D(x, y);
        vector2D.div(divisor);
        return vector2D;
    }

    public double distance(final Vector2D vector2D) {
        return distance(vector2D.x, vector2D.y);
    }

    public double distance(final double x, final double y) {
        return Vector2D.distance(this.x, this.y, x, y);
    }

    public static double distance(final Vector2D vector2D1, final Vector2D vector2D2) {
        return vector2D1.distance(vector2D2);
    }

    public static double distance(final Vector2D vector2D, final double x, final double y) {
        return vector2D.distance(x, y);
    }

    public static double distance(final double x1, final double y1, final double x2, final double y2) {
        final double a = x1 - x2;
        final double b = y1 - y2;
        return Math.sqrt(a * a + b * b);
    }

    public void normalize() {
        final double mag = getMag();
        if (mag == 0) {
            return;
        }
        x /= mag;
        y /= mag;
    }

    public static Vector2D normalize(final Vector2D vector2D) {
        final Vector2D vector2D1 = new Vector2D(vector2D);
        vector2D1.normalize();
        return vector2D1;
    }

    public double getMag() {
        return Vector2D.getMag(x, y);
    }

    public static double getMag(final Vector2D vector2D) {
        return vector2D.getMag();
    }

    public static double getMag(final double x, final double y) {
        return Math.sqrt(x * x + y * y);
    }

    public void setMag(final double mag) {
        normalize();
        mult(mag);
    }

    public static Vector2D setMag(final Vector2D vector2D, final double mag) {
        return Vector2D.setMag(vector2D.x, vector2D.y, mag);
    }

    public static Vector2D setMag(final double x, final double y, final double mag) {
        final Vector2D vector2D = new Vector2D(x, y);
        vector2D.setMag(mag);
        return vector2D;
    }

    public Vector2D midpoint(final Vector2D vector2D) {
        return midpoint(vector2D.x, vector2D.y);
    }

    public Vector2D midpoint(final double x, final double y) {
        return Vector2D.midpoint(this.x, this.y, x, y);
    }

    public static Vector2D midpoint(final Vector2D vector2D1, final Vector2D vector2D2) {
        return vector2D1.midpoint(vector2D2);
    }

    public static Vector2D midpoint(final Vector2D vector2D, final double x, final double y) {
        return vector2D.midpoint(x, y);
    }

    public static Vector2D midpoint(final double x1, final double y1, final double x2, final double y2) {
        return new Vector2D(x2 + (x1 + x2) / 2, y2 + (y1 + y2) / 2);
    }

    public double dotProduct(final Vector2D vector2D) {
        return dotProduct(vector2D.x, vector2D.y);
    }

    public double dotProduct(final double x, final double y) {
        return Vector2D.dotProduct(this.x, this.y, x, y);
    }

    public static double dotProduct(final Vector2D vector2D1, final Vector2D vector2D2) {
        return vector2D1.dotProduct(vector2D2);
    }

    public static double dotProduct(final Vector2D vector2D, final double x, final double y) {
        return vector2D.dotProduct(x, y);
    }

    public static double dotProduct(final double x1, final double y1, final double x2, final double y2) {
        return x1 * x2 + y1 * y2;
    }

    public Vector3D crossProduct(final Vector2D vector2D) {
        return crossProduct(vector2D.x, vector2D.y);
    }

    public Vector3D crossProduct(final double x, final double y) {
        return Vector2D.crossProduct(this.x, this.y, x, y);
    }

    public static Vector3D crossProduct(final Vector2D vector2D1, final Vector2D vector2D2) {
        return vector2D1.crossProduct(vector2D2);
    }

    public static Vector3D crossProduct(final Vector2D vector2D, final double x, final double y) {
        return vector2D.crossProduct(x, y);
    }

    public static Vector3D crossProduct(final double x, final double y, final Vector2D vector2D) {
        return Vector2D.crossProduct(x, y, vector2D.x, vector2D.y);
    }

    public static Vector3D crossProduct(final double x1, final double y1, final double x2, final double y2) {
        return new Vector3D(0, 0, x1 * y2 - y1 * x2);
    }

    public double getAbsoluteAngle() {
        return getAbsoluteAngle(1, 0);
    }

    public double getAbsoluteAngle(final Vector2D vector2D) {
        return getAbsoluteAngle(vector2D.x, vector2D.y);
    }

    public double getAbsoluteAngle(final double x, final double y) {
        return Vector2D.getAbsoluteAngle(this.x, this.y, x, y);
    }

    public static double getAbsoluteAngle(final double x1, final double y1, final double x2, final double y2) {
        final double delta = (x1 * x2 + y1 * y2) / Math.sqrt((x1 * x1 + y1 * y1) * (x2 * x2 + y2 * y2));
        if (delta > 1) {
            return 0;
        }
        if (delta < -1) {
            return 180;
        }
        return Math.acos(delta);
    }

    public void rotate(final Vector2D vector2D, double radians) {
        rotate(vector2D.x, vector2D.y, radians);
    }

    public void rotate(final double x, final double y, double radians) {
        final double s = Math.sin(radians);
        final double c = Math.cos(radians);
        sub(x, y);
        setAll(this.x * c - this.y * s,
                this.x * s + this.y * c);
        add(x, y);
    }

    public static Vector2D rotate(final Vector2D vector2D1, final Vector2D vector2D2, double radians) {
        return Vector2D.rotate(vector2D1.x, vector2D1.y, vector2D2.x, vector2D2.y, radians);
    }

    public static Vector2D rotate(final Vector2D vector2D, final double x, final double y, double radians) {
        return Vector2D.rotate(vector2D.x, vector2D.y, x, y, radians);
    }

    public static Vector2D rotate(final double x, final double y, final Vector2D vector2D, double radians) {
        return Vector2D.rotate(x, y, vector2D.x, vector2D.y, radians);
    }

    public static Vector2D rotate(final double x1, final double y1, final double x2, final double y2, double radians) {
        final Vector2D vector2D = new Vector2D(x1, y1);
        vector2D.rotate(x2, y2, radians);
        return vector2D;
    }

    public Point2D toPoint2D() {
        return new Point2D(x, y);
    }

    public static Point2D toPoint2D(final Vector2D vector2D) {
        return new Point2D(vector2D.x, vector2D.y);
    }

    public static Point2D toPoint2D(final double x, final double y) {
        return new Point2D(x, y);
    }

    public double getX() {
        return x;
    }

    public void setX(final double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

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
