<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Offices Detail</title>
            <link rel="stylesheet" type="text/css" href="/CS230-DZ07-BogdanPetrovic4382/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Offices Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="OfficeCode:"/>
                    <h:outputText value="#{offices.offices.officeCode}" title="OfficeCode" />
                    <h:outputText value="City:"/>
                    <h:outputText value="#{offices.offices.city}" title="City" />
                    <h:outputText value="Phone:"/>
                    <h:outputText value="#{offices.offices.phone}" title="Phone" />
                    <h:outputText value="Address:"/>
                    <h:outputText value="#{offices.offices.address}" title="Address" />
                    <h:outputText value="State:"/>
                    <h:outputText value="#{offices.offices.state}" title="State" />
                    <h:outputText value="Country:"/>
                    <h:outputText value="#{offices.offices.country}" title="Country" />
                    <h:outputText value="PostalCode:"/>
                    <h:outputText value="#{offices.offices.postalCode}" title="PostalCode" />
                    <h:outputText value="Territory:"/>
                    <h:outputText value="#{offices.offices.territory}" title="Territory" />


                </h:panelGrid>
                <br />
                <h:commandLink action="#{offices.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentOffices" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][offices.offices][offices.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{offices.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentOffices" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][offices.offices][offices.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{offices.createSetup}" value="New Offices" />
                <br />
                <h:commandLink action="#{offices.listSetup}" value="Show All Offices Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
