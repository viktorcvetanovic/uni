<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Editing OrderDetails</title>
            <link rel="stylesheet" type="text/css" href="/CS230-DZ07-BogdanPetrovic4382/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Editing OrderDetails</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="QuantityOrdered:"/>
                    <h:inputText id="quantityOrdered" value="#{orderDetails.orderDetails.quantityOrdered}" title="QuantityOrdered" required="true" requiredMessage="The quantityOrdered field is required." />
                    <h:outputText value="PriceEach:"/>
                    <h:inputText id="priceEach" value="#{orderDetails.orderDetails.priceEach}" title="PriceEach" required="true" requiredMessage="The priceEach field is required." />
                    <h:outputText value="OrderLineNumber:"/>
                    <h:inputText id="orderLineNumber" value="#{orderDetails.orderDetails.orderLineNumber}" title="OrderLineNumber" required="true" requiredMessage="The orderLineNumber field is required." />
                    <h:outputText value="DetailsId:"/>
                    <h:outputText value="#{orderDetails.orderDetails.detailsId}" title="DetailsId" />
                    <h:outputText value="OrderNumber:"/>
                    <h:selectOneMenu id="orderNumber" value="#{orderDetails.orderDetails.orderNumber}" title="OrderNumber" required="true" requiredMessage="The orderNumber field is required." >
                        <f:selectItems value="#{orders.ordersItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>
                    <h:outputText value="Code:"/>
                    <h:selectOneMenu id="code" value="#{orderDetails.orderDetails.code}" title="Code" required="true" requiredMessage="The code field is required." >
                        <f:selectItems value="#{products.productsItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{orderDetails.edit}" value="Save">
                    <f:param name="jsfcrud.currentOrderDetails" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][orderDetails.orderDetails][orderDetails.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{orderDetails.detailSetup}" value="Show" immediate="true">
                    <f:param name="jsfcrud.currentOrderDetails" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][orderDetails.orderDetails][orderDetails.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <h:commandLink action="#{orderDetails.listSetup}" value="Show All OrderDetails Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
