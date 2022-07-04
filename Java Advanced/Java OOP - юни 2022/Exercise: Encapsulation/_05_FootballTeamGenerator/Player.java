package EncapsulationExercise.FootballTeamGenerator;

public class Player {
    //Име и скилове
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    //Конструкция
    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    //Валидация
    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        if (endurance >= 0 && endurance <= 100) {
            this.endurance = endurance;
        } else {
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        }
    }

    private void setSprint(int sprint) {
        if (sprint >= 0 && sprint <= 100) {
            this.sprint = sprint;
        } else {
            throw new IllegalArgumentException("Sprint should be between 0 and 100.");
        }
    }

    private void setDribble(int dribble) {
        if (dribble >= 0 && dribble <= 100) {
            this.dribble = dribble;
        } else {
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        }
    }

    private void setPassing(int passing) {
        if (passing >= 0 && passing <= 100) {
            this.passing = passing;
        } else {
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        }
    }

    private void setShooting(int shooting) {
        if (shooting >= 0 && shooting <= 100) {
            this.shooting = shooting;
        } else {
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        }
    }

    public String getName() {
        return name;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getSprint() {
        return sprint;
    }

    public int getDribble() {
        return dribble;
    }

    public int getPassing() {
        return passing;
    }

    public int getShooting() {
        return shooting;
    }

    //Скил точки
    public double overallSkillLevel() {
        return (getDribble() + getEndurance() + getPassing() + getShooting() + getSprint()) / 5.00;
    }
}
