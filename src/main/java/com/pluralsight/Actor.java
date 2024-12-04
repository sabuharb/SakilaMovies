public class Actor {
    private int actorId;
    private String firstName;
    private String lastName;

    public Actor(int actorId, String firstName, String lastName) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters
    public int getActorId() {
        return actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Actor [actorId=" + actorId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}

