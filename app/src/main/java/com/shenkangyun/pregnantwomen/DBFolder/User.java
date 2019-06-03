package com.shenkangyun.pregnantwomen.DBFolder;

import org.litepal.crud.LitePalSupport;

/**
 * Created by Administrator on 2018/7/5.
 */

public class User extends LitePalSupport {
    private String userID;
    private String num;
    private int hospitalID;
    private String loginName;
    private String name;
    private String sex;
    private int age;
    private String national;
    private String birthday;
    private String mobile;
    private String password;
    private int degree;
    private String idCard;
    private String provinceID;
    private String cityID;
    private String regionID;
    private String address;
    private String postalCode;
    private String diseasesID;
    private int profession;
    private int husbandAge;
    private int husbandProfession;
    private int childWeeks;
    private String complication;
    private String createUser;
    private long createTime;
    private long updateTime;
    private int delFlag;
    private String delTime;
    private String remark;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getHospitalID() {
        return hospitalID;
    }

    public void setHospitalID(int hospitalID) {
        this.hospitalID = hospitalID;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(String provinceID) {
        this.provinceID = provinceID;
    }

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getRegionID() {
        return regionID;
    }

    public void setRegionID(String regionID) {
        this.regionID = regionID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getDiseasesID() {
        return diseasesID;
    }

    public void setDiseasesID(String diseasesID) {
        this.diseasesID = diseasesID;
    }

    public int getProfession() {
        return profession;
    }

    public void setProfession(int profession) {
        this.profession = profession;
    }

    public int getHusbandAge() {
        return husbandAge;
    }

    public void setHusbandAge(int husbandAge) {
        this.husbandAge = husbandAge;
    }

    public int getHusbandProfession() {
        return husbandProfession;
    }

    public void setHusbandProfession(int husbandProfession) {
        this.husbandProfession = husbandProfession;
    }

    public int getChildWeeks() {
        return childWeeks;
    }

    public void setChildWeeks(int childWeeks) {
        this.childWeeks = childWeeks;
    }

    public String getComplication() {
        return complication;
    }

    public void setComplication(String complication) {
        this.complication = complication;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelTime() {
        return delTime;
    }

    public void setDelTime(String delTime) {
        this.delTime = delTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
