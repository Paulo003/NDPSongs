package sg.edu.rp.c346.id21009874.ndpsongs;

import java.io.Serializable;

public class Song implements Serializable {

    private int id;
    private String title;
    private String singers;
    private int year;
    private int stars;

    public Song(int id, String title, String singers, int year, int stars) {
        this.id = id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    public int get_id() {

        return id;
    }

    public String getTitle() {

        return title;
    }
    public String getSingers() {

        return singers;
    }
    public int getYear() {

        return year;
    }
    public int getStar() {

        return stars;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public void setSingers(String singers) {
        this.singers = singers;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
    @Override
    public String toString() {
        return "song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", singers='" + singers + '\'' +
                ", year=" + year +
                ", stars=" + stars +
                '}';
    }
}
