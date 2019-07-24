package com.bdqn.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @Author ldwjava
 * @Date 2019/5/10 16:14
 * @Desc TODO
 **/

@JsonIgnoreProperties(ignoreUnknown = true)
public class AA {


    /**
     * {"id1" : 1,"name1" : "台式机","detail" : {"empno":7369,"job":"clerk"}
     */

    private int id1;
    private String name1;
    private DetailBean detail;

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public DetailBean getDetail() {
        return detail;
    }

    public void setDetail(DetailBean detail) {
        this.detail = detail;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DetailBean {
        /**
         * empno : 7369
         * job : clerk
         */

        private int empno;
        private String job;

        public int getEmpno() {
            return empno;
        }

        public void setEmpno(int empno) {
            this.empno = empno;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }
    }
}
