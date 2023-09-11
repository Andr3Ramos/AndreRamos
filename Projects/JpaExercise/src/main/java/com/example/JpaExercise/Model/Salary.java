package com.example.JpaExercise.Model;

public class Salary {

    private long Id;
    private String company;
    private Integer level;
    private Integer bonus;
    private Integer startingSalary;
    private Integer currentSalary;
    private String activeFlag;
    private String title;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public Integer getStartingSalary() {
        return startingSalary;
    }

    public void setStartingSalary(Integer startingSalary) {
        this.startingSalary = startingSalary;
    }

    public Integer getCurrentSalary() {
        return currentSalary;
    }

    public void setCurrentSalary(Integer currentSalary) {
        this.currentSalary = currentSalary;
    }

    public String getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(String activeFlag) {
        this.activeFlag = activeFlag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
