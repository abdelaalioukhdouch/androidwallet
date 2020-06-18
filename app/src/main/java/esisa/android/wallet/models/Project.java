package esisa.android.wallet.models;

public class Project {

    public String projectName;
    public String projectPeriode;
    public String projectBudget;
    public String projectDescription;

    public Project() {
    }

    public Project(String projectName, String projectPeriode, String projectBudget, String projectDescription) {
        this.projectName = projectName;
        this.projectPeriode = projectPeriode;
        this.projectBudget = projectBudget;
        this.projectDescription = projectDescription;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectPeriode() {
        return projectPeriode;
    }

    public void setProjectPeriode(String projectPeriode) {
        this.projectPeriode = projectPeriode;
    }

    public String getProjectBudget() {
        return projectBudget;
    }

    public void setProjectBudget(String projectBudget) {
        this.projectBudget = projectBudget;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }
}
