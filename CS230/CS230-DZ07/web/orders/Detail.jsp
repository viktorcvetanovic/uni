<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Orders Detail</title>
            <link rel="stylesheet" type="text/css" href="/CS230-DZ07-BogdanPetrovic4382/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Orders Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="Order:"/>
                    <h:outputText value="#{orders.orders.order}" title="Order" />
                    <h:outputText value="Date:"/>
                    <h:outputText value="#{orders.orders.date}" title="Date" >
                        <f:convertDateTime pattern="MM/dd/yyyy" />
                    </h:outputText>
                    <h:outputText value="RequiredDate:"/>
                    <h:outputText value="#{orders.orders.requiredDate}" title="RequiredDate" >
                        <f:convertDateTime pattern="MM/dd/yyyy" />
                    </h:outputText>
                    <h:outputText value="ShippedDate:"/>
                    <h:outputText value="#{orders.orders.shippedDate}" title="ShippedDate" >
                        <f:convertDateTime pattern="MM/dd/yyyy" />
                    </h:outputText>
                    <h:outputText value="Status:"/>
                    <h:outputText value="#{orders.orders.status}" title="Status" />
                    <h:outputText value="Comment:"/>
                    <h:outputText value="#{orders.orders.comment}" title="Comment" />
                    <h:outputText value="CustomerNumber:"/>
                    <h:outputText value="#{orders.orders.customerNumber}" title="CustomerNumber" />

                    <h:outputText value="OrderDetailsList:" />
                    <h:panelGroup>
                        <h:outputText rendered="#{empty orders.orders.orderDetailsList}" value="(No Items)"/>
                        <h:dataTable value="#{orders.orders.orderDetailsList}" var="item" 
                                     border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px" 
                                     rendered="#{not empty orders.orders.orderDetailsList}">
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="QuantityOrdered"/>
                                </f:facet>
                                <h:outputText value="#{item.quantityOrdered}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="PriceEach"/>
                                </f:facet>
                                <h:outputText value="#{item.priceEach}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="OrderLineNumber"/>
                                </f:facet>
                                <h:outputText value="#{item.orderLineNumber}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="DetailsId"/>
                                </f:facet>
                                <h:outputText value="#{item.detailsId}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="OrderNumber"/>
                                </f:facet>
                                <h:outputText value="#{item.orderNumber}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Code"/>
                                </f:facet>
                                <h:outputText value="#{item.code}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText escape="false" value="&nbsp;"/>
                                </f:facet>
                                <h:commandLink value="Show" action="#{orderDetails.detailSetup}">
                                    <f:param name="jsfcrud.currentOrders" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][orders.orders][orders.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentOrderDetails" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][orderDetails.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="orders" />
                                    <f:param name="jsfcrud.relatedControllerType" value="jsf.OrdersController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Edit" action="#{orderDetails.editSetup}">
                                    <f:param name="jsfcrud.currentOrders" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][orders.orders][orders.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentOrderDetails" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][orderDetails.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="orders" />
                                    <f:param name="jsfcrud.relatedControllerType" value="jsf.OrdersController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Destroy" action="#{orderDetails.destroy}">
                                    <f:param name="jsfcrud.currentOrders" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][orders.orders][orders.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentOrderDetails" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][orderDetails.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="orders" />
                                    <f:param name="jsfcrud.relatedControllerType" value="jsf.OrdersController" />
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                    </h:panelGroup>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{orders.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentOrders" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][orders.orders][orders.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{orders.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentOrders" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][orders.orders][orders.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{orders.createSetup}" value="New Orders" />
                <br />
                <h:commandLink action="#{orders.listSetup}" value="Show All Orders Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
