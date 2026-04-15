import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public boolean registerUser(User user) {
        try {
            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO users(name, email, password, role) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public User loginUser(String email, String password) {
    try {
        Connection conn = DBConnection.getConnection();

        String sql = "SELECT * FROM users WHERE email=? AND password=?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, email);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new User(
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("role")
            );
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
 }

 public boolean addQuestion(Question q) {
    try {
        Connection conn = DBConnection.getConnection();

        String sql = "INSERT INTO questions(question, opt1, opt2, opt3, opt4, correct) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, q.getQuestion());
        ps.setString(2, q.getOpt1());
        ps.setString(3, q.getOpt2());
        ps.setString(4, q.getOpt3());
        ps.setString(5, q.getOpt4());
        ps.setString(6, q.getCorrect());

        return ps.executeUpdate() > 0;

    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

}