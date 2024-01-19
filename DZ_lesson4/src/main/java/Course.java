import javax.persistence.*;
import java.util.Random;

@Table(name = "Courses")
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String title;
    private int duration;

    private static final String[] titles = new String[] {"JDK","JavaCore","Spring","JavaJunior"};

    public Course(String title, int duration){
        this.title = title;
        this.duration = duration;
    }

    public Course(){}

    public int getID() {
        return ID;
    }
    public void updateDuration(){
        duration = new Random().nextInt(5, 11);
    }

    public void updateTitle(){
        title = titles[new Random().nextInt(titles.length)];
    }


    @Override
    public String toString() {
        return "Course{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
