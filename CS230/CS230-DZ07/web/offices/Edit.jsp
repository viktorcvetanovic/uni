<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Editing Offices</title>
            <link rel="stylesheet" type="text/css" href="/CS230-DZ07-BogdanPetrovic4382/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Editing Offices</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="OfficeCode:"/>
                    <h:outputText value="#{offices.offices.officeCode}" title="OfficeCode" />
                    <h:outputText value="City:"/>
                    <h:inputText id="city" value="#{offices.offices.city}" title="City" required="true" requiredMessage="The city field is required." />
                    <h:outputText value="Phone:"/>
                    <h:inputText id="phone" value="#{offices.offices.phone}" title="Phone" required="true" requiredMessage="The phone field is required." />
                    <h:outputText value="Address:"/>
                    <h:inputText id="address" value="#{offices.offices.address}" title="Address" required="true" requiredMessage="The address field is required." />
                    <h:outputText value="State:"/>
                    <h:inputText id="state" value="#{offices.offices.state}" title="State" required="true" requiredMessage="The state field is required." />
                    <h:outputText value="Country:"/>
                    <h:inputText id="country" value="#{offices.offices.country}" title="Country" required="true" requiredMessage="The country field is required." />
                    <h:outputText value="PostalCode:"/>
                    <h:inputText id="postalCode" value="#{offices.offices.postalCode}" title="PostalCode" required="true" requiredMessage="The postalCode field is required." />
                    <h:outputText value="Territory:"/>
                    <h:inputText id="territory" value="#{offices.offices.territory}" title="Territory" required="true" requiredMessage="The territory field is required." />

                </h:panelGrid>
                <br />
                <h:commandLink action="#{offices.edit}" value="Save">
                    <f:param name="jsfcrud.currentOffices" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][offices.offices][offices.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{offices.detailSetup}" value="Show" immediate="true">
                    <f:param name="jsfcrud.currentOffices" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][offices.offices][offices.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <h:commandLink action="#{offices.listSetup}" value="Show All Offices Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
