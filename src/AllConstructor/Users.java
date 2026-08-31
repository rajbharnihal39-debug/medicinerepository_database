package AllConstructor;

import java.time.LocalDateTime;

public class Users {

    private int userId;
    private int roleId;
    private String name;
    private String email;
    private String passwordHash;
    private String status;
    private LocalDateTime createdAt;

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public Users(
            int userId,
            int roleId,
            String name,
            String email,
            String passwordHash,
            String status,
            LocalDateTime createdAt) {

        this.userId = userId;
        this.roleId = roleId;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.status = status;
        this.createdAt = createdAt;
    }

    // =========================================================
    // GET USER ID
    // =========================================================

    public int getUserId() {
        return userId;
    }

    // =========================================================
    // SET USER ID
    // =========================================================

    public void setUserId(int userId) {
        this.userId = userId;
    }

    // =========================================================
    // GET ROLE ID
    // =========================================================

    public int getRoleId() {
        return roleId;
    }

    // =========================================================
    // SET ROLE ID
    // =========================================================

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    // =========================================================
    // GET NAME
    // =========================================================

    public String getName() {
        return name;
    }

    // =========================================================
    // SET NAME
    // =========================================================

    public void setName(String name) {
        this.name = name;
    }

    // =========================================================
    // GET EMAIL
    // =========================================================

    public String getEmail() {
        return email;
    }

    // =========================================================
    // SET EMAIL
    // =========================================================

    public void setEmail(String email) {
        this.email = email;
    }

    // =========================================================
    // GET PASSWORD HASH
    // =========================================================

    public String getPasswordHash() {
        return passwordHash;
    }

    // =========================================================
    // SET PASSWORD HASH
    // =========================================================

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    // =========================================================
    // GET STATUS
    // =========================================================

    public String getStatus() {
        return status;
    }

    // =========================================================
    // SET STATUS
    // =========================================================

    public void setStatus(String status) {
        this.status = status;
    }

    // =========================================================
    // GET CREATED AT
    // =========================================================

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // =========================================================
    // SET CREATED AT
    // =========================================================

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // =========================================================
    // TO STRING
    // =========================================================

    @Override
    public String toString() {

        return "User ID: " + userId +
                "\nRole ID: " + roleId +
                "\nName: " + name +
                "\nEmail: " + email +
                "\nPassword Hash: " + passwordHash +
                "\nStatus: " + status +
                "\nCreated At: " + createdAt;
    }
}
