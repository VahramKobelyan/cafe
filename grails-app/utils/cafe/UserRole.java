package cafe;

public enum UserRole {
    MANAGER, WAITER;

    String getAuthority() {
        return "ROLE_" + this.toString();
    }
}
