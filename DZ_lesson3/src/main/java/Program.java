import java.io.*;

public class Program {
    public static void main(String[] args) {
        Student student = new Student("John Smith", 18, 4.0);

        try (FileOutputStream fos = new FileOutputStream("StudentObjectFile");
             ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(student);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (FileInputStream fis = new FileInputStream("StudentObjectFile");
             ObjectInputStream ois = new ObjectInputStream(fis);) {
            Student deserializedStudent = (Student) ois.readObject();
            System.out.println(deserializedStudent);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
