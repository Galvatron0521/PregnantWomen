package com.shenkangyun.pregnantwomen.BeanFolder;

/**
 * Created by Administrator on 2018/7/5.
 */

public class LoginBean {

    /**
     * status : 0
     * data : {"patient":{"id":39,"num":"PDJH180119","hospitalID":0,"loginName":"","name":"丁建红","sex":"女","age":30,"national":"","brithday":"1988-04-06","mobile":"12164385700","password":"e10adc3949ba59abbe56e057f20f883e","degree":1,"idCard":"342422198804064536","provinceID":"310000","cityID":"310100","regionID":"","address":"","postalCode":"","diseasesID":"1","profession":2,"husbandAge":30,"husbandProfession":1,"childWeeks":60,"complication":"","createUser":"","createTime":1516338074000,"updateTime":1529907475000,"delFlag":0,"delTime":"","remark":""},"appType":"1"}
     */

    private String status;
    private DataBean data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * patient : {"id":39,"num":"PDJH180119","hospitalID":0,"loginName":"","name":"丁建红","sex":"女","age":30,"national":"","brithday":"1988-04-06","mobile":"12164385700","password":"e10adc3949ba59abbe56e057f20f883e","degree":1,"idCard":"342422198804064536","provinceID":"310000","cityID":"310100","regionID":"","address":"","postalCode":"","diseasesID":"1","profession":2,"husbandAge":30,"husbandProfession":1,"childWeeks":60,"complication":"","createUser":"","createTime":1516338074000,"updateTime":1529907475000,"delFlag":0,"delTime":"","remark":""}
         * appType : 1
         */

        private PatientBean patient;
        private String appType;

        public PatientBean getPatient() {
            return patient;
        }

        public void setPatient(PatientBean patient) {
            this.patient = patient;
        }

        public String getAppType() {
            return appType;
        }

        public void setAppType(String appType) {
            this.appType = appType;
        }

        public static class PatientBean {
            /**
             * id : 39
             * num : PDJH180119
             * hospitalID : 0
             * loginName :
             * name : 丁建红
             * sex : 女
             * age : 30
             * national :
             * brithday : 1988-04-06
             * mobile : 12164385700
             * password : e10adc3949ba59abbe56e057f20f883e
             * degree : 1
             * idCard : 342422198804064536
             * provinceID : 310000
             * cityID : 310100
             * regionID :
             * address :
             * postalCode :
             * diseasesID : 1
             * profession : 2
             * husbandAge : 30
             * husbandProfession : 1
             * childWeeks : 60
             * complication :
             * createUser :
             * createTime : 1516338074000
             * updateTime : 1529907475000
             * delFlag : 0
             * delTime :
             * remark :
             */

            private String id;
            private String num;
            private int hospitalID;
            private String loginName;
            private String name;
            private String sex;
            private int age;
            private String national;
            private String brithday;
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
            private String createTime;
            private String updateTime;
            private int delFlag;
            private String delTime;
            private String remark;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
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

            public String getBrithday() {
                return brithday;
            }

            public void setBrithday(String brithday) {
                this.brithday = brithday;
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

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
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
    }
}
