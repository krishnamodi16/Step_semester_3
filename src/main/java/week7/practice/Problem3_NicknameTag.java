package week7.practice;

final class NameTag {
    private final String firstName;
    private final String lastName;

    public NameTag(String fullName) {
        String[] parts = fullName.trim().split(" ");
        if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
            throw new IllegalArgumentException("Enter exactly a first name and a last name.");
        }
        firstName = parts[0];
        lastName = parts[1];
    }

    public String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }
}

public class Problem3_NicknameTag {
    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println("Nickname: " + tag.getNickname());
    }
}
