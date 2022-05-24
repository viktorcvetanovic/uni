<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing Orders Items</title>
            <link rel="stylesheet" type="text/css" href="/CS230-DZ07-BogdanPetrovic4382/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing Orders Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No Orders Items Found)<br />" rendered="#{orders.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{orders.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{orders.pagingInfo.firstItem + 1}..#{orders.pagingInfo.lastItem} of #{orders.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{orders.prev}" value="Previous #{orders.pagingInfo.batchSize}" rendered="#{orders.pagingInfo.firstItem >= orders.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{orders.next}" value="Next #{orders.pagingInfo.batchSize}" rendered="#{orders.pagingInfo.lastItem + orders.pagingInfo.batchSize <= orders.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{orders.next}" value="Remaining #{orders.pagingInfo.itemCount - orders.pagingInfo.lastItem}"
                                   rendered="#{orders.pagingInfo.lastItem < orders.pagingInfo.itemCount && orders.pagingInfo.lastItem + orders.pagingInfo.batchSize > orders.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{orders.ordersItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Order"/>
                            </f:facet>
                            <h:outputText value="#{item.order}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Date"/>
                            </f:facet>
                            <h:outputText value="#{item.date}">
                                <f:convertDateTime pattern="MM/dd/yyyy" />
                            </h:outputText>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="RequiredDate"/>
                            </f:facet>
                            <h:outputText value="#{item.requiredDate}">
                                <f:convertDateTime pattern="MM/dd/yyyy" />
                            </h:outputText>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="ShippedDate"/>
                            </f:facet>
                            <h:outputText value="#{item.shippedDate}">
                                <f:convertDateTime pattern="MM/dd/yyyy" />
                            </h:outputText>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Status"/>
                            </f:facet>
                            <h:outputText value="#{item.status}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Comment"/>
                            </f:facet>
                            <h:outputText value="#{item.comment}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="CustomerNumber"/>
                            </f:facet>
                            <h:outputText value="#{item.customerNumber}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{orders.detailSetup}">
                                <f:param name="jsfcrud.currentOrders" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][orders.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{orders.editSetup}">
                                <f:param name="jsfcrud.currentOrders" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][orders.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{orders.remove}">
                                <f:param name="jsfcrud.currentOrders" value="#{jsfcrud_class['jsf.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][orders.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{orders.createSetup}" value="New Orders"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
