public class TestRegister {
    public static void main(String[] args) {

        User user = new User(1,"Abhi", "abhi@gmail.com", "1234", "student");

        UserDAO dao = new UserDAO();

        boolean success = dao.registerUser(user);

        if (success) {
            System.out.println("User registered successfully!");
        } else {
            System.out.println("Registration failed!");
        }
    }
}