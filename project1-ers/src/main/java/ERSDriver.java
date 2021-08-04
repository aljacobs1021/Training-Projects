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
        URoles E = new URoles(1, Roles.EMPLOYEE);
        URoles M = new URoles(0, Roles.MANAGER);
        RStatus S = new RStatus(1, Status.SUBMITTED);
        RStatus A = new RStatus(2, Status.APPROVED);
        RStatus D = new RStatus(3, Status.DENIED);
        RType F = new RType(1, Type.FOOD);
        RType L = new RType(2, Type.LODGING);
        RType O = new RType(3, Type.OTHER);
        RType T = new RType(4, Type.TRAVEL);


        uRDao.insert(M);
        uRDao.insert(E);
        User u1 = new User("Robert", "SpeedWagon", "reos@spw.com", "oil", Roles.MANAGER);
        User u2 = new User("John", "Constantine", "jconstantine@gmail.com", "hellblazer", Roles.EMPLOYEE);
        uDao.insert(u1);
        uDao.insert(u2);

        rSDao.insert(S);
        rSDao.insert(A);
        rSDao.insert(D);
        rTDao.insert(F);
        rTDao.insert(O);
        rTDao.insert(T);
        Reimbursement r1 = new Reimbursement(500, "Traveling to Philly", Status.SUBMITTED, Type.TRAVEL, u1, u2);
        rDao.insert(r1);

    }
}