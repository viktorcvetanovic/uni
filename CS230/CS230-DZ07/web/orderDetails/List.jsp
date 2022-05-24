<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing OrderDetails Items</title>
            <link rel="stylesheet" type="text/css" href="/CS230-DZ07-BogdanPetrovic4382/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing OrderDetails Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No OrderDetails Items Found)<br />" rendered="#{orderDetails.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{orderDetails.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{orderDetails.pagingInfo.firstItem + 1}..#{orderDetails.pagingInfo.lastItem} of #{orderDetails.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{orderDetails.prev}" value="Previous #{orderDetails.pagingInfo.batchSize}" rendered="#{orderDetails.pagingInfo.firstItem >= orderDetails.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{orderDetails.next}" value="Next #{orderDetails.pagingInfo.batchSize}" rendered="#{orderDetails.pagingInfo.lastItem + orderDetails.pagingInfo.batchSize <= orderDetails.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{orderDetails.next}" value="Remaining #{orderDetails.pagingInfo.itemCount - orderDetails.pagingInfo.lastItem}"
                                   rendered="#{orderDetails.pagingInfo.lastItem < orderDetails.pagingInfo.itemCount && orderDetails.pagingInfo.lastItem + orderDetails.pagingInfo.batchSize > orderDetails.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{orderDetails.orderDetailsItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
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
                                <f:param name="jsfcrud.currentOrderDetails" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][orderDetails.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{orderDetails.editSetup}">
                                <f:param name="jsfcrud.currentOrderDetails" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][orderDetails.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{orderDetails.remove}">
                                <f:param name="jsfcrud.currentOrderDetails" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][orderDetails.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{orderDetails.createSetup}" value="New OrderDetails"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
