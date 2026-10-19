package week5.practice;

public class Problem2_DuplicateTeamNameFinder {
    static String findDuplicateTeam(String[] teamNames) {
        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        String[] names1 = {"ByteForce", "CodeCrafters", "ByteForce"};
        String[] names2 = {"ByteForce", "CodeCrafters", "NullPointers"};
        System.out.println(findDuplicateTeam(names1));
        System.out.println(findDuplicateTeam(names2));
    }
}
