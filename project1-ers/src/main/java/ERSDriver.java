import com.example.dao.RStatusDAO;
import com.example.dao.RTypeDAO;
import com.example.dao.ReimbDAO;
import com.example.dao.URolesDAO;
import com.example.dao.UserDAO;
import com.example.models.RStatus;
import com.example.models.RType;
import com.example.models.Reimbursement;
import com.example.models.Roles;
import com.example.models.Status;
import com.example.models.Type;
import com.example.models.URoles;
import com.example.models.User;

public class ERSDriver {
    public static void main(String[] args) {
        ReimbDAO rDao = new ReimbDAO();
        UserDAO uDao = new UserDAO();
        RStatusDAO rSDao = new RStatusDAO();
        RTypeDAO rTDao = new RTypeDAO();
        URolesDAO uRDao = new URolesDAO();
        URoles M = new URoles(1, Roles.MANAGER);
        URoles E = new URoles(2, Roles.EMPLOYEE);
        RStatus S = new RStatus(1, Status.SUBMITTED);
        RStatus A = new RStatus(2, Status.APPROVED);
        RStatus D = new RStatus(3, Status.DENIED);
        RType F = new RType(0, Type.FOOD);
        RType L = new RType(1, Type.LODGING);
        RType O = new RType(2, Type.OTHER);
        RType T = new RType(3, Type.TRAVEL);
        User u = new User();

        uRDao.insert(M);
        uRDao.insert(E);
        User u1 = new User("Robert", "SpeedWagon", "reos@spw.com", u.getUsername(), "oil", M);
        User u2 = new User("John", "Constantine", "jconstantine@gmail.com", u.getUsername(), "hellblazer", E);
        uDao.insert(u1);
        uDao.insert(u2);

        rSDao.insert(S);
        rSDao.insert(A);
        rSDao.insert(D);
        rTDao.insert(F);
        rTDao.insert(L);
        rTDao.insert(O);
        rTDao.insert(T);
        Reimbursement r1 = new Reimbursement(500, "Traveling to Philly", S, T, u2, u1);
        Reimbursement r2 = new Reimbursement(200, "Omg is that ariana grande", S, O, u2, u1);
        rDao.insert(r1);
        rDao.insert(r2);

    }
}