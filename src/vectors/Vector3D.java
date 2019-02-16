package vectors;

import javafx.geometry.Point3D;

public class Vector3D {
    private double x;
    private double y;
    private double z;

    public Vector3D(final double x, final double y, final double z) {
        setAll(x, y, z);
    }

    public Vector3D() {
        setAll(0);
    }

    public Vector3D(final Vector3D vector3D) {
        setAll(vector3D);
    }

    public void setAll(final Vector3D vector3D) {
        setAll(vector3D.x, vector3D.y, vector3D.z);
    }

    public void setAll(final double val) {
        setAll(val, val, val);
    }

    public void setAll(final double x, final double y, final double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void add(final Vector3D vector3D) {
        add(vector3D.x, vector3D.y, vector3D.z);
    }

    public void add(final double x, final double y, final double z) {
        this.x += x;
        this.y += y;
        this.z += z;
    }

    public static Vector3D add(final Vector3D vector3D1, final Vector3D vector3D2) {
        return Vector3D.add(vector3D1.x, vector3D1.y, vector3D1.z, vector3D2.x, vector3D2.y, vector3D2.z);
    }

    public static Vector3D add(final Vector3D vector3D, final double x, final double y, final double z) {
        return Vector3D.add(vector3D.x, vector3D.y, vector3D.z, x, y, z);
    }

    public static Vector3D add(final double x1, final double y1, final double z1, final double x2, final double y2, final double z2) {
        return new Vector3D(x1 + x2, y1 + y2, z1 + z2);
    }

    public void sub(final Vector3D vector3D) {
        sub(vector3D.x, vector3D.y, vector3D.z);
    }

    public void sub(final double x, final double y, final double z) {
        this.x -= x;
        this.y -= y;
        this.z -= z;
    }

    public static Vector3D sub(final Vector3D vector3D1, final Vector3D vector3D2) {
        return Vector3D.sub(vector3D1.x, vector3D1.y, vector3D1.z, vector3D2.x, vector3D2.y, vector3D2.z);
    }

    public static Vector3D sub(final Vector3D vector3D, final double x, final double y, final double z) {
        return Vector3D.sub(vector3D.x, vector3D.y, vector3D.z, x, y, z);
    }

    public static Vector3D sub(final double x, final double y, final double z, final Vector3D vector3D) {
        return Vector3D.sub(x, y, z, vector3D.x, vector3D.y, vector3D.z);
    }

    public static Vector3D sub(final double x1, final double y1, final double z1, final double x2, final double y2, final double z2) {
        final Vector3D vector3D = new Vector3D(x1, y1, z1);
        vector3D.sub(x2, y2, z2);
        return vector3D;
    }

    public void mult(final double factor) {
        x *= factor;
        y *= factor;
        z *= factor;
    }

    public static Vector3D mult(final Vector3D vector3D, final double factor) {
        return Vector3D.mult(vector3D.x, vector3D.y, vector3D.z, factor);
    }

    public static Vector3D mult(final double x, final double y, final double z, final double factor) {
        final Vector3D vector3D = new Vector3D(x, y, z);
        vector3D.mult(factor);
        return vector3D;
    }

    public void div(final double divisor) {
        if (divisor != 0) {
            x /= divisor;
            y /= divisor;
            z /= divisor;
        }
    }

    public static Vector3D div(final Vector3D vector3D, final double divisor) {
        return Vector3D.div(vector3D.x, vector3D.y, vector3D.z, divisor);
    }

    public static Vector3D div(final double x, final double y, final double z, final double divisor) {
        final Vector3D vector3D = new Vector3D(x, y, z);
        vector3D.div(divisor);
        return vector3D;
    }

    public double distance(final Vector3D vector3D) {
        return distance(vector3D.x, vector3D.y, vector3D.z);
    }

    public double distance(final double x, final double y, final double z) {
        return Vector3D.distance(this.x, this.y, this.z, x, y, z);
    }

    public static double distance(final Vector3D vector3D1, final Vector3D vector3D2) {
        return vector3D1.distance(vector3D2);
    }

    public static double distance(final Vector3D vector3D, final double x, final double y, final double z) {
        return vector3D.distance(x, y, z);
    }

    public static double distance(final double x1, final double y1, final double z1, final double x2, final double y2, final double z2) {
        final double a = x1 - x2;
        final double b = y1 - y2;
        final double c = z1 - z2;
        return Math.sqrt(a * a + b * b + c * c);
    }

    public void normalize() {
        final double mag = getMag();
        if (mag == 0) {
            return;
        }
        x /= mag;
        y /= mag;
        z /= mag;
    }

    public static Vector3D normalize(final Vector3D vector3D) {
        final Vector3D vector3D1 = new Vector3D(vector3D);
        vector3D1.normalize();
        return vector3D1;
    }

    public double getMag() {
        return getMag(x, y, z);
    }

    public static double getMag(final Vector3D vector3D) {
        return vector3D.getMag();
    }

    public static double getMag(final double x, final double y, final double z) {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public void setMag(final double mag) {
        normalize();
        mult(mag);
    }

    public static Vector3D setMag(final Vector3D vector3D, final double mag) {
        return Vector3D.setMag(vector3D.x, vector3D.y, vector3D.z, mag);
    }

    public static Vector3D setMag(final double x, final double y, final double z, final double mag) {
        final Vector3D vector3D = new Vector3D(x, y, z);
        vector3D.setMag(mag);
        return vector3D;
    }

    public Vector3D midpoint(final Vector3D vector3D) {
        return midpoint(vector3D.x, vector3D.y, vector3D.z);
    }

    public Vector3D midpoint(final double x, final double y, final double z) {
        return Vector3D.midpoint(this.x, this.y, this.z, x, y, z);
    }

    public static Vector3D midpoint(final Vector3D vector3D1, final Vector3D vector3D2) {
        return vector3D1.midpoint(vector3D2);
    }

    public static Vector3D midpoint(final Vector3D vector3D, final double x, final double y, final double z) {
        return vector3D.midpoint(x, y, z);
    }

    public static Vector3D midpoint(final double x1, final double y1, final double z1, final double x2, final double y2, final double z2) {
        return new Vector3D(x2 + (x1 + x2) / 2, y2 + (y1 + y2) / 2, z2 + (z1 + z2) / 2);
    }

    public double dotProduct(final Vector3D vector3D) {
        return dotProduct(vector3D.x, vector3D.y, vector3D.z);
    }

    public double dotProduct(final double x, final double y, final double z) {
        return Vector3D.dotProduct(this.x, this.y, this.z, x, y, z);
    }

    public static double dotProduct(final Vector3D vector3D1, final Vector3D vector3D2) {
        return vector3D1.dotProduct(vector3D2);
    }

    public static double dotProduct(final Vector3D vector3D, final double x, final double y, final double z) {
        return vector3D.dotProduct(x, y, z);
    }

    public static double dotProduct(final double x1, final double y1, final double z1, final double x2, final double y2, final double z2) {
        return x1 * x2 + y1 * y2 + z1 * z2;
    }

    public Vector3D crossProduct(final Vector3D vector3D) {
        return crossProduct(vector3D.x, vector3D.y, vector3D.z);
    }

    public Vector3D crossProduct(final double x, final double y, final double z) {
        return Vector3D.crossProduct(this.x, this.y, this.z, x, y, z);
    }

    public static Vector3D crossProduct(final Vector3D vector3D1, final Vector3D vector2D2) {
        return vector3D1.crossProduct(vector2D2);
    }

    public static Vector3D crossProduct(final Vector3D vector3D, final double x, final double y, final double z) {
        return vector3D.crossProduct(x, y, z);
    }

    public static Vector3D crossProduct(final double x, final double y, final double z, final Vector3D vector3D) {
        return Vector3D.crossProduct(x, y, z, vector3D.x, vector3D.y, vector3D.z);
    }

    public static Vector3D crossProduct(final double x1, final double y1, final double z1, final double x2, final double y2, final double z2) {
        return new Vector3D(y1 * z2 - z1 * y2, z1 * x2 - x1 * z2, x1 * y2 - y1 * x2);
    }

    public Point3D toPoint3D() {
        return new Point3D(x, y, z);
    }

    public static Point3D toPoint3D(final Vector3D vector3D) {
        return new Point3D(vector3D.x, vector3D.y, vector3D.z);
    }

    public static Point3D toPoint3D(final double x, final double y, final double z) {
        return new Point3D(x, y, z);
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

    public double getZ() {
        return z;
    }

    public void setZ(final double z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Vector3D) {
            final Vector3D vector3D = (Vector3D) obj;
            return x == vector3D.x && y == vector3D.y && z == vector3D.z;
        } else if (obj instanceof Point3D) {
            final Point3D point3D = (Point3D) obj;
            return x == point3D.getX() && y == point3D.getY() && z == point3D.getZ();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        long bits = 7L;
        bits = 31L * bits + Double.doubleToLongBits(getX());
        bits = 31L * bits + Double.doubleToLongBits(getY());
        bits = 31L * bits + Double.doubleToLongBits(getZ());
        return (int) (bits ^ (bits >> 32));
    }

    @Override
    public String toString() {
        return "Vector3D [x = " + x + ", y = " + y + ", z = " + z + "]";
    }
}
