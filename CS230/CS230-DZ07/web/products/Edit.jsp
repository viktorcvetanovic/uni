<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Editing Products</title>
            <link rel="stylesheet" type="text/css" href="/CS230-DZ07-BogdanPetrovic4382/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Editing Products</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="Code:"/>
                    <h:outputText value="#{products.products.code}" title="Code" />
                    <h:outputText value="Name:"/>
                    <h:inputText id="name" value="#{products.products.name}" title="Name" required="true" requiredMessage="The name field is required." />
                    <h:outputText value="Line:"/>
                    <h:inputText id="line" value="#{products.products.line}" title="Line" required="true" requiredMessage="The line field is required." />
                    <h:outputText value="Scale:"/>
                    <h:inputText id="scale" value="#{products.products.scale}" title="Scale" required="true" requiredMessage="The scale field is required." />
                    <h:outputText value="Vendor:"/>
                    <h:inputText id="vendor" value="#{products.products.vendor}" title="Vendor" required="true" requiredMessage="The vendor field is required." />
                    <h:outputText value="Description:"/>
                    <h:inputText id="description" value="#{products.products.description}" title="Description" required="true" requiredMessage="The description field is required." />
                    <h:outputText value="QuantityInStock:"/>
                    <h:inputText id="quantityInStock" value="#{products.products.quantityInStock}" title="QuantityInStock" required="true" requiredMessage="The quantityInStock field is required." />
                    <h:outputText value="BuyPrice:"/>
                    <h:inputText id="buyPrice" value="#{products.products.buyPrice}" title="BuyPrice" required="true" requiredMessage="The buyPrice field is required." />
                    <h:outputText value="Msrp:"/>
                    <h:inputText id="msrp" value="#{products.products.msrp}" title="Msrp" required="true" requiredMessage="The msrp field is required." />
                    <h:outputText value="ProductilnesList:"/>
                    <h:selectManyListbox id="productilnesList" value="#{products.products.jsfcrud_transform[jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method.arrayToList].productilnesList}" title="ProductilnesList" size="6" converter="#{productilnes.converter}" >
                        <f:selectItems value="#{productilnes.productilnesItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>
                    <h:outputText value="OrderDetailsList:"/>
                    <h:selectManyListbox id="orderDetailsList" value="#{products.products.jsfcrud_transform[jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method.arrayToList].orderDetailsList}" title="OrderDetailsList" size="6" converter="#{orderDetails.converter}" >
                        <f:selectItems value="#{orderDetails.orderDetailsItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{products.edit}" value="Save">
                    <f:param name="jsfcrud.currentProducts" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][products.products][products.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{products.detailSetup}" value="Show" immediate="true">
                    <f:param name="jsfcrud.currentProducts" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][products.products][products.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <h:commandLink action="#{products.listSetup}" value="Show All Products Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
