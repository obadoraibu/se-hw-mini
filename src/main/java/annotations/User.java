package annotations;

public class User {
    @RandomString(length = 9)
    public String id;

    User() {
        RandomStringHelper.setFields(this);
    }

    @Override
    public String toString() {
        return "user_id: " + id;
    }
}
