<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>New Orders</title>
            <link rel="stylesheet" type="text/css" href="/CS230-DZ07-BogdanPetrovic4382/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>New Orders</h1>
            <h:form>
                <h:inputHidden id="validateCreateField" validator="#{orders.validateCreate}" value="value"/>
                <h:panelGrid columns="2">
                    <h:outputText value="Order:"/>
                    <h:inputText id="order" value="#{orders.orders.order}" title="Order" required="true" requiredMessage="The order field is required." />
                    <h:outputText value="Date (MM/dd/yyyy):"/>
                    <h:inputText id="date" value="#{orders.orders.date}" title="Date" required="true" requiredMessage="The date field is required." >
                        <f:convertDateTime pattern="MM/dd/yyyy" />
                    </h:inputText>
                    <h:outputText value="RequiredDate (MM/dd/yyyy):"/>
                    <h:inputText id="requiredDate" value="#{orders.orders.requiredDate}" title="RequiredDate" required="true" requiredMessage="The requiredDate field is required." >
                        <f:convertDateTime pattern="MM/dd/yyyy" />
                    </h:inputText>
                    <h:outputText value="ShippedDate (MM/dd/yyyy):"/>
                    <h:inputText id="shippedDate" value="#{orders.orders.shippedDate}" title="ShippedDate" required="true" requiredMessage="The shippedDate field is required." >
                        <f:convertDateTime pattern="MM/dd/yyyy" />
                    </h:inputText>
                    <h:outputText value="Status:"/>
                    <h:inputText id="status" value="#{orders.orders.status}" title="Status" required="true" requiredMessage="The status field is required." />
                    <h:outputText value="Comment:"/>
                    <h:inputText id="comment" value="#{orders.orders.comment}" title="Comment" required="true" requiredMessage="The comment field is required." />
                    <h:outputText value="CustomerNumber:"/>
                    <h:inputText id="customerNumber" value="#{orders.orders.customerNumber}" title="CustomerNumber" required="true" requiredMessage="The customerNumber field is required." />
                    <h:outputText value="OrderDetailsList:"/>
                    <h:selectManyListbox id="orderDetailsList" value="#{orders.orders.jsfcrud_transform[jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method.arrayToList].orderDetailsList}" title="OrderDetailsList" size="6" converter="#{orderDetails.converter}" >
                        <f:selectItems value="#{orderDetails.orderDetailsItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{orders.create}" value="Create"/>
                <br />
                <br />
                <h:commandLink action="#{orders.listSetup}" value="Show All Orders Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
