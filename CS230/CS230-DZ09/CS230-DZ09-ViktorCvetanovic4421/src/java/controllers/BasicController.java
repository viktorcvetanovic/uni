/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cdi.Basic;
import javax.inject.Inject;
import stereotype.Stereotypes;

/**
 *
 * @author BiG
 */
@Stereotypes
public class BasicController {

    @Inject
    private Basic basic;

    public BasicController(Basic basic) {
        this.basic = basic;
    }

    public Basic getBasic() {
        return basic;
    }

    public void setBasic(Basic basic) {
        this.basic = basic;
    }

    public String navigateForConfirmation() {
        return "viewBasic";
    }

    @Override
    public String toString() {
        return "basicController{" + "basic=" + basic + '}';
    }

}
