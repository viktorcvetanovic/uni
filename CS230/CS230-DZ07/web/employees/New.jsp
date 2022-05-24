<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>New Employees</title>
            <link rel="stylesheet" type="text/css" href="/CS230-DZ07-BogdanPetrovic4382/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>New Employees</h1>
            <h:form>
                <h:inputHidden id="validateCreateField" validator="#{employees.validateCreate}" value="value"/>
                <h:panelGrid columns="2">
                    <h:outputText value="LastName:"/>
                    <h:inputText id="lastName" value="#{employees.employees.lastName}" title="LastName" required="true" requiredMessage="The lastName field is required." />
                    <h:outputText value="FirstName:"/>
                    <h:inputText id="firstName" value="#{employees.employees.firstName}" title="FirstName" required="true" requiredMessage="The firstName field is required." />
                    <h:outputText value="Extension:"/>
                    <h:inputText id="extension" value="#{employees.employees.extension}" title="Extension" required="true" requiredMessage="The extension field is required." />
                    <h:outputText value="Email:"/>
                    <h:inputText id="email" value="#{employees.employees.email}" title="Email" required="true" requiredMessage="The email field is required." />
                    <h:outputText value="OfficeCode:"/>
                    <h:inputText id="officeCode" value="#{employees.employees.officeCode}" title="OfficeCode" required="true" requiredMessage="The officeCode field is required." />
                    <h:outputText value="ReportsTo:"/>
                    <h:inputText id="reportsTo" value="#{employees.employees.reportsTo}" title="ReportsTo" required="true" requiredMessage="The reportsTo field is required." />
                    <h:outputText value="JobTitle:"/>
                    <h:inputText id="jobTitle" value="#{employees.employees.jobTitle}" title="JobTitle" required="true" requiredMessage="The jobTitle field is required." />
                    <h:outputText value="CustomerNumber:"/>
                    <h:selectOneMenu id="customerNumber" value="#{employees.employees.customerNumber}" title="CustomerNumber" required="true" requiredMessage="The customerNumber field is required." >
                        <f:selectItems value="#{customers.customersItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>
                    <h:outputText value="EmployeesList:"/>
                    <h:selectManyListbox id="employeesList" value="#{employees.employees.jsfcrud_transform[jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method.arrayToList].employeesList}" title="EmployeesList" size="6" converter="#{employees.converter}" >
                        <f:selectItems value="#{employees.employeesItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>
                    <h:outputText value="ParentEmployee:"/>
                    <h:selectOneMenu id="parentEmployee" value="#{employees.employees.parentEmployee}" title="ParentEmployee" required="true" requiredMessage="The parentEmployee field is required." >
                        <f:selectItems value="#{employees.employeesItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{employees.create}" value="Create"/>
                <br />
                <br />
                <h:commandLink action="#{employees.listSetup}" value="Show All Employees Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
