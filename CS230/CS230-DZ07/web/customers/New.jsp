<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>New Customers</title>
            <link rel="stylesheet" type="text/css" href="/CS230-DZ07-BogdanPetrovic4382/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>New Customers</h1>
            <h:form>
                <h:inputHidden id="validateCreateField" validator="#{customers.validateCreate}" value="value"/>
                <h:panelGrid columns="2">
                    <h:outputText value="Name:"/>
                    <h:inputText id="name" value="#{customers.customers.name}" title="Name" required="true" requiredMessage="The name field is required." />
                    <h:outputText value="Contact:"/>
                    <h:inputText id="contact" value="#{customers.customers.contact}" title="Contact" required="true" requiredMessage="The contact field is required." />
                    <h:outputText value="Phone:"/>
                    <h:inputText id="phone" value="#{customers.customers.phone}" title="Phone" required="true" requiredMessage="The phone field is required." />
                    <h:outputText value="Address:"/>
                    <h:inputText id="address" value="#{customers.customers.address}" title="Address" required="true" requiredMessage="The address field is required." />
                    <h:outputText value="City:"/>
                    <h:inputText id="city" value="#{customers.customers.city}" title="City" required="true" requiredMessage="The city field is required." />
                    <h:outputText value="State:"/>
                    <h:inputText id="state" value="#{customers.customers.state}" title="State" required="true" requiredMessage="The state field is required." />
                    <h:outputText value="PostalCode:"/>
                    <h:inputText id="postalCode" value="#{customers.customers.postalCode}" title="PostalCode" required="true" requiredMessage="The postalCode field is required." />
                    <h:outputText value="Country:"/>
                    <h:inputText id="country" value="#{customers.customers.country}" title="Country" required="true" requiredMessage="The country field is required." />
                    <h:outputText value="SalesRepEmployeeNumber:"/>
                    <h:inputText id="salesRepEmployeeNumber" value="#{customers.customers.salesRepEmployeeNumber}" title="SalesRepEmployeeNumber" required="true" requiredMessage="The salesRepEmployeeNumber field is required." />
                    <h:outputText value="CreditLimit:"/>
                    <h:inputText id="creditLimit" value="#{customers.customers.creditLimit}" title="CreditLimit" required="true" requiredMessage="The creditLimit field is required." />
                    <h:outputText value="PaymentsList:"/>
                    <h:selectManyListbox id="paymentsList" value="#{customers.customers.jsfcrud_transform[jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method.arrayToList].paymentsList}" title="PaymentsList" size="6" converter="#{payments.converter}" >
                        <f:selectItems value="#{payments.paymentsItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>
                    <h:outputText value="EmployeesList:"/>
                    <h:selectManyListbox id="employeesList" value="#{customers.customers.jsfcrud_transform[jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method.arrayToList].employeesList}" title="EmployeesList" size="6" converter="#{employees.converter}" >
                        <f:selectItems value="#{employees.employeesItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{customers.create}" value="Create"/>
                <br />
                <br />
                <h:commandLink action="#{customers.listSetup}" value="Show All Customers Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
