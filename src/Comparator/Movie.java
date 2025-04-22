package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Movie {

    private String title;
    private int year;
    private double rating;

    Movie(String title, int year, double rating){
        this.title=title;
        this.year=year;
        this.rating=rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return
                "title='" + title + '\'' +
                ", year=" + year +
                ", rating=" + rating ;
    }
}

class MovieSortByYear implements Comparator<Movie>{

    @Override
    public int compare(Movie o1, Movie o2) {
        if(o1.getYear() != o2.getYear()){
            return Integer.compare(o1.getYear(),o2.getYear());
        }else {
            return Double.compare(o2.getRating(),o1.getRating());
        }
    }
}
class MovieSort{
    public static void main(String[] args) {
        List<Movie>movies=new ArrayList<>();
        movies.add(new Movie("Krish",2014,9.8));
        movies.add(new Movie("RRR",2023,8.0));
        movies.add(new Movie("Salar",2024,7.8));
        movies.add(new Movie("Dhol",2010,8.8));
        movies.add(new Movie("Koi mil gaya",2012,9.9));
        movies.add(new Movie("Bhootnath",2014,10));

        Collections.sort(movies,new MovieSortByYear());

        System.out.println("Movies is sort by year if year is same sort by rating");

        for(Movie movie:movies){
            System.out.println(movie);
        }


    }
}