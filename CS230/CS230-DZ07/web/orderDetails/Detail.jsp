<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>OrderDetails Detail</title>
            <link rel="stylesheet" type="text/css" href="/CS230-DZ07-BogdanPetrovic4382/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>OrderDetails Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="QuantityOrdered:"/>
                    <h:outputText value="#{orderDetails.orderDetails.quantityOrdered}" title="QuantityOrdered" />
                    <h:outputText value="PriceEach:"/>
                    <h:outputText value="#{orderDetails.orderDetails.priceEach}" title="PriceEach" />
                    <h:outputText value="OrderLineNumber:"/>
                    <h:outputText value="#{orderDetails.orderDetails.orderLineNumber}" title="OrderLineNumber" />
                    <h:outputText value="DetailsId:"/>
                    <h:outputText value="#{orderDetails.orderDetails.detailsId}" title="DetailsId" />
                    <h:outputText value="OrderNumber:"/>
                    <h:panelGroup>
                        <h:outputText value="#{orderDetails.orderDetails.orderNumber}"/>
                        <h:panelGroup rendered="#{orderDetails.orderDetails.orderNumber != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{orders.detailSetup}">
                                <f:param name="jsfcrud.currentOrderDetails" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][orderDetails.orderDetails][orderDetails.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentOrders" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][orderDetails.orderDetails.orderNumber][orders.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="orderDetails"/>
                                <f:param name="jsfcrud.relatedControllerType" value="jsf.OrderDetailsController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{orders.editSetup}">
                                <f:param name="jsfcrud.currentOrderDetails" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][orderDetails.orderDetails][orderDetails.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentOrders" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][orderDetails.orderDetails.orderNumber][orders.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="orderDetails"/>
                                <f:param name="jsfcrud.relatedControllerType" value="jsf.OrderDetailsController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{orders.destroy}">
                                <f:param name="jsfcrud.currentOrderDetails" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][orderDetails.orderDetails][orderDetails.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentOrders" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][orderDetails.orderDetails.orderNumber][orders.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="orderDetails"/>
                                <f:param name="jsfcrud.relatedControllerType" value="jsf.OrderDetailsController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>
                    <h:outputText value="Code:"/>
                    <h:panelGroup>
                        <h:outputText value="#{orderDetails.orderDetails.code}"/>
                        <h:panelGroup rendered="#{orderDetails.orderDetails.code != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{products.detailSetup}">
                                <f:param name="jsfcrud.currentOrderDetails" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][orderDetails.orderDetails][orderDetails.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentProducts" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][orderDetails.orderDetails.code][products.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="orderDetails"/>
                                <f:param name="jsfcrud.relatedControllerType" value="jsf.OrderDetailsController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{products.editSetup}">
                                <f:param name="jsfcrud.currentOrderDetails" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][orderDetails.orderDetails][orderDetails.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentProducts" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][orderDetails.orderDetails.code][products.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="orderDetails"/>
                                <f:param name="jsfcrud.relatedControllerType" value="jsf.OrderDetailsController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{products.destroy}">
                                <f:param name="jsfcrud.currentOrderDetails" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][orderDetails.orderDetails][orderDetails.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentProducts" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][orderDetails.orderDetails.code][products.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="orderDetails"/>
                                <f:param name="jsfcrud.relatedControllerType" value="jsf.OrderDetailsController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>


                </h:panelGrid>
                <br />
                <h:commandLink action="#{orderDetails.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentOrderDetails" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][orderDetails.orderDetails][orderDetails.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{orderDetails.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentOrderDetails" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][orderDetails.orderDetails][orderDetails.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{orderDetails.createSetup}" value="New OrderDetails" />
                <br />
                <h:commandLink action="#{orderDetails.listSetup}" value="Show All OrderDetails Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
