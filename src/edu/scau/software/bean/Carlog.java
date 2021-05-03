package edu.scau.software.bean;

public class Carlog {
    private Integer id = null;
    private String good_id;         // 订单编号,唯一约束
    private Integer car_id;
    private String startTime;
    private String endTime;
    private String describer;

    public Carlog() {
    }

    public Carlog(String good_id, Integer car_id, String startTime, String endTime, String describer) {
        this.good_id = good_id;
        this.car_id = car_id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.describer = describer;
    }

    public Carlog(Integer id, String good_id, Integer car_id, String startTime, String endTime, String describer) {
        this.id = id;
        this.good_id = good_id;
        this.car_id = car_id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.describer = describer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGood_id() {
        return good_id;
    }

    public void setGood_id(String good_id) {
        this.good_id = good_id;
    }

    public Integer getCar_id() {
        return car_id;
    }

    public void setCar_id(Integer car_id) {
        this.car_id = car_id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDescriber() {
        return describer;
    }

    public void setDescriber(String describer) {
        this.describer = describer;
    }

    @Override
    public String toString() {
        return "carlog{" +
                "id=" + id +
                ", good_id='" + good_id + '\'' +
                ", car_id=" + car_id +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", describer='" + describer + '\'' +
                '}';
    }
}
