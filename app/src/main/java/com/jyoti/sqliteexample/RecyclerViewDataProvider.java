package com.jyoti.sqliteexample;

/**
 * Created by jyoti on 18/01/2018.
 */

public class RecyclerViewDataProvider {
    private final String TAG = "RecyclerViewDataProvider";

    private String empName;
    private String  empsalary;
    private String deptName;
    private String  deptsal;

  /*  public RecyclerViewDataProvider(String empName, String empsalary, String deptName, String deptsal) {
        this.setEmpName(empName);
        this.setEmpsalary(empsalary);
        this.setDeptName(deptName);
        this.setDeptsal(deptsal);
    }
*/
    public String getTAG() {
        return TAG;
    }

    public  String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpsalary() {
        return empsalary;
    }

    public void setEmpsalary(String empsalary) {
        this.empsalary = empsalary;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptsal() {
        return deptsal;
    }

    public void setDeptsal(String deptsal) {
        this.deptsal = deptsal;
    }
}
