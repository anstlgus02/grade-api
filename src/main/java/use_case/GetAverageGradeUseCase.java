package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        Team team = gradeDB.getMyTeam();

        String[] members = team.getMembers();
        int total = 0;

        for (String member : members) {
            Grade grade = gradeDB.getGrade(member, course);
            total = total + grade.getGrade();
        }

        return (float) total / members.length;
    }
}
