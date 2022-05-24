/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cdi.Basic;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import qualifier.Vip;
import interceptorStereotype.InterceptorStereotype;
import stereotype.Stereotypes;

/**
 *
 * @author BiG
 */
@Stereotypes
@InterceptorStereotype
public class VipController {

    private static final Logger logger = Logger.getLogger(VipController.class.getName());

    @Inject
    @Vip
    private Basic basic;

    public String save() {
        cdi.Vip vip = (cdi.Vip) basic;
        logger.log(Level.INFO, " ",
                new Object[]{
                    vip.getFirstName(),
                    vip.getLastName(),
                    vip.getJmbg(),
                    vip.getCardNum(),
                    vip.getFlightNum(),
                    vip.getPlaceNum(),
                    vip.getMenu()});
        return "viewVip";
    }

}
