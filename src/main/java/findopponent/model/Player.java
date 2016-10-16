package findopponent.model;

/**
 * Created by Sergiy on 16.10.2016.
 */
public class Player {
    private String name;
    private double rating;

    public Player() {
    }

    public Player(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (Double.compare(player.rating, rating) != 0) return false;
        return name.equals(player.name);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(rating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }
}
