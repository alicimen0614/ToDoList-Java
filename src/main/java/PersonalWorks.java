
public class PersonalWorks {
    private int id;
private String subject;
private String mission;
private String duedate;
private boolean done;

    public PersonalWorks(int id, String subject, String mission, String duedate , boolean done) {
        this.id = id;
        this.subject = subject;
        this.mission = mission;
        this.duedate = duedate;
        this.done=done;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the mission
     */
    public String getMission() {
        return mission;
    }

    /**
     * @param mission the mission to set
     */
    public void setMission(String mission) {
        this.mission = mission;
    }

    /**
     * @return the duedate
     */
    public String getDuedate() {
        return duedate;
    }

    /**
     * @param duedate the duedate to set
     */
    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }
    
}
