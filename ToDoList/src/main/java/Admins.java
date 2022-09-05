
public class Admins {
    private int idAdmins;
    private String AdminName;
    private String AdminPassword;

    public Admins(int idAdmins, String AdminName, String AdminPassword) {
        this.idAdmins = idAdmins;
        this.AdminName = AdminName;
        this.AdminPassword = AdminPassword;
    }

    public int getIdAdmins() {
        return idAdmins;
    }

    public void setIdAdmins(int idAdmins) {
        this.idAdmins = idAdmins;
    }

    public String getAdminName() {
        return AdminName;
    }

    public void setAdminName(String AdminName) {
        this.AdminName = AdminName;
    }

    public String getAdminPassword() {
        return AdminPassword;
    }

    public void setAdminPassword(String AdminPassword) {
        this.AdminPassword = AdminPassword;
    }
    
}
